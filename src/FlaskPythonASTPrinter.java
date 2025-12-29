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

  private String format(String className, int line) {
    return indent() + className + " (Line " + line + ")\n";
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
    sb.append(format("FlaskPythonFunctionDeclaration", funcDecl.getLineNumber()));

    indentLevel++;

    if (funcDecl.parameters != null) {
      for (String param : funcDecl.parameters) {
        sb.append(format("FlaskPythonIdentifier", funcDecl.getLineNumber()));
      }
    }

    for (FlaskPythonStatement stmt : funcDecl.body) {
      sb.append(stmt.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonIfStatement ifStmt) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("FlaskPythonIfStatement", ifStmt.getLineNumber()));

    indentLevel++;

    sb.append(ifStmt.condition.accept(this));

    for (FlaskPythonStatement stmt : ifStmt.thenBloc) {
      sb.append(stmt.accept(this));
    }

    if (ifStmt.elseBloc != null) {
      sb.append(format("ElseBlock", ifStmt.getLineNumber()));
      indentLevel++;
      for (FlaskPythonStatement stmt : ifStmt.elseBloc) {
        sb.append(stmt.accept(this));
      }
      indentLevel--;
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonAssignmentStatement stmt) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("FlaskPythonAssignmentStatement", stmt.getLineNumber()));

    indentLevel++;
    sb.append(format("FlaskPythonIdentifier", stmt.getLineNumber()));

    sb.append(stmt.expression.accept(this));
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonReturnStatement stmt) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("FlaskPythonReturnStatement", stmt.getLineNumber()));

    if (stmt.expression != null) {
      indentLevel++;
      sb.append(stmt.expression.accept(this));
      indentLevel--;
    }
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonFunctionCall call) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("FlaskPythonFunctionCall", call.getLineNumber()));

    indentLevel++;
    for (var arg : call.arguments) {
      sb.append(arg.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonImportStatement stmt) {
    return format("FlaskPythonImportStatement", stmt.getLineNumber());
  }

  @Override
  public String visit(FlaskPythonBinaryExpression binExpr) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("FlaskPythonBinaryExpression", binExpr.getLineNumber()));

    indentLevel++;
    sb.append(binExpr.left.accept(this));
    sb.append(binExpr.right.accept(this));
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonIdentifier identifier) {
    return format("FlaskPythonIdentifier", identifier.getLineNumber());
  }

  @Override
  public String visit(FlaskPythonIntegerLiteral intLit) {
    return format("FlaskPythonIntegerLiteral", intLit.getLineNumber());
  }

  @Override
  public String visit(FlaskPythonStringLiteral stringLit) {
    return format("FlaskPythonStringLiteral", stringLit.getLineNumber());
  }

  @Override
  public String visit(FlaskPythonListExpression listExpr) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("FlaskPythonListExpression", listExpr.getLineNumber()));

    indentLevel++;
    for (var element : listExpr.elements) {
      sb.append(element.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonDictionaryExpression dictExpr) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("FlaskPythonDictionaryExpression", dictExpr.getLineNumber()));

    indentLevel++;
    for (var value : dictExpr.entries.values()) {
      sb.append(value.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonMemberAccess memberAccess) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("FlaskPythonMemberAccess", memberAccess.getLineNumber()));

    indentLevel++;
    sb.append(memberAccess.object.accept(this));
    sb.append(format("FlaskPythonIdentifier", memberAccess.getLineNumber()));
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FLaskPythonForStatement forStmt) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("FlaskPythonForStatement", forStmt.getLineNumber()));

    indentLevel++;

    sb.append(format("FlaskPythonIdentifier", forStmt.getLineNumber()));
    sb.append(forStmt.iterable.accept(this));

    for (FlaskPythonStatement s : forStmt.body) {
      sb.append(s.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonMethodCall methCall) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("FlaskPythonMethodCall", methCall.getLineNumber()));

    indentLevel++;
    sb.append(methCall.object.accept(this));

    for (var arg : methCall.arguments) {
      sb.append(arg.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(FlaskPythonBooleanLiteral booleanLiteral) {
    return format("FlaskPythonBooleanLiteral", booleanLiteral.getLineNumber());
  }

}
