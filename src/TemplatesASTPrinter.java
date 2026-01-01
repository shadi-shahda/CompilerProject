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

  private String format(String className, int line) {
    return indent() + className + " (Line " + line + ")\n";
  }

  @Override
  public String visit(TemplatesProgram program) {
    StringBuilder sb = new StringBuilder();
    sb.append("TemplatesProgram\n");
    indentLevel++;
    for (TemplatesASTNode nodes : program.children) {
      sb.append(nodes.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(HtmlText text) {
    return format("HtmlText", text.getLine());
  }

  @Override
  public String visit(KeyValueAttribute attribute) {
    return format("KeyValueAttribute", attribute.getLine());
  }

  @Override
  public String visit(OnlyKeyAttribute attribute) {
    return format("OnlyKeyAttribute", attribute.getLine());
  }

  @Override
  public String visit(HtmlElement element) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("HtmlElement", element.getLine()));
    indentLevel++;
    for (HtmlAttribute attribute : element.attributes) {
      sb.append(attribute.accept(this));
    }

    for (TemplatesASTNode templates : element.templates) {
      sb.append(templates.accept(this));
    }
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(JinjaPrint jinjaPrint) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("JinjaPrint", jinjaPrint.getLine()));
    indentLevel++;
    sb.append(jinjaPrint.expression.accept(this));
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(JinjaIfStatement ifStmt) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("JinjaIfStatement", ifStmt.getLine()));
    indentLevel++;

    sb.append(format("Condition", ifStmt.getLine()));
    indentLevel++;
    sb.append(ifStmt.condition.accept(this));
    indentLevel--;

    sb.append(format("ThenBlock", ifStmt.getLine()));
    indentLevel++;
    for (TemplatesASTNode thenBody : ifStmt.thenBody) {
      sb.append(thenBody.accept(this));
    }
    indentLevel--;

    sb.append(format("ElseBlock", ifStmt.getLine()));
    indentLevel++;
    if (ifStmt.elseBody != null) {
      for (TemplatesASTNode elseBody : ifStmt.elseBody) {
        sb.append(elseBody.accept(this));
      }
    }
    indentLevel--;

    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(JinjaForStatement forStmt) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("JinjaForStatement", forStmt.getLine()));
    indentLevel++;
    sb.append(format("LoopVariable", forStmt.getLine()));

    sb.append(format("LoopList", forStmt.getLine()));
    indentLevel++;
    for (TemplatesASTNode statements : forStmt.statements) {
      sb.append(statements.accept(this));
    }
    indentLevel--;

    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(MemberAccessExpression memberAccessExpr) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("MemberAccessExpression", memberAccessExpr.getLine()));
    indentLevel++;
    sb.append(memberAccessExpr.expression.accept(this));
    sb.append(format("MemberIdentifier", memberAccessExpr.getLine()));
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(DictionaryAccessExpression dictionaryAccessExpr) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("DictionaryAccessExpression", dictionaryAccessExpr.getLine()));
    indentLevel++;
    sb.append(dictionaryAccessExpr.object.accept(this));
    sb.append(format("DictionaryKey", dictionaryAccessExpr.getLine()));
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(NotExpression notExpr) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("NotExpression", notExpr.getLine()));
    indentLevel++;
    sb.append(notExpr.expression.accept(this));
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(BinaryExpression binaryExpr) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("BinaryExpression", binaryExpr.getLine()));
    indentLevel++;
    sb.append(binaryExpr.left.accept(this));
    sb.append(binaryExpr.right.accept(this));
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(LogicalExpression logicalExpr) {
    StringBuilder sb = new StringBuilder();
    sb.append(format("LogicalExpression", logicalExpr.getLine()));
    indentLevel++;
    sb.append(logicalExpr.left.accept(this));
    sb.append(logicalExpr.right.accept(this));
    indentLevel--;
    return sb.toString();
  }

  @Override
  public String visit(VarExpression varExpr) {
    return format("VarExpression", varExpr.getLine());
  }

  @Override
  public String visit(StringExpression StringExpr) {
    return format("StringExpression", StringExpr.getLine());
  }

  @Override
  public String visit(IntExpression intExpr) {
    return format("IntExpression", intExpr.getLine());
  }

  @Override
  public String visit(BoolExpression boolExpr) {
    return format("BoolExpression", boolExpr.getLine());
  }

}
