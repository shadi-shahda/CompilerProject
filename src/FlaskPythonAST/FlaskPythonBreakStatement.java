package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonBreakStatement extends FlaskPythonStatement {
    public FlaskPythonBreakStatement(int lineNumber) {
        super(lineNumber);
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
