package RuntimeServer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {

    private final List<Map<String, Object>> products = new ArrayList<>();

    public ProductRepository() {
        addInitialProduct(1, "Laptop", "High performance laptop for coding.", "https://via.placeholder.com/150", 1500);
        addInitialProduct(2, "Phone", "Smart phone with great camera.", "https://via.placeholder.com/150", 800);
    }

    public synchronized List<Map<String, Object>> getAll() {
        return new ArrayList<>(products);
    }

    public synchronized Map<String, Object> addProduct(
            String name,
            String details,
            String image,
            String price
    ) {
        Map<String, Object> product = new LinkedHashMap<>();

        product.put("id", generateNextId());
        product.put("name", name);
        product.put("details", details);
        product.put("image", image);
        product.put("price", parsePrice(price));

        products.add(product);

        return product;
    }

    public synchronized boolean deleteById(int id) {
        return products.removeIf(product -> {
            Object productId = product.get("id");
            return productId instanceof Number number && number.intValue() == id;
        });
    }

    private void addInitialProduct(
            int id,
            String name,
            String details,
            String image,
            int price
    ) {
        Map<String, Object> product = new LinkedHashMap<>();

        product.put("id", id);
        product.put("name", name);
        product.put("details", details);
        product.put("image", image);
        product.put("price", price);

        products.add(product);
    }

    private int generateNextId() {
        int maxId = 0;

        for (Map<String, Object> product : products) {
            Object id = product.get("id");

            if (id instanceof Number number) {
                maxId = Math.max(maxId, number.intValue());
            }
        }

        return maxId + 1;
    }

    private Object parsePrice(String price) {
        if (price == null || price.isBlank()) {
            return 0;
        }

        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            return price;
        }
    }
}