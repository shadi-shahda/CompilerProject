package FlaskPythonSymbolTable;

import FlaskPythonAST.FLaskPythonForStatement;
import FlaskPythonAST.FlaskPythonAssignmentStatement;
import FlaskPythonAST.FlaskPythonBinaryExpression;
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
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonAST.FlaskPythonReturnStatement;
import FlaskPythonAST.FlaskPythonStatement;
import FlaskPythonAST.FlaskPythonStringLiteral;
import FlaskPythonVisitor.ASTVisitor;

// يرث من ASTVisitor (الواجهة التي أنشأناها سابقاً)
// نوع الإرجاع Void لأننا لا نحتاجZ لإرجاع قيم، فقط نملأ الجدول
public class FlaskPythonSymbolTableVisitor implements ASTVisitor<Void> {

    private FlaskPythonSymbolTable symbolTable;

    public FlaskPythonSymbolTableVisitor(FlaskPythonSymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
    
    @Override
    public Void visit(FlaskPythonProgram program) {
        for (FlaskPythonStatement stmt : program.statements) {
            stmt.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FlaskPythonFunctionDeclaration funcDecl) {
        symbolTable.define(funcDecl.name, "FUNCTION");
        symbolTable.enterScope();
        if (funcDecl.parameters != null) {
            for (String param : funcDecl.parameters) {
                symbolTable.define(param, "PARAMETER");
            }
        }
        for (FlaskPythonStatement stmt : funcDecl.body) {
            stmt.accept(this);
        }
        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(FlaskPythonIfStatement ifStmt) {
        ifStmt.condition.accept(this);
        for (FlaskPythonStatement stmt : ifStmt.thenBloc)
            stmt.accept(this);
        if (ifStmt.elseBloc != null) {
            for (FlaskPythonStatement stmt : ifStmt.elseBloc)
                stmt.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FlaskPythonReturnStatement returnStmt) {
        if (returnStmt.expression != null)
            returnStmt.expression.accept(this);
        return null;
    }

    @Override
    public Void visit(FlaskPythonAssignmentStatement assignStmt) {
        symbolTable.define(assignStmt.variableName, "VARIABLE");
        assignStmt.expression.accept(this);
        return null;
    }

    @Override
    public Void visit(FlaskPythonImportStatement importStmt) {
        symbolTable.define(importStmt.libraryName, "LIBRARY");
        for (String item : importStmt.importedItems) {
            symbolTable.define(item, "IMPORTED");
        }
        return null;
    }

    @Override
    public Void visit(FlaskPythonBinaryExpression binExpr) {
        binExpr.left.accept(this);
        binExpr.right.accept(this);
        return null;
    }

    @Override
    public Void visit(FlaskPythonIdentifier identifier) {
        return null;
    }

    @Override
    public Void visit(FlaskPythonStringLiteral stringLit) {
        return null;
    }

    @Override
    public Void visit(FlaskPythonIntegerLiteral intLit) {
        return null;
    }

    @Override
    public Void visit(FlaskPythonFunctionCall funcCall) {
        for (FlaskPythonExpression expression : funcCall.arguments) {
            expression.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FlaskPythonListExpression listExpr) {
        for (FlaskPythonExpression expression : listExpr.elements) {
            expression.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FlaskPythonDictionaryExpression dictExpr) {
        for (FlaskPythonExpression expression : dictExpr.entries.values()) {
            expression.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FlaskPythonMemberAccess memberAccess) {
        memberAccess.object.accept(this);
        return null;
    }

    @Override
    public Void visit(FLaskPythonForStatement forStmt) {
        forStmt.iterable.accept(this);
        for (FlaskPythonStatement stmt : forStmt.body) {
            stmt.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FlaskPythonMethodCall methCall) {
        methCall.object.accept(this);
        for (FlaskPythonExpression expression : methCall.arguments) {
            expression.accept(this);
        }
        return null;
    }

}