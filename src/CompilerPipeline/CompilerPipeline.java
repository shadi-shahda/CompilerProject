package CompilerPipeline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import CompilerOutput.AstJsonWriter;
import CompilerOutput.GenerationLogWriter;
import CompilerOutput.SemanticReportWriter;
import CompilerOutput.SupportFilesCopier;

import CssAST.CssASTNode;
import CssGenerator.CssGenerator;
import CssGenerator.GeneratedCssWriter;
import CssSymbolTable.CssSymbolTable;
import CssSymbolTable.CssSymbolTableVisitor;
import CssVisitor.AntlrToCssASTVisitor;

import FinalGeneration.FinalOutputWriter;
import FinalGeneration.JinjaHtmlRenderer;
import FinalGeneration.PythonContextExtractor;
import FinalGeneration.PythonRenderTemplateAnalyzer;
import FinalGeneration.PythonRuntimeContext;
import FinalGeneration.RenderContextResolver;
import FinalGeneration.RenderTemplateBinding;

import FlaskPythonAST.FlaskPythonASTNode;
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonGenerator.FlaskPythonGenerator;
import FlaskPythonGenerator.GeneratedPythonWriter;
import FlaskPythonSymbolTable.FlaskPythonSymbolTable;
import FlaskPythonSymbolTable.FlaskPythonSymbolTableVisitor;
import FlaskPythonVisitor.AntlrToPythonASTVisitor;

import Printers.CssASTPrinter;
import Printers.FlaskPythonASTPrinter;
import Printers.TemplatesASTPrinter;

import TemplatesAST.TemplatesASTNode;
import TemplatesAST.TemplatesProgram;
import TemplatesGenerator.GeneratedTemplateWriter;
import TemplatesGenerator.TemplatesGenerator;
import TemplatesSymbolTable.TemplatesSymbolTable;
import TemplatesSymbolTable.TemplatesSymbolTableVisitor;
import TemplatesVisitor.AntlrToTemplatesVisitor;

import generated.CssLexer;
import generated.CssParser;
import generated.FlaskPythonLexer;
import generated.FlaskPythonParser;
import generated.TemplatesLexer;
import generated.TemplatesParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.File;

public class CompilerPipeline {

    private final ProjectConfig config;

    public CompilerPipeline(ProjectConfig config) {
        this.config = config;
    }

    public void run() {
        try {

            // =========================================================
            // Python Stage
            // =========================================================

            PythonStageResult pythonResult = processPython(
                    config.pythonSourceFile,
                    config.pythonGeneratedOutputPath,
                    "index.html",
                    "add.html",
                    "detail.html"
            );

            if (pythonResult == null) {
                System.out.println(
                        "Python stage failed. Compiler stopped."
                );
                return;
            }


            // =========================================================
            // Templates Stage
            // =========================================================

            TemplateStageResult indexResult = processTemplate(
                    config.indexTemplateSourceFile,
                    config.indexTemplateGeneratedOutputPath,
                    pythonResult
            );

            TemplateStageResult detailResult = processTemplate(
                    config.detailTemplateSourceFile,
                    config.detailTemplateGeneratedOutputPath,
                    pythonResult
            );

            TemplateStageResult addResult = processTemplate(
                    config.addTemplateSourceFile,
                    config.addTemplateGeneratedOutputPath,
                    pythonResult
            );

            if (
                    indexResult == null
                            || detailResult == null
                            || addResult == null
            ) {
                System.out.println(
                        "Template stage failed. Compiler stopped."
                );
                return;
            }


            // =========================================================
            // Jinja AST JSON Output
            // =========================================================

            Map<String, Object> jinjaAsts =
                    new LinkedHashMap<>();

            jinjaAsts.put(
                    indexResult.templateFileName,
                    indexResult.astRoot
            );

            jinjaAsts.put(
                    detailResult.templateFileName,
                    detailResult.astRoot
            );

            jinjaAsts.put(
                    addResult.templateFileName,
                    addResult.astRoot
            );

            AstJsonWriter jinjaAstWriter =
                    new AstJsonWriter();

            jinjaAstWriter.write(
                    jinjaAsts,
                    "compiler_output/ast_jinja.json"
            );


            // =========================================================
            // CSS Stage
            // =========================================================

            CssStageResult cssResult = processCss(
                    config.cssSourceFile,
                    config.cssGeneratedOutputPath
            );

            if (cssResult == null) {
                System.out.println(
                        "CSS stage failed. Compiler stopped."
                );
                return;
            }

            CssSymbolTable.instance.performCrossCheck();


            // =========================================================
            // Semantic Report
            // =========================================================

            SemanticReportWriter semanticReportWriter =
                    new SemanticReportWriter();

            semanticReportWriter.write(
                    pythonResult.symbolTable,
                    indexResult.symbolTable,
                    detailResult.symbolTable,
                    addResult.symbolTable,
                    "compiler_output/semantic_report.txt"
            );


            // =========================================================
            // Generation Log
            // =========================================================

            GenerationLogWriter generationLogWriter =
                    new GenerationLogWriter();

            generationLogWriter.add(
                    "Python source regenerated: "
                            + config.pythonGeneratedOutputPath
            );

            generationLogWriter.add(
                    "Template regenerated: "
                            + config.indexTemplateGeneratedOutputPath
            );

            generationLogWriter.add(
                    "Template regenerated: "
                            + config.detailTemplateGeneratedOutputPath
            );

            generationLogWriter.add(
                    "Template regenerated: "
                            + config.addTemplateGeneratedOutputPath
            );

            generationLogWriter.add(
                    "CSS regenerated: "
                            + config.cssGeneratedOutputPath
            );


            // =========================================================
            // Final HTML Rendering
            // =========================================================

            List<String> generatedHtmlFiles =
                    renderFinalOutputs(
                            pythonResult,
                            indexResult,
                            detailResult,
                            addResult
                    );

            for (String generatedFile : generatedHtmlFiles) {

                generationLogWriter.add(
                        "Final HTML generated: "
                                + generatedFile
                );
            }


            // =========================================================
            // Copy Support Files
            // =========================================================

            SupportFilesCopier supportFilesCopier =
                    new SupportFilesCopier();

            supportFilesCopier.copy(
                    config.pythonSourceFile,
                    "output/app.py"
            );

            supportFilesCopier.copy(
                    config.cssSourceFile,
                    "output/static/style.css"
            );

            generationLogWriter.add(
                    "Support file copied: output/app.py"
            );

            generationLogWriter.add(
                    "Support file copied: output/static/style.css"
            );


            // =========================================================
            // Write Generation Log
            // =========================================================

            generationLogWriter.write(
                    "compiler_output/generation_log.txt"
            );


            // =========================================================
            // Finished
            // =========================================================

            System.out.println(
                    "\n================ Compiler Pipeline Finished Successfully ================\n"
            );

            System.out.println(
                    "Source regeneration output: generated_output/"
            );

            System.out.println(
                    "Final rendered HTML output: output/"
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // =====================================================================
    // Python Stage
    // =====================================================================

    private PythonStageResult processPython(
            String pythonSourceFile,
            String outputPath,
            String... availableTemplates
    ) throws IOException {

        System.out.println(
                "\n================ Flask & Python ================\n"
        );

        System.out.println(
                ">>> 1. Reading Python File: "
                        + pythonSourceFile
        );

        CharStream pythonInput =
                CharStreams.fromFileName(
                        pythonSourceFile
                );

        FlaskPythonLexer lexer =
                new FlaskPythonLexer(
                        pythonInput
                );

        CommonTokenStream tokens =
                new CommonTokenStream(
                        lexer
                );

        System.out.println(
                ">>> 2. Parsing..."
        );

        FlaskPythonParser parser =
                new FlaskPythonParser(
                        tokens
                );

        ParseTree tree =
                parser.program();

        if (
                parser.getNumberOfSyntaxErrors() > 0
        ) {
            System.out.println(
                    "Found Python syntax errors. Stopping."
            );
            return null;
        }

        System.out.println(
                ">>> 3. Building AST..."
        );

        AntlrToPythonASTVisitor astBuilder =
                new AntlrToPythonASTVisitor();

        FlaskPythonASTNode astRoot =
                astBuilder.visit(
                        tree
                );

        if (
                !(astRoot instanceof FlaskPythonProgram pythonProgram)
        ) {
            System.out.println(
                    "Python AST root is not FlaskPythonProgram. Stopping."
            );
            return null;
        }


        // =========================================================
        // AST
        // =========================================================

        System.out.println(
                "================ AST ================"
        );

        FlaskPythonASTPrinter printer =
                new FlaskPythonASTPrinter();

        String astOutput =
                astRoot.accept(
                        printer
                );

        System.out.println(
                astOutput
        );


        // =========================================================
        // Python AST JSON
        // =========================================================

        AstJsonWriter astJsonWriter =
                new AstJsonWriter();

        astJsonWriter.write(
                astRoot,
                "compiler_output/ast_python.json"
        );


        // =========================================================
        // Symbol Table
        // =========================================================

        System.out.println(
                ">>> 4. Building Symbol Table..."
        );

        FlaskPythonSymbolTable symbolTable =
                new FlaskPythonSymbolTable();

        if (
                availableTemplates != null
        ) {

            for (
                    String template
                    : availableTemplates
            ) {

                System.out.println(
                        "   -> Injecting Available Template: "
                                + template
                );

                symbolTable.addAvailableTemplate(
                        template
                );
            }
        }

        FlaskPythonSymbolTableVisitor symbolVisitor =
                new FlaskPythonSymbolTableVisitor(
                        symbolTable
                );

        astRoot.accept(
                symbolVisitor
        );


        System.out.println(
                "\n================ Symbol Table ================\n"
        );

        symbolTable.printTable();


        // =========================================================
        // Runtime Context
        // =========================================================

        System.out.println(
                "\n================ Runtime Context ================\n"
        );

        PythonContextExtractor extractor =
                new PythonContextExtractor();

        PythonRuntimeContext runtimeContext =
                extractor.extract(
                        pythonProgram
                );

        System.out.println(
                runtimeContext
        );


        // =========================================================
        // render_template Analysis
        // =========================================================

        System.out.println(
                "\n================ render_template Bindings ================\n"
        );

        PythonRenderTemplateAnalyzer renderTemplateAnalyzer =
                new PythonRenderTemplateAnalyzer();

        var renderTemplateBindings =
                renderTemplateAnalyzer.analyze(
                        pythonProgram
                );

        for (
                RenderTemplateBinding binding
                : renderTemplateBindings
        ) {
            System.out.println(
                    binding
            );
        }


        // =========================================================
        // Python Source Regeneration
        // =========================================================

        System.out.println(
                "\n================ Source Regeneration: Python ================\n"
        );

        FlaskPythonGenerator flaskPythonGenerator =
                new FlaskPythonGenerator();

        String generatedPython =
                astRoot.accept(
                        flaskPythonGenerator
                );

        System.out.println(
                generatedPython
        );

        GeneratedPythonWriter writer =
                new GeneratedPythonWriter();

        writer.writeToFile(
                generatedPython,
                outputPath
        );


        return new PythonStageResult(
                astRoot,
                pythonProgram,
                symbolTable,
                runtimeContext,
                generatedPython,
                renderTemplateBindings
        );
    }


    // =====================================================================
    // Template Stage
    // =====================================================================

    private TemplateStageResult processTemplate(
            String htmlSourceFile,
            String outputPath,
            PythonStageResult pythonResult,
            String... contextVars
    ) throws IOException {

        System.out.println(
                "\n================ Jinja2 & HTML ================\n"
        );

        System.out.println(
                ">>> 1. Reading Html File: "
                        + htmlSourceFile
        );

        CharStream htmlInput =
                CharStreams.fromFileName(
                        htmlSourceFile
                );

        TemplatesLexer lexer =
                new TemplatesLexer(
                        htmlInput
                );

        CommonTokenStream tokens =
                new CommonTokenStream(
                        lexer
                );

        System.out.println(
                ">>> 2. Parsing..."
        );

        TemplatesParser parser =
                new TemplatesParser(
                        tokens
                );

        ParseTree tree =
                parser.template();

        if (
                parser.getNumberOfSyntaxErrors() > 0
        ) {
            System.out.println(
                    "Found template syntax errors. Stopping."
            );
            return null;
        }

        System.out.println(
                ">>> 3. Building AST..."
        );

        AntlrToTemplatesVisitor astBuilder =
                new AntlrToTemplatesVisitor();

        TemplatesASTNode astRoot =
                astBuilder.visit(
                        tree
                );

        if (
                !(astRoot instanceof TemplatesProgram templatesProgram)
        ) {
            System.out.println(
                    "Template AST root is not TemplatesProgram. Stopping."
            );
            return null;
        }


        // =========================================================
        // AST
        // =========================================================

        System.out.println(
                "\n================ AST ================\n"
        );

        System.out.println(
                "=== Abstract Syntax Tree (AST) ==="
        );

        TemplatesASTPrinter printer =
                new TemplatesASTPrinter();

        String astOutput =
                astRoot.accept(
                        printer
                );

        System.out.println(
                astOutput
        );


        // =========================================================
        // Template Symbol Table
        // =========================================================

        System.out.println(
                ">>> 4. Building Templates Symbol Table..."
        );

        String templateFileName =
                extractFileName(
                        htmlSourceFile
                );

        TemplatesSymbolTable symbolTable =
                new TemplatesSymbolTable(
                        pythonResult.symbolTable,
                        templateFileName
                );


        // =========================================================
        // Automatic Context Injection from render_template
        // =========================================================

        for (
                RenderTemplateBinding binding
                : pythonResult.renderTemplateBindings
        ) {

            if (
                    !templateFileName.equals(
                            binding.getTemplateName()
                    )
            ) {
                continue;
            }

            for (
                    String var
                    : binding
                    .getContextExpressions()
                    .keySet()
            ) {

                System.out.println(
                        "   -> Injecting Context Variable: "
                                + var
                );

                symbolTable.defineContextVariable(
                        var,
                        var.toUpperCase()
                );
            }
        }


        // =========================================================
        // Optional Manual Context
        // =========================================================

        if (
                contextVars != null
        ) {

            for (
                    String var
                    : contextVars
            ) {

                System.out.println(
                        "   -> Injecting Context Variable: "
                                + var
                );

                symbolTable.defineContextVariable(
                        var,
                        var.toUpperCase()
                );
            }
        }


        TemplatesSymbolTableVisitor symbolVisitor =
                new TemplatesSymbolTableVisitor(
                        symbolTable
                );

        astRoot.accept(
                symbolVisitor
        );


        // =========================================================
        // CSS Linking Information
        // =========================================================

        CssSymbolTable.instance.setUsedHtmlSelectors(
                symbolVisitor
                        .getSymbolTable()
                        .getUsedClasses(),
                symbolVisitor
                        .getSymbolTable()
                        .getUsedIds(),
                symbolVisitor
                        .getSymbolTable()
                        .getUsedSelectors()
        );


        System.out.println(
                "\n================ Symbol Table ================\n"
        );

        symbolTable.printTable();


        // =========================================================
        // Template Source Regeneration
        // =========================================================

        System.out.println(
                "\n================ Source Regeneration: Template ================\n"
        );

        TemplatesGenerator generator =
                new TemplatesGenerator();

        String generatedTemplate =
                astRoot.accept(
                        generator
                );

        System.out.println(
                generatedTemplate
        );

        GeneratedTemplateWriter writer =
                new GeneratedTemplateWriter();

        writer.writeToFile(
                generatedTemplate,
                outputPath
        );


        return new TemplateStageResult(
                htmlSourceFile,
                outputPath,
                templateFileName,
                astRoot,
                templatesProgram,
                symbolTable,
                generatedTemplate
        );
    }


    // =====================================================================
    // CSS Stage
    // =====================================================================

    private CssStageResult processCss(
            String cssSourceFile,
            String outputPath
    ) throws IOException {

        System.out.println(
                "\n================ CSS ================\n"
        );

        System.out.println(
                ">>> 1. Reading Css File: "
                        + cssSourceFile
        );

        CharStream cssInput =
                CharStreams.fromFileName(
                        cssSourceFile
                );

        CssLexer lexer =
                new CssLexer(
                        cssInput
                );

        CommonTokenStream tokens =
                new CommonTokenStream(
                        lexer
                );

        System.out.println(
                ">>> 2. Parsing..."
        );

        CssParser parser =
                new CssParser(
                        tokens
                );

        ParseTree tree =
                parser.stylesheet();

        if (
                parser.getNumberOfSyntaxErrors() > 0
        ) {
            System.out.println(
                    "Found CSS syntax errors. Stopping."
            );
            return null;
        }

        System.out.println(
                ">>> 3. Building AST..."
        );

        AntlrToCssASTVisitor astBuilder =
                new AntlrToCssASTVisitor();

        CssASTNode astRoot =
                astBuilder.visit(
                        tree
                );


        // =========================================================
        // AST
        // =========================================================

        System.out.println(
                "================ AST ================"
        );

        CssASTPrinter printer =
                new CssASTPrinter();

        String astOutput =
                astRoot.accept(
                        printer
                );

        System.out.println(
                astOutput
        );


        // =========================================================
        // CSS Symbol Table
        // =========================================================

        System.out.println(
                ">>> 4. Building Css Symbol Table..."
        );

        CssSymbolTableVisitor symbolVisitor =
                new CssSymbolTableVisitor();

        astRoot.accept(
                symbolVisitor
        );

        System.out.println(
                "\n================ Symbol Table ================\n"
        );

        CssSymbolTable.instance.printTable();


        // =========================================================
        // CSS Source Regeneration
        // =========================================================

        System.out.println(
                "\n================ Source Regeneration: CSS ================\n"
        );

        CssGenerator cssGenerator =
                new CssGenerator();

        String generatedCss =
                astRoot.accept(
                        cssGenerator
                );

        System.out.println(
                generatedCss
        );

        GeneratedCssWriter writer =
                new GeneratedCssWriter();

        writer.writeToFile(
                generatedCss,
                outputPath
        );


        return new CssStageResult(
                astRoot,
                generatedCss
        );
    }


    // =====================================================================
    // Final HTML Rendering
    // =====================================================================

    private List<String> renderFinalOutputs(
            PythonStageResult pythonResult,
            TemplateStageResult indexResult,
            TemplateStageResult detailResult,
            TemplateStageResult addResult
    ) {

        List<String> generatedFiles =
                new ArrayList<>();

        if (pythonResult.runtimeContext == null) {

            System.out.println(
                    "Runtime context is null. Skipping final HTML rendering."
            );

            return generatedFiles;
        }

        System.out.println(
                "\n================ Final HTML Rendering ================\n"
        );


        // =========================================================
        // Index Page
        // =========================================================

        if (
                renderTemplateIfResolvable(
                        pythonResult,
                        indexResult,
                        config.indexFinalOutputPath
                )
        ) {

            generatedFiles.add(
                    config.indexFinalOutputPath
            );
        }


        // =========================================================
        // Dynamic Detail Pages
        // =========================================================
        cleanOldDetailPages();
        generatedFiles.addAll(
                renderDetailPages(
                        pythonResult,
                        detailResult
                )
        );


        // =========================================================
        // Add Page
        // =========================================================

        if (
                renderTemplateIfResolvable(
                        pythonResult,
                        addResult,
                        config.addFinalOutputPath
                )
        ) {

            generatedFiles.add(
                    config.addFinalOutputPath
            );
        }


        return generatedFiles;
    }



    private void cleanOldDetailPages() {

        File outputDirectory =
                new File("output");

        if (!outputDirectory.exists()) {
            return;
        }

        File[] oldDetailFiles =
                outputDirectory.listFiles(
                        (dir, name) ->
                                name.startsWith("detail_")
                                        && name.endsWith(".html")
                );

        if (oldDetailFiles == null) {
            return;
        }

        for (File file : oldDetailFiles) {

            if (file.delete()) {

                System.out.println(
                        "Old generated detail page deleted: "
                                + file.getPath()
                );

            } else {

                System.out.println(
                        "Could not delete old detail page: "
                                + file.getPath()
                );
            }
        }
    }

    // =====================================================================
    // Render Dynamic Detail Pages
    // =====================================================================

    private List<String> renderDetailPages(
            PythonStageResult pythonResult,
            TemplateStageResult detailResult
    ) {

        List<String> generatedFiles =
                new ArrayList<>();

        Object productsObject =
                pythonResult.runtimeContext.get(
                        "products"
                );

        if (
                !(productsObject instanceof Iterable<?> products)
        ) {

            System.out.println(
                    "Cannot generate detail pages: products is not iterable."
            );

            return generatedFiles;
        }

        RenderTemplateBinding binding =
                findBindingForTemplate(
                        pythonResult,
                        detailResult.templateFileName
                );

        if (binding == null) {

            System.out.println(
                    "No render_template binding found for detail.html."
            );

            return generatedFiles;
        }

        for (
                Object productObject
                : products
        ) {

            if (
                    !(productObject instanceof Map<?, ?> product)
            ) {
                continue;
            }

            Object idValue =
                    product.get(
                            "id"
                    );

            if (idValue == null) {

                System.out.println(
                        "Skipping product without id."
                );

                continue;
            }


            // =========================================================
            // Route Parameters
            // =========================================================

            Map<String, Object> parameters =
                    new LinkedHashMap<>();

            parameters.put(
                    "id",
                    idValue
            );

            String outputPath =
                    "output/detail_"
                            + idValue
                            + ".html";


            // =========================================================
            // Add Successfully Generated File to Log Result
            // =========================================================

            generatedFiles.add(
                    outputPath
            );
        }


        return generatedFiles;
    }


    // =====================================================================
    // Render One Template
    // =====================================================================

    private boolean renderTemplateIfResolvable(
            PythonStageResult pythonResult,
            TemplateStageResult templateResult,
            String finalOutputPath
    ) {

        RenderTemplateBinding binding =
                findBindingForTemplate(
                        pythonResult,
                        templateResult.templateFileName
                );

        if (binding == null) {

            System.out.println(
                    "No render_template binding found for "
                            + templateResult.templateFileName
                            + ". Skipping final rendering."
            );

            return false;
        }


        RenderContextResolver resolver =
                new RenderContextResolver();

        RenderContextResolver.Resolution resolution =
                resolver.resolve(
                        binding,
                        pythonResult.runtimeContext
                );


        // =========================================================
        // Check Context
        // =========================================================

        if (
                !resolution.isFullyResolved()
        ) {

            System.out.println(
                    "Cannot render "
                            + templateResult.templateFileName
                            + ". Unresolved Python context: "
                            + resolution.getUnresolvedVariables()
            );

            return false;
        }


        // =========================================================
        // Render Template
        // =========================================================

        JinjaHtmlRenderer renderer =
                new JinjaHtmlRenderer(
                        resolution.getContext()
                );

        String html =
                templateResult.program.accept(
                        renderer
                );


        // =========================================================
        // Write Final HTML
        // =========================================================

        FinalOutputWriter writer =
                new FinalOutputWriter();

        writer.write(
                finalOutputPath,
                html
        );

        return true;
    }


    // =====================================================================
    // Find render_template Binding
    // =====================================================================

    private RenderTemplateBinding findBindingForTemplate(
            PythonStageResult pythonResult,
            String templateFileName
    ) {

        if (
                pythonResult.renderTemplateBindings == null
        ) {
            return null;
        }

        for (
                RenderTemplateBinding binding
                : pythonResult.renderTemplateBindings
        ) {

            if (
                    templateFileName.equals(
                            binding.getTemplateName()
                    )
            ) {
                return binding;
            }
        }

        return null;
    }


    // =====================================================================
    // Utility
    // =====================================================================

    private String extractFileName(
            String path
    ) {

        String normalized =
                path.replace(
                        "\\",
                        "/"
                );

        int index =
                normalized.lastIndexOf(
                        "/"
                );

        if (
                index == -1
        ) {
            return normalized;
        }

        return normalized.substring(
                index + 1
        );
    }
}