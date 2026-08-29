package RuntimeServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

public class JavaAppServer {

    private final int port;
    private final String outputDirectory;
    private final ProductRepository productRepository;

    private HttpServer server;

    public JavaAppServer(int port, String outputDirectory) {
        this(port, outputDirectory, List.of());
    }

    public JavaAppServer(
            int port,
            String outputDirectory,
            List<Map<String, Object>> initialProducts
    ) {
        this.port = port;
        this.outputDirectory = outputDirectory;
        this.productRepository = new ProductRepository(initialProducts);
    }

    public void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/health", exchange -> {
            ResponseUtils.sendText(
                    exchange,
                    200,
                    "Java server is running",
                    "text/plain"
            );
        });

        server.createContext(
                "/api/products",
                new ProductsApiHandler(productRepository)
        );

        server.createContext(
                "/",
                new StaticFileHandler(outputDirectory)
        );

        server.setExecutor(null);
        server.start();

        System.out.println("Java server started successfully.");
        System.out.println("Open: http://localhost:" + port);
        System.out.println("Products API: http://localhost:" + port + "/api/products");
    }

    public void stop() {
        if (server != null) {
            server.stop(0);
            System.out.println("Java server stopped.");
        }
    }
}