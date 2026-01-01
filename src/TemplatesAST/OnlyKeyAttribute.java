package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class OnlyKeyAttribute extends HtmlAttribute {


  public OnlyKeyAttribute(String key, int line) {
    super(key, line);
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
  

}
