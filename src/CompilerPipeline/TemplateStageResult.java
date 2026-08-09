package CompilerPipeline;

import TemplatesAST.TemplatesASTNode;
import TemplatesAST.TemplatesProgram;
import TemplatesSymbolTable.TemplatesSymbolTable;

public class TemplateStageResult {

    public final String sourcePath;
    public final String outputPath;
    public final String templateFileName;

    public final TemplatesASTNode astRoot;
    public final TemplatesProgram program;
    public final TemplatesSymbolTable symbolTable;
    public final String generatedCode;

    public TemplateStageResult(
            String sourcePath,
            String outputPath,
            String templateFileName,
            TemplatesASTNode astRoot,
            TemplatesProgram program,
            TemplatesSymbolTable symbolTable,
            String generatedCode
    ) {
        this.sourcePath = sourcePath;
        this.outputPath = outputPath;
        this.templateFileName = templateFileName;
        this.astRoot = astRoot;
        this.program = program;
        this.symbolTable = symbolTable;
        this.generatedCode = generatedCode;
    }
}
