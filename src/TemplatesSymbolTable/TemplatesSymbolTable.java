package TemplatesSymbolTable;

import java.util.*;

public class TemplatesSymbolTable {
    private Stack<Map<String, TemplatesSymbol>> scopes = new Stack<>();
    private Set<String> usedClasses = new HashSet<>();
    private Set<String> usedIds = new HashSet<>();

    private List<String> semanticErrors = new ArrayList<>();

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
        this.scopes.peek().put(name, new TemplatesSymbol(name, kind, line));
    }

    public void defineContextVariable(String name) {
        this.scopes.firstElement().put(name, new TemplatesSymbol(name, "CONTEXT_VAR", 0));
    }

    public TemplatesSymbol resolveVariable(String name) {
        for (int i = this.scopes.size() - 1; i >= 0; i--) {
            if (this.scopes.get(i).containsKey(name))
                return this.scopes.get(i).get(name);
        }
        return null;
    }

    public void reportError(String message, int line) {
        this.semanticErrors.add("Semantic Error at line " + line + ": " + message);
    }

    public List<String> getErrors() {
        return this.semanticErrors;
    }

    public boolean hasErrors() {
        return !this.semanticErrors.isEmpty();
    }

    public void addUsedClass(String c) {
        this.usedClasses.add(c);
    }

    public void addUsedId(String i) {
        this.usedIds.add(i);
    }

    public Set<String> getUsedClasses() {
        return this.usedClasses;
    }

    public Set<String> getUsedIds() {
        return this.usedIds;
    }

    public void printTable() {
        System.out.println("=== Symbol Table Analysis ===");
        if (this.hasErrors()) {
            System.err.println("ERRORS FOUND:");
            for (String err : semanticErrors)
                System.err.println(err);
        } else {
            System.out.println("No semantic errors found.");
            System.out.println("Used Classes: " + this.usedClasses);
        }
    }
}