package CssSymbolTable;

import CssAST.*;
import CssVisitor.CssASTVisitor;

public class CssSymbolTableVisitor implements CssASTVisitor<Void> {
  private CssSymbolTable table;

  public CssSymbolTableVisitor(CssSymbolTable table) {
    this.table = table;
  }

  @Override
  public Void visit(CssProgram program) {
    for (CssRule rule : program.rules) {
      rule.accept(this);
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
  public Void visit(CssTagSelector selector) {
    // اسم التاج (div, body)
    table.define(selector.name, "TAG", selector.getLine());
    return null;
  }

  @Override
  public Void visit(CssClassSelector selector) {
    table.define(selector.name, "CLASS", selector.getLine());
    return null;
  }

  @Override
  public Void visit(CssIdSelector selector) {
    table.define(selector.name, "ID", selector.getLine());
    return null;
  }

  @Override
  public Void visit(CssDeclaration d) {
    return null;
  }

  @Override
  public Void visit(CssIdentValue v) {
    return null;
  }

  @Override
  public Void visit(CssStringValue v) {
    return null;
  }

  @Override
  public Void visit(CssIntValue v) {
    return null;
  }

  @Override
  public Void visit(CssPxValue v) {
    return null;
  }

  @Override
  public Void visit(CssPercentValue v) {
    return null;
  }

  @Override
  public Void visit(CssHexValue v) {
    return null;
  }

  @Override
  public Void visit(CssFloatValue v) {
    return null;
  }

  @Override
  public Void visit(CssFunction v) {
    return null;
  }
}