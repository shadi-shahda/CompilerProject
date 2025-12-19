package FlaskPythonVisitor; // يفضل وضعهم في package خاص

import FlaskPythonAST.FlaskPythonAssignmentStatement;
import FlaskPythonAST.FlaskPythonBinaryExpression;
import FlaskPythonAST.FlaskPythonDictionaryExpression;
import FlaskPythonAST.FlaskPythonFunctionCall;
import FlaskPythonAST.FlaskPythonFunctionDeclaration;
import FlaskPythonAST.FlaskPythonIdentifier;
import FlaskPythonAST.FlaskPythonIfStatement;
import FlaskPythonAST.FlaskPythonImportStatement;
import FlaskPythonAST.FlaskPythonIntegerLiteral;
import FlaskPythonAST.FlaskPythonListExpression;
import FlaskPythonAST.FlaskPythonMemberAccess;
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonAST.FlaskPythonReturnStatement;
import FlaskPythonAST.FlaskPythonStringLiteral;

public interface ASTVisitor<T> {

    T visit(FlaskPythonProgram program);
    T visit(FlaskPythonFunctionDeclaration funcDecl);
    T visit(FlaskPythonIfStatement ifStmt);
    T visit(FlaskPythonReturnStatement returnStmt);
    T visit(FlaskPythonAssignmentStatement assignStmt);
    T visit(FlaskPythonImportStatement importStmt);
    
    T visit(FlaskPythonBinaryExpression binExpr); // للعمليات + - ==
    T visit(FlaskPythonIdentifier identifier);
    T visit(FlaskPythonStringLiteral stringLit);
    T visit(FlaskPythonIntegerLiteral intLit);
    T visit(FlaskPythonFunctionCall funcCall);
    T visit(FlaskPythonListExpression listExpr);
    T visit(FlaskPythonDictionaryExpression dictExpr);
    T visit(FlaskPythonMemberAccess memberAccess); // product.id
}