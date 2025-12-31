// Generated from C:/Users/VICTUS/Desktop/lectures/projects/CompilerProject/grammars/CssGrammars/CssParser.g4 by ANTLR 4.13.2
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CssParser}.
 */
public interface CssParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CssParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(CssParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CssParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(CssParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link CssParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(CssParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CssParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(CssParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CssParser#selectors}.
	 * @param ctx the parse tree
	 */
	void enterSelectors(CssParser.SelectorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CssParser#selectors}.
	 * @param ctx the parse tree
	 */
	void exitSelectors(CssParser.SelectorsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagSelector}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterTagSelector(CssParser.TagSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagSelector}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitTagSelector(CssParser.TagSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassSelector}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterClassSelector(CssParser.ClassSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassSelector}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitClassSelector(CssParser.ClassSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdSelector}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterIdSelector(CssParser.IdSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdSelector}
	 * labeled alternative in {@link CssParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitIdSelector(CssParser.IdSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CssParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CssParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CssParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CssParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CssParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CssParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CssParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CssParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CssParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(CssParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CssParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(CssParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CssParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(CssParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CssParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(CssParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CssParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CssParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CssParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CssParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void enterIdentValue(CssParser.IdentValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void exitIdentValue(CssParser.IdentValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void enterIntValue(CssParser.IntValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void exitIntValue(CssParser.IntValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringVlue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void enterStringVlue(CssParser.StringVlueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringVlue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void exitStringVlue(CssParser.StringVlueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PxValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void enterPxValue(CssParser.PxValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PxValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void exitPxValue(CssParser.PxValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PercentValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void enterPercentValue(CssParser.PercentValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PercentValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void exitPercentValue(CssParser.PercentValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HexValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void enterHexValue(CssParser.HexValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HexValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void exitHexValue(CssParser.HexValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void enterFloatValue(CssParser.FloatValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void exitFloatValue(CssParser.FloatValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void enterFunctionValue(CssParser.FunctionValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionValue}
	 * labeled alternative in {@link CssParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void exitFunctionValue(CssParser.FunctionValueContext ctx);
}