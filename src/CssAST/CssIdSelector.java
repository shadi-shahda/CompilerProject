package CssAST;

import CssVisitor.CssASTVisitor;

public class CssIdSelector extends CssSelector {
  public CssIdSelector(String name, int line) {
    super(name, line);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
