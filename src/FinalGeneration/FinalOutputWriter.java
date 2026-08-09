package FinalGeneration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FinalOutputWriter {

    public void write(String outputPath, String content) {
        try {
            Path path = Path.of(outputPath);

            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }

            Files.writeString(path, content, StandardCharsets.UTF_8);

            System.out.println("Final HTML file generated:");
            System.out.println(path.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Failed to write final HTML file: " + e.getMessage());
        }
    }
}