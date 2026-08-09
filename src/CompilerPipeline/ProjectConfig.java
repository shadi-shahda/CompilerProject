package CompilerPipeline;

public class ProjectConfig {


    public final String pythonSourceFile;
    public final String cssSourceFile;

    public final String indexTemplateSourceFile;
    public final String addTemplateSourceFile;
    public final String detailTemplateSourceFile;

    public final String pythonGeneratedOutputPath;
    public final String cssGeneratedOutputPath;

    public final String indexTemplateGeneratedOutputPath;
    public final String addTemplateGeneratedOutputPath;
    public final String detailTemplateGeneratedOutputPath;

    public final String indexFinalOutputPath;
    public final String addFinalOutputPath;

    private ProjectConfig(
            String pythonSourceFile,
            String cssSourceFile,
            String indexTemplateSourceFile,
            String addTemplateSourceFile,
            String detailTemplateSourceFile,
            String pythonGeneratedOutputPath,
            String cssGeneratedOutputPath,
            String indexTemplateGeneratedOutputPath,
            String addTemplateGeneratedOutputPath,
            String detailTemplateGeneratedOutputPath,
            String indexFinalOutputPath,
            String addFinalOutputPath
    ) {
        this.pythonSourceFile = pythonSourceFile;
        this.cssSourceFile = cssSourceFile;

        this.indexTemplateSourceFile = indexTemplateSourceFile;
        this.addTemplateSourceFile = addTemplateSourceFile;
        this.detailTemplateSourceFile = detailTemplateSourceFile;

        this.pythonGeneratedOutputPath = pythonGeneratedOutputPath;
        this.cssGeneratedOutputPath = cssGeneratedOutputPath;

        this.indexTemplateGeneratedOutputPath = indexTemplateGeneratedOutputPath;
        this.addTemplateGeneratedOutputPath = addTemplateGeneratedOutputPath;
        this.detailTemplateGeneratedOutputPath = detailTemplateGeneratedOutputPath;

        this.indexFinalOutputPath = indexFinalOutputPath;
        this.addFinalOutputPath = addFinalOutputPath;
    }

    public static ProjectConfig defaultConfig() {
        return new ProjectConfig(
                "input_files/app.py",
                "input_files/static/style.css",

                "input_files/templates/index.html",
                "input_files/templates/add.html",
                "input_files/templates/detail.html",

                "generated_output/app.py",
                "generated_output/static/style.css",

                "generated_output/templates/index.html",
                "generated_output/templates/add.html",
                "generated_output/templates/detail.html",

                "output/index.html",
                "output/add.html"
        );
    }

}
