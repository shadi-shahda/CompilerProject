import CompilerPipeline.SourceCompilationPipeline;
import RuntimeServer.JavaAppServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        try {
            SourceCompilationPipeline compilerPipeline =
                    new SourceCompilationPipeline(
                            "input_files/app.py",
                            "input_files/templates",
                            "input_files/static/style.css",
                            "output"
                    );

            List<String> availableTemplates = new ArrayList<>();
            availableTemplates.add("index.html");
            availableTemplates.add("add.html");
            availableTemplates.add("detail.html");

            List<Map<String, Object>> initialProducts =
                    compilerPipeline.compile(availableTemplates);

            JavaAppServer server = new JavaAppServer(
                    8081,
                    "output",
                    initialProducts
            );

            server.start();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}