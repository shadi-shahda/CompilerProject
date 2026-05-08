package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class JinjaSet extends TemplatesASTNode {
  public String variableName;
  public TemplatesExpression expression;

  public JinjaSet(String variableName, TemplatesExpression expression, int line) {
    super(line);
    this.variableName = variableName;
    this.expression = expression;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
