package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class BoolExpression extends TemplatesExpression {
  public boolean value;
  
  public BoolExpression(int line, boolean value) {
    super(line);
    this.value = value;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
