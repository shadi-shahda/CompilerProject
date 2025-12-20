package FlaskPythonSymbolTable;

public class FlaskPythonSymbol {
    private String name;
    private String type;
    private int scopeLevel;    // (0 = Global, 1 = Function)
    
    public FlaskPythonSymbol(String name, String type, int scopeLevel) {
        this.name = name;
        this.type = type;
        this.scopeLevel = scopeLevel;
    }

    @Override
    public String toString() {
        return String.format("| %-15s | %-15s | %-5d |", name, type, scopeLevel);
    }
}