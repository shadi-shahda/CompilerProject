package FlaskPythonAST;

import java.util.List;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonMethodCall extends FlaskPythonExpression {
  public FlaskPythonExpression object;
  public String methodName;
  public List<FlaskPythonExpression> arguments;

  public FlaskPythonMethodCall(FlaskPythonExpression object, String methodName, List<FlaskPythonExpression> arguments, int line) {
    super(line);
    this.object = object;
    this.methodName = methodName;
    this.arguments = arguments;
  }

  @Override
  public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}

