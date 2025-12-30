package FlaskPythonAST;

import java.util.List;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonListExpression extends FlaskPythonExpression {
    public List<FlaskPythonExpression> elements;

    public FlaskPythonListExpression(List<FlaskPythonExpression> elements, int line) {
        super(line);
        this.elements = elements;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
