package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class DictionaryAccessExpression extends TemplatesExpression {
  public String key;
  public TemplatesExpression object;

  public DictionaryAccessExpression(int line, String key, TemplatesExpression object) {
    super(line);
    this.key = key;
    this.object = object;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
