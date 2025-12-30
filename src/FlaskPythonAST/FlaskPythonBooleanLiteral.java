package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonBooleanLiteral extends FlaskPythonExpression {

  public boolean value;

  public FlaskPythonBooleanLiteral(boolean value, int line) {
    super(line);
    this.value = value;
  }

  @Override
  public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
