package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class VarExpression extends TemplatesExpression {
  public String name;

  public VarExpression(String name, int line) {
    super(line);
    this.name = name;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
