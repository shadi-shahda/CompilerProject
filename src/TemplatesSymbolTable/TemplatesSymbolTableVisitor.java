package TemplatesSymbolTable;

import TemplatesAST.*;
import TemplatesVisitor.TemplatesASTVisitor;

public class TemplatesSymbolTableVisitor implements TemplatesASTVisitor<Void> {
    private TemplatesSymbolTable symbolTable;

    public TemplatesSymbolTableVisitor(TemplatesSymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public Void visit(TemplatesProgram node) {
        for (TemplatesASTNode child : node.children) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(HtmlElement node) {
        for (HtmlAttribute attr : node.attributes) {
            attr.accept(this);
        }

        for (TemplatesASTNode child : node.templates) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(KeyValueAttribute node) {
        String cleanValue = stripQuotes(node.value);

        if (node.getKey().equalsIgnoreCase("class")) {
            String[] classes = cleanValue.split("\\s+");
            for (String cls : classes) {
                if (!cls.isEmpty()) {
                    symbolTable.addUsedClass("." + cls);
                }
            }
        } else if (node.getKey().equalsIgnoreCase("id")) {
            if (!cleanValue.isEmpty()) {
                symbolTable.addUsedId("#" + cleanValue);
            }
        }
        return null;
    }

    @Override
    public Void visit(OnlyKeyAttribute node) {
        return null;
    }

    @Override
    public Void visit(HtmlText node) {
        return null;
    }

    @Override
    public Void visit(JinjaForStatement node) {
        symbolTable.enterScope();

        symbolTable.defineVariable(node.variableName, "LOOP_VAR", node.getLine());

        for (TemplatesASTNode child : node.statements) {
            child.accept(this);
        }

        symbolTable.exitScope();

        return null;
    }

    @Override
    public Void visit(JinjaIfStatement node) {
        node.condition.accept(this);

        for (TemplatesASTNode child : node.thenBody) {
            child.accept(this);
        }

        if (node.elseBody != null) {
            for (TemplatesASTNode child : node.elseBody) {
                child.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(JinjaPrint node) {
        node.expression.accept(this);
        return null;
    }

    @Override
    public Void visit(VarExpression node) {
        return null;
    }

    @Override
    public Void visit(MemberAccessExpression node) {
        node.expression.accept(this);
        return null;
    }

    @Override
    public Void visit(DictionaryAccessExpression node) {
        node.object.accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression node) {
        node.left.accept(this);
        node.right.accept(this);
        return null;
    }

    @Override
    public Void visit(LogicalExpression node) {
        node.left.accept(this);
        node.right.accept(this);
        return null;
    }

    @Override
    public Void visit(NotExpression node) {
        node.expression.accept(this);
        return null;
    }

    @Override
    public Void visit(StringExpression node) {
        return null;
    }

    @Override
    public Void visit(IntExpression node) {
        return null;
    }

    @Override
    public Void visit(BoolExpression node) {
        return null;
    }

    private String stripQuotes(String value) {
        if (value == null || value.length() < 2)
            return value;
        char first = value.charAt(0);
        char last = value.charAt(value.length() - 1);

        if ((first == '"' && last == '"') || (first == '\'' && last == '\'')) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }
}