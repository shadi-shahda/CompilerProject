package CssVisitor;

import CssAST.CssASTNode;
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
import CssAST.CssStringValue;
import CssAST.CssTagSelector;
import CssAST.CssValueTerm;
import generated.CssParser;
import generated.CssParserBaseVisitor;
import generated.CssParser.ClassSelectorContext;
import generated.CssParser.DeclarationContext;
import generated.CssParser.FloatValueContext;
import generated.CssParser.FunctionContext;
import generated.CssParser.HexValueContext;
import generated.CssParser.IdSelectorContext;
import generated.CssParser.IdentValueContext;
import generated.CssParser.IntValueContext;
import generated.CssParser.PercentValueContext;
import generated.CssParser.PxValueContext;
import generated.CssParser.RuleContext;
import generated.CssParser.StringVlueContext;
import generated.CssParser.StylesheetContext;
import generated.CssParser.TagSelectorContext;

public class AntlrToCssASTVisitor extends CssParserBaseVisitor<CssASTNode> {

  @Override
  public CssProgram visitStylesheet(StylesheetContext ctx) {
    int line = ctx.getStart().getLine();
    CssProgram program = new CssProgram(line);

    for (CssParser.RuleContext rule : ctx.rule_()) {
      CssRule cssRule = (CssRule) visit(rule);
      program.addRule(cssRule);
    }
    return program;
  }

  @Override
  public CssRule visitRule(RuleContext ctx) {
    int line = ctx.getStart().getLine();
    CssRule rule = new CssRule(line);
    for (CssParser.DeclarationContext declaration : ctx.block().declaration()) {
      rule.addDeclaration((CssAST.CssDeclaration) visit(declaration));
    }

    for (CssParser.SelectorContext selector : ctx.selectors().selector()) {
      rule.addSelector((CssAST.CssSelector) visit(selector));
    }
    return rule;
  }

  @Override
  public CssTagSelector visitTagSelector(TagSelectorContext ctx) {
    int line = ctx.getStart().getLine();
    String name = ctx.getText();
    return new CssTagSelector(name, line);
  }

  @Override
  public CssClassSelector visitClassSelector(ClassSelectorContext ctx) {
    int line = ctx.getStart().getLine();
    String name = ctx.getText();
    return new CssClassSelector(name, line);
  }

  @Override
  public CssIdSelector visitIdSelector(IdSelectorContext ctx) {
    int line = ctx.getStart().getLine();
    String name = ctx.getText();
    return new CssIdSelector(name, line);
  }

  @Override
  public CssDeclaration visitDeclaration(DeclarationContext ctx) {
    int line = ctx.getStart().getLine();
    String property = ctx.property().getText();
    CssDeclaration declaration = new CssDeclaration(property, line);
    for (CssParser.ValueTermContext value : ctx.value().valueTerm()) {
      declaration.addValueTerm((CssValueTerm) visit(value));
    }
    return declaration;
  }

  @Override
  public CssIdentValue visitIdentValue(IdentValueContext ctx) {
    int line = ctx.getStart().getLine();
    String value = ctx.getText();
    return new CssIdentValue(value, line);
  }

  @Override
  public CssStringValue visitStringVlue(StringVlueContext ctx) {
    int line = ctx.getStart().getLine();
    String value = ctx.getText();
    return new CssStringValue(value, line);
  }

  @Override
  public CssIntValue visitIntValue(IntValueContext ctx) {
    int line = ctx.getStart().getLine();
    String value = ctx.getText();
    return new CssIntValue(value, line);
  }

  @Override
  public CssPxValue visitPxValue(PxValueContext ctx) {
    int line = ctx.getStart().getLine();
    String value = ctx.getText();
    return new CssPxValue(value, line);
  }

  @Override
  public CssPercentValue visitPercentValue(PercentValueContext ctx) {
    int line = ctx.getStart().getLine();
    String value = ctx.getText();
    return new CssPercentValue(value, line);
  }

  @Override
  public CssHexValue visitHexValue(HexValueContext ctx) {
    int line = ctx.getStart().getLine();
    String value = ctx.getText();
    return new CssHexValue(value, line);
  }

  @Override
  public CssFloatValue visitFloatValue(FloatValueContext ctx) {
    int line = ctx.getStart().getLine();
    String value = ctx.getText();
    return new CssFloatValue(value, line);
  }

  @Override
  public CssASTNode visitFunction(FunctionContext ctx) {
    int line = ctx.getStart().getLine();
    String funcationName = ctx.IDENTIFIER().getText();
    CssFunction function = new CssFunction(funcationName, line);
    for (CssParser.ValueTermContext value : ctx.valueTerm()) {
      function.addArgument((CssValueTerm) visit(value));
    }
    return function;
  }
}
