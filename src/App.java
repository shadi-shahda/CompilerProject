import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CompilerPipeline.CompilerPipeline;
import CompilerPipeline.ProjectConfig;
import CssGenerator.CssGenerator;
import CssGenerator.GeneratedCssWriter;
import FinalGeneration.FinalOutputWriter;
import FinalGeneration.JinjaHtmlRenderer;
import FinalGeneration.PythonContextExtractor;
import FinalGeneration.PythonRuntimeContext;
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonGenerator.FlaskPythonGenerator;
import FlaskPythonGenerator.GeneratedPythonWriter;
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

public class App {

    public static void main(String[] args) {
        ProjectConfig config = ProjectConfig.defaultConfig();
        CompilerPipeline pipeline = new CompilerPipeline(config);
        pipeline.run();
    }
}
