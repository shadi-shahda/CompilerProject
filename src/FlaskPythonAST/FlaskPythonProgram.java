package FlaskPythonAST;

import java.util.ArrayList;
import java.util.List;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonProgram extends FlaskPythonASTNode {

  public List<FlaskPythonStatement> statements = new ArrayList<>();

  public FlaskPythonProgram() {
    super(0);
  }

  public void addStatement(FlaskPythonStatement stmt) {
    statements.add(stmt);
  }

  @Override
  public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
