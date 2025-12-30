package CssAST;

import CssVisitor.CssASTVisitor;

public class CssPxValue extends CssValueTerm {
  public CssPxValue(String value, int line) {
    super(value, line);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
