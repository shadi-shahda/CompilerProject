package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonListComprehensionExpression extends FlaskPythonExpression {
    public FlaskPythonExpression elementExpression;
    public String loopVariable;
    public FlaskPythonExpression iterableExpression;
    public FlaskPythonExpression conditionExpression;
    public FlaskPythonListComprehensionExpression(
            FlaskPythonExpression elementExpression,
            String loopVariable,
            FlaskPythonExpression iterableExpression,
            FlaskPythonExpression conditionExpression,
            int lineNumber
    ) {
        super(lineNumber);
        this.elementExpression = elementExpression;
        this.loopVariable = loopVariable;
        this.iterableExpression = iterableExpression;
        this.conditionExpression = conditionExpression;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
