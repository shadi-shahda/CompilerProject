package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonAssignmentStatement extends FlaskPythonStatement {
    public String variableName;
    public FlaskPythonExpression expression;

    public FlaskPythonAssignmentStatement(String variableName, FlaskPythonExpression expression, int line) {
        super(line);
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
