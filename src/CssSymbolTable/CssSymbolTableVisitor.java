package CssSymbolTable;

import CssAST.*;
import CssVisitor.CssASTVisitor;

public class CssSymbolTableVisitor implements CssASTVisitor<Void> {
  private CssSymbolTable symbolTable;

  public CssSymbolTableVisitor(CssSymbolTable symbolTable) {
    this.symbolTable = symbolTable;
  }

  @Override
  public Void visit(CssProgram program) {
    for (CssASTNode child : program.rules) {
      child.accept(this);
    }
    return null;
  }

  @Override
  public Void visit(CssRule rule) {
    for (CssSelector selector : rule.selectors) {
      selector.accept(this);
    }
    return null;
  }

  @Override
  public Void visit(CssClassSelector classSelector) {
    String name = classSelector.name;
    if (!name.startsWith(".")) {
      name = "." + name;
    }
    symbolTable.defineClass(name);
    return null;
  }

  @Override
  public Void visit(CssIdSelector idSelector) {
    String name = idSelector.name;
    if (!name.startsWith("#")) {
      name = "#" + name;
    }
    symbolTable.defineId(name);
    return null;
  }

  @Override
  public Void visit(CssTagSelector tagSelector) {
    return null;
  }

  @Override
  public Void visit(CssDeclaration declaration) {
    return null;
  }

  @Override
  public Void visit(CssIdentValue identValue) {
    return null;
  }

  @Override
  public Void visit(CssIntValue intVlaue) {
    return null;
  }

  @Override
  public Void visit(CssStringValue stringVlue) {
    return null;
  }

  @Override
  public Void visit(CssPxValue pxValue) {
    return null;
  }

  @Override
  public Void visit(CssPercentValue percentValue) {
    return null;
  }

  @Override
  public Void visit(CssHexValue hexValue) {
    return null;
  }

  @Override
  public Void visit(CssFunction function) {
    return null;
  }

  @Override
  public Void visit(CssFloatValue floatValue) {
    return null;
  }
}