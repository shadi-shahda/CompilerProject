package FlaskPythonGenerator;

import FlaskPythonAST.*;
import FlaskPythonVisitor.FlaskPythonASTVisitor;

import java.util.Objects;

public class FlaskPythonGenerator implements FlaskPythonASTVisitor<String> {

    private int indentLevel = 0;

    private String indent() {
        return "    ".repeat(indentLevel);
    }

    @Override
    public String visit(FlaskPythonProgram program) {
        StringBuilder sb = new StringBuilder();
        for (FlaskPythonStatement statement : program.statements) {
            sb.append(statement.accept(this)).append('\n');
        }
        return sb.toString();
    }

    @Override
    public String visit(FlaskPythonFunctionDeclaration funcDecl) {
        StringBuilder sb = new StringBuilder();
        if (funcDecl.routePath != null) {
            sb.append("@app.route('").append(funcDecl.routePath).append("'");
            if (funcDecl.methods != null && funcDecl.methods.size() > 0) {
                sb.append(", methods=[");
                for (int i = 0; i < funcDecl.methods.size(); i++) {
                    if (i == funcDecl.methods.size() - 1) {
                        sb.append(funcDecl.methods.get(i));
                        break;
                    }
                    sb.append(funcDecl.methods.get(i)).append(", ");
                }
                sb.append("]");
            }
            sb.append(")\n");
        }
        sb.append("def ").append(funcDecl.name).append("(");
        if (funcDecl.parameters != null && funcDecl.parameters.size() > 0) {
            for (int i = 0; i < funcDecl.parameters.size(); i++) {
                if (i == funcDecl.parameters.size() - 1) {
                    sb.append(funcDecl.parameters.get(i));
                    break;
                }
                sb.append(funcDecl.parameters.get(i)).append(", ");
            }
        }
        sb.append("):\n");
        if (funcDecl.body != null && funcDecl.body.size() > 0) {
            indentLevel++;
            for (int i = 0; i < funcDecl.body.size(); i++) {
                sb.append(indent()).append(funcDecl.body.get(i).accept(this)).append('\n');
            }
            indentLevel--;
        }
        return sb.toString();
    }

    @Override
    public String visit(FlaskPythonIfStatement ifStmt) {
        StringBuilder sb = new StringBuilder();
        sb.append("if ").append(ifStmt.condition.accept(this)).append(":\n");
        indentLevel++;
        for (int i = 0; i < ifStmt.thenBloc.size(); i++) {
            sb.append(indent()).append(ifStmt.thenBloc.get(i).accept(this));
            if (i != ifStmt.thenBloc.size() - 1) {
                sb.append('\n');
            }
        }
        indentLevel--;
        if (ifStmt.elseBloc != null && ifStmt.elseBloc.size() > 0) {
            indentLevel++;
            for (int i = 0; i < ifStmt.elseBloc.size(); i++) {
                sb.append(ifStmt.elseBloc.get(i).accept(this));
                if (i != ifStmt.thenBloc.size() - 1) {
                    sb.append('\n');
                }
            }
            indentLevel--;
        }
        return sb.toString();
    }

    @Override
    public String visit(FlaskPythonReturnStatement returnStmt) {
        return "return " + returnStmt.expression.accept(this);
    }

    @Override
    public String visit(FlaskPythonAssignmentStatement assignStmt) {
        return assignStmt.variableName + " = " +
                assignStmt.expression.accept(this);
    }

    @Override
    public String visit(FlaskPythonImportStatement importStmt) {
        StringBuilder sb = new StringBuilder();
        sb.append("from ").append(importStmt.libraryName).append(" import ");
        for (int i = 0; i < importStmt.importedItems.size(); i++) {
            if (i == importStmt.importedItems.size() - 1) {
                sb.append(importStmt.importedItems.get(i));
                break;
            }
            sb.append(importStmt.importedItems.get(i)).append(", ");
        }
        return sb.toString();
    }

    @Override
    public String visit(FlaskPythonForStatement forStmt) {
        StringBuilder sb = new StringBuilder();
        sb.append("for ")
                .append(forStmt.variableName)
                .append(" in ")
                .append(forStmt.iterable.accept(this)).append(":").append("\n");
        indentLevel++;
        for (int i = 0; i < forStmt.body.size(); i++) {
            sb.append(indent()).append(forStmt.body.get(i).accept(this));
            if (i == forStmt.body.size() - 1) {
                sb.append('\n');
            }
        }
        indentLevel--;
        return sb.toString();
    }

    @Override
    public String visit(FlaskPythonPrintStatement printStmt) {
        return "print(" +
                printStmt.expression.accept(this) +
                ")";
    }

    @Override
    public String visit(FlaskPythonBinaryExpression binExpr) {
        return binExpr.left.accept(this) +
                " " + binExpr.operator + " " +
                binExpr.right.accept(this);
    }

    @Override
    public String visit(FlaskPythonIdentifier identifier) {
        return identifier.name;
    }

    @Override
    public String visit(FlaskPythonStringLiteral stringLit) {
        return "\"" + stringLit.value + "\"";
    }

    @Override
    public String visit(FlaskPythonIntegerLiteral intLit) {
        return String.valueOf(intLit.value);
    }

    @Override
    public String visit(FlaskPythonFunctionCall funcCall) {
        StringBuilder sb = new StringBuilder();
        sb.append(funcCall.functionName).append("(");
        for (int i = 0; i < funcCall.arguments.size(); i++) {
            sb.append(funcCall.arguments.get(i).accept(this));
            if (i != funcCall.arguments.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String visit(FlaskPythonListExpression listExpr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        indentLevel++;
        for (FlaskPythonExpression element : listExpr.elements) {
            sb.append(indent()).append(element.accept(this));
            sb.append(",\n");
        }
        indentLevel--;
        sb.append(indent()).append("]");

        return sb.toString();
    }

    @Override
    public String visit(FlaskPythonDictionaryExpression dictExpr) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        indentLevel++;
        for (FlaskPythonExpression key : dictExpr.entries.keySet()) {
            sb.append(indent()).append(key.accept(this))
                    .append(": ")
                    .append(dictExpr.entries.get(key).accept(this))
                    .append(",\n");
        }
        indentLevel--;
        sb.append(indent()).append("}");
        return sb.toString();
    }

    @Override
    public String visit(FlaskPythonMemberAccess memberAccess) {
        if (memberAccess.memberName.charAt(0) == '[') {
            String memberName = "[\"" + memberAccess.memberName.substring(1, memberAccess.memberName.length() - 1) + "\"]";
            return memberAccess.object.accept(this) + memberName;
        }
        return memberAccess.object.accept(this) + "." + memberAccess.memberName;
    }

    @Override
    public String visit(FlaskPythonMethodCall methCall) {
        StringBuilder sb = new StringBuilder();
        sb.append(methCall.object.accept(this))
                .append(".")
                .append(methCall.methodName)
                .append("(");
        for (FlaskPythonArgument flaskPythonArgument : methCall.arguments) {
            if (flaskPythonArgument.keywordName != null && !flaskPythonArgument.keywordName.isEmpty()) {
                sb.append(flaskPythonArgument.keywordName).append("=");
            }
            sb.append(flaskPythonArgument.value.accept(this));
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String visit(FlaskPythonBooleanLiteral booleanLiteral) {
        return booleanLiteral.value ? "True" : "False";
    }

    @Override
    public String visit(FlaskPythonExpressionStatement expressionStatement) {
        return expressionStatement.expression.accept(this);
    }

    @Override
    public String visit(FlaskPythonGlobalStatement globalStatement) {
        StringBuilder sb = new StringBuilder();
        sb.append("global ");
        for (String variable : globalStatement.variableNames) {
            sb.append(variable);
        }
        return sb.toString();
    }

    @Override
    public String visit(FlaskPythonBreakStatement breakStatement) {
        return "break";
    }

    @Override
    public String visit(FlaskPythonListComprehensionExpression expression) {
        {
            StringBuilder sb = new StringBuilder();

            sb.append("[")
                    .append(expression.elementExpression.accept(this))
                    .append(" for ")
                    .append(expression.loopVariable)
                    .append(" in ")
                    .append(expression.iterableExpression.accept(this));

            if (expression.conditionExpression != null) {
                sb.append(" if ")
                        .append(expression.conditionExpression.accept(this));
            }

            sb.append("]");

            return sb.toString();
        }
    }

    @Override
    public String visit(FlaskPythonArgument argument) {
        StringBuilder sb = new StringBuilder();
        if (argument.keywordName != null) sb.append(argument.keywordName);
        if (argument.keywordName != null && argument.value != null) sb.append("=");
        if (argument.value != null) sb.append(argument.value.accept(this));
        return sb.toString();
    }
}
