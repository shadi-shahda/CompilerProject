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
        for (FlaskPythonStatement statement : pythonAst.statements) {
            if (statement instanceof FlaskPythonAssignmentStatement assignment) {
                if ("products".equals(assignment.variableName)) {
                    return extractProductsFromExpression(assignment.expression);
                }
            }
        }

        return new ArrayList<>();
    }

    private List<Map<String, Object>> extractProductsFromExpression(
            FlaskPythonExpression expression
    ) {
        List<Map<String, Object>> products = new ArrayList<>();

        if (!(expression instanceof FlaskPythonListExpression listExpression)) {
            return products;
        }

        for (FlaskPythonExpression element : listExpression.elements) {
            Object value = evaluateExpression(element);

            if (value instanceof Map<?, ?> mapValue) {
                Map<String, Object> product = new LinkedHashMap<>();

                for (Map.Entry<?, ?> entry : mapValue.entrySet()) {
                    product.put(
                            String.valueOf(entry.getKey()),
                            entry.getValue()
                    );
                }

                products.add(product);
            }
        }

        return products;
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
}