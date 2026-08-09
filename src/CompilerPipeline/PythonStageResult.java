package CompilerPipeline;

import FinalGeneration.PythonRuntimeContext;
import FlaskPythonAST.FlaskPythonASTNode;
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonSymbolTable.FlaskPythonSymbolTable;

public class PythonStageResult {

    public final FlaskPythonASTNode astRoot;
    public final FlaskPythonProgram program;
    public final FlaskPythonSymbolTable symbolTable;
    public final PythonRuntimeContext runtimeContext;
    public final String generatedCode;

    public PythonStageResult(
            FlaskPythonASTNode astRoot,
            FlaskPythonProgram program,
            FlaskPythonSymbolTable symbolTable,
            PythonRuntimeContext runtimeContext,
            String generatedCode
    ) {
        this.astRoot = astRoot;
        this.program = program;
        this.symbolTable = symbolTable;
        this.runtimeContext = runtimeContext;
        this.generatedCode = generatedCode;
    }
}
