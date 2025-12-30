package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public abstract class FlaskPythonASTNode {
    protected int lineNumber;

    public FlaskPythonASTNode(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public abstract <T> T accept(FlaskPythonASTVisitor<T> visitor);
}