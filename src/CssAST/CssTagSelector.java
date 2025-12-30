package CssAST;

import CssVisitor.CssASTVisitor;

public class CssTagSelector extends CssSelector {
  public CssTagSelector(String name, int line) {
    super(name, line);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }


}
