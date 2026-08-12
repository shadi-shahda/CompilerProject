package CompilerOutput;

import CssSymbolTable.CssSymbolTable;
import FlaskPythonSymbolTable.FlaskPythonSymbolTable;
import TemplatesSymbolTable.TemplatesSymbolTable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import TemplatesSymbolTable.TemplatesSymbol;

public class SemanticReportWriter {

    public void write(
            FlaskPythonSymbolTable pythonSymbolTable,
            TemplatesSymbolTable indexSymbolTable,
            TemplatesSymbolTable detailSymbolTable,
            TemplatesSymbolTable addSymbolTable,
            String outputPath
    ) throws IOException {

        StringBuilder report = new StringBuilder();

        report.append(
                "================ SEMANTIC ANALYSIS REPORT ================\n\n"
        );

        report.append(
                captureSection(
                        "PYTHON / FLASK",
                        pythonSymbolTable::printTable
                )
        );

        report.append(
                buildTemplateSection(
                        "JINJA / index.html",
                        indexSymbolTable
                )
        );

        report.append(
                buildTemplateSection(
                        "JINJA / detail.html",
                        detailSymbolTable
                )
        );

        report.append(
                buildTemplateSection(
                        "JINJA / add.html",
                        addSymbolTable
                )
        );

        report.append(
                captureSection(
                        "CSS",
                        CssSymbolTable.instance::printTable
                )
        );

        Path path = Paths.get(outputPath);

        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        Files.writeString(
                path,
                report.toString(),
                StandardCharsets.UTF_8
        );

        System.out.println(
                "Semantic report generated: "
                        + path.toAbsolutePath()
        );
    }


    private String captureSection(
            String title,
            Runnable printer
    ) {

        PrintStream originalOut = System.out;

        ByteArrayOutputStream buffer =
                new ByteArrayOutputStream();

        try (
                PrintStream capture =
                        new PrintStream(buffer, true, StandardCharsets.UTF_8)
        ) {

            System.setOut(capture);

            printer.run();

        } finally {

            System.setOut(originalOut);
        }

        return "================ "
                + title
                + " ================\n\n"
                + buffer.toString(StandardCharsets.UTF_8)
                + "\n";
    }

    private String buildTemplateSection(
            String title,
            TemplatesSymbolTable symbolTable
    ) {

        StringBuilder section =
                new StringBuilder();

        section.append(
                "================ "
                        + title
                        + " ================\n\n"
        );

        for (TemplatesSymbol symbol : symbolTable.getAllSymbols()) {

            String location =
                    symbol.getLine() == 0
                            ? "Injected Context"
                            : "Line " + symbol.getLine();

            section.append(
                    String.format(
                            "| %-25s | %-20s | %-20s |\n",
                            symbol.getName(),
                            symbol.getKind(),
                            location
                    )
            );
        }

        if (
                !symbolTable.getUsedSelectors().isEmpty()
                        || !symbolTable.getUsedClasses().isEmpty()
                        || !symbolTable.getUsedIds().isEmpty()
        ) {

            section.append(
                    "\n| HTML SELECTORS USAGE (For CSS Linking) |\n"
            );
        }

        if (symbolTable.hasErrors()) {

            section.append(
                    "\nStatus: Semantic Errors Found.\n"
            );

            for (String error : symbolTable.getErrors()) {
                section.append(error).append("\n");
            }

        } else {

            section.append(
                    "\nStatus: No Semantic Errors Found.\n"
            );
        }

        section.append("\n");

        return section.toString();
    }
}