package CssAST;

import CssVisitor.CssASTVisitor;

public class CssClassSelector extends CssSelector {
  public CssClassSelector(String name, int line) {
    super(name, line);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }


}
