package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonExpressionStatement extends FlaskPythonStatement {
    public FlaskPythonExpression expression;
    public FlaskPythonExpressionStatement(FlaskPythonExpression expression, int lineNumber) {
        super(lineNumber);
        this.expression = expression;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {

        return visitor.visit(this);
    }
}
