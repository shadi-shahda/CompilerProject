// Generated from c:/Users/VICTUS/Desktop/lectures/projects/CompilerProject/grammars/TemplatesGrammars/TemplatesParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TemplatesParser}.
 */
public interface TemplatesParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TemplatesParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(TemplatesParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplatesParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(TemplatesParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlContent}
	 * labeled alternative in {@link TemplatesParser#content}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContent(TemplatesParser.HtmlContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlContent}
	 * labeled alternative in {@link TemplatesParser#content}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContent(TemplatesParser.HtmlContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaContent}
	 * labeled alternative in {@link TemplatesParser#content}.
	 * @param ctx the parse tree
	 */
	void enterJinjaContent(TemplatesParser.JinjaContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaContent}
	 * labeled alternative in {@link TemplatesParser#content}.
	 * @param ctx the parse tree
	 */
	void exitJinjaContent(TemplatesParser.JinjaContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextContent}
	 * labeled alternative in {@link TemplatesParser#content}.
	 * @param ctx the parse tree
	 */
	void enterTextContent(TemplatesParser.TextContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextContent}
	 * labeled alternative in {@link TemplatesParser#content}.
	 * @param ctx the parse tree
	 */
	void exitTextContent(TemplatesParser.TextContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalTag}
	 * labeled alternative in {@link TemplatesParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterNormalTag(TemplatesParser.NormalTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalTag}
	 * labeled alternative in {@link TemplatesParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitNormalTag(TemplatesParser.NormalTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidElement}
	 * labeled alternative in {@link TemplatesParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterVoidElement(TemplatesParser.VoidElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidElement}
	 * labeled alternative in {@link TemplatesParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitVoidElement(TemplatesParser.VoidElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelfClosingTag}
	 * labeled alternative in {@link TemplatesParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingTag(TemplatesParser.SelfClosingTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelfClosingTag}
	 * labeled alternative in {@link TemplatesParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingTag(TemplatesParser.SelfClosingTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code keyValueAttribute}
	 * labeled alternative in {@link TemplatesParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterKeyValueAttribute(TemplatesParser.KeyValueAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code keyValueAttribute}
	 * labeled alternative in {@link TemplatesParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitKeyValueAttribute(TemplatesParser.KeyValueAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code onlyKeyAttribute}
	 * labeled alternative in {@link TemplatesParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterOnlyKeyAttribute(TemplatesParser.OnlyKeyAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code onlyKeyAttribute}
	 * labeled alternative in {@link TemplatesParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitOnlyKeyAttribute(TemplatesParser.OnlyKeyAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleQuotedAttribute}
	 * labeled alternative in {@link TemplatesParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterDoubleQuotedAttribute(TemplatesParser.DoubleQuotedAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleQuotedAttribute}
	 * labeled alternative in {@link TemplatesParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitDoubleQuotedAttribute(TemplatesParser.DoubleQuotedAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleQuotedAttribute}
	 * labeled alternative in {@link TemplatesParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterSingleQuotedAttribute(TemplatesParser.SingleQuotedAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleQuotedAttribute}
	 * labeled alternative in {@link TemplatesParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitSingleQuotedAttribute(TemplatesParser.SingleQuotedAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttributeTextPart}
	 * labeled alternative in {@link TemplatesParser#attributePart}.
	 * @param ctx the parse tree
	 */
	void enterAttributeTextPart(TemplatesParser.AttributeTextPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttributeTextPart}
	 * labeled alternative in {@link TemplatesParser#attributePart}.
	 * @param ctx the parse tree
	 */
	void exitAttributeTextPart(TemplatesParser.AttributeTextPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttributeExpressionPart}
	 * labeled alternative in {@link TemplatesParser#attributePart}.
	 * @param ctx the parse tree
	 */
	void enterAttributeExpressionPart(TemplatesParser.AttributeExpressionPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttributeExpressionPart}
	 * labeled alternative in {@link TemplatesParser#attributePart}.
	 * @param ctx the parse tree
	 */
	void exitAttributeExpressionPart(TemplatesParser.AttributeExpressionPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleAttributeTextPart}
	 * labeled alternative in {@link TemplatesParser#singleAttributePart}.
	 * @param ctx the parse tree
	 */
	void enterSingleAttributeTextPart(TemplatesParser.SingleAttributeTextPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleAttributeTextPart}
	 * labeled alternative in {@link TemplatesParser#singleAttributePart}.
	 * @param ctx the parse tree
	 */
	void exitSingleAttributeTextPart(TemplatesParser.SingleAttributeTextPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleAttributeExpressionPart}
	 * labeled alternative in {@link TemplatesParser#singleAttributePart}.
	 * @param ctx the parse tree
	 */
	void enterSingleAttributeExpressionPart(TemplatesParser.SingleAttributeExpressionPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleAttributeExpressionPart}
	 * labeled alternative in {@link TemplatesParser#singleAttributePart}.
	 * @param ctx the parse tree
	 */
	void exitSingleAttributeExpressionPart(TemplatesParser.SingleAttributeExpressionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplatesParser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaElement(TemplatesParser.JinjaElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplatesParser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaElement(TemplatesParser.JinjaElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplatesParser#jinjaPrint}.
	 * @param ctx the parse tree
	 */
	void enterJinjaPrint(TemplatesParser.JinjaPrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplatesParser#jinjaPrint}.
	 * @param ctx the parse tree
	 */
	void exitJinjaPrint(TemplatesParser.JinjaPrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplatesParser#jinjaIf}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIf(TemplatesParser.JinjaIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplatesParser#jinjaIf}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIf(TemplatesParser.JinjaIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplatesParser#jinjaFor}.
	 * @param ctx the parse tree
	 */
	void enterJinjaFor(TemplatesParser.JinjaForContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplatesParser#jinjaFor}.
	 * @param ctx the parse tree
	 */
	void exitJinjaFor(TemplatesParser.JinjaForContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplatesParser#jinjaSet}.
	 * @param ctx the parse tree
	 */
	void enterJinjaSet(TemplatesParser.JinjaSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplatesParser#jinjaSet}.
	 * @param ctx the parse tree
	 */
	void exitJinjaSet(TemplatesParser.JinjaSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(TemplatesParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(TemplatesParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(TemplatesParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(TemplatesParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(TemplatesParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(TemplatesParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(TemplatesParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(TemplatesParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(TemplatesParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(TemplatesParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(TemplatesParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(TemplatesParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DictAccessExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDictAccessExpr(TemplatesParser.DictAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DictAccessExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDictAccessExpr(TemplatesParser.DictAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(TemplatesParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(TemplatesParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessExpr(TemplatesParser.MemberAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessExpr(TemplatesParser.MemberAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpr(TemplatesParser.LogicalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpr(TemplatesParser.LogicalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMathExpr(TemplatesParser.MathExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMathExpr(TemplatesParser.MathExprContext ctx);
}