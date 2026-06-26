package FlaskPythonAST;

import java.util.List;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonFunctionCall extends FlaskPythonExpression {
  public String functionName;
  public List<FlaskPythonArgument> arguments;
  public boolean isFlaskFunction;

  public FlaskPythonFunctionCall(String functionName, List<FlaskPythonArgument> arguments, boolean isFlaskFunction, int line) {
        super(line);
        this.functionName = functionName;
        this.arguments = arguments;
        this.isFlaskFunction = isFlaskFunction;
    }

  @Override
  public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
