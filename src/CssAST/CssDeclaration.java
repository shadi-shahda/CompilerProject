package CssAST;

import java.util.List;

import CssVisitor.CssASTVisitor;

public class CssDeclaration extends CssASTNode {
  public String property;
  List<CssValueTerm> valueTerms;

  public CssDeclaration(String property, List<CssValueTerm> valueTerms, int line) {
    super(line);
    this.property = property;
    this.valueTerms = valueTerms;
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
