package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonBinaryExpression extends FlaskPythonExpression {
    public FlaskPythonExpression left;
    public FlaskPythonExpression right;
    public String operator;

    public FlaskPythonBinaryExpression(FlaskPythonExpression left, String operator, FlaskPythonExpression right,
            int line) {
        super(line);
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
