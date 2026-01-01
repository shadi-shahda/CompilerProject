package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public class HtmlText extends TemplatesASTNode {
  public String text;

  public HtmlText(String text, int line) {
    super(line);
    this.text = text;
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
