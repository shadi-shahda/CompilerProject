package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class NotExpression extends TemplatesExpression {
  public TemplatesExpression expression;

  public NotExpression(int line, TemplatesExpression expression) {
    super(line);
    this.expression = expression;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
