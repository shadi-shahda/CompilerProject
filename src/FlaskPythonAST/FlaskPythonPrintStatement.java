package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonPrintStatement extends FlaskPythonStatement {
  public FlaskPythonExpression expression;

  public FlaskPythonPrintStatement(FlaskPythonExpression expression, int lineNumber) {
    super(lineNumber);
    this.expression = expression;
  }


  @Override
  public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
