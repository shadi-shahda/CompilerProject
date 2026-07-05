package FlaskPythonVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FlaskPythonAST.*;
import generated.FlaskPythonParser;
import generated.FlaskPythonParserBaseVisitor;

public class AntlrToPythonASTVisitor extends FlaskPythonParserBaseVisitor<FlaskPythonASTNode> {
    @Override
    public FlaskPythonProgram visitProgram(FlaskPythonParser.ProgramContext ctx) {
        FlaskPythonProgram program = new FlaskPythonProgram();
        for (FlaskPythonParser.LineContext lineCtx : ctx.line()) {
            FlaskPythonASTNode node = visit(lineCtx);
            if (node instanceof FlaskPythonStatement) {
                program.addStatement((FlaskPythonStatement) node);
            }
        }
        return program;
    }

    @Override
    public FlaskPythonASTNode visitImportStatement(FlaskPythonParser.ImportStatementContext ctx) {
        return visit(ctx.importStmt());
    }

    @Override
    public FlaskPythonASTNode visitFunctionDeclarationStatement(FlaskPythonParser.FunctionDeclarationStatementContext ctx) {
        return visit(ctx.functionDecl());
    }

    @Override
    public FlaskPythonASTNode visitRegularStatement(FlaskPythonParser.RegularStatementContext ctx) {
        return visit(ctx.statement());
    }

    @Override
    public FlaskPythonImportStatement visitImportStmt(FlaskPythonParser.ImportStmtContext ctx) {
        int line = ctx.getStart().getLine();
        String libraryName = ctx.ID().getText();
        List<String> importedItems = new ArrayList<>();
        for (FlaskPythonParser.ImportItemContext item : ctx.importList().importItem()) {
            importedItems.add(item.getText());
        }

        return new FlaskPythonImportStatement(libraryName, importedItems, line);
    }

    @Override
    public FlaskPythonASTNode visitImportList(FlaskPythonParser.ImportListContext ctx) {
        return super.visitImportList(ctx);
    }

    @Override
    public FlaskPythonASTNode visitImportItem(FlaskPythonParser.ImportItemContext ctx) {
        return super.visitImportItem(ctx);
    }

    @Override
    public FlaskPythonFunctionDeclaration visitFunctionDecl(FlaskPythonParser.FunctionDeclContext ctx) {
        String name = ctx.ID().getText();
        int line = ctx.getStart().getLine();
        List<String> parameters = new ArrayList<>();
        if (ctx.paramList() != null) {
            for (var id : ctx.paramList().ID()) {
                parameters.add(id.getText());
            }
        }
        String routePath = null;
        List<String> methods = new ArrayList<>();
        if (ctx.routeDecorator() != null) {
            if (ctx.routeDecorator().STRING() != null) {
                String rawPath = ctx.routeDecorator().STRING().getText();
                routePath = rawPath.substring(1, rawPath.length() - 1);
            }

            if (ctx.routeDecorator().methodsParam() != null) {
                if (ctx.routeDecorator().methodsParam().STRING() != null) {
                    for (int i = 0; i < ctx.routeDecorator().methodsParam().STRING().size(); i++) {
                        String method = ctx.routeDecorator().methodsParam().STRING(i).getText();
                        methods.add(method);
                    }
                }
            }
        }

        List<FlaskPythonStatement> body = getStatementsFromBlock(ctx.block());
        return new FlaskPythonFunctionDeclaration(name, parameters, body, routePath, methods, line);
    }

    @Override
    public FlaskPythonASTNode visitRouteDecorator(FlaskPythonParser.RouteDecoratorContext ctx) {
        return super.visitRouteDecorator(ctx);
    }

    @Override
    public FlaskPythonASTNode visitParamList(FlaskPythonParser.ParamListContext ctx) {
        return super.visitParamList(ctx);
    }

    @Override
    public FlaskPythonASTNode visitBlock(FlaskPythonParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public FlaskPythonASTNode visitSimpleStatement(FlaskPythonParser.SimpleStatementContext ctx) {
        return visit(ctx.simpleStmt());
    }

    @Override
    public FlaskPythonASTNode visitForStatement(FlaskPythonParser.ForStatementContext ctx) {
        return visit(ctx.forStmt());
    }

    @Override
    public FlaskPythonASTNode visitSimpleStmt(FlaskPythonParser.SimpleStmtContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public FlaskPythonASTNode visitIfStatement(FlaskPythonParser.IfStatementContext ctx) {
        return visit(ctx.ifStmt());
    }

    @Override
    public FlaskPythonIfStatement visitIfStmt(FlaskPythonParser.IfStmtContext ctx) {
        int line = ctx.getStart().getLine();
        FlaskPythonExpression condition = (FlaskPythonExpression) visit(ctx.condition());
        List<FlaskPythonStatement> thenBlock = getStatementsFromBlock(ctx.block(0));
        List<FlaskPythonStatement> elseBlock = null;

        if (ctx.block().size() > 1) {
            elseBlock = getStatementsFromBlock(ctx.block(1));
        }
        return new FlaskPythonIfStatement(condition, thenBlock, elseBlock, line);
    }

    @Override
    public FlaskPythonASTNode visitPrintStmt(FlaskPythonParser.PrintStmtContext ctx) {
        int line = ctx.getStart().getLine();
        FlaskPythonExpression expression = (FlaskPythonExpression) visit(ctx.expression());
        return new FlaskPythonPrintStatement(expression, line);
    }
//
//    @Override
//    public FlaskPythonASTNode visitCompareCond(FlaskPythonParser.CompareCondContext ctx) {
//        int line = ctx.getStart().getLine();
//        FlaskPythonExpression left = (FlaskPythonExpression) visit(ctx.expression(0));
//        FlaskPythonExpression right = (FlaskPythonExpression) visit(ctx.expression(1));
//        String op = ctx.getChild(1).getText();
//        return new FlaskPythonBinaryExpression(left, op, right, line);
//    }
//
//    @Override
//    public FlaskPythonASTNode visitVarCond(FlaskPythonParser.VarCondContext ctx) {
//        int line = ctx.getStart().getLine();
//        String name = ctx.ID().getText();
//        return new FlaskPythonIdentifier(name, line);
//    }
//
//    @Override
//    public FlaskPythonASTNode visitBoolCond(FlaskPythonParser.BoolCondContext ctx) {
//        int line = ctx.getStart().getLine();
//        boolean val = Boolean.parseBoolean(ctx.BOOLEAN().getText().toLowerCase());
//        return new FlaskPythonBooleanLiteral(val, line);
//    }


    @Override
    public FlaskPythonASTNode visitCondition(FlaskPythonParser.ConditionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public FlaskPythonForStatement visitForStmt(FlaskPythonParser.ForStmtContext ctx) {
        int line = ctx.getStart().getLine();
        String varName = ctx.ID().getText();

        FlaskPythonExpression iterable = (FlaskPythonExpression) visit(ctx.expression());

        List<FlaskPythonStatement> body = getStatementsFromBlock(ctx.block());

        return new FlaskPythonForStatement(varName, iterable, body, line);
    }

    @Override
    public FlaskPythonBinaryExpression visitMathExpr(FlaskPythonParser.MathExprContext ctx) {
        int line = ctx.getStart().getLine();
        FlaskPythonExpression left = (FlaskPythonExpression) visit(ctx.expression(0));
        FlaskPythonExpression right = (FlaskPythonExpression) visit(ctx.expression(1));
        String operator = ctx.getChild(1).getText();
        return new FlaskPythonBinaryExpression(left, operator, right, line);
    }

    @Override
    public FlaskPythonMethodCall visitMethodCallExpr(FlaskPythonParser.MethodCallExprContext ctx) {
        FlaskPythonExpression object = (FlaskPythonExpression) visit(ctx.expression());
        String methodName = ctx.ID().getText();
        List<FlaskPythonArgument> args = getArguments(ctx.argList());
        return new FlaskPythonMethodCall(object, methodName, args, ctx.getStart().getLine());
    }

    @Override
    public FlaskPythonASTNode visitBoolExpr(FlaskPythonParser.BoolExprContext ctx) {
        int line = ctx.getStart().getLine();
        boolean value = Boolean.parseBoolean(ctx.BOOLEAN().getText().toLowerCase());
        return new FlaskPythonBooleanLiteral(value, line);
    }

    @Override
    public FlaskPythonReturnStatement visitReturnStmt(FlaskPythonParser.ReturnStmtContext ctx) {
        int line = ctx.getStart().getLine();
        FlaskPythonExpression expression = (FlaskPythonExpression) visit(ctx.expression());
        return new FlaskPythonReturnStatement(expression, line);
    }

    @Override
    public FlaskPythonAssignmentStatement visitAssignment(FlaskPythonParser.AssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        String variableName = ctx.ID().getText();
        FlaskPythonExpression expression = (FlaskPythonExpression) visit(ctx.expression());
        return new FlaskPythonAssignmentStatement(variableName, expression, line);
    }

    @Override
    public FlaskPythonASTNode visitGlobalStmt(FlaskPythonParser.GlobalStmtContext ctx) {
        int line = ctx.getStart().getLine();
        List<String> variableNames = new ArrayList<>();
        for (int i = 0; i < ctx.ID().size(); i++) {
            variableNames.add(ctx.ID(i).getText());
        }
        return new FlaskPythonGlobalStatement(variableNames, line);
    }

    @Override
    public FlaskPythonASTNode visitBreakStmt(FlaskPythonParser.BreakStmtContext ctx) {
        int line = ctx.getStart().getLine();
        return new FlaskPythonBreakStatement(line);
    }

    @Override
    public FlaskPythonASTNode visitExpressionStmt(FlaskPythonParser.ExpressionStmtContext ctx) {
        int line = ctx.getStart().getLine();
        FlaskPythonExpression expression = (FlaskPythonExpression) visit(ctx.expression());
        return new FlaskPythonExpressionStatement(expression, line);
    }

    @Override
    public FlaskPythonStringLiteral visitStringExpr(FlaskPythonParser.StringExprContext ctx) {
        int line = ctx.getStart().getLine();
        String text = ctx.STRING().getText();
        String value = text.substring(1, text.length() - 1);
        return new FlaskPythonStringLiteral(value, line);
    }

    @Override
    public FlaskPythonFunctionCall visitFunctionCallExpr(FlaskPythonParser.FunctionCallExprContext ctx) {
        int line = ctx.getStart().getLine();
        String functionName = ctx.ID().getText();
        List<FlaskPythonArgument> arguments = getArguments(ctx.argList());
        return new FlaskPythonFunctionCall(functionName, arguments, false, line);
    }

    @Override
    public FlaskPythonIdentifier visitIdExpr(FlaskPythonParser.IdExprContext ctx) {
        int line = ctx.getStart().getLine();
        String name = ctx.getText();
        return new FlaskPythonIdentifier(name, line);
    }

    @Override
    public FlaskPythonBinaryExpression visitComparisonExpr(FlaskPythonParser.ComparisonExprContext ctx) {
        int line = ctx.getStart().getLine();
        FlaskPythonExpression left = (FlaskPythonExpression) visit(ctx.expression(0));
        FlaskPythonExpression right = (FlaskPythonExpression) visit(ctx.expression(1));
        String operator = ctx.getChild(1).getText();
        return new FlaskPythonBinaryExpression(left, operator, right, line);
    }

    @Override
    public FlaskPythonFunctionCall visitFlaskCallExpr(FlaskPythonParser.FlaskCallExprContext ctx) {
        int line = ctx.getStart().getLine();
        String functionName = ctx.flaskFunc().getText();
        List<FlaskPythonArgument> arguments = new ArrayList<>();
        if (ctx.argList() != null) {
            arguments = getArguments(ctx.argList());
        }
        return new FlaskPythonFunctionCall(functionName, arguments, true, line);
    }

    @Override
    public FlaskPythonDictionaryExpression visitDictExpr(FlaskPythonParser.DictExprContext ctx) {
        int line = ctx.getStart().getLine();
        Map<FlaskPythonExpression, FlaskPythonExpression> entries = new HashMap<>();
        for (var entry : ctx.dictionary().dictEntry()) {
            FlaskPythonExpression key = (FlaskPythonExpression) visit(entry.expression(0));

            FlaskPythonExpression value = (FlaskPythonExpression) visit(entry.expression(1));
            entries.put(key, value);
        }
        return new FlaskPythonDictionaryExpression(entries, line);
    }

    @Override
    public FlaskPythonMemberAccess visitListAccessExpr(FlaskPythonParser.ListAccessExprContext ctx) {
        int line = ctx.getStart().getLine();
        FlaskPythonExpression object = (FlaskPythonExpression) visit(ctx.expression(0));
        FlaskPythonExpression index = (FlaskPythonExpression) visit(ctx.expression(1));
        String memberName = index.toString();
        if (index instanceof FlaskPythonStringLiteral) memberName = ((FlaskPythonStringLiteral) index).value;
        return new FlaskPythonMemberAccess(object, "[" + memberName + "]", line);
    }

    @Override
    public FlaskPythonExpression visitListExpr(FlaskPythonParser.ListExprContext ctx) {
        int line = ctx.getStart().getLine();
        if (ctx.list().listComp() != null) {
            FlaskPythonParser.ListCompContext listCompCtx = ctx.list().listComp();

            FlaskPythonExpression elementExpression =
                    (FlaskPythonExpression) visit(listCompCtx.expression(0));

            String loopVariable =
                    listCompCtx.ID().getText();

            FlaskPythonExpression iterableExpression =
                    (FlaskPythonExpression) visit(listCompCtx.expression(1));

            FlaskPythonExpression conditionExpression = null;

            if (listCompCtx.expression().size() > 2) {
                conditionExpression =
                        (FlaskPythonExpression) visit(listCompCtx.expression(2));
            }

            return new FlaskPythonListComprehensionExpression(elementExpression, loopVariable,
                    iterableExpression, conditionExpression, line);
        }

        List<FlaskPythonExpression> elements = new ArrayList<>();

        if (ctx.list().elements() != null) {
            for (var exprCtx : ctx.list().elements().expression()) {
                elements.add((FlaskPythonExpression) visit(exprCtx));
            }
        }

        return new FlaskPythonListExpression(elements, line);
    }

    @Override
    public FlaskPythonIntegerLiteral visitIntExpr(FlaskPythonParser.IntExprContext ctx) {
        int line = ctx.getStart().getLine();
        int value = Integer.parseInt(ctx.INT().getText());
        return new FlaskPythonIntegerLiteral(value, line);
    }

    @Override
    public FlaskPythonASTNode visitMemberAccessExpr(FlaskPythonParser.MemberAccessExprContext ctx) {
        int line = ctx.getStart().getLine();
        String memberName = ctx.ID().getText();
        FlaskPythonExpression object = (FlaskPythonExpression) visit(ctx.expression());
        return new FlaskPythonMemberAccess(object, memberName, line);
    }

    @Override
    public FlaskPythonASTNode visitFlaskFunc(FlaskPythonParser.FlaskFuncContext ctx) {
        return super.visitFlaskFunc(ctx);
    }

    @Override
    public FlaskPythonASTNode visitArgList(FlaskPythonParser.ArgListContext ctx) {
        return super.visitArgList(ctx);
    }

    @Override
    public FlaskPythonASTNode visitArgument(FlaskPythonParser.ArgumentContext ctx) {
        return super.visitArgument(ctx);
    }

    @Override
    public FlaskPythonASTNode visitElements(FlaskPythonParser.ElementsContext ctx) {
        return super.visitElements(ctx);
    }

    @Override
    public FlaskPythonASTNode visitListComp(FlaskPythonParser.ListCompContext ctx) {
        return super.visitListComp(ctx);
    }

    @Override
    public FlaskPythonASTNode visitDictionary(FlaskPythonParser.DictionaryContext ctx) {
        return super.visitDictionary(ctx);
    }

    @Override
    public FlaskPythonASTNode visitDictEntry(FlaskPythonParser.DictEntryContext ctx) {
        return super.visitDictEntry(ctx);
    }

    private List<FlaskPythonStatement> getStatementsFromBlock(FlaskPythonParser.BlockContext ctx) {
        List<FlaskPythonStatement> stats = new ArrayList<>();
        for (var stmtCtx : ctx.statement()) {
            FlaskPythonASTNode node = visit(stmtCtx);
            if (node instanceof FlaskPythonStatement) {
                stats.add((FlaskPythonStatement) node);
            }
        }
        return stats;
    }

    private List<FlaskPythonArgument> getArguments(FlaskPythonParser.ArgListContext ctx) {
        List<FlaskPythonArgument> args = new ArrayList<>();

        if (ctx == null) {
            return args;
        }

        for (FlaskPythonParser.ArgumentContext argCtx : ctx.argument()) {
            String keywordName = null;

            if (argCtx.keyword != null) {
                keywordName = argCtx.keyword.getText();
            }

            FlaskPythonExpression value =
                    (FlaskPythonExpression) visit(argCtx.value);

            args.add(new FlaskPythonArgument(
                    keywordName,
                    value,
                    argCtx.getStart().getLine()
            ));
        }

        return args;
    }
}
