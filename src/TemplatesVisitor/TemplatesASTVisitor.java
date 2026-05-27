package TemplatesVisitor;

import TemplatesAST.*;

public interface TemplatesASTVisitor<T> {
  T visit(TemplatesProgram program);
  T visit(HtmlText text);
  T visit(KeyValueAttribute attribute);
  T visit(OnlyKeyAttribute attribute);
  T visit(HtmlElement element);
  T visit(JinjaPrint jinjaPrint);
  T visit(JinjaSet jinjaSet);
  T visit(JinjaIfStatement ifStmt);
  T visit(JinjaForStatement forStmt);

  T visit(MemberAccessExpression memberAccessExpr);
  T visit(DictionaryAccessExpression dictionaryAccessExpr);
  T visit(MathExpression mathExpr);
  T visit(NotExpression notExpr);
  T visit(BinaryExpression binaryExpr);
  T visit(LogicalExpression logicalExpr);
  T visit(VarExpression varExpr);
  T visit(StringExpression StringExpr);
  T visit(IntExpression intExpr);
  T visit(BoolExpression boolExpr);
  T visit(AttributeValue value);
  T visit(AttributeTextPart textPart);
  T visit(AttributeExpressionPart expressionPart);
}
