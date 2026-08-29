package CompilerOutput;

import CssAST.CssProgram;
import CssSymbolTable.CssSymbolTable;
import FlaskPythonAST.FlaskPythonProgram;
import FlaskPythonSymbolTable.FlaskPythonSymbolTable;
import TemplatesAST.TemplatesProgram;
import TemplatesSymbolTable.TemplatesSymbolTable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AstAndSymbolTableReportWriter {

    public void write(
            FlaskPythonProgram pythonAst,
            FlaskPythonSymbolTable pythonSymbolTable,
            List<TemplatesProgram> templateAsts,
            List<TemplatesSymbolTable> templateSymbolTables,
            List<String> templateFileNames,
            CssProgram cssAst,
            CssSymbolTable cssSymbolTable,
            String outputPath
    ) throws IOException {

        StringBuilder report = new StringBuilder();

        report.append("================ AST AND SYMBOL TABLE REPORT ================\n\n");

        report.append("============================================================\n");
        report.append("PYTHON AST\n");
        report.append("============================================================\n");
        appendAst(report, pythonAst);

        report.append("\n============================================================\n");
        report.append("PYTHON SYMBOL TABLE\n");
        report.append("============================================================\n");
        report.append(capturePrintTable(pythonSymbolTable::printTable));

        for (int i = 0; i < templateAsts.size(); i++) {
            String fileName = templateFileNames.get(i);

            report.append("\n============================================================\n");
            report.append("TEMPLATE AST: ").append(fileName).append("\n");
            report.append("============================================================\n");
            appendAst(report, templateAsts.get(i));

            report.append("\n============================================================\n");
            report.append("TEMPLATE SYMBOL TABLE: ").append(fileName).append("\n");
            report.append("============================================================\n");
            report.append(capturePrintTable(templateSymbolTables.get(i)::printTable));
        }

        report.append("\n============================================================\n");
        report.append("CSS AST\n");
        report.append("============================================================\n");
        appendAst(report, cssAst);

        report.append("\n============================================================\n");
        report.append("CSS SYMBOL TABLE\n");
        report.append("============================================================\n");
        report.append(capturePrintTable(cssSymbolTable::printTable));

        Path path = Path.of(outputPath);

        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        Files.writeString(
                path,
                report.toString(),
                StandardCharsets.UTF_8
        );

        System.out.println("AST and Symbol Table report generated: " + outputPath);
    }

    private void appendAst(StringBuilder report, Object ast) {
        Set<Object> visited =
                java.util.Collections.newSetFromMap(new IdentityHashMap<>());

        appendObject(report, ast, 0, visited);
    }

    private void appendObject(
            StringBuilder report,
            Object value,
            int indent,
            Set<Object> visited
    ) {
        appendIndent(report, indent);

        if (value == null) {
            report.append("null\n");
            return;
        }

        if (isSimpleValue(value)) {
            report.append(value).append("\n");
            return;
        }

        if (visited.contains(value)) {
            report.append(value.getClass().getSimpleName())
                    .append(" (already printed)\n");
            return;
        }

        visited.add(value);

        if (value instanceof Collection<?> collection) {
            report.append("List").append(" [size=")
                    .append(collection.size())
                    .append("]\n");

            for (Object item : collection) {
                appendObject(report, item, indent + 1, visited);
            }

            return;
        }

        if (value instanceof Map<?, ?> map) {
            report.append("Map").append(" [size=")
                    .append(map.size())
                    .append("]\n");

            for (Map.Entry<?, ?> entry : map.entrySet()) {
                appendIndent(report, indent + 1);
                report.append("Key:\n");
                appendObject(report, entry.getKey(), indent + 2, visited);

                appendIndent(report, indent + 1);
                report.append("Value:\n");
                appendObject(report, entry.getValue(), indent + 2, visited);
            }

            return;
        }

        Class<?> clazz = value.getClass();

        report.append(clazz.getSimpleName()).append("\n");

        for (Field field : clazz.getFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            try {
                Object fieldValue = field.get(value);

                appendIndent(report, indent + 1);
                report.append(field.getName()).append(":\n");

                appendObject(report, fieldValue, indent + 2, visited);

            } catch (IllegalAccessException e) {
                appendIndent(report, indent + 1);
                report.append(field.getName())
                        .append(": <not accessible>\n");
            }
        }
    }

    private boolean isSimpleValue(Object value) {
        return value instanceof String
                || value instanceof Number
                || value instanceof Boolean
                || value instanceof Character
                || value.getClass().isEnum();
    }

    private void appendIndent(StringBuilder report, int indent) {
        for (int i = 0; i < indent; i++) {
            report.append("  ");
        }
    }

    private String capturePrintTable(Runnable printAction) {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream capture = new PrintStream(
                outputStream,
                true,
                StandardCharsets.UTF_8
        );

        try {
            System.setOut(capture);
            System.setErr(capture);

            printAction.run();

            capture.flush();

            return outputStream.toString(StandardCharsets.UTF_8);

        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }
}