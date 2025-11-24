// Generated from C:/Users/VICTUS/IdeaProjects/CompilerProject/grammars/Falsk/FlaskParser.g4 by ANTLR 4.13.2
package grammars.Falsk;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FlaskParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FlaskParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FlaskParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FlaskParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FlaskParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#var_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_declaration(FlaskParser.Var_declarationContext ctx);
}