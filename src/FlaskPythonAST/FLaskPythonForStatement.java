package FlaskPythonAST;

import java.util.List;

import FlaskPythonVisitor.ASTVisitor;

public class FLaskPythonForStatement extends FlaskPythonStatement {
  public String variableName; // المتغير p
  public FlaskPythonExpression iterable; // القائمة products
  public List<FlaskPythonStatement> body; // جسم الحلقة

  public FLaskPythonForStatement(String variableName, FlaskPythonExpression iterable, List<FlaskPythonStatement> body, int line) {
    super(line);
    this.variableName = variableName;
    this.iterable = iterable;
    this.body = body;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
