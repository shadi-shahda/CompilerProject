package FlaskPythonAST;

import java.util.Map;

import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonDictionaryExpression extends FlaskPythonExpression {

    public Map<String, FlaskPythonExpression> entries;

    public FlaskPythonDictionaryExpression(Map<String, FlaskPythonExpression> entries, int line) {
        super(line);
        this.entries = entries;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
