package FinalGeneration;

import TemplatesAST.*;
import TemplatesVisitor.TemplatesASTVisitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JinjaHtmlRenderer implements TemplatesASTVisitor<String> {

    private final Map<String, Object> context;
    private final JinjaExpressionEvaluator evaluator;
    private int indentLevel = 0;

    public JinjaHtmlRenderer(Map<String, Object> context) {
        this.context = new HashMap<>(context);
        this.evaluator = new JinjaExpressionEvaluator(this.context);
    }

    private String indent() {
        return "    ".repeat(indentLevel);
    }

    @Override
    public String visit(TemplatesProgram program) {
        StringBuilder sb = new StringBuilder();

        for (TemplatesASTNode child : program.children) {
            String generated = child.accept(this);

            if (generated != null && !generated.isBlank()) {
                sb.append(generated);

                if (!generated.endsWith("\n")) {
                    sb.append("\n");
                }
            }
        }

        return sb.toString();
    }

    @Override
    public String visit(HtmlText text) {
        if (text.text == null) {
            return "";
        }

        if (text.text.trim().isEmpty()) {
            return "";
        }

        return text.text.trim();
    }

    @Override
    public String visit(KeyValueAttribute attribute) {

        String value =
                attribute.value.accept(this);

        /*
         * Static generation:
         *
         * /product/1 -> detail_1.html
         * /product/2 -> detail_2.html
         */
        if (
                "href".equalsIgnoreCase(attribute.getKey())
                        && value != null
                        && value.startsWith("/product/")
        ) {

            String id =
                    value.substring(
                            "/product/".length()
                    );

            value =
                    "detail_"
                            + id
                            + ".html";
        }

        /*
         * Static add page:
         *
         * /add -> add.html
         */
        if (
                "href".equalsIgnoreCase(attribute.getKey())
                        && "/add".equals(value)
        ) {
            value = "add.html";
        }

        /*
         * Static home page:
         *
         * / -> index.html
         */
        if (
                "href".equalsIgnoreCase(attribute.getKey())
                        && "/".equals(value)
        ) {
            value = "index.html";
        }

        /*
         * Static CSS path:
         *
         * /static/style.css -> static/style.css
         */
        if (
                "href".equalsIgnoreCase(attribute.getKey())
                        && "/static/style.css".equals(value)
        ) {
            value = "static/style.css";
        }

        return attribute.getKey()
                + "=\""
                + value
                + "\"";
    }

    @Override
    public String visit(OnlyKeyAttribute attribute) {
        return attribute.getKey();
    }

    @Override
    public String visit(HtmlElement element) {
        StringBuilder sb = new StringBuilder();

        sb.append(indent())
                .append("<")
                .append(element.tagName);

        if (element.attributes != null) {
            for (HtmlAttribute attribute : element.attributes) {
                String generated = attribute.accept(this);

                if (generated != null && !generated.isBlank()) {
                    sb.append(" ").append(generated);
                }
            }
        }

        sb.append(">");

        if (isVoidTag(element.tagName)) {
            return sb.toString();
        }

        boolean inline = hasOnlyInlineContent(element);

        if (inline) {
            if (element.templates != null) {
                for (TemplatesASTNode child : element.templates) {
                    String generated = child.accept(this);

                    if (generated != null) {
                        sb.append(generated);
                    }
                }
            }

            sb.append("</").append(element.tagName).append(">");
            return sb.toString();
        }

        sb.append("\n");

        indentLevel++;

        if (element.templates != null) {
            for (TemplatesASTNode child : element.templates) {
                String generated = child.accept(this);

                if (generated != null && !generated.isBlank()) {
                    sb.append(generated);

                    if (!generated.endsWith("\n")) {
                        sb.append("\n");
                    }
                }
            }
        }

        indentLevel--;

        sb.append(indent())
                .append("</")
                .append(element.tagName)
                .append(">");

        return sb.toString();
    }

    @Override
    public String visit(JinjaPrint jinjaPrint) {
        Object value = evaluator.evaluate(jinjaPrint.expression);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(JinjaSet jinjaSet) {
        Object value = evaluator.evaluate(jinjaSet.expression);
        context.put(jinjaSet.variableName, value);
        return "";
    }

    @Override
    public String visit(JinjaIfStatement ifStmt) {
        Object conditionValue = evaluator.evaluate(ifStmt.condition);
        boolean condition = toBoolean(conditionValue);

        List<TemplatesASTNode> selectedBody = condition
                ? ifStmt.thenBody
                : ifStmt.elseBody;

        if (selectedBody == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (TemplatesASTNode child : selectedBody) {
            String generated = child.accept(this);

            if (generated != null && !generated.isBlank()) {
                sb.append(generated);

                if (!generated.endsWith("\n")) {
                    sb.append("\n");
                }
            }
        }

        return sb.toString();
    }

    @Override
    public String visit(JinjaForStatement forStmt) {
        StringBuilder sb = new StringBuilder();

        Object listObject = context.get(forStmt.listName);

        if (!(listObject instanceof List<?> list)) {
            return "";
        }

        Object oldValue = context.get(forStmt.variableName);
        boolean hadOldValue = context.containsKey(forStmt.variableName);

        for (Object item : list) {
            context.put(forStmt.variableName, item);

            if (forStmt.statements != null) {
                for (TemplatesASTNode child : forStmt.statements) {
                    String generated = child.accept(this);

                    if (generated != null && !generated.isBlank()) {
                        sb.append(generated);

                        if (!generated.endsWith("\n")) {
                            sb.append("\n");
                        }
                    }
                }
            }
        }

        if (hadOldValue) {
            context.put(forStmt.variableName, oldValue);
        } else {
            context.remove(forStmt.variableName);
        }

        return sb.toString();
    }

    @Override
    public String visit(MemberAccessExpression memberAccessExpr) {
        Object value = evaluator.evaluate(memberAccessExpr);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(DictionaryAccessExpression dictionaryAccessExpr) {
        Object value = evaluator.evaluate(dictionaryAccessExpr);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(MathExpression mathExpr) {
        Object value = evaluator.evaluate(mathExpr);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(NotExpression notExpr) {
        Object value = evaluator.evaluate(notExpr);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(BinaryExpression binaryExpr) {
        Object value = evaluator.evaluate(binaryExpr);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(LogicalExpression logicalExpr) {
        Object value = evaluator.evaluate(logicalExpr);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(VarExpression varExpr) {
        Object value = evaluator.evaluate(varExpr);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(StringExpression stringExpr) {
        Object value = evaluator.evaluate(stringExpr);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(IntExpression intExpr) {
        Object value = evaluator.evaluate(intExpr);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(BoolExpression boolExpr) {
        Object value = evaluator.evaluate(boolExpr);
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public String visit(AttributeValue value) {
        StringBuilder sb = new StringBuilder();

        if (value.parts != null) {
            for (AttributePart part : value.parts) {
                String generated = part.accept(this);

                if (generated != null) {
                    sb.append(generated);
                }
            }
        }

        return sb.toString();
    }

    @Override
    public String visit(AttributeTextPart textPart) {
        return textPart.text == null ? "" : textPart.text;
    }

    @Override
    public String visit(AttributeExpressionPart expressionPart) {
        Object value = evaluator.evaluate(expressionPart.expression);
        return value == null ? "" : String.valueOf(value);
    }

    private boolean isVoidTag(String tagName) {
        if (tagName == null) {
            return false;
        }

        return tagName.equalsIgnoreCase("link")
                || tagName.equalsIgnoreCase("img")
                || tagName.equalsIgnoreCase("input")
                || tagName.equalsIgnoreCase("br")
                || tagName.equalsIgnoreCase("hr")
                || tagName.equalsIgnoreCase("meta");
    }

    private boolean hasOnlyInlineContent(HtmlElement element) {
        if (element.templates == null || element.templates.isEmpty()) {
            return false;
        }

        for (TemplatesASTNode child : element.templates) {
            if (!(child instanceof HtmlText || child instanceof JinjaPrint)) {
                return false;
            }
        }

        return true;
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

        if (value instanceof List<?> listValue) {
            return !listValue.isEmpty();
        }

        return true;
    }
}
