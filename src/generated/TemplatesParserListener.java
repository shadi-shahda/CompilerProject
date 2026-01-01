// Generated from C:/Users/VICTUS/Desktop/lectures/projects/CompilerProject/grammars/TemplatesGrammars/TemplatesParser.g4 by ANTLR 4.13.2
package generated;
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
	 * Enter a parse tree produced by {@link TemplatesParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(TemplatesParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplatesParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(TemplatesParser.ContentContext ctx);
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
	 * Enter a parse tree produced by {@link TemplatesParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(TemplatesParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplatesParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(TemplatesParser.AttributeContext ctx);
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
}