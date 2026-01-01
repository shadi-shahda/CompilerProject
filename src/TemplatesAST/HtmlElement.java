package TemplatesAST;

import java.util.ArrayList;
import java.util.List;

import TemplatesVisitor.TemplatesASTVisitor;

public class HtmlElement extends TemplatesASTNode {
  public String tagName;
  public List<HtmlAttribute> attributes;
  public List<TemplatesASTNode> templates;

  public HtmlElement(String tagName, int line) {
    super(line);
    this.tagName = tagName;
    this.attributes = new ArrayList<>();
    this.templates = new ArrayList<>();
  }

  public void addAttribute(HtmlAttribute attribute) {
    this.attributes.add(attribute);
  }

  public void addTemplate(TemplatesASTNode template) {
    this.templates.add(template);
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
