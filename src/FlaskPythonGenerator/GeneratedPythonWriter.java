package FlaskPythonGenerator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeneratedPythonWriter {

    public void writeToFile(String generatedCode, String outputPath) {
        try {
            Path path = Path.of(outputPath);

            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }

            Files.writeString(path, generatedCode, StandardCharsets.UTF_8);

            System.out.println("Python file generated successfully:");
            System.out.println(path.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Failed to generate Python file: " + e.getMessage());
        }
    }
}