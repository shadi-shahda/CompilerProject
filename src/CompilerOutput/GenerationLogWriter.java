package CompilerOutput;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GenerationLogWriter {

    private final List<String> entries =
            new ArrayList<>();

    public void add(String message) {
        entries.add(message);
    }

    public void write(String outputPath) throws IOException {

        StringBuilder content =
                new StringBuilder();

        content.append(
                "================ GENERATION LOG ================\n\n"
        );

        for (String entry : entries) {
            content.append("- ")
                    .append(entry)
                    .append("\n");
        }

        Path path =
                Paths.get(outputPath);

        if (path.getParent() != null) {
            Files.createDirectories(
                    path.getParent()
            );
        }

        Files.writeString(
                path,
                content.toString(),
                StandardCharsets.UTF_8
        );

        System.out.println(
                "Generation log generated: "
                        + path.toAbsolutePath()
        );
    }
}