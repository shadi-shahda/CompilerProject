package TemplatesSymbolTable;

import java.util.Set;
import java.util.Stack;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TemplatesSymbolTable {
  private Stack<Map<String, TemplatesSymbol>> scopes = new Stack<>();

  private Set<String> usedClasses = new HashSet<>();
  private Set<String> usedIds = new HashSet<>();

  public TemplatesSymbolTable() {
    this.scopes.push(new HashMap<>());
  }

  public void enterScope() {
    this.scopes.push(new HashMap<>());
  }

  public void exitScope() {
    if (this.scopes.size() > 1) {
      this.scopes.pop();
    }
  }

  public void defineVariable(String name, String kind, int line) {
    TemplatesSymbol symbol = new TemplatesSymbol(name, kind, line);
    this.scopes.peek().put(name, symbol);
  }

  public TemplatesSymbol resolveVariable(String name) {
    for (int i = this.scopes.size() - 1; i >= 0; i--) {
      Map<String, TemplatesSymbol> scope = this.scopes.get(i);
      if (scope.containsKey(name)) {
        return scope.get(name);
      }
    }
    return null;
  }

  public void addUsedClass(String className) {
    this.usedClasses.add(className);
  }

  public void addUsedId(String idName) {
    this.usedIds.add(idName);
  }

  public Set<String> getUsedClasses() {
    return this.usedClasses;
  }

  public Set<String> getUsedIds() {
    return this.usedIds;
  }

  public void printTable() {
    System.out.println("=== Template HTML/CSS Usage ===");
    System.out.println("Used Classes: " + this.usedClasses);
    System.out.println("Used IDs:     " + this.usedIds);

    System.out.println("\n=== Current Jinja Scopes ===");
    if (!this.scopes.isEmpty()) {
      System.out.println("Global Scope Variables: " + this.scopes.firstElement().keySet());
    }
  }
}
