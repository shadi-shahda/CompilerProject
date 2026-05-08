import TemplatesAST.BinaryExpression;
import TemplatesAST.BoolExpression;
import TemplatesAST.DictionaryAccessExpression;
import TemplatesAST.HtmlAttribute;
import TemplatesAST.HtmlElement;
import TemplatesAST.HtmlText;
import TemplatesAST.IntExpression;
import TemplatesAST.JinjaForStatement;
import TemplatesAST.JinjaIfStatement;
import TemplatesAST.JinjaPrint;
import TemplatesAST.KeyValueAttribute;
import TemplatesAST.LogicalExpression;
import TemplatesAST.MemberAccessExpression;
import TemplatesAST.NotExpression;
import TemplatesAST.OnlyKeyAttribute;
import TemplatesAST.StringExpression;
import TemplatesAST.TemplatesASTNode;
import TemplatesAST.TemplatesProgram;
import TemplatesAST.VarExpression;
import TemplatesVisitor.TemplatesASTVisitor;

public class TemplatesASTPrinter implements TemplatesASTVisitor<String> {

  private int indentLevel = 0;

  private String indent() {
    return "  ".repeat(indentLevel);
  }

  private String line(String label, int line) {
    return indent() + label + " (Line " + line + ")\n";
  }

  private int nodeCounter = 0;

  private String nodeHeader(Object node) {
    return indent() + "NodeId:" + (++nodeCounter) + " Type:" + node.getClass().getSimpleName() + "\n";
  }

  private void inc() { indentLevel++; }
  private void dec() { indentLevel--; }

  // ================= PROGRAM =================
  @Override
  public String visit(TemplatesProgram program) {
    StringBuilder sb = new StringBuilder();

    sb.append("TemplatesProgram\n");
    sb.append(nodeHeader(program));

    inc();
    for (TemplatesASTNode node : program.children) {
      sb.append(node.accept(this));
    }
    dec();

    return sb.toString();
  }

  // ================= HTML TEXT =================
  @Override
  public String visit(HtmlText text) {
    return line("HtmlText: " + text.text, text.getLine());
  }

  // ================= HTML ELEMENT =================
  @Override
  public String visit(HtmlElement element) {
    StringBuilder sb = new StringBuilder();

    sb.append(indent())
            .append("HtmlElement: ")
            .append(element.tagName)
            .append(" (Line ")
            .append(element.getLine())
            .append(")\n");

    inc();

    // Attributes
    for (HtmlAttribute attr : element.attributes) {
      sb.append(attr.accept(this));
    }

    // Children
    for (TemplatesASTNode node : element.templates) {
      sb.append(node.accept(this));
    }

    dec();
    return sb.toString();
  }

  // ================= KEY-VALUE ATTRIBUTE =================
  @Override
  public String visit(KeyValueAttribute attribute) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("KeyValueAttribute", attribute.getLine()));
    inc();

    sb.append(indent()).append("Key: ").append(attribute.getKey()).append("\n");
    sb.append(indent()).append("Value: ").append(attribute.value).append("\n");

    dec();
    return sb.toString();
  }

  // ================= ONLY KEY ATTRIBUTE =================
  @Override
  public String visit(OnlyKeyAttribute attribute) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("OnlyKeyAttribute", attribute.getLine()));
    inc();

    sb.append(indent()).append("Key: ").append(attribute.getKey()).append("\n");

    dec();
    return sb.toString();
  }

  // ================= JINJA PRINT =================
  @Override
  public String visit(JinjaPrint jinjaPrint) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("JinjaPrint", jinjaPrint.getLine()));

    inc();
    sb.append(jinjaPrint.expression.accept(this));
    dec();

    return sb.toString();
  }

  // ================= IF =================
  @Override
  public String visit(JinjaIfStatement ifStmt) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("JinjaIf", ifStmt.getLine()));

    inc();

    sb.append(line("Condition", ifStmt.getLine()));
    inc();
    sb.append(ifStmt.condition.accept(this));
    dec();

    sb.append(line("Then", ifStmt.getLine()));
    inc();
    for (TemplatesASTNode node : ifStmt.thenBody) {
      sb.append(node.accept(this));
    }
    dec();

    if (ifStmt.elseBody != null) {
      sb.append(line("Else", ifStmt.getLine()));
      inc();
      for (TemplatesASTNode node : ifStmt.elseBody) {
        sb.append(node.accept(this));
      }
      dec();
    }

    dec();
    return sb.toString();
  }

  // ================= FOR =================
  @Override
  public String visit(JinjaForStatement forStmt) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("JinjaFor", forStmt.getLine()));

    inc();

    sb.append(indent())
            .append("LoopVariable: ")
            .append(forStmt.variableName)
            .append("\n");

    sb.append(indent())
            .append("LoopList: ")
            .append(forStmt.listName)
            .append("\n");

    sb.append(line("Body", forStmt.getLine()));
    inc();

    for (TemplatesASTNode node : forStmt.statements) {
      sb.append(node.accept(this));
    }

    dec();
    dec();

    return sb.toString();
  }

  // ================= EXPRESSIONS =================
  @Override
  public String visit(MemberAccessExpression expr) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("MemberAccess", expr.getLine()));

    inc();
    sb.append(expr.expression.accept(this));
    dec();

    return sb.toString();
  }

  @Override
  public String visit(DictionaryAccessExpression expr) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("DictionaryAccess", expr.getLine()));

    inc();
    sb.append(expr.object.accept(this));
    dec();

    return sb.toString();
  }

  @Override
  public String visit(NotExpression expr) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("Not", expr.getLine()));

    inc();
    sb.append(expr.expression.accept(this));
    dec();

    return sb.toString();
  }

  @Override
  public String visit(BinaryExpression expr) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("BinaryExpression", expr.getLine()));

    inc();
    sb.append(expr.left.accept(this));
    sb.append(expr.right.accept(this));
    dec();

    return sb.toString();
  }

  @Override
  public String visit(LogicalExpression expr) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("LogicalExpression", expr.getLine()));

    inc();
    sb.append(expr.left.accept(this));
    sb.append(expr.right.accept(this));
    dec();

    return sb.toString();
  }

  // ================= LITERALS =================
  @Override
  public String visit(VarExpression expr) {
    return line("Var: " + expr.name, expr.getLine());
  }

  @Override
  public String visit(StringExpression expr) {
    return line("String: " + expr.name, expr.getLine());
  }

  @Override
  public String visit(IntExpression expr) {
    return line("Int: " + expr.value, expr.getLine());
  }

  @Override
  public String visit(BoolExpression expr) {
    return line("Bool: " + expr.value, expr.getLine());
  }
}