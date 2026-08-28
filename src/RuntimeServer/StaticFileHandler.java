package RuntimeServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StaticFileHandler implements HttpHandler {

    private final Path rootDirectory;

    public StaticFileHandler(String rootDirectory) {
        this.rootDirectory = Path.of(rootDirectory).toAbsolutePath().normalize();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            ResponseUtils.sendMethodNotAllowed(exchange);
            return;
        }

        String requestPath = exchange.getRequestURI().getPath();

        if (requestPath.equals("/")) {
            requestPath = "/index.html";
        }

        Path requestedFile = rootDirectory
                .resolve(requestPath.substring(1))
                .normalize();

        if (!requestedFile.startsWith(rootDirectory)) {
            ResponseUtils.sendNotFound(exchange);
            return;
        }

        if (!Files.exists(requestedFile) || Files.isDirectory(requestedFile)) {
            ResponseUtils.sendNotFound(exchange);
            return;
        }

        String content = Files.readString(requestedFile);
        String contentType = detectContentType(requestedFile);

        ResponseUtils.sendText(exchange, 200, content, contentType);
    }

    private String detectContentType(Path file) {
        String fileName = file.getFileName().toString().toLowerCase();

        if (fileName.endsWith(".html")) {
            return "text/html";
        }

        if (fileName.endsWith(".css")) {
            return "text/css";
        }

        if (fileName.endsWith(".js")) {
            return "application/javascript";
        }

        if (fileName.endsWith(".json")) {
            return "application/json";
        }

        return "text/plain";
    }
}