package FlaskPythonAST;

import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonPrintStatement extends FlaskPythonStatement {
  public FlaskPythonExpression expression;

  public FlaskPythonPrintStatement(FlaskPythonExpression expression, int lineNumber) {
    super(lineNumber);
    this.expression = expression;
  }


  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
