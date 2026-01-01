package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class StringExpression extends TemplatesExpression {
  public String name;

  public StringExpression(int line, String name) {
    super(line);
    this.name = name;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
