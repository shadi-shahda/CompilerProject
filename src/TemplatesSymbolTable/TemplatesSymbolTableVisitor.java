package TemplatesSymbolTable;

import TemplatesAST.*;
import TemplatesVisitor.TemplatesASTVisitor;

public class TemplatesSymbolTableVisitor implements TemplatesASTVisitor<Void> {
    private TemplatesSymbolTable symbolTable;

    public TemplatesSymbolTableVisitor(TemplatesSymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public Void visit(JinjaForStatement node) {
        TemplatesSymbol iterableSymbol = this.symbolTable.resolveVariable(node.listName);

        if (iterableSymbol == null) {
            this.symbolTable.reportError("Undefined iterable variable '" + node.listName + "'", node.getLine());
            return null;
        }

        symbolTable.enterScope();

        // 3. تعريف متغير الحلقة (p)
        // هذا المتغير سيكون متاحاً فقط داخل هذا النطاق
        symbolTable.defineVariable(node.variableName, "LOOP_VAR", node.getLine());

        // 4. زيارة الجسم
        for (TemplatesASTNode child : node.statements) {
            child.accept(this);
        }

        // 5. الخروج
        symbolTable.exitScope();

        return null;
    }

    @Override
    public Void visit(JinjaIfStatement node) {
        // زيارة الشرط للتحقق من المتغيرات بداخله
        // مثلاً: {% if user.isActive %} -> سيفحص user
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
    public Void visit(VarExpression node) {
        // جوهر التحقق: هل المتغير المستخدم معروف؟
        TemplatesSymbol sym = symbolTable.resolveVariable(node.name);

        if (sym == null) {
            symbolTable.reportError("Variable '" + node.name + "' is not defined in the current scope.",
                    node.getLine());
        }
        return null;
    }

    // --- بقية الدوال (تمرير فقط) ---
    @Override
    public Void visit(TemplatesProgram node) {
        for (var c : node.children) {
            c.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(HtmlElement node) {
        for (var a : node.attributes) {
            a.accept(this);
        }
        for (var c : node.templates) {
            c.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(JinjaPrint node) {
        node.expression.accept(this);
        return null;
    }

    @Override
    public Void visit(MemberAccessExpression node) {
        node.expression.accept(this);
        return null;
    } // يفحص الابن اليسار فقط

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

    // الأوراق التي لا تحتاج فحص
    @Override
    public Void visit(KeyValueAttribute node) {
        /* المنطق السابق للكلاسات */ return null;
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
}