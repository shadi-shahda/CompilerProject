import PythonAST.StringDefinition;

public class BaseVisitor extends FlaskPythonParserBaseVisitor<Object> {
  @Override
  public StringDefinition visitString(FlaskPythonParser.StringContext ctx) {
    String value = ctx.STRING().getText();
    // Remove the surrounding quotes
    value = value.substring(1, value.length() - 1);
    return new StringDefinition(value);
  }
}
