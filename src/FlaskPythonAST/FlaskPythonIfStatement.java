package FlaskPythonAST;

import java.util.List;

import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonIfStatement extends FlaskPythonStatement {
  public FlaskPythonExpression condition;
  public List<FlaskPythonStatement> thenBloc;
  public List<FlaskPythonStatement> elseBloc;

  public FlaskPythonIfStatement(FlaskPythonExpression condition,
      List<FlaskPythonStatement> thenBloc, List<FlaskPythonStatement> elseBloc, int line) {
    super(line);
    this.condition = condition;
    this.thenBloc = thenBloc;
    this.elseBloc = elseBloc;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }


}
