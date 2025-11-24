// Generated from C:/Users/VICTUS/IdeaProjects/CompilerProject/grammars/Falsk/FlaskParser.g4 by ANTLR 4.13.2
package grammars.Falsk;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlaskParser}.
 */
public interface FlaskParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FlaskParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FlaskParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FlaskParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(FlaskParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(FlaskParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVar_declaration(FlaskParser.Var_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVar_declaration(FlaskParser.Var_declarationContext ctx);
}