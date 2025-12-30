package FlaskPythonVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FlaskPythonAST.*;
import generated.FlaskPythonParser;
import generated.FlaskPythonParserBaseVisitor;

public class AntlrToASTVisitor extends FlaskPythonParserBaseVisitor<FlaskPythonASTNode> {
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
    public FlaskPythonASTNode visitLine(FlaskPythonParser.LineContext ctx) {
        return visit(ctx.getChild(0));
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

            if (ctx.routeDecorator().ID().size() > 1) {
                String argName = ctx.routeDecorator().ID(1).getText();

                if ("methods".equals(argName)) {
                    if (ctx.routeDecorator().list() != null) {
                        String listText = ctx.routeDecorator().list().getText();
                        methods.add(listText);
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
    public FlaskPythonASTNode visitStatement(FlaskPythonParser.StatementContext ctx) {
        return visit(ctx.getChild(0));
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

    @Override
    public FlaskPythonASTNode visitCompareCond(FlaskPythonParser.CompareCondContext ctx) {
        int line = ctx.getStart().getLine();
        FlaskPythonExpression left = (FlaskPythonExpression) visit(ctx.expression(0));
        FlaskPythonExpression right = (FlaskPythonExpression) visit(ctx.expression(1));
        String op = ctx.getChild(1).getText();
        return new FlaskPythonBinaryExpression(left, op, right, line);
    }

    @Override
    public FlaskPythonASTNode visitVarCond(FlaskPythonParser.VarCondContext ctx) {
        int line = ctx.getStart().getLine();
        String name = ctx.ID().getText();
        return new FlaskPythonIdentifier(name, line);
    }

    @Override
    public FlaskPythonASTNode visitBoolCond(FlaskPythonParser.BoolCondContext ctx) {
        int line = ctx.getStart().getLine();
        boolean val = Boolean.parseBoolean(ctx.BOOLEAN().getText().toLowerCase());
        return new FlaskPythonBooleanLiteral(val, line);
    }

    @Override
    public FLaskPythonForStatement visitForStmt(FlaskPythonParser.ForStmtContext ctx) {
        int line = ctx.getStart().getLine();
        String varName = ctx.ID(0).getText();

        String listName = ctx.ID(1).getText();
        FlaskPythonExpression iterable = new FlaskPythonIdentifier(listName, line);
        List<FlaskPythonStatement> body = getStatementsFromBlock(ctx.block());

        return new FLaskPythonForStatement(varName, iterable, body, line);
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
        List<FlaskPythonExpression> args = getArguments(ctx.argList());

        return new FlaskPythonMethodCall(object, methodName, args, ctx.getStart().getLine());
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
    public FlaskPythonASTNode visitExpressionStmt(FlaskPythonParser.ExpressionStmtContext ctx) {
        return visit(ctx.expression());
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
        List<FlaskPythonExpression> arguments = getArguments(ctx.argList());
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
        List<FlaskPythonExpression> arguments = new ArrayList<>();
        if (ctx.argList() != null) {
            arguments = getArguments(ctx.argList());
        }
        return new FlaskPythonFunctionCall(functionName, arguments, true, line);
    }

    @Override
    public FlaskPythonDictionaryExpression visitDictExpr(FlaskPythonParser.DictExprContext ctx) {
        int line = ctx.getStart().getLine();
        Map<String, FlaskPythonExpression> entries = new HashMap<>();
        for (var entry : ctx.dictionary().dictEntry()) {
            String key = entry.STRING().getText();
            key = key.substring(1, key.length() - 1);
            FlaskPythonExpression value = (FlaskPythonExpression) visit(entry.expression());
            entries.put(key, value);
        }
        return new FlaskPythonDictionaryExpression(entries, line);
    }

    @Override
    public FlaskPythonMemberAccess visitListAccessExpr(FlaskPythonParser.ListAccessExprContext ctx) {
        int line = ctx.getStart().getLine();
        FlaskPythonExpression object = (FlaskPythonExpression) visit(ctx.expression(0));
        String index = ctx.expression(1).getText();
        return new FlaskPythonMemberAccess(object, "[" + index + "]", line);
    }

    @Override
    public FlaskPythonListExpression visitListExpr(FlaskPythonParser.ListExprContext ctx) {
        int line = ctx.getStart().getLine();
        List<FlaskPythonExpression> elements = new ArrayList<>();
        if (ctx.list().elements() != null) {
            for (var exprCtx : ctx.list().elements().expression()) {
                elements.add((FlaskPythonExpression) visit(exprCtx));
            }
        } else if (ctx.list().listComp() != null) {
            elements.add(new FlaskPythonStringLiteral("List_Comprehension_Structure", line));
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
        String memeberName = ctx.ID().getText();
        FlaskPythonExpression object = (FlaskPythonExpression) visit(ctx.expression());
        return new FlaskPythonMemberAccess(object, memeberName, line);
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
    public FlaskPythonASTNode visitList(FlaskPythonParser.ListContext ctx) {
        return super.visitList(ctx);
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
        List<FlaskPythonStatement> stmts = new ArrayList<>();
        for (var stmtCtx : ctx.statement()) {
            FlaskPythonASTNode node = visit(stmtCtx);
            if (node instanceof FlaskPythonStatement) {
                stmts.add((FlaskPythonStatement) node);
            }
        }
        return stmts;
    }

    private List<FlaskPythonExpression> getArguments(FlaskPythonParser.ArgListContext ctx) {
        List<FlaskPythonExpression> args = new ArrayList<>();
        if (ctx != null) {
            for (var arg : ctx.argument()) {
                args.add((FlaskPythonExpression) visit(arg.expression()));
            }
        }
        return args;
    }
}
