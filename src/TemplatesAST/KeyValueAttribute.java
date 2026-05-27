package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class KeyValueAttribute extends HtmlAttribute {
    public AttributeValue value;


    public KeyValueAttribute(String key, int line, AttributeValue value) {
        super(key, line);
        this.value = value;
    }

    public String buildAttributeValue(AttributeValue value) {

        StringBuilder sb = new StringBuilder();

        for (AttributePart part : value.parts) {

            // Static HTML text
            if (part instanceof AttributeTextPart textPart) {

                sb.append(textPart.text);
            }

            // Embedded Jinja expression
            else if (part instanceof AttributeExpressionPart exprPart) {

                sb.append("\"{{ ");

                // temporary debug rendering
                sb.append(exprPart.expression.toString());

                sb.append(" }}\"");
            }
        }

        return sb.toString();

    }

    @Override
    public <T> T accept(TemplatesASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
