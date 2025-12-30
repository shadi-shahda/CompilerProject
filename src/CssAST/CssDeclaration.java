package CssAST;

import java.util.ArrayList;
import java.util.List;

import CssVisitor.CssASTVisitor;

public class CssDeclaration extends CssASTNode {
  public String property;
  public List<CssValueTerm> valueTerms;

  public CssDeclaration(String property, int line) {
    super(line);
    this.property = property;
    this.valueTerms = new ArrayList<>();
  }

  public void addValueTerm(CssValueTerm term) {
    valueTerms.add(term);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
