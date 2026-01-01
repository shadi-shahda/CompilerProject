package CssSymbolTable;

import java.util.HashMap;
import java.util.Map;

public class CssSymbolTable {

  private Map<String, CssSymbol> symbols = new HashMap<>();

  public void define(String name, String kind, int line) {
    CssSymbol symbol = new CssSymbol(name, kind, line);
    this.symbols.put(name, symbol);
  }

  // دالة للبحث عن رمز (سنحتاجها عند ربط HTML بـ CSS)
  public CssSymbol resolve(String name) {
    return this.symbols.get(name);
  }

  public void printTable() {
    System.out.println("==============================================");
    System.out.println(String.format("| %-20s | %-10s | %-5s |", "Selector Name", "Kind", "Line"));
    System.out.println("----------------------------------------------");
    for (CssSymbol sym : this.symbols.values()) {
      System.out.println(sym);
    }
    System.out.println("==============================================");
  }
}