// Generated from grammars/Jinja2-Html-Css-grammars/Jinja2HtmlCssParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Jinja2HtmlCssParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Jinja2HtmlCssParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Jinja2HtmlCssParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(Jinja2HtmlCssParser.StringContext ctx);
}