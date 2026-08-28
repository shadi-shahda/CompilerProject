package RuntimeServer;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ResponseUtils {

    public static void sendText(
            HttpExchange exchange,
            int statusCode,
            String content,
            String contentType
    ) throws IOException {

        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().set(
                "Content-Type",
                contentType + "; charset=UTF-8"
        );

        exchange.sendResponseHeaders(statusCode, bytes.length);

        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(bytes);
        }
    }

    public static void sendNotFound(HttpExchange exchange) throws IOException {
        sendText(
                exchange,
                404,
                "404 - Not Found",
                "text/plain"
        );
    }

    public static void sendMethodNotAllowed(HttpExchange exchange) throws IOException {
        sendText(
                exchange,
                405,
                "405 - Method Not Allowed",
                "text/plain"
        );
    }
}