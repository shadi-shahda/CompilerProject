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
        System.out.println("\n====================== TEMPLATES SYMBOL TABLE SNAPSHOT ======================");
        System.out.println(String.format("| %-25s | %-20s | %-20s |", "NAME", "KIND", "SCOPE / LINE"));
        System.out.println("-----------------------------------------------------------------------------");

        for (int i = 0; i < scopes.size(); i++) {
            Map<String, TemplatesSymbol> scope = scopes.get(i);
            String scopeName = (i == 0) ? "Global Context" : "Loop/Block (" + i + ")";

            for (TemplatesSymbol sym : scope.values()) {
                String location = scopeName + " : L" + sym.getLine();

                if (sym.getLine() == 0)
                    location = "Injected Context";

                System.out.println(String.format("| %-25s | %-20s | %-20s |",
                        sym.getName(),
                        sym.getKind(),
                        location));
            }
        }

        if (!usedClasses.isEmpty() || !usedIds.isEmpty()) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("| HTML SELECTORS USAGE (For CSS Linking)                                    |");
            System.out.println("-----------------------------------------------------------------------------");

            for (String cls : usedClasses) {
                System.out.println(String.format("| %-25s | %-20s | %-20s |", cls, "HTML CLASS", "Used in Tag"));
            }
            for (String id : usedIds) {
                System.out.println(String.format("| %-25s | %-20s | %-20s |", id, "HTML ID", "Used in Tag"));
            }
        }

        System.out.println("-----------------------------------------------------------------------------");

        if (!semanticErrors.isEmpty()) {
            System.err.println("\n!!! TEMPLATE SEMANTIC ERRORS !!!");
            for (String err : semanticErrors) {
                System.err.println(err);
            }
        } else {
            System.out.println("\nStatus: No Semantic Errors Found.");
        }
        System.out.println("=============================================================================");
    }
}