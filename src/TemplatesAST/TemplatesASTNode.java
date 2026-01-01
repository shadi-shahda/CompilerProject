package TemplatesAST;

import TemplatesVisitor.TemplatesASTVisitor;

public abstract class TemplatesASTNode {
  protected int line;

  public TemplatesASTNode(int line) {
    this.line = line;
  }

  public int getLine() {
    return this.line;
  }

  public abstract <T> T accept(TemplatesASTVisitor<T> visitor);
}
