package FlaskPythonAST;

import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonAssignmentStatement extends FlaskPythonStatement {
    public String variableName;
    public FlaskPythonExpression expression;

    public FlaskPythonAssignmentStatement(String variableName, FlaskPythonExpression expression, int line) {
        super(line);
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
