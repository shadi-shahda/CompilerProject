package CompilerPipeline;

import java.io.IOException;

import CssGenerator.CssGenerator;
import CssGenerator.GeneratedCssWriter;
import FinalGeneration.FinalOutputWriter;
import FinalGeneration.JinjaHtmlRenderer;
import FinalGeneration.PythonContextExtractor;
import FinalGeneration.PythonRuntimeContext;
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonGenerator.FlaskPythonGenerator;
import FlaskPythonGenerator.GeneratedPythonWriter;
import Printers.CssASTPrinter;
import Printers.FlaskPythonASTPrinter;
import Printers.TemplatesASTPrinter;
import TemplatesAST.TemplatesProgram;
import TemplatesGenerator.TemplatesGenerator;
import TemplatesGenerator.GeneratedTemplateWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import CssAST.CssASTNode;
import CssSymbolTable.CssSymbolTable;
import CssSymbolTable.CssSymbolTableVisitor;
import CssVisitor.AntlrToCssASTVisitor;
import FlaskPythonAST.FlaskPythonASTNode;
import FlaskPythonSymbolTable.FlaskPythonSymbolTable;
import FlaskPythonSymbolTable.FlaskPythonSymbolTableVisitor;
import FlaskPythonVisitor.AntlrToPythonASTVisitor;
import TemplatesAST.TemplatesASTNode;
import TemplatesSymbolTable.TemplatesSymbolTable;
import TemplatesSymbolTable.TemplatesSymbolTableVisitor;
import TemplatesVisitor.AntlrToTemplatesVisitor;
import generated.CssLexer;
import generated.CssParser;
import generated.FlaskPythonLexer;
import generated.FlaskPythonParser;
import generated.TemplatesLexer;
import generated.TemplatesParser;

public class CompilerPipeline {
    private final ProjectConfig config;
    public CompilerPipeline(ProjectConfig config) {
        this.config = config;
    }
    public void run() {
        try {
            PythonStageResult pythonResult = processPython(
                    config.pythonSourceFile,
                    config.pythonGeneratedOutputPath,
                    "index.html",
                    "add.html",
                    "detail.html"
            );

            if (pythonResult == null) {
                System.out.println("Python stage failed. Compiler stopped.");
                return;
            }

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

            if (indexResult == null || detailResult == null || addResult == null) {
                System.out.println("Template stage failed. Compiler stopped.");
                return;
            }

            CssStageResult cssResult = processCss(
                    config.cssSourceFile,
                    config.cssGeneratedOutputPath
            );

            if (cssResult == null) {
                System.out.println("CSS stage failed. Compiler stopped.");
                return;
            }

            CssSymbolTable.instance.performCrossCheck();

            renderCurrentlySafeFinalOutputs(
                    pythonResult,
                    indexResult,
                    addResult
            );

            System.out.println("\n================ Compiler Pipeline Finished Successfully ================\n");
            System.out.println("Source regeneration output: generated_output/");
            System.out.println("Final rendered HTML output: output/");
            System.out.println("Note: detail final rendering will be completed after PythonRenderTemplateAnalyzer.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PythonStageResult processPython(
            String pythonSourceFile,
            String outputPath,
            String... availableTemplates
    ) throws IOException {
        System.out.println("\n================ Flask & Python ================\n");
        System.out.println(">>> 1. Reading Python File: " + pythonSourceFile);

        CharStream pythonInput = CharStreams.fromFileName(pythonSourceFile);

        FlaskPythonLexer lexer = new FlaskPythonLexer(pythonInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        System.out.println(">>> 2. Parsing...");
        FlaskPythonParser parser = new FlaskPythonParser(tokens);
        ParseTree tree = parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Found Python syntax errors. Stopping.");
            return null;
        }

        System.out.println(">>> 3. Building AST...");
        AntlrToPythonASTVisitor astBuilder = new AntlrToPythonASTVisitor();
        FlaskPythonASTNode astRoot = astBuilder.visit(tree);

        if (!(astRoot instanceof FlaskPythonProgram pythonProgram)) {
            System.out.println("Python AST root is not FlaskPythonProgram. Stopping.");
            return null;
        }

        System.out.println("================ AST ================");
        FlaskPythonASTPrinter printer = new FlaskPythonASTPrinter();
        String astOutput = astRoot.accept(printer);
        System.out.println(astOutput);

        System.out.println(">>> 4. Building Symbol Table...");
        FlaskPythonSymbolTable symbolTable = new FlaskPythonSymbolTable();

        if (availableTemplates != null) {
            for (String template : availableTemplates) {
                System.out.println("   -> Injecting Available Template: " + template);
                symbolTable.addAvailableTemplate(template);
            }
        }

        FlaskPythonSymbolTableVisitor symbolVisitor = new FlaskPythonSymbolTableVisitor(symbolTable);
        astRoot.accept(symbolVisitor);

        System.out.println("\n================ Symbol Table ================\n");
        symbolTable.printTable();

        System.out.println("\n================ Runtime Context ================\n");
        PythonContextExtractor extractor = new PythonContextExtractor();
        PythonRuntimeContext runtimeContext = extractor.extract(pythonProgram);
        System.out.println(runtimeContext);

        System.out.println("\n================ Source Regeneration: Python ================\n");
        FlaskPythonGenerator flaskPythonGenerator = new FlaskPythonGenerator();
        String generatedPython = astRoot.accept(flaskPythonGenerator);

        System.out.println(generatedPython);

        GeneratedPythonWriter writer = new GeneratedPythonWriter();
        writer.writeToFile(generatedPython, outputPath);

        return new PythonStageResult(
                astRoot,
                pythonProgram,
                symbolTable,
                runtimeContext,
                generatedPython
        );
    }

    private TemplateStageResult processTemplate(
            String htmlSourceFile,
            String outputPath,
            PythonStageResult pythonResult,
            String... contextVars
    ) throws IOException {
        System.out.println("\n================ Jinja2 & HTML ================\n");
        System.out.println(">>> 1. Reading Html File: " + htmlSourceFile);

        CharStream htmlInput = CharStreams.fromFileName(htmlSourceFile);

        TemplatesLexer lexer = new TemplatesLexer(htmlInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        System.out.println(">>> 2. Parsing...");
        TemplatesParser parser = new TemplatesParser(tokens);
        ParseTree tree = parser.template();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Found template syntax errors. Stopping.");
            return null;
        }

        System.out.println(">>> 3. Building AST...");
        AntlrToTemplatesVisitor astBuilder = new AntlrToTemplatesVisitor();
        TemplatesASTNode astRoot = astBuilder.visit(tree);

        if (!(astRoot instanceof TemplatesProgram templatesProgram)) {
            System.out.println("Template AST root is not TemplatesProgram. Stopping.");
            return null;
        }

        System.out.println("\n================ AST ================\n");
        System.out.println("=== Abstract Syntax Tree (AST) ===");
        TemplatesASTPrinter printer = new TemplatesASTPrinter();
        String astOutput = astRoot.accept(printer);
        System.out.println(astOutput);

        System.out.println(">>> 4. Building Templates Symbol Table...");

        String templateFileName = extractFileName(htmlSourceFile);
        TemplatesSymbolTable symbolTable = new TemplatesSymbolTable(
                pythonResult.symbolTable,
                templateFileName
        );

        if (contextVars != null) {
            for (String var : contextVars) {
                System.out.println("   -> Injecting Context Variable: " + var);
                symbolTable.defineContextVariable(var, var.toUpperCase());
            }
        }

        TemplatesSymbolTableVisitor symbolVisitor = new TemplatesSymbolTableVisitor(symbolTable);
        astRoot.accept(symbolVisitor);

        CssSymbolTable.instance.setUsedHtmlSelectors(
                symbolVisitor.getSymbolTable().getUsedClasses(),
                symbolVisitor.getSymbolTable().getUsedIds(),
                symbolVisitor.getSymbolTable().getUsedSelectors()
        );

        System.out.println("\n================ Symbol Table ================\n");
        symbolTable.printTable();

        System.out.println("\n================ Source Regeneration: Template ================\n");

        TemplatesGenerator generator = new TemplatesGenerator();
        String generatedTemplate = astRoot.accept(generator);

        System.out.println(generatedTemplate);

        GeneratedTemplateWriter writer = new GeneratedTemplateWriter();
        writer.writeToFile(generatedTemplate, outputPath);

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

    private CssStageResult processCss(
            String cssSourceFile,
            String outputPath
    ) throws IOException {
        System.out.println("\n================ CSS ================\n");
        System.out.println(">>> 1. Reading Css File: " + cssSourceFile);

        CharStream cssInput = CharStreams.fromFileName(cssSourceFile);

        CssLexer lexer = new CssLexer(cssInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        System.out.println(">>> 2. Parsing...");
        CssParser parser = new CssParser(tokens);
        ParseTree tree = parser.stylesheet();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Found CSS syntax errors. Stopping.");
            return null;
        }

        System.out.println(">>> 3. Building AST...");
        AntlrToCssASTVisitor astBuilder = new AntlrToCssASTVisitor();
        CssASTNode astRoot = astBuilder.visit(tree);

        System.out.println("================ AST ================");
        CssASTPrinter printer = new CssASTPrinter();
        String astOutput = astRoot.accept(printer);
        System.out.println(astOutput);

        System.out.println(">>> 4. Building Css Symbol Table...");
        CssSymbolTableVisitor symbolVisitor = new CssSymbolTableVisitor();
        astRoot.accept(symbolVisitor);

        System.out.println("\n================ Symbol Table ================\n");
        CssSymbolTable.instance.printTable();

        System.out.println("\n================ Source Regeneration: CSS ================\n");

        CssGenerator cssGenerator = new CssGenerator();
        String generatedCss = astRoot.accept(cssGenerator);

        System.out.println(generatedCss);

        GeneratedCssWriter writer = new GeneratedCssWriter();
        writer.writeToFile(generatedCss, outputPath);

        return new CssStageResult(
                astRoot,
                generatedCss
        );
    }

    private void renderCurrentlySafeFinalOutputs(
            PythonStageResult pythonResult,
            TemplateStageResult indexResult,
            TemplateStageResult addResult
    ) {
        if (pythonResult.runtimeContext == null) {
            System.out.println("Runtime context is null. Skipping final HTML rendering.");
            return;
        }

        System.out.println("\n================ Final HTML Rendering ================\n");

        FinalOutputWriter writer = new FinalOutputWriter();

        JinjaHtmlRenderer indexRenderer = new JinjaHtmlRenderer(
                pythonResult.runtimeContext.getGlobals()
        );
        String indexHtml = indexResult.program.accept(indexRenderer);
        writer.write(config.indexFinalOutputPath, indexHtml);

        JinjaHtmlRenderer addRenderer = new JinjaHtmlRenderer(
                pythonResult.runtimeContext.getGlobals()
        );
        String addHtml = addResult.program.accept(addRenderer);
        writer.write(config.addFinalOutputPath, addHtml);
    }

    private String extractFileName(String path) {
        String normalized = path.replace("\\", "/");
        int index = normalized.lastIndexOf("/");

        if (index == -1) {
            return normalized;
        }

        return normalized.substring(index + 1);
    }
}
