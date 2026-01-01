package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class KeyValueAttribute extends HtmlAttribute {
  public String value;


  public KeyValueAttribute(String key, int line, String value) {
    super(key, line);
    this.value = value;
  }


  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
