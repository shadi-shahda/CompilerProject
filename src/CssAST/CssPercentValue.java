package CssAST;

import CssVisitor.CssASTVisitor;

public class CssPercentValue extends CssValueTerm {
  public CssPercentValue(String value, int line) {
    super(value, line);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
