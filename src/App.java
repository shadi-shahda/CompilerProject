import CompilerPipeline.CompilerPipeline;
import CompilerPipeline.ProjectConfig;

public class App {

    public static void main(String[] args) {
        ProjectConfig config = ProjectConfig.defaultConfig();
        CompilerPipeline pipeline = new CompilerPipeline(config);
        pipeline.run();
    }
}
