import java.io.IOException;

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

public class App {
    public static void main(String[] args) {
        String pythonSourceFile = "input_files/app.py";
        String cssSourceFile = "input_files/static/style.css";
        String indexSourceFile = "input_files/templates/index.html";
        String addSourceFile = "input_files/templates/add.html";
        String detailsSourceFile = "input_files/templates/detail.html";
        try {
            printPython(pythonSourceFile, "index.html", "add.html", "detail.html");
            printCss(cssSourceFile);
            printHtml(indexSourceFile, "products");
            printHtml(detailsSourceFile, "product");
            printHtml(addSourceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPython(String pythonSourceFile, String... availableTemplates) throws IOException {
        System.out.println("\n================ Flask & Python ================\n");
        System.out.println(">>> 1. Reading Python File: " + pythonSourceFile);
        CharStream pythonInput = CharStreams.fromFileName(pythonSourceFile);

        FlaskPythonLexer lexer = new FlaskPythonLexer(pythonInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        System.out.println(">>> 2. Parsing...");
        FlaskPythonParser parser = new FlaskPythonParser(tokens);
        ParseTree tree = parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Found syntax errors. Stopping.");
            return;
        }

        System.out.println(">>> 3. Building AST...");
        AntlrToPythonASTVisitor astBuilder = new AntlrToPythonASTVisitor();
        FlaskPythonASTNode astRoot = astBuilder.visit(tree);

        System.out.println("================ AST ================");
        FlaskPythonASTPrinter printer = new FlaskPythonASTPrinter();
        String astOutput = astRoot.accept(printer);
        System.out.println(astOutput);

        System.out.println(">>> 4. Building Symbol Table...");
        FlaskPythonSymbolTable symbolTable = new FlaskPythonSymbolTable();
        if (availableTemplates != null) {
            for (String var : availableTemplates) {
                System.out.println("   -> Injecting Context Variable: " + var);
                symbolTable.addAvailableTemplate(var);
            }
        }
        FlaskPythonSymbolTableVisitor symbolVisitor = new FlaskPythonSymbolTableVisitor(symbolTable);
        astRoot.accept(symbolVisitor);

        System.out.println("\n================ Symbot Table ================\n");

        symbolTable.printTable();
    }

    private static void printCss(String cssSourceFile) throws IOException {
        System.out.println("\n================ CSS ================\n");
        System.out.println(">>> 1. Reading Css File: " + cssSourceFile);
        CharStream cssInput = CharStreams.fromFileName(cssSourceFile);

        CssLexer lexer = new CssLexer(cssInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        System.out.println(">>> 2. Parsing...");
        CssParser parser = new CssParser(tokens);
        ParseTree tree = parser.stylesheet();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Found syntax errors. Stopping.");
            return;
        }

        System.out.println(">>> 3. Building AST...");
        AntlrToCssASTVisitor astBuilder = new AntlrToCssASTVisitor();
        CssASTNode astRoot = astBuilder.visit(tree);

        System.out.println("================ AST ================");
        CssASTPrinter printer = new CssASTPrinter();
        String astOutput = astRoot.accept(printer);
        System.out.println(astOutput);

        System.out.println(">>> 4. Building Css Symbol Table...");
        CssSymbolTable symbolTable = new CssSymbolTable();
        CssSymbolTableVisitor symbolVisitor = new CssSymbolTableVisitor(symbolTable);
        astRoot.accept(symbolVisitor);

        System.out.println("\n================ Symbot Table ================\n");

        symbolTable.printTable();
    }

    private static void printHtml(String htmlSourceFile, String... contextVars) throws IOException {
        System.out.println("\n================ Jinja2 & HTML ================\n");
        System.out.println(">>> 1. Reading Html File: " + htmlSourceFile);
        CharStream htmlInput = CharStreams.fromFileName(htmlSourceFile);

        TemplatesLexer lexer = new TemplatesLexer(htmlInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        System.out.println(">>> 2. Parsing...");
        TemplatesParser parser = new TemplatesParser(tokens);
        ParseTree tree = parser.template();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Found syntax errors. Stopping.");
            return;
        }

        System.out.println(">>> 3. Building AST...");
        AntlrToTemplatesVisitor astBuilder = new AntlrToTemplatesVisitor();
        TemplatesASTNode astRoot = astBuilder.visit(tree);
        System.out.println("\n================ AST ================\n");
        System.out.println("=== Abstract Syntax Tree (AST) ===");
        TemplatesASTPrinter printer = new TemplatesASTPrinter();
        String astOutput = astRoot.accept(printer);
        System.out.println(astOutput);

        System.out.println(">>> 4. Building Templates Symbol Table...");
        TemplatesSymbolTable symbolTable = new TemplatesSymbolTable();
        if (contextVars != null) {
            for (String var : contextVars) {
                System.out.println("   -> Injecting Context Variable: " + var);
                symbolTable.defineContextVariable(var);
            }
        }
        TemplatesSymbolTableVisitor symbolVisitor = new TemplatesSymbolTableVisitor(symbolTable);
        astRoot.accept(symbolVisitor);

        System.out.println("\n================ Symbot Table ================\n");

        symbolTable.printTable();

    }

}
