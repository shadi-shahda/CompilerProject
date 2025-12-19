package FlaskPythonAST;

import FlaskPythonVisitor.ASTVisitor;

// StringLiteral.java
public class FlaskPythonStringLiteral extends FlaskPythonExpression {
  public String value;

  public FlaskPythonStringLiteral(String value, int line) {
    super(line);
    this.value = value;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}