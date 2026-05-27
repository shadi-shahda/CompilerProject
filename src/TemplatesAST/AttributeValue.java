package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class AttributeValue extends TemplatesASTNode {
    public List<AttributePart> parts = new ArrayList<>();
    public AttributeValue(int line) {
        super(line);
    }

    public void addPart(AttributePart part) {
        this.parts.add(part);
    }

    @Override
    public <T> T accept(TemplatesASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
