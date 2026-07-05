package TemplatesGenerator;

import TemplatesAST.*;
import TemplatesVisitor.TemplatesASTVisitor;

public class TemplatesGenerator implements TemplatesASTVisitor<String> {

    private int indentLevel = 0;

    private String indent() {
        return "    ".repeat(indentLevel);
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

    private boolean isInlineNode(TemplatesASTNode node) {
        return node instanceof HtmlText
                || node instanceof JinjaPrint
                || node instanceof AttributeExpressionPart;
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
        return text.text == null ? "" : text.text.trim();
    }

    @Override
    public String visit(KeyValueAttribute attribute) {
        return attribute.getKey() + "=\"" + attribute.value.accept(this) + "\"";
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

        if (element.attributes != null && !element.attributes.isEmpty()) {
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

        boolean inlineContent = hasOnlyInlineContent(element);

        if (inlineContent) {
            for (TemplatesASTNode child : element.templates) {
                String generated = child.accept(this);

                if (generated != null) {
                    sb.append(generated);
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
        return "{{ " + jinjaPrint.expression.accept(this) + " }}";
    }

    @Override
    public String visit(JinjaSet jinjaSet) {
        return indent()
                + "{% set "
                + jinjaSet.variableName
                + " = "
                + jinjaSet.expression.accept(this)
                + " %}";
    }

    @Override
    public String visit(JinjaIfStatement ifStmt) {
        StringBuilder sb = new StringBuilder();

        sb.append(indent())
                .append("{% if ")
                .append(ifStmt.condition.accept(this))
                .append(" %}\n");

        indentLevel++;

        if (ifStmt.thenBody != null) {
            for (TemplatesASTNode child : ifStmt.thenBody) {
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

        if (ifStmt.elseBody != null && !ifStmt.elseBody.isEmpty()) {
            sb.append(indent()).append("{% else %}\n");

            indentLevel++;

            for (TemplatesASTNode child : ifStmt.elseBody) {
                String generated = child.accept(this);

                if (generated != null && !generated.isBlank()) {
                    sb.append(generated);

                    if (!generated.endsWith("\n")) {
                        sb.append("\n");
                    }
                }
            }

            indentLevel--;
        }

        sb.append(indent()).append("{% endif %}");

        return sb.toString();
    }

    @Override
    public String visit(JinjaForStatement forStmt) {
        StringBuilder sb = new StringBuilder();

        sb.append(indent())
                .append("{% for ")
                .append(forStmt.variableName)
                .append(" in ")
                .append(forStmt.listName)
                .append(" %}\n");

        indentLevel++;

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

        indentLevel--;

        sb.append(indent()).append("{% endfor %}");

        return sb.toString();
    }

    @Override
    public String visit(MemberAccessExpression memberAccessExpr) {
        return memberAccessExpr.expression.accept(this) + "." + memberAccessExpr.attribute;
    }

    @Override
    public String visit(DictionaryAccessExpression dictionaryAccessExpr) {
        return dictionaryAccessExpr.object.accept(this)
                + "["
                + formatDictionaryKey(dictionaryAccessExpr.key)
                + "]";
    }

    @Override
    public String visit(MathExpression mathExpr) {
        return mathExpr.getLeft().accept(this)
                + " " + mathExpr.getOperator() + " "
                + mathExpr.getRight().accept(this);
    }

    @Override
    public String visit(NotExpression notExpr) {
        return "not " + notExpr.expression.accept(this);
    }

    @Override
    public String visit(BinaryExpression binaryExpr) {
        return binaryExpr.left.accept(this)
                + " " + binaryExpr.operator + " "
                + binaryExpr.right.accept(this);
    }

    @Override
    public String visit(LogicalExpression logicalExpr) {
        return logicalExpr.left.accept(this)
                + " " + logicalExpr.operator + " "
                + logicalExpr.right.accept(this);
    }

    @Override
    public String visit(VarExpression varExpr) {
        return varExpr.name;
    }

    @Override
    public String visit(StringExpression stringExpr) {
        return "\"" + escapeString(stringExpr.name) + "\"";
    }

    @Override
    public String visit(IntExpression intExpr) {
        return String.valueOf(intExpr.value);
    }

    @Override
    public String visit(BoolExpression boolExpr) {
        return boolExpr.value ? "True" : "False";
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

        return sb.toString().trim();
    }

    @Override
    public String visit(AttributeTextPart textPart) {
        return textPart.text == null ? "" : textPart.text;
    }

    @Override
    public String visit(AttributeExpressionPart expressionPart) {
        return "{{ " + expressionPart.expression.accept(this) + " }}";
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

    private String formatDictionaryKey(String key) {
        if (key == null) {
            return "";
        }

        String trimmed = key.trim();

        if ((trimmed.startsWith("\"") && trimmed.endsWith("\""))
                || (trimmed.startsWith("'") && trimmed.endsWith("'"))) {
            return trimmed;
        }

        if (trimmed.matches("\\d+")) {
            return trimmed;
        }

        return "\"" + escapeString(trimmed) + "\"";
    }

    private String escapeString(String value) {
        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");
    }
}