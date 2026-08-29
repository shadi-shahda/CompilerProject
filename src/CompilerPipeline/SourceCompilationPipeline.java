package CompilerPipeline;

import CompilerOutput.AstAndSymbolTableReportWriter;
import CompilerOutput.SemanticReportWriter;

import CssAST.CssProgram;
import CssGenerator.CssGenerator;
import CssSymbolTable.CssSymbolTable;
import CssSymbolTable.CssSymbolTableVisitor;
import CssVisitor.AntlrToCssASTVisitor;

import FinalGeneration.FrontendPageGenerator;

import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonSymbolTable.FlaskPythonSymbolTable;
import FlaskPythonSymbolTable.FlaskPythonSymbolTableVisitor;
import FlaskPythonVisitor.AntlrToPythonASTVisitor;

import TemplatesAST.TemplatesProgram;
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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SourceCompilationPipeline {

    private final Path pythonSourcePath;
    private final Path templatesDirectory;
    private final Path cssSourcePath;
    private final Path outputDirectory;

    public SourceCompilationPipeline(
            String pythonSourcePath,
            String templatesDirectory,
            String cssSourcePath,
            String outputDirectory
    ) {
        this.pythonSourcePath = Path.of(pythonSourcePath);
        this.templatesDirectory = Path.of(templatesDirectory);
        this.cssSourcePath = Path.of(cssSourcePath);
        this.outputDirectory = Path.of(outputDirectory);
    }

    public List<Map<String, Object>> compile(
            List<String> availableTemplates
    ) throws IOException {

        System.out.println("========== COMPILATION STARTED ==========");

        FlaskPythonProgram pythonAst = parsePythonFile();

        List<Map<String, Object>> initialProducts =
                new PythonProductsExtractor().extractProducts(pythonAst);

        FlaskPythonSymbolTable pythonSymbolTable = analyzePythonSemantics(
                pythonAst,
                availableTemplates
        );

        List<TemplatesProgram> templatesPrograms = new ArrayList<>();
        List<TemplatesSymbolTable> templatesSymbolTables = new ArrayList<>();

        for (String availableTemplate : availableTemplates) {
            TemplatesProgram ast = parseTemplateFile(availableTemplate);
            templatesPrograms.add(ast);

            TemplatesSymbolTable templateSymbolTable =
                    analyzeTemplateSemantics(
                            ast,
                            availableTemplate,
                            pythonSymbolTable
                    );

            templatesSymbolTables.add(templateSymbolTable);
        }

        CssProgram cssAst = parseCssFile();

        analyzeCssSemantics(
                cssAst,
                templatesSymbolTables
        );

        new SemanticReportWriter().write(
                pythonSymbolTable,
                templatesSymbolTables,
                availableTemplates,
                "compiler_output/semantic_report.txt"
        );

        new AstAndSymbolTableReportWriter().write(
                pythonAst,
                pythonSymbolTable,
                templatesPrograms,
                templatesSymbolTables,
                availableTemplates,
                cssAst,
                CssSymbolTable.instance,
                "compiler_output/ast_and_symbol_tables.txt"
        );

        stopIfSemanticErrorsExist(
                pythonSymbolTable,
                templatesSymbolTables,
                availableTemplates
        );

        generateOutputFilesFromAst(
                templatesPrograms,
                availableTemplates,
                cssAst
        );

        System.out.println(
                "Initial products extracted from Python AST: "
                        + initialProducts.size()
        );

        System.out.println("========== COMPILATION FINISHED SUCCESSFULLY ==========");

        return initialProducts;
    }

    private FlaskPythonProgram parsePythonFile() throws IOException {
        CharStream input = CharStreams.fromPath(
                pythonSourcePath,
                StandardCharsets.UTF_8
        );

        FlaskPythonLexer lexer = new FlaskPythonLexer(input);
        SyntaxErrorCollector lexerErrors = new SyntaxErrorCollector();
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerErrors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        FlaskPythonParser parser = new FlaskPythonParser(tokens);
        SyntaxErrorCollector parserErrors = new SyntaxErrorCollector();
        parser.removeErrorListeners();
        parser.addErrorListener(parserErrors);

        FlaskPythonParser.ProgramContext parseTree = parser.program();

        stopIfSyntaxErrorsExist(
                pythonSourcePath.toString(),
                lexerErrors,
                parserErrors
        );

        FlaskPythonProgram ast = (FlaskPythonProgram) new AntlrToPythonASTVisitor()
                .visit(parseTree);

        if (ast == null) {
            throw new CompilationException(
                    "Failed to build Python AST from: " + pythonSourcePath
            );
        }

        System.out.println("Python AST built successfully.");
        return ast;
    }

    private TemplatesProgram parseTemplateFile(String templateFileName) throws IOException {
        Path templatePath = templatesDirectory.resolve(templateFileName);

        CharStream input = CharStreams.fromPath(
                templatePath,
                StandardCharsets.UTF_8
        );

        TemplatesLexer lexer = new TemplatesLexer(input);
        SyntaxErrorCollector lexerErrors = new SyntaxErrorCollector();
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerErrors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        TemplatesParser parser = new TemplatesParser(tokens);
        SyntaxErrorCollector parserErrors = new SyntaxErrorCollector();
        parser.removeErrorListeners();
        parser.addErrorListener(parserErrors);

        TemplatesParser.TemplateContext parseTree = parser.template();

        stopIfSyntaxErrorsExist(
                templatePath.toString(),
                lexerErrors,
                parserErrors
        );

        TemplatesProgram ast = (TemplatesProgram) new AntlrToTemplatesVisitor()
                .visit(parseTree);

        if (ast == null) {
            throw new CompilationException(
                    "Failed to build Template AST from: " + templatePath
            );
        }

        System.out.println("Template AST built successfully: " + templateFileName);
        return ast;
    }

    private CssProgram parseCssFile() throws IOException {
        CharStream input = CharStreams.fromPath(
                cssSourcePath,
                StandardCharsets.UTF_8
        );

        CssLexer lexer = new CssLexer(input);
        SyntaxErrorCollector lexerErrors = new SyntaxErrorCollector();
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerErrors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CssParser parser = new CssParser(tokens);
        SyntaxErrorCollector parserErrors = new SyntaxErrorCollector();
        parser.removeErrorListeners();
        parser.addErrorListener(parserErrors);

        CssParser.StylesheetContext parseTree = parser.stylesheet();

        stopIfSyntaxErrorsExist(
                cssSourcePath.toString(),
                lexerErrors,
                parserErrors
        );

        CssProgram ast = (CssProgram) new AntlrToCssASTVisitor()
                .visit(parseTree);

        if (ast == null) {
            throw new CompilationException(
                    "Failed to build CSS AST from: " + cssSourcePath
            );
        }

        System.out.println("CSS AST built successfully.");
        return ast;
    }

    private void stopIfSyntaxErrorsExist(
            String sourceName,
            SyntaxErrorCollector lexerErrors,
            SyntaxErrorCollector parserErrors
    ) {
        List<String> errors = new ArrayList<>();

        if (lexerErrors.hasErrors()) {
            for (String error : lexerErrors.getErrors()) {
                errors.add("Lexer error in " + sourceName + " -> " + error);
            }
        }

        if (parserErrors.hasErrors()) {
            for (String error : parserErrors.getErrors()) {
                errors.add("Parser error in " + sourceName + " -> " + error);
            }
        }

        if (!errors.isEmpty()) {
            throw new CompilationException(
                    "Compilation stopped before AST generation because syntax/parsing errors were found:\n"
                            + String.join("\n", errors)
            );
        }
    }

    private FlaskPythonSymbolTable analyzePythonSemantics(
            FlaskPythonProgram pythonAst,
            List<String> availableTemplates
    ) {
        FlaskPythonSymbolTable symbolTable = new FlaskPythonSymbolTable();
        for (String template : availableTemplates) {
            symbolTable.addAvailableTemplate(template);
        }

        FlaskPythonSymbolTableVisitor visitor =
                new FlaskPythonSymbolTableVisitor(symbolTable);

        pythonAst.accept(visitor);

        symbolTable.printTable();

        return symbolTable;
    }

    private TemplatesSymbolTable analyzeTemplateSemantics(
            TemplatesProgram templateAst,
            String templateFileName,
            FlaskPythonSymbolTable pythonSymbolTable
    ) {
        TemplatesSymbolTable symbolTable =
                new TemplatesSymbolTable(
                        pythonSymbolTable,
                        templateFileName
                );

        TemplatesSymbolTableVisitor visitor =
                new TemplatesSymbolTableVisitor(symbolTable);

        templateAst.accept(visitor);

        symbolTable.printTable();

        return symbolTable;
    }

    private void analyzeCssSemantics(
            CssProgram cssAst,
            List<TemplatesSymbolTable> availableTemplates
    ) {
        CssSymbolTable.instance.reset();

        for (TemplatesSymbolTable templateSymbolTable : availableTemplates) {
            CssSymbolTable.instance.setUsedHtmlSelectors(
                    templateSymbolTable.getUsedClasses(),
                    templateSymbolTable.getUsedIds(),
                    templateSymbolTable.getUsedSelectors());
        }

        CssSymbolTableVisitor visitor = new CssSymbolTableVisitor();

        cssAst.accept(visitor);

        CssSymbolTable.instance.printTable();
        CssSymbolTable.instance.performCrossCheck();
    }

    private void stopIfSemanticErrorsExist(
            FlaskPythonSymbolTable pythonSymbolTable,
            List<TemplatesSymbolTable> availableTemplates,
            List<String> availableTemplatesFileNames
    ) {
        List<String> errors = new ArrayList<>();

        if (pythonSymbolTable.hasErrors()) {
            for (String error : pythonSymbolTable.getErrors()) {
                errors.add("Python semantic error -> " + error);
            }
        }

        for (int i = 0; i < availableTemplates.size(); i++) {
            collectTemplateSemanticErrors(errors, availableTemplatesFileNames.get(i), availableTemplates.get(i));
        }

        if (!errors.isEmpty()) {
            throw new CompilationException(
                    "Compilation stopped before code generation because semantic errors were found:\n"
                            + String.join("\n", errors)
            );
        }
    }

    private void collectTemplateSemanticErrors(
            List<String> errors,
            String templateFileName,
            TemplatesSymbolTable symbolTable
    ) {
        if (!symbolTable.hasErrors()) {
            return;
        }

        for (String error : symbolTable.getErrors()) {
            errors.add(
                    "Template semantic error in "
                            + templateFileName
                            + " -> "
                            + error
            );
        }
    }

    private void generateOutputFilesFromAst(
            List<TemplatesProgram> availableTemplates,
            List<String> availableTemplatesFileNames,
            CssProgram cssAst
    ) throws IOException {

        List<String> generatedHtml = new ArrayList<>();

        for (TemplatesProgram availableTemplate : availableTemplates) {
            generatedHtml.add(availableTemplate.accept(new TemplatesGenerator()));
        }

        String generatedCss =
                cssAst.accept(new CssGenerator());

        FrontendPageGenerator frontendPageGenerator =
                new FrontendPageGenerator(
                        outputDirectory.toString(),
                        generatedHtml,
                        availableTemplatesFileNames,
                        generatedCss
                );

        frontendPageGenerator.generate();
    }
}