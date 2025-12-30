package generated;
// Generated from grammars/CssGrammars/CssParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CssParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CssParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CssParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(CssParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link CssParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(CssParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CssParser#selectors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectors(CssParser.SelectorsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagSelector}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagSelector(CssParser.TagSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassSelector}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassSelector(CssParser.ClassSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdSelector}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdSelector(CssParser.IdSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CssParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CssParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CssParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(CssParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CssParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(CssParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CssParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(CssParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CssParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CssParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentValue(CssParser.IdentValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(CssParser.IntValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringVlue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringVlue(CssParser.StringVlueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PxValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPxValue(CssParser.PxValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PercentValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercentValue(CssParser.PercentValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HexValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexValue(CssParser.HexValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatValue(CssParser.FloatValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionValue(CssParser.FunctionValueContext ctx);
}