package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonReturnStatement extends FlaskPythonStatement{
    public FlaskPythonExpression expression;

    public FlaskPythonReturnStatement(FlaskPythonExpression expression, int line) {
        super(line);
        this.expression = expression;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
