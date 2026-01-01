package CssSymbolTable;

public class CssSymbol {
  private String name;
  private String kind;
  private int line;

  public CssSymbol(String name, String kind, int line) {
    this.name = name;
    this.kind = kind;
    this.line = line;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return String.format("| %-20s | %-10s | %-5d |", name, kind, line);
  }
}