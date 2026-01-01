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
import generated.CssLexer;
import generated.CssParser;
import generated.FlaskPythonLexer;
import generated.FlaskPythonParser;

public class App {
    public static void main(String[] args) {
        String pythonSourceFile = "input_files/app.py";
        String cssSourceFile = "input_files/static/style.css";
        String htmlSourceFile = "input_files/templates/index.html";
        try {
            printHtml(htmlSourceFile);
            printPython(pythonSourceFile);
            printCss(cssSourceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPython(String pythonSourceFile) throws IOException {
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

        System.out.println(">>> 4. Building Symbol Table...");
        FlaskPythonSymbolTable symbolTable = new FlaskPythonSymbolTable();
        FlaskPythonSymbolTableVisitor symbolVisitor = new FlaskPythonSymbolTableVisitor(symbolTable);
        astRoot.accept(symbolVisitor);

        System.out.println("\n================ OUTPUT ================\n");

        symbolTable.printTable();

        System.out.println("=== Abstract Syntax Tree (AST) ===");
        FlaskPythonASTPrinter printer = new FlaskPythonASTPrinter();
        String astOutput = astRoot.accept(printer);
        System.out.println(astOutput);
    }

    private static void printCss(String cssSourceFile) throws IOException {
        System.out.println(">>> 1. Reading Css File: " + cssSourceFile);
            CharStream pythonInput = CharStreams.fromFileName(cssSourceFile);

            CssLexer lexer = new CssLexer(pythonInput);
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

            System.out.println(">>> 4. Building Css Symbol Table...");
            CssSymbolTable symbolTable = new CssSymbolTable();
            CssSymbolTableVisitor symbolVisitor = new CssSymbolTableVisitor(symbolTable);
            astRoot.accept(symbolVisitor);

            System.out.println("\n================ OUTPUT ================\n");

            symbolTable.printTable();

            System.out.println("=== Abstract Syntax Tree (AST) ===");
            CssASTPrinter printer = new CssASTPrinter();
            String astOutput = astRoot.accept(printer);
            System.out.println(astOutput);

    }

    private static void printHtml(String htmlSourceFile) throws IOException {
        // System.out.println(">>> 1. Reading Html File: " + htmlSourceFile);
        //     CharStream pythonInput = CharStreams.fromFileName(htmlSourceFile);

        //     CssLexer lexer = new CssLexer(pythonInput);
        //     CommonTokenStream tokens = new CommonTokenStream(lexer);

        //     System.out.println(">>> 2. Parsing...");
        //     CssParser parser = new CssParser(tokens);
        //     ParseTree tree = parser.stylesheet();

        //     if (parser.getNumberOfSyntaxErrors() > 0) {
        //         System.out.println("Found syntax errors. Stopping.");
        //         return;
        //     }

        //     System.out.println(">>> 3. Building AST...");
        //     AntlrToCssASTVisitor astBuilder = new AntlrToCssASTVisitor();
        //     CssASTNode astRoot = astBuilder.visit(tree);

        //     System.out.println(">>> 4. Building Css Symbol Table...");
        //     CssSymbolTable symbolTable = new CssSymbolTable();
        //     CssSymbolTableVisitor symbolVisitor = new CssSymbolTableVisitor(symbolTable);
        //     astRoot.accept(symbolVisitor);

        //     System.out.println("\n================ OUTPUT ================\n");

        //     symbolTable.printTable();

        //     System.out.println("=== Abstract Syntax Tree (AST) ===");
        //     CssASTPrinter printer = new CssASTPrinter();
        //     String astOutput = astRoot.accept(printer);
        //     System.out.println(astOutput);

    }

}
