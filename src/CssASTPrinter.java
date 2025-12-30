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

  private String format(String className, int line) {
    return indent() + className + " (Line " + line + ")\n";
  }

  @Override
  public String visit(CssProgram program) {
    StringBuilder sb = new StringBuilder();
    sb.append("CssProgram\n");
    indentLevel++;
    for (CssRule rule : program.rules) {
      sb.append(rule.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(CssRule rule) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("CssRule", rule.getLine()));
    indentLevel++;
    for (CssDeclaration declaration : rule.declarations) {
      sb.append(declaration.accept(this));
    }
    for (CssSelector selector : rule.selectors) {
      sb.append(selector.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(CssDeclaration declaration) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("CssDeclaration", declaration.getLine()));
    indentLevel++;
    sb.append(format("CssProperty", declaration.getLine()));
    for (CssValueTerm valueTerm : declaration.valueTerms) {
      sb.append(valueTerm.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(CssTagSelector tagSelector) {
    return format("CssTagSelector", tagSelector.getLine());
  }

  @Override
  public String visit(CssClassSelector classSelector) {
    return format("CssClassSelector", classSelector.getLine());
  }

  @Override
  public String visit(CssIdSelector idSelector) {
    return format("CssIdSelector", idSelector.getLine());
  }

  @Override
  public String visit(CssIdentValue identValue) {
    return format("CssIdentValue", identValue.getLine());
  }

  @Override
  public String visit(CssIntValue intValue) {
    return format("CssIntValue", intValue.getLine());
  }

  @Override
  public String visit(CssStringValue stringVlue) {
    return format("CssStringValue", stringVlue.getLine());
  }

  @Override
  public String visit(CssPxValue pxValue) {
    return format("CssPxValue", pxValue.getLine());
  }

  @Override
  public String visit(CssPercentValue percentValue) {
    return format("CssPercentValue", percentValue.getLine());
  }

  @Override
  public String visit(CssHexValue hexValue) {
    return format("CssHexValue", hexValue.getLine());
  }

  @Override
  public String visit(CssFloatValue floatValue) {
    return format("CssFloatValue", floatValue.getLine());
  }

  @Override
  public String visit(CssFunction function) {
    StringBuilder sb = new StringBuilder();
    indentLevel++;
    sb.append(format("CssFunction", function.getLine()));

    for (CssValueTerm value : function.arguments) {
      sb.append(value.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }
}
