package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class MemberAccessExpression extends TemplatesExpression {
  public String attribute;
  public TemplatesExpression expression;

  public MemberAccessExpression(int line, String attribute, TemplatesExpression expression) {
    super(line);
    this.attribute = attribute;
    this.expression = expression;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
