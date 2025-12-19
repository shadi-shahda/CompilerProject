package FlaskPythonAST;

import java.util.List;

import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonImportStatement extends FlaskPythonStatement {
  public String libraryName; // اسم المكتبة (مثل flask)
    public List<String> importedItems; // قائمة العناصر المستوردة (Flask, request...)

    public FlaskPythonImportStatement(String libraryName, List<String> importedItems, int line) {
        super(line);
        this.libraryName = libraryName;
        this.importedItems = importedItems;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
