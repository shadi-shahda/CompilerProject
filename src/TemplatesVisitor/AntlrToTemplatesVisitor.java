package TemplatesVisitor;

import TemplatesAST.*;
import generated.TemplatesParser;
import generated.TemplatesParser.BinaryExprContext;
import generated.TemplatesParser.BoolExprContext;
import generated.TemplatesParser.DictAccessExprContext;
import generated.TemplatesParser.HtmlContentContext;
import generated.TemplatesParser.IntExprContext;
import generated.TemplatesParser.JinjaContentContext;
import generated.TemplatesParser.JinjaForContext;
import generated.TemplatesParser.JinjaIfContext;
import generated.TemplatesParser.JinjaPrintContext;
import generated.TemplatesParser.JinjaSetContext;
import generated.TemplatesParser.KeyValueAttributeContext;
import generated.TemplatesParser.LogicalExprContext;
import generated.TemplatesParser.MathExprContext;
import generated.TemplatesParser.MemberAccessExprContext;
import generated.TemplatesParser.NormalTagContext;
import generated.TemplatesParser.NotExprContext;
import generated.TemplatesParser.OnlyKeyAttributeContext;
import generated.TemplatesParser.ParenExprContext;
import generated.TemplatesParser.SelfClosingTagContext;
import generated.TemplatesParser.StringExprContext;
import generated.TemplatesParser.TemplateContext;
import generated.TemplatesParser.TextContentContext;
import generated.TemplatesParser.VarExprContext;
import generated.TemplatesParser.VoidElementContext;
import generated.TemplatesParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class AntlrToTemplatesVisitor extends TemplatesParserBaseVisitor<TemplatesASTNode> {
  @Override
  public TemplatesASTNode visitTemplate(TemplateContext ctx) {
    int line = ctx.getStart().getLine();
    TemplatesProgram program = new TemplatesProgram(line);
    for (TemplatesParser.ContentContext content : ctx.content()) {
      TemplatesASTNode contentNode = visit(content);
      program.addChild(contentNode);
    }
    return program;
  }

  @Override
  public TemplatesASTNode visitHtmlContent(HtmlContentContext ctx) {
    return visit(ctx.htmlElement());
  }

  @Override
  public TemplatesASTNode visitJinjaContent(JinjaContentContext ctx) {
    return visit(ctx.jinjaElement());
  }

  @Override
  public TemplatesASTNode visitTextContent(TextContentContext ctx) {
    int line = ctx.getStart().getLine();
    String text = ctx.TEXT().getText();
    return new HtmlText(text, line);
  }

  @Override
  public TemplatesASTNode visitNormalTag(NormalTagContext ctx) {
    int line = ctx.getStart().getLine();
    String tagName = ctx.TAG_ID(0).getText();
    HtmlElement element = new HtmlElement(tagName, line);
    for (TemplatesParser.AttributeContext attribute : ctx.attribute()) {
      KeyValueAttribute node = (TemplatesAST.KeyValueAttribute) visit(attribute);
      element.addAttribute(node);
    }

    for (TemplatesParser.ContentContext content : ctx.content()) {
      TemplatesASTNode node = (TemplatesASTNode) visit(content);
      element.addTemplate(node);
    }

    return element;
  }

  @Override
  public TemplatesASTNode visitSelfClosingTag(SelfClosingTagContext ctx) {
    int line = ctx.getStart().getLine();
    String tagName = ctx.getChild(1).getText();
    HtmlElement element = new HtmlElement(tagName, line);
    for (TemplatesParser.AttributeContext attribute : ctx.attribute()) {
      HtmlAttribute node = (HtmlAttribute) visit(attribute);
      element.addAttribute(node);
    }
    return element;
  }

  @Override
  public TemplatesASTNode visitKeyValueAttribute(KeyValueAttributeContext ctx) {
    int line = ctx.getStart().getLine();
    String key = ctx.getChild(0).getText();
    AttributeValue value = (AttributeValue) visit(ctx.attributeValue());
    return new KeyValueAttribute(key, line, value);
  }

  @Override
  public TemplatesASTNode visitDoubleQuotedAttribute(TemplatesParser.DoubleQuotedAttributeContext ctx) {
    int line = ctx.getStart().getLine();

    AttributeValue value = new AttributeValue(line);

    for (TemplatesParser.AttributePartContext part : ctx.attributePart()) {
      value.addPart((AttributePart) visit(part));
    }

    return value;
  }

  @Override
  public TemplatesASTNode visitSingleQuotedAttribute(TemplatesParser.SingleQuotedAttributeContext ctx) {
    int line = ctx.getStart().getLine();

    AttributeValue value = new AttributeValue(line);

    for (TemplatesParser.SingleAttributePartContext part : ctx.singleAttributePart()) {
      value.addPart((AttributePart) visit(part));
    }

    return value;
  }


  @Override
  public TemplatesASTNode visitAttributeTextPart(
          TemplatesParser.AttributeTextPartContext ctx) {

    int line = ctx.getStart().getLine();

    return new AttributeTextPart(line, ctx.ATTR_TEXT().getText());
  }

  @Override
  public TemplatesASTNode visitSingleAttributeTextPart(
          TemplatesParser.SingleAttributeTextPartContext ctx) {

    int line = ctx.getStart().getLine();

    return new AttributeTextPart(line, ctx.ATTR_TEXT_SINGLE().getText());
  }

  @Override
  public TemplatesASTNode visitAttributeExpressionPart(
          TemplatesParser.AttributeExpressionPartContext ctx) {

    int line = ctx.getStart().getLine();

    TemplatesExpression expr =
            (TemplatesExpression) visit(ctx.expression());

    return new AttributeExpressionPart(line, expr);
  }

  @Override
  public TemplatesASTNode visitSingleAttributeExpressionPart(
          TemplatesParser.SingleAttributeExpressionPartContext ctx) {

    int line = ctx.getStart().getLine();

    TemplatesExpression expr =
            (TemplatesExpression) visit(ctx.expression());

    return new AttributeExpressionPart(line, expr);
  }

  @Override
  public TemplatesASTNode visitOnlyKeyAttribute(OnlyKeyAttributeContext ctx) {
    int line = ctx.getStart().getLine();
    String value = ctx.getChild(0).getText();
    return new OnlyKeyAttribute(value, line);
  }

  @Override
  public TemplatesASTNode visitJinjaPrint(JinjaPrintContext ctx) {
    int line = ctx.getStart().getLine();
    TemplatesExpression expression = (TemplatesExpression) visit(ctx.expression());
    return new JinjaPrint(expression, line);
  }

  @Override
  public TemplatesASTNode visitJinjaIf(JinjaIfContext ctx) {
    int line = ctx.getStart().getLine();
    TemplatesExpression condition = (TemplatesExpression) visit(ctx.expression());
    JinjaIfStatement ifStatement = new JinjaIfStatement(condition, line);

    for (TemplatesParser.ContentContext child : ctx.thenBlock) {
      ifStatement.addToThenBody(visit(child));
    }

    if (ctx.elseBlock != null && !ctx.elseBlock.isEmpty()) {
      for (TemplatesParser.ContentContext child : ctx.elseBlock) {
        ifStatement.addToELseBody(visit(child));
      }
    }

    return ifStatement;
  }

  @Override
  public TemplatesASTNode visitJinjaFor(JinjaForContext ctx) {
    int line = ctx.getStart().getLine();
    String variableName = ctx.J_ID(0).getText();
    String listName = ctx.J_ID(1).getText();
    JinjaForStatement forStatement = new JinjaForStatement(variableName, listName, line);
    for (TemplatesParser.ContentContext content : ctx.content()) {
      TemplatesASTNode node = (TemplatesASTNode) visit(content);
      forStatement.addStatement(node);
    }
    return forStatement;
  }

  @Override
  public TemplatesASTNode visitJinjaSet(JinjaSetContext ctx) {
    int line = ctx.getStart().getLine();
    String varName = ctx.J_ID().getText();
    TemplatesExpression expr = (TemplatesExpression) visit(ctx.expression());
    return new JinjaSet(varName, expr, line);
  }

  @Override
  public TemplatesASTNode visitMemberAccessExpr(MemberAccessExprContext ctx) {
    int line = ctx.getStart().getLine();
    String attribute = ctx.J_ID().getText();
    TemplatesExpression expression = (TemplatesExpression) visit(ctx.expression());
    return new MemberAccessExpression(line, attribute, expression);
  }

  @Override
  public TemplatesASTNode visitDictAccessExpr(DictAccessExprContext ctx) {
    int line = ctx.getStart().getLine();
    String key = ctx.J_STRING().getText().substring(1, ctx.J_STRING().getText().length() - 1);
    TemplatesExpression object = (TemplatesExpression) visit(ctx.expression());
    return new DictionaryAccessExpression(line, key, object);
  }

  @Override
  public TemplatesASTNode visitMathExpr(MathExprContext ctx) {

    int line = ctx.getStart().getLine();
    TemplatesExpression left = (TemplatesExpression) visit(ctx.expression(0));
    String operator = ctx.getChild(1).getText();
    TemplatesExpression right = (TemplatesExpression) visit(ctx.expression(1));
    return new MathExpression(line, left, operator, right);
  }

  @Override
  public TemplatesASTNode visitParenExpr(ParenExprContext ctx) {
    return visit(ctx.expression());
  }

  @Override
  public TemplatesASTNode visitNotExpr(NotExprContext ctx) {
    int line = ctx.getStart().getLine();
    TemplatesExpression expression = (TemplatesExpression) visit(ctx.expression());
    return new NotExpression(line, expression);
  }

  @Override
  public TemplatesASTNode visitBinaryExpr(BinaryExprContext ctx) {
    int line = ctx.getStart().getLine();
    TemplatesExpression left = (TemplatesExpression) visit(ctx.expression(0));
    String operator = ctx.getChild(1).getText();
    TemplatesExpression right = (TemplatesExpression) visit(ctx.expression(1));
    return new BinaryExpression(left, operator, right, line);
  }

  @Override
  public TemplatesASTNode visitLogicalExpr(LogicalExprContext ctx) {
    int line = ctx.getStart().getLine();
    TemplatesExpression left = (TemplatesExpression) visit(ctx.expression(0));
    String operator = ctx.getChild(1).getText();
    TemplatesExpression right = (TemplatesExpression) visit(ctx.expression(1));
    return new LogicalExpression(line, left, right, operator);
  }

  @Override
  public TemplatesASTNode visitVarExpr(VarExprContext ctx) {
    int line = ctx.getStart().getLine();
    String name = ctx.J_ID().getText();
    return new VarExpression(name, line);
  }

  @Override
  public TemplatesASTNode visitStringExpr(StringExprContext ctx) {
    int line = ctx.getStart().getLine();
    String name = ctx.J_STRING().getText().substring(1, ctx.J_STRING().getText().length() - 1);
    return new StringExpression(line, name);
  }

  @Override
  public TemplatesASTNode visitIntExpr(IntExprContext ctx) {
    int line = ctx.getStart().getLine();
    String value = ctx.J_INT().getText();
    return new IntExpression(line, value);
  }

  @Override
  public TemplatesASTNode visitBoolExpr(BoolExprContext ctx) {
    int line = ctx.getStart().getLine();
    boolean value = Boolean.parseBoolean(ctx.getChild(0).getText());
    return new BoolExpression(line, value);
  }

  @Override
  public TemplatesASTNode visitVoidElement(VoidElementContext ctx) {
    int line = ctx.getStart().getLine();
    String tagName = ctx.VOID_TAG_ID().getText();
    HtmlElement element = new HtmlElement(tagName, line);
    for (TemplatesParser.AttributeContext attribute : ctx.attribute()) {
      element.attributes.add((HtmlAttribute) visit(attribute));
    }
    return element;
  }
}
