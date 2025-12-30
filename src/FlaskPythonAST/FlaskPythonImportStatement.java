package FlaskPythonAST;

import java.util.List;

import FlaskPythonVisitor.FlaskPythonASTVisitor;

public class FlaskPythonImportStatement extends FlaskPythonStatement {
    public String libraryName;
    public List<String> importedItems;

    public FlaskPythonImportStatement(String libraryName, List<String> importedItems, int line) {
        super(line);
        this.libraryName = libraryName;
        this.importedItems = importedItems;
    }

    @Override
    public <T> T accept(FlaskPythonASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
