package CssAST;

import CssVisitor.CssASTVisitor;

public class CssIdentValue extends CssValueTerm {
  public CssIdentValue(String value, int line) {
    super(value, line);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
