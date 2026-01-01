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
    return name;
  }

  public String getKind() {
    return kind;
  }

  @Override
  public String toString() {
    return String.format("Symbol{name='%s', kind='%s', line=%d}", name, kind, line);
  }
}
