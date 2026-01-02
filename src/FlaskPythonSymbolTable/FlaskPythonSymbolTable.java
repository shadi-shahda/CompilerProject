package FlaskPythonSymbolTable;

import java.util.*;

public class FlaskPythonSymbolTable {
  private Stack<Map<String, FlaskPythonType>> scopes = new Stack<>();

  private Set<String> definedRoutes = new HashSet<>();

  private Set<String> availableTemplates = new HashSet<>();

  private List<String> semanticErrors = new ArrayList<>();

  public FlaskPythonSymbolTable() {
    scopes.push(new HashMap<>());
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
    System.out.println("=== Flask/Python Analysis Results ===");
    if (semanticErrors.isEmpty()) {
      System.out.println("No semantic errors found.");
      System.out.println("Defined Routes: " + definedRoutes);
    } else {
      System.err.println("SEMANTIC ERRORS FOUND:");
      for (String err : semanticErrors) {
        System.err.println(err);
      }
    }
  }
}