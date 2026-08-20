package FinalGeneration;

import FlaskPythonAST.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Analyzes the Python AST and discovers which Flask function renders which
 * Jinja template and which values are passed to that template.
 *
 * This class does NOT render HTML yet.
 * It only builds the Python -> Jinja binding map.
 */
public final class PythonRenderTemplateAnalyzer {

    public List<RenderTemplateBinding> analyze(FlaskPythonProgram program) {

        List<RenderTemplateBinding> bindings = new ArrayList<>();

        if (program == null || program.statements == null) {
            return bindings;
        }

        for (FlaskPythonStatement statement : program.statements) {

            if (statement instanceof FlaskPythonFunctionDeclaration function) {
                analyzeFunction(function, bindings);
            }
        }

        return bindings;
    }

    private void analyzeFunction(
            FlaskPythonFunctionDeclaration function,
            List<RenderTemplateBinding> bindings
    ) {

        if (function.body == null) {
            return;
        }

        for (FlaskPythonStatement statement : function.body) {
            analyzeStatement(statement, function, bindings);
        }
    }

    private void analyzeStatement(
            FlaskPythonStatement statement,
            FlaskPythonFunctionDeclaration currentFunction,
            List<RenderTemplateBinding> bindings
    ) {

        if (statement == null) {
            return;
        }

        if (statement instanceof FlaskPythonReturnStatement returnStatement) {

            analyzeExpression(
                    returnStatement.expression,
                    currentFunction,
                    bindings
            );

            return;
        }

        if (statement instanceof FlaskPythonIfStatement ifStatement) {

            analyzeExpression(
                    ifStatement.condition,
                    currentFunction,
                    bindings
            );

            analyzeBlock(
                    ifStatement.thenBloc,
                    currentFunction,
                    bindings
            );

            analyzeBlock(
                    ifStatement.elseBloc,
                    currentFunction,
                    bindings
            );

            return;
        }

        if (statement instanceof FlaskPythonForStatement forStatement) {

            analyzeExpression(
                    forStatement.iterable,
                    currentFunction,
                    bindings
            );

            analyzeBlock(
                    forStatement.body,
                    currentFunction,
                    bindings
            );

            return;
        }

        if (statement instanceof FlaskPythonAssignmentStatement assignmentStatement) {

            analyzeExpression(
                    assignmentStatement.expression,
                    currentFunction,
                    bindings
            );

            return;
        }

        if (statement instanceof FlaskPythonExpressionStatement expressionStatement) {

            analyzeExpression(
                    expressionStatement.expression,
                    currentFunction,
                    bindings
            );

            return;
        }

        if (statement instanceof FlaskPythonPrintStatement printStatement) {

            analyzeExpression(
                    printStatement.expression,
                    currentFunction,
                    bindings
            );
        }
    }

    private void analyzeBlock(
            List<FlaskPythonStatement> statements,
            FlaskPythonFunctionDeclaration currentFunction,
            List<RenderTemplateBinding> bindings
    ) {

        if (statements == null) {
            return;
        }

        for (FlaskPythonStatement statement : statements) {

            analyzeStatement(
                    statement,
                    currentFunction,
                    bindings
            );
        }
    }

    private void analyzeExpression(
            FlaskPythonExpression expression,
            FlaskPythonFunctionDeclaration currentFunction,
            List<RenderTemplateBinding> bindings
    ) {

        if (expression == null) {
            return;
        }

        /*
         * Example:
         *
         * render_template(
         *      "index.html",
         *      products=products
         * )
         */
        if (expression instanceof FlaskPythonFunctionCall functionCall) {

            if ("render_template".equals(functionCall.functionName)) {

                RenderTemplateBinding binding =
                        extractBinding(
                                functionCall,
                                currentFunction
                        );

                if (binding != null) {
                    bindings.add(binding);
                }
            }

            if (functionCall.arguments != null) {

                for (FlaskPythonArgument argument : functionCall.arguments) {

                    if (argument != null) {

                        analyzeExpression(
                                argument.value,
                                currentFunction,
                                bindings
                        );
                    }
                }
            }

            return;
        }

        if (expression instanceof FlaskPythonMethodCall methodCall) {

            analyzeExpression(
                    methodCall.object,
                    currentFunction,
                    bindings
            );

            if (methodCall.arguments != null) {

                for (FlaskPythonArgument argument : methodCall.arguments) {

                    if (argument != null) {

                        analyzeExpression(
                                argument.value,
                                currentFunction,
                                bindings
                        );
                    }
                }
            }

            return;
        }

        if (expression instanceof FlaskPythonBinaryExpression binaryExpression) {

            analyzeExpression(
                    binaryExpression.left,
                    currentFunction,
                    bindings
            );

            analyzeExpression(
                    binaryExpression.right,
                    currentFunction,
                    bindings
            );

            return;
        }

        if (expression instanceof FlaskPythonMemberAccess memberAccess) {

            analyzeExpression(
                    memberAccess.object,
                    currentFunction,
                    bindings
            );

            return;
        }

        if (expression instanceof FlaskPythonListExpression listExpression) {

            if (listExpression.elements != null) {

                for (FlaskPythonExpression item : listExpression.elements) {

                    analyzeExpression(
                            item,
                            currentFunction,
                            bindings
                    );
                }
            }

            return;
        }

        if (expression instanceof FlaskPythonDictionaryExpression dictionaryExpression) {

            if (dictionaryExpression.entries != null) {

                for (
                        Map.Entry<
                                FlaskPythonExpression,
                                FlaskPythonExpression
                                > entry
                        : dictionaryExpression.entries.entrySet()
                ) {

                    analyzeExpression(
                            entry.getKey(),
                            currentFunction,
                            bindings
                    );

                    analyzeExpression(
                            entry.getValue(),
                            currentFunction,
                            bindings
                    );
                }
            }

            return;
        }

        if (expression instanceof FlaskPythonListComprehensionExpression listComprehension) {

            analyzeExpression(
                    listComprehension.elementExpression,
                    currentFunction,
                    bindings
            );

            analyzeExpression(
                    listComprehension.iterableExpression,
                    currentFunction,
                    bindings
            );

            analyzeExpression(
                    listComprehension.conditionExpression,
                    currentFunction,
                    bindings
            );
        }
    }

    private RenderTemplateBinding extractBinding(
            FlaskPythonFunctionCall functionCall,
            FlaskPythonFunctionDeclaration currentFunction
    ) {

        if (
                functionCall.arguments == null ||
                        functionCall.arguments.isEmpty()
        ) {
            return null;
        }

        /*
         * أول Argument:
         *
         * "index.html"
         */
        FlaskPythonArgument templateArgument =
                functionCall.arguments.get(0);

        if (
                templateArgument == null ||
                        !(templateArgument.value
                                instanceof FlaskPythonStringLiteral templateLiteral)
        ) {
            return null;
        }

        String templateName = templateLiteral.value;

        /*
         * باقي Arguments:
         *
         * products=products
         * product=product
         */
        Map<String, FlaskPythonExpression> contextExpressions =
                new LinkedHashMap<>();

        for (int i = 1; i < functionCall.arguments.size(); i++) {

            FlaskPythonArgument argument =
                    functionCall.arguments.get(i);

            if (
                    argument == null ||
                            !argument.isKeywordArgument()
            ) {
                continue;
            }

            contextExpressions.put(
                    argument.keywordName,
                    argument.value
            );
        }

        return new RenderTemplateBinding(
                currentFunction.name,
                currentFunction.routePath,
                templateName,
                contextExpressions
        );
    }
}