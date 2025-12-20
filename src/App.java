import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import FlaskPythonAST.FlaskPythonASTNode;
import FlaskPythonSymbolTable.FlaskPythonSymbolTable;
import FlaskPythonSymbolTable.FlaskPythonSymbolTableVisitor;
import FlaskPythonVisitor.AntlrToASTVisitor;
import generated.FlaskPythonLexer;
import generated.FlaskPythonParser;

public class App {
    public static void main(String[] args) {
        String sourceFile = "input_files/app.py";

        try {
            System.out.println(">>> 1. Reading File: " + sourceFile);
            CharStream input = CharStreams.fromFileName(sourceFile);

            FlaskPythonLexer lexer = new FlaskPythonLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            System.out.println(">>> 2. Parsing...");
            FlaskPythonParser parser = new FlaskPythonParser(tokens);
            ParseTree tree = parser.program();

            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.out.println("Found syntax errors. Stopping.");
                return;
            }

            System.out.println(">>> 3. Building AST...");
            AntlrToASTVisitor astBuilder = new AntlrToASTVisitor();
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
