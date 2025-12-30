package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonMemberAccess extends FlaskPythonExpression {
    public FlaskPythonExpression object;
    public String memberName;

    public FlaskPythonMemberAccess(FlaskPythonExpression object, String memberName, int line) {
        super(line);
        this.object = object;
        this.memberName = memberName;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
