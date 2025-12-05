// Generated from grammars/Flask-Python-grammars/FlaskPythonParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlaskPythonParser}.
 */
public interface FlaskPythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(FlaskPythonParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(FlaskPythonParser.StringContext ctx);
}