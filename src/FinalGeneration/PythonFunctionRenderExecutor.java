package FinalGeneration;

import FlaskPythonAST.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class PythonFunctionRenderExecutor {

    private static final Object UNRESOLVED = new Object();

    public ExecutionResult execute(
            FlaskPythonProgram program,
            PythonRuntimeContext runtimeContext,
            String functionName,
            Map<String, Object> parameters
    ) {

        FlaskPythonFunctionDeclaration function =
                findFunction(program, functionName);

        if (function == null) {
            return ExecutionResult.failure(
                    "Function not found: " + functionName
            );
        }

        Map<String, Object> env =
                new LinkedHashMap<>();

        if (
                runtimeContext != null
                        && runtimeContext.getGlobals() != null
        ) {
            env.putAll(
                    runtimeContext.getGlobals()
            );
        }

        if (parameters != null) {
            env.putAll(parameters);
        }

        Signal signal =
                executeBlock(
                        function.body,
                        env
                );

        if (signal.kind == SignalKind.RENDER) {

            return ExecutionResult.success(
                    signal.templateName,
                    signal.renderContext
            );
        }

        if (signal.kind == SignalKind.UNRESOLVED) {

            return ExecutionResult.failure(
                    "Unresolved value: "
                            + signal.message
            );
        }

        return ExecutionResult.failure(
                "Function did not reach render_template(): "
                        + functionName
        );
    }


    private FlaskPythonFunctionDeclaration findFunction(
            FlaskPythonProgram program,
            String functionName
    ) {

        if (
                program == null
                        || program.statements == null
        ) {
            return null;
        }

        for (
                FlaskPythonStatement statement
                : program.statements
        ) {

            if (
                    statement
                            instanceof FlaskPythonFunctionDeclaration function
                            && Objects.equals(
                            function.name,
                            functionName
                    )
            ) {
                return function;
            }
        }

        return null;
    }


    private Signal executeBlock(
            List<FlaskPythonStatement> statements,
            Map<String, Object> env
    ) {

        if (statements == null) {
            return Signal.normal();
        }

        for (
                FlaskPythonStatement statement
                : statements
        ) {

            Signal signal =
                    executeStatement(
                            statement,
                            env
                    );

            if (
                    signal.kind
                            != SignalKind.NORMAL
            ) {
                return signal;
            }
        }

        return Signal.normal();
    }


    private Signal executeStatement(
            FlaskPythonStatement statement,
            Map<String, Object> env
    ) {

        if (statement == null) {
            return Signal.normal();
        }

        /*
         * product = None
         *
         * أو:
         *
         * product = p
         */
        if (
                statement
                        instanceof FlaskPythonAssignmentStatement assignment
        ) {

            Object value =
                    evaluate(
                            assignment.expression,
                            env
                    );

            if (value == UNRESOLVED) {

                return Signal.unresolved(
                        assignment.variableName
                );
            }

            env.put(
                    assignment.variableName,
                    value
            );

            return Signal.normal();
        }


        /*
         * if p["id"] == id:
         */
        if (
                statement
                        instanceof FlaskPythonIfStatement ifStatement
        ) {

            Object condition =
                    evaluate(
                            ifStatement.condition,
                            env
                    );

            if (condition == UNRESOLVED) {

                return Signal.unresolved(
                        "if condition"
                );
            }

            boolean truthy =
                    isTruthy(condition);

            return executeBlock(
                    truthy
                            ? ifStatement.thenBloc
                            : ifStatement.elseBloc,
                    env
            );
        }


        /*
         * for p in products:
         */
        if (
                statement
                        instanceof FlaskPythonForStatement forStatement
        ) {

            Object iterableValue =
                    evaluate(
                            forStatement.iterable,
                            env
                    );

            if (
                    !(iterableValue
                            instanceof Iterable<?> iterable)
            ) {

                return Signal.unresolved(
                        forStatement.variableName
                                + " iterable"
                );
            }

            for (Object item : iterable) {

                env.put(
                        forStatement.variableName,
                        item
                );

                Signal bodySignal =
                        executeBlock(
                                forStatement.body,
                                env
                        );

                if (
                        bodySignal.kind
                                == SignalKind.BREAK
                ) {
                    break;
                }

                if (
                        bodySignal.kind
                                != SignalKind.NORMAL
                ) {
                    return bodySignal;
                }
            }

            return Signal.normal();
        }


        /*
         * break
         */
        if (
                statement
                        instanceof FlaskPythonBreakStatement
        ) {

            return Signal.breakLoop();
        }


        /*
         * return render_template(...)
         */
        if (
                statement
                        instanceof FlaskPythonReturnStatement returnStatement
        ) {

            if (
                    returnStatement.expression
                            instanceof FlaskPythonFunctionCall functionCall
                            && "render_template".equals(
                            functionCall.functionName
                    )
            ) {

                return extractRender(
                        functionCall,
                        env
                );
            }

            return Signal.normal();
        }

        return Signal.normal();
    }


    private Signal extractRender(
            FlaskPythonFunctionCall functionCall,
            Map<String, Object> env
    ) {

        if (
                functionCall.arguments == null
                        || functionCall.arguments.isEmpty()
        ) {

            return Signal.unresolved(
                    "render_template arguments"
            );
        }

        Object template =
                evaluate(
                        functionCall.arguments
                                .get(0)
                                .value,
                        env
                );

        if (!(template instanceof String templateName)) {

            return Signal.unresolved(
                    "template name"
            );
        }

        Map<String, Object> context =
                new LinkedHashMap<>();

        for (
                int i = 1;
                i < functionCall.arguments.size();
                i++
        ) {

            FlaskPythonArgument argument =
                    functionCall.arguments.get(i);

            if (
                    argument == null
                            || !argument.isKeywordArgument()
            ) {
                continue;
            }

            Object value =
                    evaluate(
                            argument.value,
                            env
                    );

            if (value == UNRESOLVED) {

                return Signal.unresolved(
                        argument.keywordName
                );
            }

            context.put(
                    argument.keywordName,
                    value
            );
        }

        return Signal.render(
                templateName,
                context
        );
    }


    private Object evaluate(
            FlaskPythonExpression expression,
            Map<String, Object> env
    ) {

        if (expression == null) {
            return null;
        }


        if (
                expression
                        instanceof FlaskPythonStringLiteral literal
        ) {
            return literal.value;
        }


        if (
                expression
                        instanceof FlaskPythonIntegerLiteral literal
        ) {
            return literal.value;
        }


        if (
                expression
                        instanceof FlaskPythonBooleanLiteral literal
        ) {
            return literal.value;
        }


        if (
                expression
                        instanceof FlaskPythonIdentifier identifier
        ) {

            if ("None".equals(identifier.name)) {
                return null;
            }

            if (env.containsKey(identifier.name)) {
                return env.get(identifier.name);
            }

            return UNRESOLVED;
        }


        /*
         * p["id"]
         * product.name
         */
        if (
                expression
                        instanceof FlaskPythonMemberAccess memberAccess
        ) {

            Object object =
                    evaluate(
                            memberAccess.object,
                            env
                    );

            if (object == UNRESOLVED) {
                return UNRESOLVED;
            }

            if (object instanceof Map<?, ?> map) {

                return map.get(
                        cleanMemberName(
                                memberAccess.memberName
                        )
                );
            }

            return UNRESOLVED;
        }


        /*
         * p["id"] == id
         */
        if (
                expression
                        instanceof FlaskPythonBinaryExpression binary
        ) {

            Object left =
                    evaluate(
                            binary.left,
                            env
                    );

            Object right =
                    evaluate(
                            binary.right,
                            env
                    );

            if (
                    left == UNRESOLVED
                            || right == UNRESOLVED
            ) {
                return UNRESOLVED;
            }

            return switch (binary.operator) {

                case "==" ->
                        Objects.equals(
                                left,
                                right
                        );

                case "!=" ->
                        !Objects.equals(
                                left,
                                right
                        );

                default ->
                        UNRESOLVED;
            };
        }


        if (
                expression
                        instanceof FlaskPythonListExpression listExpression
        ) {

            List<Object> values =
                    new ArrayList<>();

            if (listExpression.elements != null) {

                for (
                        FlaskPythonExpression item
                        : listExpression.elements
                ) {

                    Object value =
                            evaluate(
                                    item,
                                    env
                            );

                    if (value == UNRESOLVED) {
                        return UNRESOLVED;
                    }

                    values.add(value);
                }
            }

            return values;
        }


        if (
                expression
                        instanceof FlaskPythonDictionaryExpression dictionaryExpression
        ) {

            Map<String, Object> values =
                    new LinkedHashMap<>();

            if (
                    dictionaryExpression.entries != null
            ) {

                for (
                        Map.Entry<
                                FlaskPythonExpression,
                                FlaskPythonExpression
                                > entry
                        : dictionaryExpression.entries.entrySet()
                ) {

                    Object key =
                            evaluate(
                                    entry.getKey(),
                                    env
                            );

                    Object value =
                            evaluate(
                                    entry.getValue(),
                                    env
                            );

                    if (
                            key == UNRESOLVED
                                    || value == UNRESOLVED
                    ) {
                        return UNRESOLVED;
                    }

                    values.put(
                            String.valueOf(key),
                            value
                    );
                }
            }

            return values;
        }

        return UNRESOLVED;
    }


    private boolean isTruthy(Object value) {

        if (value == null) {
            return false;
        }

        if (value instanceof Boolean b) {
            return b;
        }

        if (value instanceof Number n) {
            return n.doubleValue() != 0;
        }

        if (value instanceof String s) {
            return !s.isEmpty();
        }

        if (value instanceof List<?> list) {
            return !list.isEmpty();
        }

        if (value instanceof Map<?, ?> map) {
            return !map.isEmpty();
        }

        return true;
    }


    private String cleanMemberName(
            String memberName
    ) {

        if (memberName == null) {
            return "";
        }

        String value =
                memberName.trim();

        if (
                value.startsWith("[")
                        && value.endsWith("]")
        ) {

            value =
                    value.substring(
                            1,
                            value.length() - 1
                    );
        }

        return value;
    }


    private enum SignalKind {

        NORMAL,
        BREAK,
        RENDER,
        UNRESOLVED
    }


    private static final class Signal {

        private final SignalKind kind;

        private final String templateName;

        private final Map<String, Object> renderContext;

        private final String message;


        private Signal(
                SignalKind kind,
                String templateName,
                Map<String, Object> renderContext,
                String message
        ) {

            this.kind = kind;

            this.templateName = templateName;

            this.renderContext = renderContext;

            this.message = message;
        }


        static Signal normal() {

            return new Signal(
                    SignalKind.NORMAL,
                    null,
                    null,
                    null
            );
        }


        static Signal breakLoop() {

            return new Signal(
                    SignalKind.BREAK,
                    null,
                    null,
                    null
            );
        }


        static Signal render(
                String templateName,
                Map<String, Object> context
        ) {

            return new Signal(
                    SignalKind.RENDER,
                    templateName,
                    context,
                    null
            );
        }


        static Signal unresolved(
                String message
        ) {

            return new Signal(
                    SignalKind.UNRESOLVED,
                    null,
                    null,
                    message
            );
        }
    }


    public static final class ExecutionResult {

        private final boolean success;

        private final String templateName;

        private final Map<String, Object> context;

        private final String error;


        private ExecutionResult(
                boolean success,
                String templateName,
                Map<String, Object> context,
                String error
        ) {

            this.success = success;

            this.templateName = templateName;

            this.context = context;

            this.error = error;
        }


        public static ExecutionResult success(
                String templateName,
                Map<String, Object> context
        ) {

            return new ExecutionResult(
                    true,
                    templateName,
                    context,
                    null
            );
        }


        public static ExecutionResult failure(
                String error
        ) {

            return new ExecutionResult(
                    false,
                    null,
                    new LinkedHashMap<>(),
                    error
            );
        }


        public boolean isSuccess() {
            return success;
        }


        public String getTemplateName() {
            return templateName;
        }


        public Map<String, Object> getContext() {
            return context;
        }


        public String getError() {
            return error;
        }
    }
}