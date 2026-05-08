package TemplatesSymbolTable;

import TemplatesAST.BinaryExpression;
import TemplatesAST.BoolExpression;
import TemplatesAST.DictionaryAccessExpression;
import TemplatesAST.HtmlElement;
import TemplatesAST.HtmlText;
import TemplatesAST.IntExpression;
import TemplatesAST.JinjaForStatement;
import TemplatesAST.JinjaIfStatement;
import TemplatesAST.JinjaPrint;
import TemplatesAST.KeyValueAttribute;
import TemplatesAST.LogicalExpression;
import TemplatesAST.MemberAccessExpression;
import TemplatesAST.NotExpression;
import TemplatesAST.OnlyKeyAttribute;
import TemplatesAST.StringExpression;
import TemplatesAST.TemplatesASTNode;
import TemplatesAST.TemplatesProgram;
import TemplatesAST.VarExpression;
import TemplatesVisitor.TemplatesASTVisitor;

public class TemplatesSymbolTableVisitor implements TemplatesASTVisitor<Void> {
    private TemplatesSymbolTable symbolTable;

    public TemplatesSymbolTableVisitor(TemplatesSymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public TemplatesSymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(TemplatesSymbolTable symbolTable) {
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
            if(a instanceof KeyValueAttribute) {
                KeyValueAttribute kvAttr = (KeyValueAttribute) a;
                if (kvAttr.getKey().equals("class")) {
                    String[] classes = kvAttr.value.split("\\s+");
                    for (String cls : classes) {
                        symbolTable.addUsedClass(cls);
                    }
                } else if (kvAttr.getKey().equals("id")) {
                    symbolTable.addUsedId(kvAttr.value);
                } else {
                    symbolTable.addUsedSelector(element.tagName + "[" + kvAttr.getKey() + "]");
                }
            }
            a.accept(this);
        }
        for (var c : element.templates) {
            c.accept(this);
        }
        symbolTable.addUsedSelector(element.tagName);
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