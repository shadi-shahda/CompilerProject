package FlaskPythonAST;

import java.util.Map;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonDictionaryExpression extends FlaskPythonExpression {

    public Map<FlaskPythonExpression, FlaskPythonExpression> entries;

    public FlaskPythonDictionaryExpression(Map<FlaskPythonExpression, FlaskPythonExpression> entries, int line) {
        super(line);
        this.entries = entries;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
