package CompilerPipeline;

import CssAST.CssASTNode;

public class CssStageResult {

    public final CssASTNode astRoot;
    public final String generatedCode;

    public CssStageResult(
            CssASTNode astRoot,
            String generatedCode
    ) {
        this.astRoot = astRoot;
        this.generatedCode = generatedCode;
    }
}
