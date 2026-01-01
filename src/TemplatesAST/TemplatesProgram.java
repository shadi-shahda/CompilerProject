package TemplatesAST;

import java.util.ArrayList;
import java.util.List;

import TemplatesVisitor.TemplatesASTVisitor;

public class TemplatesProgram extends TemplatesASTNode {
  public List<TemplatesASTNode> children;

  public TemplatesProgram(int line) {
    super(line);
    this.children = new ArrayList<>();
  }

  public void addChild(TemplatesASTNode template) {
    this.children.add(template);
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
