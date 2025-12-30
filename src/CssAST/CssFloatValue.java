package CssAST;

import CssVisitor.CssASTVisitor;

public class CssFloatValue extends CssValueTerm {
  public String value;

  public CssFloatValue(String value, int line) {
    super(value, line);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }


}
