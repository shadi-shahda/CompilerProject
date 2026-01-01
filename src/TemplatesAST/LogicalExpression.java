package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class LogicalExpression extends TemplatesExpression {
  public TemplatesExpression left, right;
  public String operator;

  public LogicalExpression(int line, TemplatesExpression left, TemplatesExpression right, String operator) {
    super(line);
    this.left = left;
    this.right = right;
    this.operator = operator;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
