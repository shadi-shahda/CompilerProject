package TemplatesVisitor;

import TemplatesAST.BinaryExpression;
import TemplatesAST.BoolExpression;
import TemplatesAST.DictionaryAccessExpression;
import TemplatesAST.HtmlElement;
import TemplatesAST.HtmlText;
import TemplatesAST.IntExpression;
import TemplatesAST.JinjaForStatement;
import TemplatesAST.JinjaIfStatement;
import TemplatesAST.JinjaPrint;
import TemplatesAST.KeyValueAttribute;
import TemplatesAST.LogicalExpression;
import TemplatesAST.MemberAccessExpression;
import TemplatesAST.NotExpression;
import TemplatesAST.OnlyKeyAttribute;
import TemplatesAST.StringExpression;
import TemplatesAST.TemplatesProgram;
import TemplatesAST.VarExpression;

public interface TemplatesASTVisitor<T> {
  T visit(TemplatesProgram program);
  T visit(HtmlText text);
  T visit(KeyValueAttribute attribute);
  T visit(OnlyKeyAttribute attribute);
  T visit(HtmlElement element);
  T visit(JinjaPrint jinjaPrint);
  T visit(JinjaIfStatement ifStmt);
  T visit(JinjaForStatement forStmt);

  T visit(MemberAccessExpression memberAccessExpr);
  T visit(DictionaryAccessExpression dictionaryAccessExpr);
  T visit(NotExpression notExpr);
  T visit(BinaryExpression binaryExpr);
  T visit(LogicalExpression logicalExpr);
  T visit(VarExpression varExpr);
  T visit(StringExpression StringExpr);
  T visit(IntExpression intExpr);
  T visit(BoolExpression boolExpr);
}
