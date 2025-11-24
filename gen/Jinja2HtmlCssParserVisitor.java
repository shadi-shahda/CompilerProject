// Generated from C:/Users/VICTUS/IdeaProjects/CompilerProject/grammars/Jinja2_Html_Css/Jinja2HtmlCssParser.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by {@link Jinja2HtmlCssParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(Jinja2HtmlCssParser.RuleContext ctx);
}