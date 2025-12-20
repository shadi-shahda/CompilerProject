package FlaskPythonAST;

import java.util.List;

import FlaskPythonVisitor.ASTVisitor;

public class FLaskPythonForStatement extends FlaskPythonStatement {
  public String variableName;
  public FlaskPythonExpression iterable;
  public List<FlaskPythonStatement> body;

  public FLaskPythonForStatement(String variableName, FlaskPythonExpression iterable, List<FlaskPythonStatement> body, int line) {
    super(line);
    this.variableName = variableName;
    this.iterable = iterable;
    this.body = body;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
