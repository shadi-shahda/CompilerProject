package RuntimeServer;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestUtils {

    public static Map<String, String> parseQuery(String query) {
        Map<String, String> params = new LinkedHashMap<>();

        if (query == null || query.isBlank()) {
            return params;
        }

        String[] pairs = query.split("&");

        for (String pair : pairs) {
            String[] parts = pair.split("=", 2);

            String key = decode(parts[0]);
            String value = parts.length > 1 ? decode(parts[1]) : "";

            params.put(key, value);
        }

        return params;
    }

    public static Map<String, String> parseFormBody(HttpExchange exchange) throws IOException {
        String body = new String(
                exchange.getRequestBody().readAllBytes(),
                StandardCharsets.UTF_8
        );

        return parseQuery(body);
    }

    private static String decode(String value) {
        return URLDecoder.decode(value, StandardCharsets.UTF_8);
    }
}