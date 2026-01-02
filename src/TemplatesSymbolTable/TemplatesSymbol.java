package TemplatesSymbolTable;

public class TemplatesSymbol {
  private String name;
  private String kind;
  private int line;

  public TemplatesSymbol(String name, String kind, int line) {
    this.name = name;
    this.kind = kind;
    this.line = line;
  }

  public String getName() {
    return this.name;
  }

  public String getKind() {
    return this.kind;
  }

  public int getLine() {
    return this.line;
  }

  @Override
  public String toString() {
    return String.format("Symbol{name='%s', kind='%s', line=%d}", this.name, this.kind, this.line);
  }
}
