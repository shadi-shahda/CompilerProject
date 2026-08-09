package FinalGeneration;

import TemplatesAST.BinaryExpression;
import TemplatesAST.BoolExpression;
import TemplatesAST.DictionaryAccessExpression;
import TemplatesAST.IntExpression;
import TemplatesAST.LogicalExpression;
import TemplatesAST.MathExpression;
import TemplatesAST.MemberAccessExpression;
import TemplatesAST.NotExpression;
import TemplatesAST.StringExpression;
import TemplatesAST.VarExpression;

import java.util.Map;

public class JinjaExpressionEvaluator {

    private final Map<String, Object> context;

    public JinjaExpressionEvaluator(Map<String, Object> context) {
        this.context = context;
    }

    public Object evaluate(Object expression) {
        if (expression == null) {
            return null;
        }

        if (expression instanceof VarExpression varExpression) {
            return context.get(varExpression.name);
        }

        if (expression instanceof StringExpression stringExpression) {
            return stringExpression.name;
        }

        if (expression instanceof IntExpression intExpression) {
            return intExpression.value;
        }

        if (expression instanceof BoolExpression boolExpression) {
            return boolExpression.value;
        }

        if (expression instanceof MemberAccessExpression memberAccessExpression) {
            Object object = evaluate(memberAccessExpression.expression);

            if (object instanceof Map<?, ?> map) {
                return map.get(memberAccessExpression.attribute);
            }

            return null;
        }

        if (expression instanceof DictionaryAccessExpression dictionaryAccessExpression) {
            Object object = evaluate(dictionaryAccessExpression.object);

            if (object instanceof Map<?, ?> map) {
                String key = cleanKey(dictionaryAccessExpression.key);
                return map.get(key);
            }

            return null;
        }

        if (expression instanceof NotExpression notExpression) {
            return !toBoolean(evaluate(notExpression.expression));
        }

        if (expression instanceof LogicalExpression logicalExpression) {
            boolean left = toBoolean(evaluate(logicalExpression.left));
            boolean right = toBoolean(evaluate(logicalExpression.right));

            return switch (logicalExpression.operator) {
                case "and", "&&" -> left && right;
                case "or", "||" -> left || right;
                default -> false;
            };
        }

        if (expression instanceof BinaryExpression binaryExpression) {
            Object left = evaluate(binaryExpression.left);
            Object right = evaluate(binaryExpression.right);

            return compare(left, right, binaryExpression.operator);
        }

        if (expression instanceof MathExpression mathExpression) {
            Object leftValue = evaluate(mathExpression.getLeft());
            Object rightValue = evaluate(mathExpression.getRight());

            if (!(leftValue instanceof Number leftNumber)
                    || !(rightValue instanceof Number rightNumber)) {
                return null;
            }

            double left = leftNumber.doubleValue();
            double right = rightNumber.doubleValue();

            return switch (mathExpression.getOperator()) {
                case "+" -> left + right;
                case "-" -> left - right;
                case "*" -> left * right;
                case "/" -> right == 0 ? null : left / right;
                default -> null;
            };
        }

        return null;
    }

    private boolean compare(Object left, Object right, String operator) {
        if (operator == null) {
            return false;
        }

        if (operator.equals("==")) {
            return left == null ? right == null : left.equals(right);
        }

        if (operator.equals("!=")) {
            return left == null ? right != null : !left.equals(right);
        }

        if (left instanceof Number leftNumber && right instanceof Number rightNumber) {
            double l = leftNumber.doubleValue();
            double r = rightNumber.doubleValue();

            return switch (operator) {
                case ">" -> l > r;
                case "<" -> l < r;
                case ">=" -> l >= r;
                case "<=" -> l <= r;
                default -> false;
            };
        }

        return false;
    }

    private String cleanKey(String key) {
        if (key == null) {
            return "";
        }

        String trimmed = key.trim();

        if ((trimmed.startsWith("\"") && trimmed.endsWith("\""))
                || (trimmed.startsWith("'") && trimmed.endsWith("'"))) {
            return trimmed.substring(1, trimmed.length() - 1);
        }

        return trimmed;
    }

    private boolean toBoolean(Object value) {
        if (value == null) {
            return false;
        }

        if (value instanceof Boolean boolValue) {
            return boolValue;
        }

        if (value instanceof Number numberValue) {
            return numberValue.doubleValue() != 0;
        }

        if (value instanceof String stringValue) {
            return !stringValue.isBlank();
        }

        return true;
    }
}