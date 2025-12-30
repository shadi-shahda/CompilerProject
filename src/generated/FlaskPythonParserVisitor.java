// Generated from C:/Users/VICTUS/Desktop/lectures/projects/CompilerProject/grammars/FlaskPythonGrammars/FlaskPythonParser.g4 by ANTLR 4.13.2
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FlaskPythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FlaskPythonParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FlaskPythonParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(FlaskPythonParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#importStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStmt(FlaskPythonParser.ImportStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportList(FlaskPythonParser.ImportListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#importItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportItem(FlaskPythonParser.ImportItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(FlaskPythonParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#routeDecorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteDecorator(FlaskPythonParser.RouteDecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(FlaskPythonParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(FlaskPythonParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FlaskPythonParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(FlaskPythonParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(FlaskPythonParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompareCond}
	 * labeled alternative in {@link FlaskPythonParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareCond(FlaskPythonParser.CompareCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarCond}
	 * labeled alternative in {@link FlaskPythonParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarCond(FlaskPythonParser.VarCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolCond}
	 * labeled alternative in {@link FlaskPythonParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolCond(FlaskPythonParser.BoolCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(FlaskPythonParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(FlaskPythonParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(FlaskPythonParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#expressionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStmt(FlaskPythonParser.ExpressionStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(FlaskPythonParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(FlaskPythonParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(FlaskPythonParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FlaskCallExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlaskCallExpr(FlaskPythonParser.FlaskCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListAccessExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAccessExpr(FlaskPythonParser.ListAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(FlaskPythonParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DictExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictExpr(FlaskPythonParser.DictExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(FlaskPythonParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(FlaskPythonParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(FlaskPythonParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccessExpr(FlaskPythonParser.MemberAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MathExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathExpr(FlaskPythonParser.MathExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodCallExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallExpr(FlaskPythonParser.MethodCallExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#flaskFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlaskFunc(FlaskPythonParser.FlaskFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(FlaskPythonParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(FlaskPythonParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(FlaskPythonParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#elements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElements(FlaskPythonParser.ElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#listComp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComp(FlaskPythonParser.ListCompContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#dictionary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictionary(FlaskPythonParser.DictionaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#dictEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictEntry(FlaskPythonParser.DictEntryContext ctx);
}