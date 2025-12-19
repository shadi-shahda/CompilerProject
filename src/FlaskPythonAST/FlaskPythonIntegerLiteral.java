package FlaskPythonAST;

import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonIntegerLiteral extends FlaskPythonExpression {
  public int value;
  public FlaskPythonIntegerLiteral(int value, int line) {
    super(line);
    this.value = value;
  }


  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
