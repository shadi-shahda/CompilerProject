package CssAST;

public abstract class CssSelector extends CssASTNode {
  public String name;
  public CssSelector(String name, int line) {
    super(line);
    this.name = name;
  }

  
}
