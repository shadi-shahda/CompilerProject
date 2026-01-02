package FlaskPythonSymbolTable;

import java.util.*;

public class FlaskPythonSymbolTable {
  private Stack<Map<String, FlaskPythonType>> scopes = new Stack<>();

  private Set<String> definedRoutes = new HashSet<>();

  private Set<String> availableTemplates = new HashSet<>();

  private List<String> semanticErrors = new ArrayList<>();

  public FlaskPythonSymbolTable() {
    scopes.push(new HashMap<>());
    initializeBuiltins();
  }

  private void initializeBuiltins() {
    defineVariable("__name__", FlaskPythonType.STRING);
    defineVariable("None", FlaskPythonType.OBJECT);
    defineVariable("True", FlaskPythonType.BOOLEAN);
    defineVariable("False", FlaskPythonType.BOOLEAN);

    defineVariable("print", FlaskPythonType.OBJECT);
    defineVariable("len", FlaskPythonType.OBJECT);
    defineVariable("str", FlaskPythonType.OBJECT);
    defineVariable("int", FlaskPythonType.OBJECT);
  }

  public void enterScope() {
    this.scopes.push(new HashMap<>());
  }

  public void exitScope() {
    if (this.scopes.size() > 1)
      this.scopes.pop();
  }

  public void defineVariable(String name, FlaskPythonType type) {
    this.scopes.peek().put(name, type);
  }

  public boolean isVariableDefined(String name) {
    for (int i = this.scopes.size() - 1; i >= 0; i--) {
      if (this.scopes.get(i).containsKey(name))
        return true;
    }
    return false;
  }

  public FlaskPythonType getVariableType(String name) {
    for (int i = this.scopes.size() - 1; i >= 0; i--) {
      if (this.scopes.get(i).containsKey(name)) {
        return this.scopes.get(i).get(name);
      }
    }
    return FlaskPythonType.UNKNOWN;
  }

  public boolean isRouteDefined(String route) {
    return this.definedRoutes.contains(route);
  }

  public void addRoute(String route) {
    this.definedRoutes.add(route);
  }

  public void addAvailableTemplate(String filename) {
    this.availableTemplates.add(filename);
  }

  public boolean isTemplateExists(String filename) {
    return availableTemplates.contains(filename);
  }

  public void reportError(String msg, int line) {
    semanticErrors.add("Error at line " + line + ": " + msg);
  }

  public void printTable() {
    System.out.println("\n======================= SYMBOL TABLE SNAPSHOT =======================");

    System.out.println(String.format("| %-25s | %-20s | %-15s |", "VARIABLE NAME", "TYPE", "SCOPE"));
    System.out.println("---------------------------------------------------------------------");

    for (int i = 0; i < scopes.size(); i++) {
      Map<String, FlaskPythonType> scope = scopes.get(i);

      String scopeName = (i == 0) ? "Global (0)" : "Function/Local (" + i + ")";

      for (Map.Entry<String, FlaskPythonType> entry : scope.entrySet()) {
        System.out.println(String.format("| %-25s | %-20s | %-15s |",
            entry.getKey(),
            entry.getValue(),
            scopeName));
      }
    }
    System.out.println("---------------------------------------------------------------------");

    System.out.println("\n[Additional Context]");
    System.out.println("Defined Routes:      " + definedRoutes);
    System.out.println("Available Templates: " + availableTemplates);

    if (!semanticErrors.isEmpty()) {
      System.err.println("\n!!! SEMANTIC ERRORS DETECTED !!!");
      for (String err : semanticErrors) {
        System.err.println(err);
      }
    } else {
      System.out.println("\nStatus: No Semantic Errors Found. Code is Clean.");
    }
    System.out.println("=====================================================================");
  }
}