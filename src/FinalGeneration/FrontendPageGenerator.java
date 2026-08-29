package FinalGeneration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FrontendPageGenerator {

    private final Path outputDirectory;
    private final Path staticDirectory;
    private final List<String> availableTemplatesContent;
    private final List<String> templatesFileNames;
    private final String cssFromAst;

    public FrontendPageGenerator(
            String outputDirectory,
            List<String> availableTemplatesContent,
            List<String> templatesFileNames,
            String cssFromAst
    ) {
        this.outputDirectory = Path.of(outputDirectory);
        this.staticDirectory = this.outputDirectory.resolve("static");
        this.availableTemplatesContent = availableTemplatesContent;
        this.templatesFileNames = templatesFileNames;
        this.cssFromAst = cssFromAst;
    }

    public void generate() throws IOException {
        prepareOutputDirectories();

        for (int i = 0; i < availableTemplatesContent.size(); i++) {
            writeFile(
                    outputDirectory.resolve(templatesFileNames.get(i)),
                    availableTemplatesContent.get(i)
            );
        }

        JavaScriptGenerator javaScriptGenerator = new JavaScriptGenerator();

        writeFile(
                staticDirectory.resolve("app.js"),
                javaScriptGenerator.generate()
        );

        writeFile(
                staticDirectory.resolve("style.css"),
                cssFromAst
        );

        System.out.println("Frontend files generated from AST successfully.");
    }

    private void prepareOutputDirectories() throws IOException {
        Files.createDirectories(outputDirectory);
        Files.createDirectories(staticDirectory);

        cleanOldDetailPages();
    }

    private void cleanOldDetailPages() throws IOException {
        if (!Files.exists(outputDirectory)) {
            return;
        }

        try (var files = Files.list(outputDirectory)) {
            files
                    .filter(path -> path.getFileName().toString().matches("detail_\\d+\\.html"))
                    .forEach(path -> {
                        try {
                            Files.deleteIfExists(path);
                        } catch (IOException e) {
                            throw new RuntimeException(
                                    "Failed to delete old detail page: " + path,
                                    e
                            );
                        }
                    });
        }
    }

    private void writeFile(Path path, String content) throws IOException {
        Files.writeString(
                path,
                content,
                StandardCharsets.UTF_8
        );

        System.out.println("Generated: " + path);
    }
}