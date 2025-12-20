package FlaskPythonAST;

import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonBooleanLiteral extends FlaskPythonExpression {

  public boolean value;

  public FlaskPythonBooleanLiteral(boolean value, int line) {
    super(line);
    this.value = value;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
