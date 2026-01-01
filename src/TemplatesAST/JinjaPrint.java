package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class JinjaPrint extends TemplatesASTNode {
  public TemplatesExpression expression;

  public JinjaPrint(TemplatesExpression expression, int line) {
    super(line);
    this.expression = expression;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
