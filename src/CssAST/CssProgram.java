package CssAST;

import java.util.List;

import CssVisitor.CssASTVisitor;

public class CssProgram extends CssASTNode {
  public List<CssRule> rules;

  public CssProgram(List<CssRule> rules, int line) {
    super(line);
    this.rules = rules;
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
