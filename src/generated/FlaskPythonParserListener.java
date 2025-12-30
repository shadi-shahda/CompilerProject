// Generated from C:/Users/VICTUS/Desktop/lectures/projects/CompilerProject/grammars/FlaskPythonGrammars/FlaskPythonParser.g4 by ANTLR 4.13.2
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlaskPythonParser}.
 */
public interface FlaskPythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FlaskPythonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FlaskPythonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(FlaskPythonParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(FlaskPythonParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#importStmt}.
	 * @param ctx the parse tree
	 */
	void enterImportStmt(FlaskPythonParser.ImportStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#importStmt}.
	 * @param ctx the parse tree
	 */
	void exitImportStmt(FlaskPythonParser.ImportStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#importList}.
	 * @param ctx the parse tree
	 */
	void enterImportList(FlaskPythonParser.ImportListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#importList}.
	 * @param ctx the parse tree
	 */
	void exitImportList(FlaskPythonParser.ImportListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#importItem}.
	 * @param ctx the parse tree
	 */
	void enterImportItem(FlaskPythonParser.ImportItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#importItem}.
	 * @param ctx the parse tree
	 */
	void exitImportItem(FlaskPythonParser.ImportItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(FlaskPythonParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(FlaskPythonParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#routeDecorator}.
	 * @param ctx the parse tree
	 */
	void enterRouteDecorator(FlaskPythonParser.RouteDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#routeDecorator}.
	 * @param ctx the parse tree
	 */
	void exitRouteDecorator(FlaskPythonParser.RouteDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(FlaskPythonParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(FlaskPythonParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(FlaskPythonParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(FlaskPythonParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(FlaskPythonParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(FlaskPythonParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(FlaskPythonParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(FlaskPythonParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(FlaskPythonParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(FlaskPythonParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompareCond}
	 * labeled alternative in {@link FlaskPythonParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCompareCond(FlaskPythonParser.CompareCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompareCond}
	 * labeled alternative in {@link FlaskPythonParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCompareCond(FlaskPythonParser.CompareCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarCond}
	 * labeled alternative in {@link FlaskPythonParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterVarCond(FlaskPythonParser.VarCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarCond}
	 * labeled alternative in {@link FlaskPythonParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitVarCond(FlaskPythonParser.VarCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolCond}
	 * labeled alternative in {@link FlaskPythonParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterBoolCond(FlaskPythonParser.BoolCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolCond}
	 * labeled alternative in {@link FlaskPythonParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitBoolCond(FlaskPythonParser.BoolCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(FlaskPythonParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(FlaskPythonParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(FlaskPythonParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(FlaskPythonParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(FlaskPythonParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(FlaskPythonParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#expressionStmt}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStmt(FlaskPythonParser.ExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#expressionStmt}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStmt(FlaskPythonParser.ExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(FlaskPythonParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(FlaskPythonParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(FlaskPythonParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(FlaskPythonParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(FlaskPythonParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(FlaskPythonParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FlaskCallExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFlaskCallExpr(FlaskPythonParser.FlaskCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FlaskCallExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFlaskCallExpr(FlaskPythonParser.FlaskCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListAccessExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListAccessExpr(FlaskPythonParser.ListAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListAccessExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListAccessExpr(FlaskPythonParser.ListAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(FlaskPythonParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(FlaskPythonParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DictExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDictExpr(FlaskPythonParser.DictExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DictExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDictExpr(FlaskPythonParser.DictExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(FlaskPythonParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(FlaskPythonParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(FlaskPythonParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(FlaskPythonParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(FlaskPythonParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(FlaskPythonParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessExpr(FlaskPythonParser.MemberAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessExpr(FlaskPythonParser.MemberAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMathExpr(FlaskPythonParser.MathExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMathExpr(FlaskPythonParser.MathExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodCallExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallExpr(FlaskPythonParser.MethodCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodCallExpr}
	 * labeled alternative in {@link FlaskPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallExpr(FlaskPythonParser.MethodCallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#flaskFunc}.
	 * @param ctx the parse tree
	 */
	void enterFlaskFunc(FlaskPythonParser.FlaskFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#flaskFunc}.
	 * @param ctx the parse tree
	 */
	void exitFlaskFunc(FlaskPythonParser.FlaskFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(FlaskPythonParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(FlaskPythonParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(FlaskPythonParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(FlaskPythonParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(FlaskPythonParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(FlaskPythonParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#elements}.
	 * @param ctx the parse tree
	 */
	void enterElements(FlaskPythonParser.ElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#elements}.
	 * @param ctx the parse tree
	 */
	void exitElements(FlaskPythonParser.ElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#listComp}.
	 * @param ctx the parse tree
	 */
	void enterListComp(FlaskPythonParser.ListCompContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#listComp}.
	 * @param ctx the parse tree
	 */
	void exitListComp(FlaskPythonParser.ListCompContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#dictionary}.
	 * @param ctx the parse tree
	 */
	void enterDictionary(FlaskPythonParser.DictionaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#dictionary}.
	 * @param ctx the parse tree
	 */
	void exitDictionary(FlaskPythonParser.DictionaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#dictEntry}.
	 * @param ctx the parse tree
	 */
	void enterDictEntry(FlaskPythonParser.DictEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#dictEntry}.
	 * @param ctx the parse tree
	 */
	void exitDictEntry(FlaskPythonParser.DictEntryContext ctx);
}