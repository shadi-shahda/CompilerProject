package TemplatesAST;

import java.util.ArrayList;
import java.util.List;

import TemplatesVisitor.TemplatesASTVisitor;

public class JinjaForStatement extends TemplatesASTNode {
  public String variableName;
  public String listName;
  public List<TemplatesASTNode> statements;

  public JinjaForStatement(String variableName, String listName, int line) {
    super(line);
    this.variableName = variableName;
    this.listName = listName;
    this.statements = new ArrayList<>();
  }

  public void addStatement(TemplatesASTNode statement) {
    this.statements.add(statement);
  }

  @Override
  public <T> T accept(TemplatesASTVisitor<T> visitor) {
    return visitor.visit(this);
  }


}
