package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonIdentifier extends FlaskPythonExpression {
    public String name;

    public FlaskPythonIdentifier(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
