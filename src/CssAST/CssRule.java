package CssAST;

import java.util.ArrayList;
import java.util.List;

import CssVisitor.CssASTVisitor;

public class CssRule extends CssASTNode {
  public List<CssDeclaration> declarations;
  public List<CssSelector> selectors;
  public CssRule(int line) {
    super(line);
    declarations = new ArrayList<>();
    selectors = new ArrayList<>();
  }

  public void addDeclaration(CssDeclaration declaration) {
    declarations.add(declaration);
  }

  public void addSelector(CssSelector selector) {
    selectors.add(selector);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }



}
