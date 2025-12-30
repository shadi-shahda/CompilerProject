package CssAST;

import CssVisitor.CssASTVisitor;

public class CssStringValue extends CssValueTerm {
  public CssStringValue(String value, int line) {
    super(value, line);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
