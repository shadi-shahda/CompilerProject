package CssAST;

import CssVisitor.CssASTVisitor;

public class CssHexValue extends CssValueTerm {
  public CssHexValue(String value, int line) {
    super(value, line);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
