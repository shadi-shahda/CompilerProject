import FlaskPythonAST.FLaskPythonForStatement;
import FlaskPythonAST.FlaskPythonAssignmentStatement;
import FlaskPythonAST.FlaskPythonBinaryExpression;
import FlaskPythonAST.FlaskPythonBooleanLiteral;
import FlaskPythonAST.FlaskPythonDictionaryExpression;
import FlaskPythonAST.FlaskPythonFunctionCall;
import FlaskPythonAST.FlaskPythonFunctionDeclaration;
import FlaskPythonAST.FlaskPythonIdentifier;
import FlaskPythonAST.FlaskPythonIfStatement;
import FlaskPythonAST.FlaskPythonImportStatement;
import FlaskPythonAST.FlaskPythonIntegerLiteral;
import FlaskPythonAST.FlaskPythonListExpression;
import FlaskPythonAST.FlaskPythonMemberAccess;
import FlaskPythonAST.FlaskPythonMethodCall;
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonAST.FlaskPythonReturnStatement;
import FlaskPythonAST.FlaskPythonStatement;
import FlaskPythonAST.FlaskPythonStringLiteral;
import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonASTPrinter implements ASTVisitor<String> {
  private int indentLevel = 0;

  private String indent() {
    return "  ".repeat(indentLevel);
  }

  @Override
  public String visit(FlaskPythonProgram program) {
    StringBuilder sb = new StringBuilder();
    sb.append("Program\n");
    indentLevel++;
    for (FlaskPythonStatement stmt : program.statements) {
      sb.append(stmt.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonFunctionDeclaration funcDecl) {
    StringBuilder sb = new StringBuilder();
    sb.append(indent()).append("Function: ").append(funcDecl.name).append("\n");
    indentLevel++;

    if (funcDecl.routePath != null) {
      sb.append(indent()).append("@Route: ").append(funcDecl.routePath).append("\n");
    }

    if (funcDecl.parameters != null && !funcDecl.parameters.isEmpty()) {
      sb.append(indent()).append("Params: ").append(funcDecl.parameters).append("\n");
    }

    sb.append(indent()).append("Body:\n");
    indentLevel++;
    for (FlaskPythonStatement stmt : funcDecl.body) {
      sb.append(stmt.accept(this));
    }
    indentLevel--; // close body
    indentLevel--; // close function
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonIfStatement ifStmt) {
    StringBuilder sb = new StringBuilder();
    sb.append(indent()).append("If (").append(ifStmt.condition.accept(this).trim()).append(")\n");

    indentLevel++;
    for (FlaskPythonStatement stmt : ifStmt.thenBloc) {
      sb.append(stmt.accept(this));
    }
    indentLevel--;

    if (ifStmt.elseBloc != null) {
      sb.append(indent()).append("Else\n");
      indentLevel++;
      for (FlaskPythonStatement stmt : ifStmt.elseBloc) {
        sb.append(stmt.accept(this));
      }
      indentLevel--;
    }
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonAssignmentStatement stmt) {
    return indent() + "Assign: " + stmt.variableName + " = " + stmt.expression.accept(this) + "\n";
  }

  @Override
  public String visit(FlaskPythonReturnStatement stmt) {
    String expr = (stmt.expression != null) ? stmt.expression.accept(this).trim() : "None";
    return indent() + "Return: " + expr + "\n";
  }

  @Override
  public String visit(FlaskPythonFunctionCall call) {
    return "Call " + call.functionName + "(" + call.arguments.size() + " args)";
  }

  @Override
  public String visit(FlaskPythonImportStatement stmt) {
    return indent() + "Import: " + stmt.libraryName + " " + stmt.importedItems + "\n";
  }

  @Override
  public String visit(FlaskPythonBinaryExpression e) {
    return e.left.accept(this).trim() + " " + e.operator + " " + e.right.accept(this).trim();
  }

  @Override
  public String visit(FlaskPythonIdentifier e) {
    return e.name;
  }

  @Override
  public String visit(FlaskPythonIntegerLiteral e) {
    return String.valueOf(e.value);
  }

  @Override
  public String visit(FlaskPythonStringLiteral e) {
    return "\"" + e.value + "\"";
  }

  @Override
  public String visit(FlaskPythonListExpression e) {
    return "[List...]";
  }

  @Override
  public String visit(FlaskPythonDictionaryExpression e) {
    return "{Dict...}";
  }

  @Override
  public String visit(FlaskPythonMemberAccess e) {
    return e.object.accept(this).trim() + "." + e.memberName;
  }

  @Override
  public String visit(FLaskPythonForStatement forStmt) {
    StringBuilder sb = new StringBuilder();

    sb.append(indent()).append("For ").append(forStmt.variableName)
        .append(" In ").append(forStmt.iterable.accept(this).trim()).append("\n");

    indentLevel++;
    for (FlaskPythonStatement s : forStmt.body) {
      sb.append(s.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonMethodCall methCall) {
    return methCall.object.accept(this).trim() + "." + methCall.methodName + "(...)";
  }

  @Override
  public String visit(FlaskPythonBooleanLiteral booleanLiteral) {
    return booleanLiteral.value ? "True" : "False";
  }

}
