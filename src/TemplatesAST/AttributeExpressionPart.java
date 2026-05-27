package TemplatesAST;

public class AttributeExpressionPart extends AttributePart {
    public TemplatesExpression expression;

    public AttributeExpressionPart(int line, TemplatesExpression expression) {
        super(line);
        this.expression = expression;
    }

    @Override
    public <T> T accept(TemplatesVisitor.TemplatesASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
