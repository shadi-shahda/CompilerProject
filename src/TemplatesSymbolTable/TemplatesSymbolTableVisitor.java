package TemplatesSymbolTable;

import TemplatesAST.*;
import TemplatesVisitor.TemplatesASTVisitor;

public class TemplatesSymbolTableVisitor implements TemplatesASTVisitor<Void> {
    private TemplatesSymbolTable symbolTable;

    public TemplatesSymbolTableVisitor(TemplatesSymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public Void visit(JinjaForStatement forStmt) {
        TemplatesSymbol iterableSymbol = this.symbolTable.resolveVariable(forStmt.listName);

        if (iterableSymbol == null) {
            this.symbolTable.reportError("Undefined iterable variable '" + forStmt.listName + "'", forStmt.getLine());
            return null;
        }

        this.symbolTable.enterScope();
        this.symbolTable.defineVariable(forStmt.variableName, "LOOP_VAR", forStmt.getLine());
        for (TemplatesASTNode child : forStmt.statements) {
            child.accept(this);
        }
        this.symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(JinjaIfStatement ifStmt) {
        ifStmt.condition.accept(this);
        for (TemplatesASTNode child : ifStmt.thenBody) {
            child.accept(this);
        }
        if (ifStmt.elseBody != null) {
            for (TemplatesASTNode child : ifStmt.elseBody) {
                child.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(VarExpression varExpr) {
        TemplatesSymbol sym = this.symbolTable.resolveVariable(varExpr.name);
        if (sym == null) {
            this.symbolTable.reportError("Variable '" + varExpr.name + "' is not defined in the current scope.",
                    varExpr.getLine());
        }
        return null;
    }

    @Override
    public Void visit(TemplatesProgram program) {
        for (var c : program.children) {
            c.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(HtmlElement element) {
        for (var a : element.attributes) {
            a.accept(this);
        }
        for (var c : element.templates) {
            c.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(JinjaPrint jinjaPrint) {
        jinjaPrint.expression.accept(this);
        return null;
    }

    @Override
    public Void visit(MemberAccessExpression memberAccessExpr) {
        memberAccessExpr.expression.accept(this);
        return null;
    }

    @Override
    public Void visit(DictionaryAccessExpression dictionaryAccessExpr) {
        dictionaryAccessExpr.object.accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpr) {
        binaryExpr.left.accept(this);
        binaryExpr.right.accept(this);
        return null;
    }

    @Override
    public Void visit(LogicalExpression logicalExpr) {
        logicalExpr.left.accept(this);
        logicalExpr.right.accept(this);
        return null;
    }

    @Override
    public Void visit(NotExpression notExpr) {
        notExpr.expression.accept(this);
        return null;
    }

    @Override
    public Void visit(KeyValueAttribute attribute) {
        return null;
    }

    @Override
    public Void visit(OnlyKeyAttribute attribute) {
        return null;
    }

    @Override
    public Void visit(HtmlText text) {
        return null;
    }

    @Override
    public Void visit(StringExpression StringExpr) {
        return null;
    }

    @Override
    public Void visit(IntExpression intExpr) {
        return null;
    }

    @Override
    public Void visit(BoolExpression boolExpr) {
        return null;
    }
}