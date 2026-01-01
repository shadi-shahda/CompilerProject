package TemplatesSymbolTable;

import TemplatesAST.*;
import TemplatesVisitor.TemplatesASTVisitor;

public class TemplatesSymbolTableVisitor implements TemplatesASTVisitor<Void> {
    private TemplatesSymbolTable symbolTable;

    public TemplatesSymbolTableVisitor(TemplatesSymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    // --- الجذر (Root) ---
    @Override
    public Void visit(TemplatesProgram node) {
        for (TemplatesASTNode child : node.children) {
            child.accept(this);
        }
        return null;
    }

    // --- HTML Logic ---

    @Override
    public Void visit(HtmlElement node) {
        // نمر على الخصائص (Attributes) لنستخرج الكلاسات والآيديات
        for (HtmlAttribute attr : node.attributes) {
            attr.accept(this);
        }

        // نمر على الأبناء (Children) لاستكمال البحث
        for (TemplatesASTNode child : node.templates) {
            child.accept(this);
        }
        return null;
    }

    // --- التعامل مع الخصائص ذات القيم (class="btn") ---
    @Override
    public Void visit(KeyValueAttribute node) {
        // ملاحظة: node.value تأتي مع علامات التنصيص، يجب تنظيفها
        String cleanValue = stripQuotes(node.value);

        if (node.getKey().equalsIgnoreCase("class")) {
            // الكلاسات قد تكون متعددة ومفصولة بمسافات
            // مثال: "btn btn-primary mt-5"
            String[] classes = cleanValue.split("\\s+");
            for (String cls : classes) {
                if (!cls.isEmpty()) {
                    // نضيف النقطة لتتوافق مع تنسيق CSS Symbol Table
                    symbolTable.addUsedClass("." + cls);
                }
            }
        } else if (node.getKey().equalsIgnoreCase("id")) {
            // الآيدي قيمة واحدة فقط
            if (!cleanValue.isEmpty()) {
                symbolTable.addUsedId("#" + cleanValue);
            }
        }
        return null;
    }

    // --- التعامل مع الخصائص بدون قيم (checked, disabled) ---
    @Override
    public Void visit(OnlyKeyAttribute node) {
        // لا نفعل شيئاً هنا لأننا نبحث عن Classes و IDs
        // وهذه الخصائص دائماً تحتاج لقيمة (KeyValue)
        return null;
    }

    // --- التعامل مع النصوص ---
    @Override
    public Void visit(HtmlText node) {
        return null;
    }

    // --- Jinja Logic (Jinja Variables) ---

    @Override
    public Void visit(JinjaForStatement node) {
        // 1. (اختياري) التحقق من وجود القائمة التي ندور عليها
        TemplatesSymbol iterableSym = symbolTable.resolveVariable(node.listName);
        // if (iterableSym == null) System.out.println("Warning: " + node.iterable + "
        // not defined.");

        // 2. دخول نطاق جديد (Scope) لمتغيرات الحلقة
        symbolTable.enterScope();

        // 3. تعريف متغير الحلقة
        symbolTable.defineVariable(node.variableName, "LOOP_VAR", node.getLine());

        // 4. زيارة جسم الحلقة
        for (TemplatesASTNode child : node.statements) {
            child.accept(this);
        }

        // 5. الخروج من النطاق
        symbolTable.exitScope();

        return null;
    }

    @Override
    public Void visit(JinjaIfStatement node) {
        // زيارة الشرط
        node.condition.accept(this);

        // زيارة البلوك الأساسي
        for (TemplatesASTNode child : node.thenBody) {
            child.accept(this);
        }

        // زيارة بلوك else إن وجد
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

    // --- Expressions (التحقق من استخدام المتغيرات) ---

    @Override
    public Void visit(VarExpression node) {
        // عند استخدام متغير، نتحقق هل هو معرف في النطاق الحالي أو السابق
        TemplatesSymbol sym = symbolTable.resolveVariable(node.name);

        // ملاحظة: المتغيرات القادمة من الـ Backend (مثل products) لن تكون موجودة في
        // الجدول
        // إلا إذا أضفناها يدوياً كـ Global Context، لذا لا نعتبر عدم وجودها خطأً
        // حالياً.

        return null;
    }

    // --- بقية العقد (Pass-through or Ignore) ---

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

    // --- دالة مساعدة لتنظيف النصوص ---
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