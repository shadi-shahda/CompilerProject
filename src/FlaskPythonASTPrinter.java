import FlaskPythonAST.*;
import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonASTPrinter implements FlaskPythonASTVisitor<String> {

  private int indentLevel = 0;

  private String indent() {
    return "  ".repeat(indentLevel);
  }

  private String line(String text, int line) {
    return indent() + text + " (Line " + line + ")\n";
  }

  // ================= PROGRAM =================
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

  // ================= IMPORT =================
  @Override
  public String visit(FlaskPythonImportStatement stmt) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("Import: " + stmt.libraryName, stmt.getLineNumber()));

    if (stmt.importedItems != null) {
      indentLevel++;
      for (String item : stmt.importedItems) {
        sb.append(line("ImportItem: " + item, stmt.getLineNumber()));
      }
      indentLevel--;
    }

    return sb.toString();
  }

  // ================= IDENTIFIER =================
  @Override
  public String visit(FlaskPythonIdentifier id) {
    return line("Identifier: " + id.name, id.getLineNumber());
  }

  // ================= LITERALS =================
  @Override
  public String visit(FlaskPythonIntegerLiteral lit) {
    return line("Integer: " + lit.value, lit.getLineNumber());
  }

  @Override
  public String visit(FlaskPythonStringLiteral lit) {
    return line("String: " + lit.value, lit.getLineNumber());
  }

  @Override
  public String visit(FlaskPythonBooleanLiteral lit) {
    return line("Boolean: " + lit.value, lit.getLineNumber());
  }

  // ================= ASSIGNMENT =================
  @Override
  public String visit(FlaskPythonAssignmentStatement stmt) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("Assignment", stmt.getLineNumber()));

    indentLevel++;
    sb.append(line("Identifier: " + stmt.variableName, stmt.getLineNumber()));
    sb.append(stmt.expression.accept(this));
    indentLevel--;

    return sb.toString();
  }

  // ================= FUNCTION CALL =================
  @Override
  public String visit(FlaskPythonFunctionCall call) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("FunctionCall: " + call.functionName, call.getLineNumber()));

    indentLevel++;
    for (var arg : call.arguments) {
      sb.append(arg.accept(this));
    }
    indentLevel--;

    return sb.toString();
  }

  // ================= RETURN =================
  @Override
  public String visit(FlaskPythonReturnStatement stmt) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("Return", stmt.getLineNumber()));

    if (stmt.expression != null) {
      indentLevel++;
      sb.append(stmt.expression.accept(this));
      indentLevel--;
    }

    return sb.toString();
  }

  // ================= IF =================
  @Override
  public String visit(FlaskPythonIfStatement stmt) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("If", stmt.getLineNumber()));

    indentLevel++;

    sb.append(stmt.condition.accept(this));

    for (FlaskPythonStatement s : stmt.thenBloc) {
      sb.append(s.accept(this));
    }

    if (stmt.elseBloc != null) {
      sb.append(line("Else", stmt.getLineNumber()));
      indentLevel++;
      for (FlaskPythonStatement s : stmt.elseBloc) {
        sb.append(s.accept(this));
      }
      indentLevel--;
    }

    indentLevel--;

    return sb.toString();
  }

  // ================= FOR (FIXED) =================
  @Override
  public String visit(FLaskPythonForStatement stmt) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("For: " + stmt.variableName + " in", stmt.getLineNumber()));

    indentLevel++;

    sb.append(line("Iterable", stmt.getLineNumber()));
    sb.append(stmt.iterable.accept(this));

    for (FlaskPythonStatement s : stmt.body) {
      sb.append(s.accept(this));
    }

    indentLevel--;

    return sb.toString();
  }

  // ================= BINARY =================
  @Override
  public String visit(FlaskPythonBinaryExpression expr) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("BinaryExpression: " + expr.operator, expr.getLineNumber()));

    indentLevel++;
    sb.append(expr.left.accept(this));
    sb.append(expr.right.accept(this));
    indentLevel--;

    return sb.toString();
  }

  // ================= LIST =================
  @Override
  public String visit(FlaskPythonListExpression list) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("List", list.getLineNumber()));

    indentLevel++;
    for (var e : list.elements) {
      sb.append(e.accept(this));
    }
    indentLevel--;

    return sb.toString();
  }

  // ================= DICTIONARY (FIXED) =================
  @Override
  public String visit(FlaskPythonDictionaryExpression dict) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("Dictionary", dict.getLineNumber()));

    indentLevel++;

    for (var entry : dict.entries.entrySet()) {
      sb.append(indent());
      sb.append(entry.getKey())
              .append(" -> ");
      sb.append(entry.getValue().accept(this));
    }

    indentLevel--;

    return sb.toString();
  }

  // ================= MEMBER ACCESS (FIXED) =================
  @Override
  public String visit(FlaskPythonMemberAccess access) {
    return line(
            "MemberAccess: " + access.object.accept(this).trim() + "." + access.memberName,
            access.getLineNumber()
    );
  }

  // ================= PRINT =================
  @Override
  public String visit(FlaskPythonPrintStatement stmt) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("Print", stmt.getLineNumber()));

    indentLevel++;
    sb.append(stmt.expression.accept(this));
    indentLevel--;

    return sb.toString();
  }

  // ================= FUNCTION =================
  @Override
  public String visit(FlaskPythonFunctionDeclaration func) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("Function: " + func.name, func.getLineNumber()));

    indentLevel++;

    if (func.parameters != null) {
      for (String p : func.parameters) {
        sb.append(line("Param: " + p, func.getLineNumber()));
      }
    }

    for (FlaskPythonStatement s : func.body) {
      sb.append(s.accept(this));
    }

    indentLevel--;

    return sb.toString();
  }

  // ================= METHOD CALL =================
  @Override
  public String visit(FlaskPythonMethodCall call) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("MethodCall: " + call.methodName, call.getLineNumber()));

    indentLevel++;
    sb.append(call.object.accept(this));

    for (var a : call.arguments) {
      sb.append(a.accept(this));
    }
    indentLevel--;

    return sb.toString();
  }
}