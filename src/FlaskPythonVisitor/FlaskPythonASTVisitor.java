package FlaskPythonVisitor; // يفضل وضعهم في package خاص

import FlaskPythonAST.*;

public interface FlaskPythonASTVisitor<T> {

    T visit(FlaskPythonProgram program);
    T visit(FlaskPythonFunctionDeclaration funcDecl);
    T visit(FlaskPythonIfStatement ifStmt);
    T visit(FlaskPythonReturnStatement returnStmt);
    T visit(FlaskPythonAssignmentStatement assignStmt);
    T visit(FlaskPythonImportStatement importStmt);
    T visit(FLaskPythonForStatement forStmt);
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
}