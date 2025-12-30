package CssAST;

public abstract class CssValueTerm extends CssASTNode {
  public String value;

  public CssValueTerm(String value, int line){
    super(line);
    this.value = value;
  }
}
