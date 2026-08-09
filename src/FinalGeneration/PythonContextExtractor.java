package FinalGeneration;

import FlaskPythonAST.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PythonContextExtractor {
    private final PythonRuntimeContext context = new PythonRuntimeContext();

    public PythonRuntimeContext extract(FlaskPythonProgram program) {
        for (FlaskPythonStatement statement : program.statements) {
            handleStatement(statement);
        }
        return context;
    }


    private void handleStatement(FlaskPythonStatement statement) {
        if (statement instanceof FlaskPythonAssignmentStatement assignmentStatement) {
            Object value = evaluateExpression(assignmentStatement.expression);

            if (value != null) {
                context.put(assignmentStatement.variableName, value);
            }
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

        if (expression instanceof FlaskPythonListExpression listExpression) {
            return evaluateListExpression(listExpression);
        }

        if (expression instanceof FlaskPythonDictionaryExpression dictionaryExpression) {
            return evaluateDictionaryExpression(dictionaryExpression);
        }

        return null;
    }

    private List<Object> evaluateListExpression(FlaskPythonListExpression listExpression) {
        List<Object> values = new ArrayList<>();

        if (listExpression.elements == null) {
            return values;
        }

        for (FlaskPythonExpression item : listExpression.elements) {
            Object value = evaluateExpression(item);

            if (value != null) {
                values.add(value);
            }
        }

        return values;
    }

    private Map<String, Object> evaluateDictionaryExpression(
            FlaskPythonDictionaryExpression dictionaryExpression
    ) {
        Map<String, Object> values = new LinkedHashMap<>();

        if (dictionaryExpression.entries == null) {
            return values;
        }

        for (Map.Entry<FlaskPythonExpression, FlaskPythonExpression> entry
                : dictionaryExpression.entries.entrySet()) {

            String key = extractDictionaryKey(entry.getKey());
            Object value = evaluateExpression(entry.getValue());

            if (key != null && value != null) {
                values.put(key, value);
            }
        }

        return values;
    }


    private String extractDictionaryKey(FlaskPythonExpression keyExpression) {
        if (keyExpression instanceof FlaskPythonStringLiteral stringLiteral) {
            return stringLiteral.value;
        }

        if (keyExpression instanceof FlaskPythonIntegerLiteral integerLiteral) {
            return String.valueOf(integerLiteral.value);
        }

        if (keyExpression instanceof FlaskPythonIdentifier identifier) {
            return identifier.name;
        }

        return null;
    }

}
