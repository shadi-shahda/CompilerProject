package CompilerPipeline;

import FinalGeneration.PythonRuntimeContext;
import FinalGeneration.RenderTemplateBinding;

import java.util.List;

import FlaskPythonAST.FlaskPythonASTNode;
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonSymbolTable.FlaskPythonSymbolTable;

public class PythonStageResult {

    public final FlaskPythonASTNode astRoot;

    public final FlaskPythonProgram program;

    public final FlaskPythonSymbolTable symbolTable;

    public final PythonRuntimeContext runtimeContext;

    public final String generatedCode;

    public final List<RenderTemplateBinding> renderTemplateBindings;

    public PythonStageResult(
            FlaskPythonASTNode astRoot,
            FlaskPythonProgram program,
            FlaskPythonSymbolTable symbolTable,
            PythonRuntimeContext runtimeContext,
            String generatedCode,
            List<RenderTemplateBinding> renderTemplateBindings
    ) {

        this.astRoot = astRoot;

        this.program = program;

        this.symbolTable = symbolTable;

        this.runtimeContext = runtimeContext;

        this.generatedCode = generatedCode;

        this.renderTemplateBindings = renderTemplateBindings;
    }
}