package CssAST;

import java.util.ArrayList;
import java.util.List;

import CssVisitor.CssASTVisitor;

public class CssFunction extends CssValueTerm {
  public List<CssValueTerm> arguments;
  public String functionName;
  public CssFunction(String functionName, int line) {
    super(functionName, line);
    this.arguments = new ArrayList<>();
  }

  public void addArgument(CssValueTerm arg) {
    this.arguments.add(arg);
  }

  @Override
  public <T> T accept(CssASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
