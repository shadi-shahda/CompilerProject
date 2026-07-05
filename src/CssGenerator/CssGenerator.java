package CssGenerator;

import CssAST.*;
import CssVisitor.CssASTVisitor;

public class CssGenerator implements CssASTVisitor<String> {
    private int indentLevel = 0;

    private String indent() {
        return "    ".repeat(indentLevel);
    }

    @Override
    public String visit(CssProgram program) {
        StringBuilder sb = new StringBuilder();
        if (program.rules != null && program.rules.size() > 0) {
            for (CssRule rule : program.rules) {
                sb.append(rule.accept(this)).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String visit(CssRule rule) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rule.selectors.size(); i++) {
            if (i == rule.selectors.size() - 1) {
                sb.append(rule.selectors.get(i).accept(this)).append(" {\n");
                break;
            }
            sb.append(rule.selectors.get(i).accept(this)).append("\n");
        }
        indentLevel++;
        for (int i = 0; i < rule.declarations.size(); i++) {

            if (i == rule.declarations.size() - 1) {
                sb.append(indent()).append(rule.declarations.get(i).accept(this)).append("\n");
                break;
            }
            sb.append(indent()).append(rule.declarations.get(i).accept(this)).append(";\n");
        }
        indentLevel--;
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public String visit(CssDeclaration declaration) {
        StringBuilder sb = new StringBuilder();
        sb.append(declaration.property).append(": ");
        for (int i = 0; i < declaration.valueTerms.size(); i++) {
            if (i == declaration.valueTerms.size() - 1) {
                sb.append(declaration.valueTerms.get(i).accept(this));
                break;
            }
            sb.append(declaration.valueTerms.get(i).accept(this)).append(", ");
        }
        return sb.toString();
    }

    @Override
    public String visit(CssTagSelector tagSelector) {
        return tagSelector.name;
    }

    @Override
    public String visit(CssClassSelector classSelector) {
        return classSelector.name;
    }

    @Override
    public String visit(CssIdSelector idSelector) {
        return idSelector.name;
    }

    @Override
    public String visit(CssIdentValue identValue) {
        return identValue.value;
    }

    @Override
    public String visit(CssIntValue intValue) {
        return String.valueOf(intValue.value);
    }

    @Override
    public String visit(CssStringValue stringVlue) {
        return "\"" + stringVlue.value + "\"";
    }

    @Override
    public String visit(CssPxValue pxValue) {
        return pxValue.value;
    }

    @Override
    public String visit(CssPercentValue percentValue) {
        return percentValue.value;
    }

    @Override
    public String visit(CssHexValue hexValue) {
        return hexValue.value;
    }

    @Override
    public String visit(CssFunction function) {
        StringBuilder sb = new StringBuilder();
        sb.append(function.functionName).append("(");
        for (int i = 0; i < function.arguments.size(); i++) {
            if (i == function.arguments.size() - 1) {
                sb.append(function.arguments.get(i).accept(this)).append(")");
                break;
            }
            sb.append(function.arguments.get(i).accept(this)).append(", ");
        }
        return sb.toString();
    }

    @Override
    public String visit(CssFloatValue floatValue) {
        return floatValue.value;
    }
}
