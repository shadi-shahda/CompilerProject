package CssAST;

import java.util.List;

import CssVisitor.CssASTVisitor;

public class CssRule extends CssASTNode {
  List<CssDeclaration> declarations;
  List<CssSelector> selectors;
  public CssRule(List<CssDeclaration> declarations, List<CssSelector> selectors, int line) {
    super(line);
    this.declarations = declarations;
    this.selectors = selectors;
  }
  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }



}
