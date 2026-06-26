package FlaskPythonAST;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

import java.util.List;

public class FlaskPythonGlobalStatement extends FlaskPythonStatement {
    public List<String> variableNames;
    public FlaskPythonGlobalStatement(List<String> variableNames, int lineNumber) {
        super(lineNumber);
        this.variableNames = variableNames;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
