package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class BinaryExpression extends TemplatesExpression {
  public TemplatesExpression left, right;
  public String operator;

  public BinaryExpression(TemplatesExpression left, String operator, TemplatesExpression right, int line) {
    super(line);
    this.left = left;
    this.operator = operator;
    this.right = right;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
