package FlaskPythonAST;

import FlaskPythonVisitor.ASTVisitor;

public abstract class FlaskPythonASTNode {
    protected int lineNumber;

    public FlaskPythonASTNode(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    // الدالة السحرية التي تحقق الـ Polymorphism
    // كل عقدة ستنفذها بطريقتها الخاصة لتستدعي الزائر المناسب
    public abstract <T> T accept(ASTVisitor<T> visitor);
}