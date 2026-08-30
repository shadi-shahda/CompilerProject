package CompilerPipeline;

import FlaskPythonAST.FlaskPythonAssignmentStatement;
import FlaskPythonAST.FlaskPythonBooleanLiteral;
import FlaskPythonAST.FlaskPythonDictionaryExpression;
import FlaskPythonAST.FlaskPythonExpression;
import FlaskPythonAST.FlaskPythonIdentifier;
import FlaskPythonAST.FlaskPythonIntegerLiteral;
import FlaskPythonAST.FlaskPythonListExpression;
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonAST.FlaskPythonStatement;
import FlaskPythonAST.FlaskPythonStringLiteral;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PythonProductsExtractor {

    public List<Map<String, Object>> extractProducts(
            FlaskPythonProgram pythonAst
    ) {
        List<ProductListCandidate> candidates = new ArrayList<>();

        for (FlaskPythonStatement statement : pythonAst.statements) {
            if (statement instanceof FlaskPythonAssignmentStatement assignment) {
                if (assignment.expression instanceof FlaskPythonListExpression listExpression) {

                    List<Map<String, Object>> dictionaries =
                            extractDictionariesFromListExpression(listExpression);

                    if (looksLikeProductList(dictionaries)) {
                        validateProducts(
                                assignment.variableName,
                                dictionaries
                        );

                        candidates.add(
                                new ProductListCandidate(
                                        assignment.variableName,
                                        dictionaries,
                                        calculateProductScore(dictionaries)
                                )
                        );
                    }
                }
            }
        }

        if (candidates.isEmpty()) {
            throw new CompilationException(
                    "Missing product data list: no product-like list was found in Python AST. "
                            + "Expected a list of dictionaries where each item has a required numeric 'id' field."
            );
        }

        ProductListCandidate bestCandidate = chooseBestCandidate(candidates);

        System.out.println(
                "Products extracted from Python AST variable: "
                        + bestCandidate.variableName
        );

        return bestCandidate.products;
    }

    private ProductListCandidate chooseBestCandidate(
            List<ProductListCandidate> candidates
    ) {
        if (candidates.size() == 1) {
            return candidates.get(0);
        }

        ProductListCandidate bestCandidate = null;
        boolean ambiguous = false;

        for (ProductListCandidate candidate : candidates) {
            if (bestCandidate == null) {
                bestCandidate = candidate;
                ambiguous = false;
                continue;
            }

            if (candidate.score > bestCandidate.score) {
                bestCandidate = candidate;
                ambiguous = false;
                continue;
            }

            if (candidate.score == bestCandidate.score) {
                ambiguous = true;
            }
        }

        if (ambiguous) {
            List<String> candidateNames = new ArrayList<>();

            for (ProductListCandidate candidate : candidates) {
                candidateNames.add(
                        candidate.variableName + " score=" + candidate.score
                );
            }

            throw new CompilationException(
                    "Ambiguous product data list: more than one product-like list was found in Python AST: "
                            + candidateNames
                            + ". Keep only one product-like list or make the intended product list more complete."
            );
        }

        return bestCandidate;
    }

    private List<Map<String, Object>> extractDictionariesFromListExpression(
            FlaskPythonListExpression listExpression
    ) {
        List<Map<String, Object>> dictionaries = new ArrayList<>();

        for (FlaskPythonExpression element : listExpression.elements) {
            Object value = evaluateExpression(element);

            if (value instanceof Map<?, ?> mapValue) {
                Map<String, Object> dictionary = new LinkedHashMap<>();

                for (Map.Entry<?, ?> entry : mapValue.entrySet()) {
                    dictionary.put(
                            String.valueOf(entry.getKey()),
                            entry.getValue()
                    );
                }

                dictionaries.add(dictionary);
            }
        }

        return dictionaries;
    }

    private boolean looksLikeProductList(
            List<Map<String, Object>> dictionaries
    ) {
        if (dictionaries.isEmpty()) {
            return false;
        }

        for (Map<String, Object> dictionary : dictionaries) {
            if (!dictionary.containsKey("id")) {
                return false;
            }

            Object idValue = dictionary.get("id");

            if (!(idValue instanceof Number)) {
                return false;
            }
        }

        return true;
    }

    private int calculateProductScore(
            List<Map<String, Object>> dictionaries
    ) {
        int score = 0;

        for (Map<String, Object> dictionary : dictionaries) {
            if (dictionary.containsKey("id")) {
                score += 5;
            }

            if (dictionary.containsKey("name")) {
                score++;
            }

            if (dictionary.containsKey("details")) {
                score++;
            }

            if (dictionary.containsKey("image")) {
                score++;
            }

            if (dictionary.containsKey("price")) {
                score++;
            }
        }

        return score;
    }

    private void validateProducts(
            String variableName,
            List<Map<String, Object>> products
    ) {
        for (int i = 0; i < products.size(); i++) {
            Map<String, Object> product = products.get(i);

            validateRequiredId(variableName, product, i);
            validateIdType(variableName, product, i);
        }
    }

    private void validateRequiredId(
            String variableName,
            Map<String, Object> product,
            int index
    ) {
        if (!product.containsKey("id")) {
            throw new CompilationException(
                    "Missing required product id in Python AST variable '"
                            + variableName
                            + "' at product index "
                            + index
                            + ". The 'id' field is required because it is used by product details and delete logic."
            );
        }
    }

    private void validateIdType(
            String variableName,
            Map<String, Object> product,
            int index
    ) {
        Object value = product.get("id");

        if (!(value instanceof Number)) {
            throw new CompilationException(
                    "Type mismatch in Python AST variable '"
                            + variableName
                            + "' at product index "
                            + index
                            + ": field 'id' must be a number because it is used by runtime logic."
            );
        }
    }

    private Object evaluateExpression(FlaskPythonExpression expression) {
        if (expression instanceof FlaskPythonStringLiteral stringLiteral) {
            return stringLiteral.value;
        }

        if (expression instanceof FlaskPythonIntegerLiteral integerLiteral) {
            return integerLiteral.value;
        }

        if (expression instanceof FlaskPythonBooleanLiteral booleanLiteral) {
            return booleanLiteral.value;
        }

        if (expression instanceof FlaskPythonIdentifier identifier) {
            return identifier.name;
        }

        if (expression instanceof FlaskPythonListExpression listExpression) {
            List<Object> values = new ArrayList<>();

            for (FlaskPythonExpression element : listExpression.elements) {
                values.add(evaluateExpression(element));
            }

            return values;
        }

        if (expression instanceof FlaskPythonDictionaryExpression dictionaryExpression) {
            Map<String, Object> values = new LinkedHashMap<>();

            for (Map.Entry<FlaskPythonExpression, FlaskPythonExpression> entry
                    : dictionaryExpression.entries.entrySet()) {

                Object key = evaluateExpression(entry.getKey());
                Object value = evaluateExpression(entry.getValue());

                values.put(String.valueOf(key), value);
            }

            return values;
        }

        return String.valueOf(expression);
    }

    private static class ProductListCandidate {

        private final String variableName;
        private final List<Map<String, Object>> products;
        private final int score;

        private ProductListCandidate(
                String variableName,
                List<Map<String, Object>> products,
                int score
        ) {
            this.variableName = variableName;
            this.products = products;
            this.score = score;
        }
    }
}