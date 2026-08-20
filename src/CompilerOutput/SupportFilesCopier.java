package CompilerOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SupportFilesCopier {

    public void copy(
            String sourcePath,
            String destinationPath
    ) throws IOException {

        Path source =
                Paths.get(sourcePath);

        Path destination =
                Paths.get(destinationPath);

        if (destination.getParent() != null) {
            Files.createDirectories(
                    destination.getParent()
            );
        }

        Files.copy(
                source,
                destination,
                StandardCopyOption.REPLACE_EXISTING
        );

        System.out.println(
                "Support file copied: "
                        + destination.toAbsolutePath()
        );
    }
}