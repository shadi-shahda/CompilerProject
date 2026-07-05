package FlaskPythonVisitor;

import FlaskPythonAST.*;

public interface FlaskPythonASTVisitor<T> {

    T visit(FlaskPythonProgram program);
    T visit(FlaskPythonFunctionDeclaration funcDecl);
    T visit(FlaskPythonIfStatement ifStmt);
    T visit(FlaskPythonReturnStatement returnStmt);
    T visit(FlaskPythonAssignmentStatement assignStmt);
    T visit(FlaskPythonImportStatement importStmt);
    T visit(FlaskPythonForStatement forStmt);
    T visit(FlaskPythonPrintStatement printStmt);
    
    T visit(FlaskPythonBinaryExpression binExpr);
    T visit(FlaskPythonIdentifier identifier);
    T visit(FlaskPythonStringLiteral stringLit);
    T visit(FlaskPythonIntegerLiteral intLit);
    T visit(FlaskPythonFunctionCall funcCall);
    T visit(FlaskPythonListExpression listExpr);
    T visit(FlaskPythonDictionaryExpression dictExpr);
    T visit(FlaskPythonMemberAccess memberAccess);
    T visit(FlaskPythonMethodCall methCall);
    T visit(FlaskPythonBooleanLiteral booleanLiteral);
    T visit(FlaskPythonExpressionStatement expressionStatement);
    T visit(FlaskPythonGlobalStatement globalStatement);
    T visit(FlaskPythonBreakStatement breakStatement);
    T visit(FlaskPythonListComprehensionExpression expression);
    T visit(FlaskPythonArgument argument);
}