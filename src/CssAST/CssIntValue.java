package CssAST;

import CssVisitor.CssASTVisitor;

public class CssIntValue extends CssValueTerm {
  public CssIntValue(String value, int line) {
    super(value, line);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
