// Generated from C:/Users/VICTUS/IdeaProjects/CompilerProject/grammars/Jinja2_Html_Css/Jinja2HtmlCssParser.g4 by ANTLR 4.13.2
package grammars.Jinja2_Html_Css;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link Jinja2HtmlCssParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
@SuppressWarnings("CheckReturnValue")
public class Jinja2HtmlCssParserBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements Jinja2HtmlCssParserVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitHtml_tag(Jinja2HtmlCssParser.Html_tagContext ctx) { return visitChildren(ctx); }
}