package FlaskPythonSymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class FlaskPythonSymbolTable {

  private Stack<Map<String, FlaskPythonSymbol>> scopes;

  private List<FlaskPythonSymbol> allSymbols;

  private int currentScopeLevel;

  public FlaskPythonSymbolTable() {
    scopes = new Stack<>();
    allSymbols = new ArrayList<>();
    currentScopeLevel = 0;

    enterScope();
  }

  public void enterScope() {
    scopes.push(new HashMap<>());
    currentScopeLevel++;
  }

  public void exitScope() {
    if (!scopes.isEmpty()) {
      scopes.pop();
      currentScopeLevel--;
    }
  }

  public void define(String name, String type) {
    Map<String, FlaskPythonSymbol> currentScope = scopes.peek();

    if (!currentScope.containsKey(name)) {
      FlaskPythonSymbol symbol = new FlaskPythonSymbol(name, type, currentScopeLevel - 1);
      currentScope.put(name, symbol);

      allSymbols.add(symbol);
    }
  }

  public FlaskPythonSymbol findSymbol(String name) {
    for (int i = scopes.size() - 1; i >= 0; i--) {
      if (scopes.get(i).containsKey(name)) {
        return scopes.get(i).get(name);
      }
    }
    return null;
  }

  public void printTable() {
    System.out.println("\n=== Symbol Table ===");
    System.out.println("------------------------------------------------");
    System.out.printf("| %-15s | %-15s | %-5s |\n", "Name", "Type", "Scope");
    System.out.println("------------------------------------------------");
    for (FlaskPythonSymbol s : allSymbols) {
      System.out.println(s);
    }
    System.out.println("------------------------------------------------\n");
  }
}
