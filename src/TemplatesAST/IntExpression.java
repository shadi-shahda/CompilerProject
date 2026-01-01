package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class IntExpression extends TemplatesExpression {
  public int value;

  public IntExpression(int line, String value) {
    super(line);
    this.value = Integer.parseInt(value);
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

  
}
