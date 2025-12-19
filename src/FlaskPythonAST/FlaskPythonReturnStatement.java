package FlaskPythonAST;

import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonReturnStatement extends FlaskPythonStatement{
    public FlaskPythonExpression expression; // القيمة المرجعة (قد تكون null إذا كان return فقط)

    public FlaskPythonReturnStatement(FlaskPythonExpression expression, int line) {
        super(line);
        this.expression = expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
