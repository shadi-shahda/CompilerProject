package RuntimeServer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {

    private final List<Map<String, Object>> products = new ArrayList<>();

    public ProductRepository() {
    }

    public ProductRepository(List<Map<String, Object>> initialProducts) {
        if (initialProducts == null) {
            return;
        }

        for (Map<String, Object> product : initialProducts) {
            products.add(new LinkedHashMap<>(product));
        }
    }

    public synchronized List<Map<String, Object>> getAll() {
        List<Map<String, Object>> copy = new ArrayList<>();

        for (Map<String, Object> product : products) {
            copy.add(new LinkedHashMap<>(product));
        }

        return copy;
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

            if (productId instanceof Number number) {
                return number.intValue() == id;
            }

            try {
                return Integer.parseInt(String.valueOf(productId)) == id;
            } catch (NumberFormatException e) {
                return false;
            }
        });
    }

    private int generateNextId() {
        int maxId = 0;

        for (Map<String, Object> product : products) {
            Object id = product.get("id");

            if (id instanceof Number number) {
                maxId = Math.max(maxId, number.intValue());
                continue;
            }

            try {
                maxId = Math.max(maxId, Integer.parseInt(String.valueOf(id)));
            } catch (NumberFormatException ignored) {
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