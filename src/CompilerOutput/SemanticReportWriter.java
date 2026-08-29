package CompilerOutput;

import FlaskPythonSymbolTable.FlaskPythonSymbolTable;
import TemplatesSymbolTable.TemplatesSymbolTable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SemanticReportWriter {

    public void write(
            FlaskPythonSymbolTable pythonSymbolTable,
            List<TemplatesSymbolTable> templatesSymbolTables,
            List<String> availableTemplatesFileNames,
            String outputPath
    ) throws IOException {

        Path path = Path.of(outputPath);

        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        StringBuilder report = new StringBuilder();

        report.append("================ SEMANTIC REPORT ================\n\n");

        appendSection(
                report,
                "Python Semantic Analysis",
                pythonSymbolTable.getErrors()
        );

        for (int i = 0; i < templatesSymbolTables.size(); i++) {
            appendSection(
                    report,
                    "Template Semantic Analysis - " + availableTemplatesFileNames.get(i),
                    templatesSymbolTables.get(i).getErrors()
            );
        }

        Files.writeString(
                path,
                report.toString(),
                StandardCharsets.UTF_8
        );

        System.out.println("Semantic report generated: " + outputPath);
    }

    private void appendSection(
            StringBuilder report,
            String title,
            List<String> errors
    ) {
        report.append("----- ")
                .append(title)
                .append(" -----\n");

        if (errors == null || errors.isEmpty()) {
            report.append("No Semantic Errors Found.\n\n");
            return;
        }

        for (String error : errors) {
            report.append(error).append("\n");
        }

        report.append("\n");
    }
}