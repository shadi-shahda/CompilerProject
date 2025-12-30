package CssAST;

import CssVisitor.CssASTVisitor;

abstract public class CssASTNode {
  protected int line;

  public CssASTNode(int line) {
    this.line = line;
  }

  public int getLine() {
    return this.line;
  }

  public abstract <T> T accept(CssASTVisitor<T> visitor);
}
