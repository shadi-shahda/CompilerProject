package RuntimeServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.Map;

public class ProductsApiHandler implements HttpHandler {

    private final ProductRepository productRepository;

    public ProductsApiHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();

        if (method.equalsIgnoreCase("GET")) {
            handleGetProducts(exchange);
            return;
        }

        if (method.equalsIgnoreCase("POST")) {
            handleAddProduct(exchange);
            return;
        }

        if (method.equalsIgnoreCase("DELETE")) {
            handleDeleteProduct(exchange);
            return;
        }

        ResponseUtils.sendMethodNotAllowed(exchange);
    }

    private void handleGetProducts(HttpExchange exchange) throws IOException {
        String json = JsonUtil.toJson(productRepository.getAll());

        ResponseUtils.sendText(
                exchange,
                200,
                json,
                "application/json"
        );
    }

    private void handleAddProduct(HttpExchange exchange) throws IOException {
        Map<String, String> formData = RequestUtils.parseFormBody(exchange);

        String name = formData.getOrDefault("name", "");
        String details = formData.getOrDefault("details", "");
        String image = formData.getOrDefault("image", "");
        String price = formData.getOrDefault("price", "0");

        if (name.isBlank()) {
            ResponseUtils.sendText(
                    exchange,
                    400,
                    "{\"error\":\"Product name is required\"}",
                    "application/json"
            );
            return;
        }

        Map<String, Object> createdProduct = productRepository.addProduct(
                name,
                details,
                image,
                price
        );

        ResponseUtils.sendText(
                exchange,
                201,
                JsonUtil.toJson(createdProduct),
                "application/json"
        );
    }

    private void handleDeleteProduct(HttpExchange exchange) throws IOException {
        Map<String, String> queryParams = RequestUtils.parseQuery(
                exchange.getRequestURI().getQuery()
        );

        String idValue = queryParams.get("id");

        if (idValue == null || idValue.isBlank()) {
            ResponseUtils.sendText(
                    exchange,
                    400,
                    "{\"error\":\"Product id is required\"}",
                    "application/json"
            );
            return;
        }

        int id;

        try {
            id = Integer.parseInt(idValue);
        } catch (NumberFormatException e) {
            ResponseUtils.sendText(
                    exchange,
                    400,
                    "{\"error\":\"Product id must be a number\"}",
                    "application/json"
            );
            return;
        }

        boolean deleted = productRepository.deleteById(id);

        if (!deleted) {
            ResponseUtils.sendText(
                    exchange,
                    404,
                    "{\"error\":\"Product not found\"}",
                    "application/json"
            );
            return;
        }

        ResponseUtils.sendText(
                exchange,
                200,
                "{\"message\":\"Product deleted successfully\"}",
                "application/json"
        );
    }
}