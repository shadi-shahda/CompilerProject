package TemplatesAST;

public abstract class HtmlAttribute extends TemplatesASTNode {

  protected String key;
  public AttributeValue value;

  public HtmlAttribute(String key, int line) {
    super(line);
    this.key = key;
  }

  
  public String getKey() {
    return this.key;
  }
}
