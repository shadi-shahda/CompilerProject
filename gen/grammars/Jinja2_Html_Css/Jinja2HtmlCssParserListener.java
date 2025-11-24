// Generated from C:/Users/VICTUS/IdeaProjects/CompilerProject/grammars/Jinja2_Html_Css/Jinja2HtmlCssParser.g4 by ANTLR 4.13.2
package grammars.Jinja2_Html_Css;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Jinja2HtmlCssParser}.
 */
public interface Jinja2HtmlCssParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Jinja2HtmlCssParser#html_tag}.
	 * @param ctx the parse tree
	 */
	void enterHtml_tag(Jinja2HtmlCssParser.Html_tagContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2HtmlCssParser#html_tag}.
	 * @param ctx the parse tree
	 */
	void exitHtml_tag(Jinja2HtmlCssParser.Html_tagContext ctx);
}