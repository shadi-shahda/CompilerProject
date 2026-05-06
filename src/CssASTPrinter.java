import CssAST.CssClassSelector;
import CssAST.CssDeclaration;
import CssAST.CssFloatValue;
import CssAST.CssFunction;
import CssAST.CssHexValue;
import CssAST.CssIdSelector;
import CssAST.CssIdentValue;
import CssAST.CssIntValue;
import CssAST.CssPercentValue;
import CssAST.CssProgram;
import CssAST.CssPxValue;
import CssAST.CssRule;
import CssAST.CssSelector;
import CssAST.CssStringValue;
import CssAST.CssTagSelector;
import CssAST.CssValueTerm;
import CssVisitor.CssASTVisitor;

public class CssASTPrinter implements CssASTVisitor<String> {

  private int indentLevel = 0;

  private String indent() {
    return "  ".repeat(indentLevel);
  }

  private String line(String text, int line) {
    return indent() + text + " (Line " + line + ")\n";
  }

  private int nodeCounter = 0;

  private String nodeHeader(Object node) {
    return indent() + "NodeId:" + (++nodeCounter) + " Type:" + node.getClass().getSimpleName() + "\n";
  }

  // ================= PROGRAM =================
  @Override
  public String visit(CssProgram program) {
    StringBuilder sb = new StringBuilder();
    sb.append("CssProgram\n");
    sb.append(nodeHeader(program));

    indentLevel++;
    for (CssRule rule : program.rules) {
      sb.append(rule.accept(this));
    }
    indentLevel--;

    return sb.toString();
  }

  // ================= RULE =================
  @Override
  public String visit(CssRule rule) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("CssRule", rule.getLine()));

    indentLevel++;

    for (CssSelector selector : rule.selectors) {
      sb.append(selector.accept(this));
    }

    for (CssDeclaration declaration : rule.declarations) {
      sb.append(declaration.accept(this));
    }

    indentLevel--;

    return sb.toString();
  }

  // ================= DECLARATION =================
  @Override
  public String visit(CssDeclaration declaration) {
    StringBuilder sb = new StringBuilder();

    sb.append(line("CssDeclaration", declaration.getLine()));

    indentLevel++;

    if (declaration.property != null) {
      sb.append(line("Property: " + declaration.property, declaration.getLine()));
    } else {
      sb.append(line("Property: UNKNOWN", declaration.getLine()));
    }

    for (CssValueTerm value : declaration.valueTerms) {
      sb.append(value.accept(this));
    }

    indentLevel--;

    return sb.toString();
  }

  // ================= SELECTORS =================
  @Override
  public String visit(CssTagSelector tagSelector) {
    return line("TagSelector: " + tagSelector.name, tagSelector.getLine());
  }

  @Override
  public String visit(CssClassSelector classSelector) {
    return line("ClassSelector: " + classSelector.name, classSelector.getLine());
  }

  @Override
  public String visit(CssIdSelector idSelector) {
    return line("IdSelector: #" + idSelector.name, idSelector.getLine());
  }

  // ================= VALUES (NO MODIFICATION) =================
  @Override
  public String visit(CssIdentValue v) {
    return line("IdentValue: " + v.value, v.getLine());
  }

  @Override
  public String visit(CssIntValue v) {
    return line("IntValue: " + v.value, v.getLine());
  }

  @Override
  public String visit(CssFloatValue v) {
    return line("FloatValue: " + v.value, v.getLine());
  }

  @Override
  public String visit(CssStringValue v) {
    return line("StringValue: " + v.value, v.getLine());
  }

  @Override
  public String visit(CssPxValue v) {
    return line("PxValue: " + v.value, v.getLine());
  }

  @Override
  public String visit(CssPercentValue v) {
    return line("PercentValue: " + v.value, v.getLine());
  }

  @Override
  public String visit(CssHexValue v) {
    return line("HexValue: " + v.value, v.getLine());
  }

  // ================= FUNCTION =================
  @Override
  public String visit(CssFunction function) {
    StringBuilder sb = new StringBuilder();

    String name = (function.functionName != null) ? function.functionName : "unknown";

    sb.append(line("Function: " + name, function.getLine()));

    indentLevel++;

    for (CssValueTerm arg : function.arguments) {
      sb.append(arg.accept(this));
    }

    indentLevel--;

    return sb.toString();
  }
}