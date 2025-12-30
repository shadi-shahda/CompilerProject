package CssAST;

import java.util.ArrayList;
import java.util.List;

import CssVisitor.CssASTVisitor;

public class CssProgram extends CssASTNode {
  public List<CssRule> rules;

  public CssProgram(int line) {
    super(line);
    rules = new ArrayList<>();
  }

  public void addRule(CssRule rule) {
    rules.add(rule);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
