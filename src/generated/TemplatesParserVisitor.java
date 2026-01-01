// Generated from C:/Users/VICTUS/Desktop/lectures/projects/CompilerProject/grammars/TemplatesGrammars/TemplatesParser.g4 by ANTLR 4.13.2
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TemplatesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TemplatesParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TemplatesParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplate(TemplatesParser.TemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplatesParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(TemplatesParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalTag}
	 * labeled alternative in {@link TemplatesParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalTag(TemplatesParser.NormalTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelfClosingTag}
	 * labeled alternative in {@link TemplatesParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingTag(TemplatesParser.SelfClosingTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplatesParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(TemplatesParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplatesParser#jinjaElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaElement(TemplatesParser.JinjaElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplatesParser#jinjaPrint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaPrint(TemplatesParser.JinjaPrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplatesParser#jinjaIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIf(TemplatesParser.JinjaIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplatesParser#jinjaFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaFor(TemplatesParser.JinjaForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(TemplatesParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(TemplatesParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(TemplatesParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(TemplatesParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DictAccessExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictAccessExpr(TemplatesParser.DictAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(TemplatesParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link TemplatesParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccessExpr(TemplatesParser.MemberAccessExprContext ctx);
}