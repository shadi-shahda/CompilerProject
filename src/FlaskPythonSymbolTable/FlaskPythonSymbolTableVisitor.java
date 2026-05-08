package FlaskPythonSymbolTable;

import java.util.HashSet;
import java.util.Set;

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
    if (funcDecl.methods.size() > 1) {
      Set<String> checkMethodDuplication = new HashSet<>(funcDecl.methods);
      if (checkMethodDuplication.size() < funcDecl.methods.size()) {
        this.symbolTable.reportError("Duplicate method definition detected", funcDecl.getLineNumber());
      }
    }
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

    if (funcDecl.routePath == null || funcDecl.routePath.isEmpty()) {
      this.symbolTable.defineVariable(funcDecl.name, FlaskPythonType.METHOD);
    } else {
      this.symbolTable.defineVariable(funcDecl.name, FlaskPythonType.ROUTE);
    }

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
    // Validate known built-in functions
    switch (funcCall.functionName) {
      case "len":
        if (funcCall.arguments == null || funcCall.arguments.isEmpty()) {
          symbolTable.reportError("TypeError: len() missing required argument", funcCall.getLineNumber());
        } else {
          FlaskPythonType argType = funcCall.arguments.get(0).accept(this);
          if (argType != FlaskPythonType.LIST && argType != FlaskPythonType.STRING && argType != FlaskPythonType.DICT &&
              argType != FlaskPythonType.UNKNOWN) {
            symbolTable.reportError("TypeError: object of type '" + argType + "' has no len()",
                funcCall.getLineNumber());
          }
        }
        return FlaskPythonType.INT;
      case "str":
        if (funcCall.arguments == null || funcCall.arguments.isEmpty()) {
          symbolTable.reportError("TypeError: str() missing required argument", funcCall.getLineNumber());
        }
        return FlaskPythonType.STRING;
      case "int":
        if (funcCall.arguments == null || funcCall.arguments.isEmpty()) {
          symbolTable.reportError("TypeError: int() missing required argument", funcCall.getLineNumber());
        }
        return FlaskPythonType.INT;
    }

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

    // Enter block scope for for loop
    this.symbolTable.enterScope();
    this.symbolTable.defineVariable(forStmt.variableName, FlaskPythonType.UNKNOWN);

    for (FlaskPythonStatement stmt : forStmt.body) {
      stmt.accept(this);
    }

    // Exit block scope for for loop
    this.symbolTable.exitScope();
    return FlaskPythonType.VOID;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonBinaryExpression binExpr) {
    FlaskPythonType left = binExpr.left.accept(this);
    FlaskPythonType right = binExpr.right.accept(this);
    String operator = binExpr.operator;

    // Arithmetic operators
    if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
      if (left == FlaskPythonType.INT && right == FlaskPythonType.INT) {
        return FlaskPythonType.INT;
      } else if (left == FlaskPythonType.STRING && operator.equals("+") && right == FlaskPythonType.STRING) {
        return FlaskPythonType.STRING;
      } else if ((left == FlaskPythonType.INT || left == FlaskPythonType.UNKNOWN) &&
          (right == FlaskPythonType.INT || right == FlaskPythonType.UNKNOWN)) {
        return left == FlaskPythonType.UNKNOWN ? right : left;
      } else if (left != FlaskPythonType.UNKNOWN && right != FlaskPythonType.UNKNOWN) {
        symbolTable.reportError(
            "Type Error: Unsupported operand types for " + operator + ": '" + left + "' and '" + right + "'",
            binExpr.getLineNumber());
      }
      return FlaskPythonType.INT;
    }

    // Comparison operators always return boolean
    if (operator.equals("==") || operator.equals("!=") || operator.equals(">") || operator.equals("<")
        || operator.equals(">=") || operator.equals("<=")) {
      // Validate that comparable types are being used
      if (left != FlaskPythonType.UNKNOWN && right != FlaskPythonType.UNKNOWN) {
        if ((left == FlaskPythonType.INT || left == FlaskPythonType.STRING) &&
            (right == FlaskPythonType.INT || right == FlaskPythonType.STRING)) {
          if (left != right) {
            symbolTable.reportError("Type Warning: Comparing different types " + left + " and " + right,
                binExpr.getLineNumber());
          }
        }
      }
      return FlaskPythonType.BOOLEAN;
    }

    // Logical operators
    if (operator.equals("and") || operator.equals("or")) {
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
    // Infer element types from list contents
    FlaskPythonType elementType = FlaskPythonType.UNKNOWN;

    if (!listExpr.elements.isEmpty()) {
      // Try to infer element type from first element
      FlaskPythonType firstElemType = listExpr.elements.get(0).accept(this);
      elementType = firstElemType;

      // Check for type consistency in remaining elements
      for (int i = 1; i < listExpr.elements.size(); i++) {
        FlaskPythonType elemType = listExpr.elements.get(i).accept(this);
        if (elemType != elementType && elemType != FlaskPythonType.UNKNOWN && elementType != FlaskPythonType.UNKNOWN) {
          // Mixed types in list - warn but don't fail
          if (i == 1) {
            this.symbolTable.reportError("Type Warning: List contains mixed types: " + elementType + " and " + elemType,
                listExpr.getLineNumber());
          }
          elementType = FlaskPythonType.UNKNOWN; // Fall back to unknown if mixed
        }
      }
    }

    return FlaskPythonType.LIST;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonDictionaryExpression dictExpr) {
    FlaskPythonType valueType = FlaskPythonType.UNKNOWN;

    int count = 0;
    for (var entry : dictExpr.entries.entrySet()) {
      FlaskPythonType valType = entry.getValue().accept(this);
      if (count == 0) {
        valueType = valType;
      } else if (valType != valueType && valType != FlaskPythonType.UNKNOWN && valueType != FlaskPythonType.UNKNOWN) {
        valueType = FlaskPythonType.UNKNOWN; // Mixed value types
      }
      count++;
    }

    return FlaskPythonType.DICT;
  }

  @Override
  public FlaskPythonType visit(FlaskPythonIfStatement ifStmt) {
    if (ifStmt.condition != null) {
      ifStmt.condition.accept(this);
    }

    // Enter scope for then block
    this.symbolTable.enterScope();
    for (var stmt : ifStmt.thenBloc) {
      stmt.accept(this);
    }
    this.symbolTable.exitScope();

    // Enter separate scope for else block if present
    if (ifStmt.elseBloc != null) {
      this.symbolTable.enterScope();
      for (var stmt : ifStmt.elseBloc) {
        stmt.accept(this);
      }
      this.symbolTable.exitScope();
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