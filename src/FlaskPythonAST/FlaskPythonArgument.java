package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonArgument extends FlaskPythonASTNode {

    public String keywordName;
    public FlaskPythonExpression value;
    public FlaskPythonArgument(String keywordName, FlaskPythonExpression value, int lineNumber) {
        super(lineNumber);
        this.keywordName = keywordName;
        this.value = value;
    }

    public boolean isKeywordArgument() {
        return keywordName != null && !keywordName.isEmpty();
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
