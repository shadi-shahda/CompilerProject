package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonStringLiteral extends FlaskPythonExpression {
  public String value;

  public FlaskPythonStringLiteral(String value, int line) {
    super(line);
    this.value = value;
  }

  @Override
  public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}