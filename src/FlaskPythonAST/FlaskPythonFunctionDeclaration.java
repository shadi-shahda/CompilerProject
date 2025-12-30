package FlaskPythonAST;

import java.util.List;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonFunctionDeclaration extends FlaskPythonStatement {
  public String name;
  public List<String> parameters;
  public List<FlaskPythonStatement> body;
  public String routePath;
  public List<String> methods; // GET, POST

  public FlaskPythonFunctionDeclaration(String name, List<String> parameters, List<FlaskPythonStatement> body,
      String routePath,
      List<String> methods, int line) {
    super(line);
    this.name = name;
    this.parameters = parameters;
    this.body = body;
    this.routePath = routePath;
    this.methods = methods;
  }

  @Override
  public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
