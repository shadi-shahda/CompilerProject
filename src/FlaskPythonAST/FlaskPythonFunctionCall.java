package FlaskPythonAST;

import java.util.List;

import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonFunctionCall extends FlaskPythonExpression {
  public String functionName;
  public List<FlaskPythonExpression> arguments;
  public boolean isFlaskFunction;

  public FlaskPythonFunctionCall(String functionName, List<FlaskPythonExpression> arguments, boolean isFlaskFunction, int line) {
        super(line);
        this.functionName = functionName;
        this.arguments = arguments;
        this.isFlaskFunction = isFlaskFunction;
    }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
