package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class HtmlAttribute extends TemplatesASTNode {
  public String key;
  public String value;

  public HtmlAttribute(String key, String value, int line) {
    super(line);
    this.key = key;
    this.value = value;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
