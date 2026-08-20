package FinalGeneration;

import FlaskPythonAST.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class RenderContextResolver {

    private static final Object UNRESOLVED = new Object();

    public Resolution resolve(
            RenderTemplateBinding binding,
            PythonRuntimeContext runtimeContext
    ) {
        Map<String, Object> resolvedContext = new LinkedHashMap<>();
        List<String> unresolvedVariables = new ArrayList<>();

        if (binding == null) {
            return new Resolution(
                    resolvedContext,
                    unresolvedVariables
            );
        }

        for (
                Map.Entry<String, FlaskPythonExpression> entry
                : binding.getContextExpressions().entrySet()
        ) {

            Object value = evaluate(
                    entry.getValue(),
                    runtimeContext
            );

            if (value == UNRESOLVED) {
                unresolvedVariables.add(entry.getKey());
            } else {
                resolvedContext.put(
                        entry.getKey(),
                        value
                );
            }
        }

        return new Resolution(
                resolvedContext,
                unresolvedVariables
        );
    }

    private Object evaluate(
            FlaskPythonExpression expression,
            PythonRuntimeContext runtimeContext
    ) {

        if (expression == null) {
            return null;
        }

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

            if (
                    runtimeContext != null
                            && runtimeContext.contains(identifier.name)
            ) {
                return runtimeContext.get(identifier.name);
            }

            return UNRESOLVED;
        }

        if (expression instanceof FlaskPythonListExpression listExpression) {

            List<Object> values = new ArrayList<>();

            if (listExpression.elements == null) {
                return values;
            }

            for (FlaskPythonExpression item : listExpression.elements) {

                Object value = evaluate(
                        item,
                        runtimeContext
                );

                if (value == UNRESOLVED) {
                    return UNRESOLVED;
                }

                values.add(value);
            }

            return values;
        }

        if (
                expression
                        instanceof FlaskPythonDictionaryExpression dictionaryExpression
        ) {

            Map<String, Object> values = new LinkedHashMap<>();

            if (dictionaryExpression.entries == null) {
                return values;
            }

            for (
                    Map.Entry<
                            FlaskPythonExpression,
                            FlaskPythonExpression
                            > entry
                    : dictionaryExpression.entries.entrySet()
            ) {

                String key = extractDictionaryKey(
                        entry.getKey()
                );

                Object value = evaluate(
                        entry.getValue(),
                        runtimeContext
                );

                if (key == null || value == UNRESOLVED) {
                    return UNRESOLVED;
                }

                values.put(key, value);
            }

            return values;
        }

        if (
                expression
                        instanceof FlaskPythonMemberAccess memberAccess
        ) {

            Object object = evaluate(
                    memberAccess.object,
                    runtimeContext
            );

            if (object == UNRESOLVED) {
                return UNRESOLVED;
            }

            if (object instanceof Map<?, ?> map) {

                return map.get(
                        cleanMemberName(
                                memberAccess.memberName
                        )
                );
            }

            return UNRESOLVED;
        }

        return UNRESOLVED;
    }

    private String extractDictionaryKey(
            FlaskPythonExpression expression
    ) {

        if (expression instanceof FlaskPythonStringLiteral stringLiteral) {
            return stringLiteral.value;
        }

        if (expression instanceof FlaskPythonIntegerLiteral integerLiteral) {
            return String.valueOf(integerLiteral.value);
        }

        if (expression instanceof FlaskPythonIdentifier identifier) {
            return identifier.name;
        }

        return null;
    }

    private String cleanMemberName(String memberName) {

        if (memberName == null) {
            return "";
        }

        String value = memberName.trim();

        if (
                value.startsWith("[")
                        && value.endsWith("]")
        ) {
            value = value.substring(
                    1,
                    value.length() - 1
            );
        }

        return value;
    }


    public static final class Resolution {

        private final Map<String, Object> context;

        private final List<String> unresolvedVariables;

        public Resolution(
                Map<String, Object> context,
                List<String> unresolvedVariables
        ) {
            this.context = context;
            this.unresolvedVariables = unresolvedVariables;
        }

        public Map<String, Object> getContext() {
            return context;
        }

        public List<String> getUnresolvedVariables() {
            return unresolvedVariables;
        }

        public boolean isFullyResolved() {
            return unresolvedVariables.isEmpty();
        }
    }
}