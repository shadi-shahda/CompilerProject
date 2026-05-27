package TemplatesAST;

public class AttributeTextPart extends AttributePart {

    public String text;

    public AttributeTextPart(int line, String text) {
        super(line);
        this.text = text;
    }

    @Override
    public <T> T accept(TemplatesVisitor.TemplatesASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}