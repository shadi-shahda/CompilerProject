package CssVisitor;

import CssAST.CssClassSelector;
import CssAST.CssDeclaration;
import CssAST.CssFloatValue;
import CssAST.CssFunction;
import CssAST.CssHexValue;
import CssAST.CssIdSelector;
import CssAST.CssIdentValue;
import CssAST.CssIntValue;
import CssAST.CssPercentValue;
import CssAST.CssProgram;
import CssAST.CssPxValue;
import CssAST.CssRule;
import CssAST.CssStringValue;
import CssAST.CssTagSelector;

public interface CssASTVisitor<T> {

  T visit(CssProgram program);
  T visit(CssRule rule);
  T visit(CssDeclaration declaration);

  T visit(CssTagSelector tagSelector);
  T visit(CssClassSelector classSelector);
  T visit(CssIdSelector idSelector);

  T visit(CssIdentValue identValue);
  T visit(CssIntValue intValue);
  T visit(CssStringValue stringVlue);
  T visit(CssPxValue pxValue);
  T visit(CssPercentValue percentValue);
  T visit(CssHexValue hexValue);
  T visit(CssFunction function);
  T visit(CssFloatValue floatValue);
}
