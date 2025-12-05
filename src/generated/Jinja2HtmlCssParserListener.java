// Generated from grammars/Jinja2-Html-Css-grammars/Jinja2HtmlCssParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Jinja2HtmlCssParser}.
 */
public interface Jinja2HtmlCssParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Jinja2HtmlCssParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(Jinja2HtmlCssParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2HtmlCssParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(Jinja2HtmlCssParser.StringContext ctx);
}