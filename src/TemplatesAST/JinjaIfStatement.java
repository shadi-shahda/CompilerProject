package TemplatesAST;

import java.util.ArrayList;
import java.util.List;

import TemplatesVisitor.TemplatesASTVisitor;

public class JinjaIfStatement extends TemplatesASTNode {
  public TemplatesExpression condition;
  public List<TemplatesASTNode> thenBody;
  public List<TemplatesASTNode> elseBody;

  public JinjaIfStatement(TemplatesExpression condition, int line) {
    super(line);
    this.condition = condition;
    this.thenBody = new ArrayList<>();
    this.elseBody = new ArrayList<>();
  }

  public void addToThenBody(TemplatesASTNode template) {
    this.thenBody.add(template);
  }

  public void addToELseBody(TemplatesASTNode template) {
    this.elseBody.add(template);
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
