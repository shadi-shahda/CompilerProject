package PythonAST;

public class StringDefinition {
  String value;

  public StringDefinition(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "StringDefinition{" +
        "value='" + value + '\'' +
        '}';
  }
}