package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonIntegerLiteral extends FlaskPythonExpression {
  public int value;
  public FlaskPythonIntegerLiteral(int value, int line) {
    super(line);
    this.value = value;
  }


  @Override
  public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
