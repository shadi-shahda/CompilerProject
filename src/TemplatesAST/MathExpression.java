package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class MathExpression extends TemplatesExpression {
  private TemplatesExpression left;
  private TemplatesExpression right;
  private String operator;

  public MathExpression(int line, TemplatesExpression left, String operator, TemplatesExpression right) {
    super(line);
    this.left = left;
    this.operator = operator;
    this.right = right;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public TemplatesExpression getLeft() {
    return left;
  }

  public void setLeft(TemplatesExpression left) {
    this.left = left;
  }

  public TemplatesExpression getRight() {
    return right;
  }

  public void setRight(TemplatesExpression right) {
    this.right = right;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }
  
}
