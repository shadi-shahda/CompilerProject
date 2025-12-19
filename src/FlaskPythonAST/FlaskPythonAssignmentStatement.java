package FlaskPythonAST;

import FlaskPythonVisitor.ASTVisitor;

public class FlaskPythonAssignmentStatement extends FlaskPythonStatement{
  public String variableName; // اسم المتغير (الطرف الأيسر)
    public FlaskPythonExpression expression; // القيمة (الطرف الأيمن)

    public FlaskPythonAssignmentStatement(String variableName, FlaskPythonExpression expression, int line) {
        super(line);
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
