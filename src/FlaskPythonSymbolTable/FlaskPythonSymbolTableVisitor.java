package FlaskPythonSymbolTable;

import FlaskPythonAST.FLaskPythonForStatement;
import FlaskPythonAST.FlaskPythonAssignmentStatement;
import FlaskPythonAST.FlaskPythonBinaryExpression;
import FlaskPythonAST.FlaskPythonBooleanLiteral;
import FlaskPythonAST.FlaskPythonDictionaryExpression;
import FlaskPythonAST.FlaskPythonExpression;
import FlaskPythonAST.FlaskPythonFunctionCall;
import FlaskPythonAST.FlaskPythonFunctionDeclaration;
import FlaskPythonAST.FlaskPythonIdentifier;
import FlaskPythonAST.FlaskPythonIfStatement;
import FlaskPythonAST.FlaskPythonImportStatement;
import FlaskPythonAST.FlaskPythonIntegerLiteral;
import FlaskPythonAST.FlaskPythonListExpression;
import FlaskPythonAST.FlaskPythonMemberAccess;
import FlaskPythonAST.FlaskPythonMethodCall;
import FlaskPythonAST.FlaskPythonPrintStatement;
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonAST.FlaskPythonReturnStatement;
import FlaskPythonAST.FlaskPythonStatement;
import FlaskPythonAST.FlaskPythonStringLiteral;
import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonSymbolTableVisitor implements FlaskPythonASTVisitor<FlaskPythonType> {

  public FlaskPythonSymbolTable symbolTable;

  public FlaskPythonSymbolTableVisitor(FlaskPythonSymbolTable symbolTable) {
    this.symbolTable = symbolTable;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonProgram program) {
    for (FlaskPythonStatement statement : program.statements) {
      statement.accept(this);
    }
    return FlaskPythonType.VOID;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonFunctionDeclaration funcDecl) {
    if (funcDecl.routePath != null && !funcDecl.routePath.isEmpty()) {
      String route = stripQuotes(funcDecl.routePath);
      if (symbolTable.isRouteDefined(route)) {
        this.symbolTable.reportError("Duplicate route definition detected: " + route, funcDecl.getLineNumber());
      } else {
        this.symbolTable.addRoute(route);
      }
    }

    if (this.symbolTable.isVariableDefined(funcDecl.name)) {
      this.symbolTable.reportError("Function '" + funcDecl.name + "' is already defined.", funcDecl.getLineNumber());
    }
    this.symbolTable.defineVariable(funcDecl.name, FlaskPythonType.OBJECT);

    this.symbolTable.enterScope();

    if (funcDecl.parameters != null) {
      for (String param : funcDecl.parameters) {
        this.symbolTable.defineVariable(param, FlaskPythonType.UNKNOWN);
      }
    }

    if (funcDecl.body != null) {
      for (FlaskPythonStatement stmt : funcDecl.body) {
        stmt.accept(this);
      }
    }

    this.symbolTable.exitScope();
    return FlaskPythonType.VOID;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonAssignmentStatement assignStmt) {
    FlaskPythonType inferredType = FlaskPythonType.UNKNOWN;
    if (assignStmt.expression != null) {
      inferredType = assignStmt.expression.accept(this);
    }

    symbolTable.defineVariable(assignStmt.variableName, inferredType);

    return FlaskPythonType.VOID;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonIdentifier identifier) {
    if (!symbolTable.isVariableDefined(identifier.name)) {
      this.symbolTable.reportError("Undefined variable '" + identifier.name + "' used.", identifier.getLineNumber());
      return FlaskPythonType.UNKNOWN;
    }
    return this.symbolTable.getVariableType(identifier.name);
  }

  @Override
  public FlaskPythonType visit(FlaskPythonFunctionCall funcCall) {
    if ("render_template".equals(funcCall.functionName)) {
      if (funcCall.arguments != null && !funcCall.arguments.isEmpty()) {
        FlaskPythonExpression firstArg = funcCall.arguments.get(0);

        if (firstArg instanceof FlaskPythonStringLiteral) {
          String templateName = stripQuotes(((FlaskPythonStringLiteral) firstArg).value);
          if (!this.symbolTable.isTemplateExists(templateName)) {
            this.symbolTable.reportError("Template file not found: '" + templateName + "'",
                funcCall.getLineNumber());
          }
        }
      }
    }
    for (FlaskPythonExpression arg : funcCall.arguments) {
      arg.accept(this);
    }

    return FlaskPythonType.UNKNOWN;
  }

  @Override
  public FlaskPythonType visit(FLaskPythonForStatement forStmt) {
    FlaskPythonType iterableType = FlaskPythonType.UNKNOWN;

    if (forStmt.iterable != null) {
      iterableType = forStmt.iterable.accept(this);
    }

    if (iterableType != FlaskPythonType.LIST
        && iterableType != FlaskPythonType.DICT
        && iterableType != FlaskPythonType.STRING
        && iterableType != FlaskPythonType.UNKNOWN) {

      this.symbolTable.reportError("Type Error: Object of type '" + iterableType + "' is not iterable.",
          forStmt.getLineNumber());
    }

    // this.symbolTable.enterScope();
    this.symbolTable.defineVariable(forStmt.variableName, FlaskPythonType.UNKNOWN);

    for (FlaskPythonStatement stmt : forStmt.body) {
      stmt.accept(this);
    }

    // this.symbolTable.exitScope();
    return FlaskPythonType.VOID;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonBinaryExpression binExpr) {
    FlaskPythonType left = binExpr.left.accept(this);
    FlaskPythonType right = binExpr.right.accept(this);
    String operator = binExpr.operator;

    if (operator.equals("+")) {
      if ((left == FlaskPythonType.INT && right == FlaskPythonType.STRING) ||
          (left == FlaskPythonType.STRING && right == FlaskPythonType.INT)) {
        symbolTable.reportError("Type Error: Unsupported operand types for +: '" + left + "' and '" + right + "'",
            binExpr.getLineNumber());
      }

      if (left == right) {
        return left;
      }
    }

    if (operator.equals("==") || operator.equals("!=") || operator.equals(">") || operator.equals("<")
        || operator.equals(">=") || operator.equals("<=")) {
      return FlaskPythonType.BOOLEAN;
    }

    return FlaskPythonType.UNKNOWN;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonIntegerLiteral intLit) {
    return FlaskPythonType.INT;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonStringLiteral stringLit) {
    return FlaskPythonType.STRING;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonBooleanLiteral booleanLiteral) {
    return FlaskPythonType.BOOLEAN;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonListExpression listExpr) {
    for (var elem : listExpr.elements) {
      elem.accept(this);
    }
    return FlaskPythonType.LIST;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonDictionaryExpression dictExpr) {
    for (var val : dictExpr.entries.values()) {
      val.accept(this);
    }
    return FlaskPythonType.DICT;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonIfStatement ifStmt) {
    if (ifStmt.condition != null) {
      ifStmt.condition.accept(this);
    }

    for (var stmt : ifStmt.thenBloc) {
      stmt.accept(this);
    }

    if (ifStmt.elseBloc != null) {
      for (var stmt : ifStmt.elseBloc) {
        stmt.accept(this);
      }
    }

    return FlaskPythonType.VOID;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonImportStatement importStmt) {
    if (importStmt.importedItems != null) {
      for (String name : importStmt.importedItems) {
        this.symbolTable.defineVariable(name, FlaskPythonType.OBJECT);
      }
    }
    return FlaskPythonType.VOID;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonPrintStatement printStmt) {
    if (printStmt.expression != null) {
      printStmt.expression.accept(this);
    }
    return FlaskPythonType.VOID;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonReturnStatement returnStmt) {
    if (returnStmt.expression != null) {
      return returnStmt.expression.accept(this);
    }
    return FlaskPythonType.VOID;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonMemberAccess memberAccess) {
    FlaskPythonType infferedType = memberAccess.object.accept(this);
    return infferedType;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonMethodCall methCall) {
    if (methCall.object != null) {
      methCall.object.accept(this);
    }

    for (var arg : methCall.arguments) {
      arg.accept(this);
    }
    
    return FlaskPythonType.UNKNOWN;
  }

  private String stripQuotes(String s) {
    if (s == null)
      return "";
    if (s.length() >= 2 && (s.startsWith("'") || s.startsWith("\""))) {
      return s.substring(1, s.length() - 1);
    }
    return s;
  }
}