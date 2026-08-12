package FinalGeneration;

import FlaskPythonAST.FlaskPythonExpression;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents one render_template(...) call found inside a Flask function.
 *
 * Example:
 * render_template("index.html", products=products)
 *
 * becomes:
 * templateName = index.html
 * contextExpressions = { products -> Identifier(products) }
 */
public final class RenderTemplateBinding {

    private final String functionName;
    private final String routePath;
    private final String templateName;

    private final Map<String, FlaskPythonExpression> contextExpressions;

    public RenderTemplateBinding(
            String functionName,
            String routePath,
            String templateName,
            Map<String, FlaskPythonExpression> contextExpressions
    ) {
        this.functionName = functionName;
        this.routePath = routePath;
        this.templateName = templateName;

        this.contextExpressions = Collections.unmodifiableMap(
                new LinkedHashMap<>(contextExpressions)
        );
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getRoutePath() {
        return routePath;
    }

    public String getTemplateName() {
        return templateName;
    }

    public Map<String, FlaskPythonExpression> getContextExpressions() {
        return contextExpressions;
    }

    @Override
    public String toString() {
        return "RenderTemplateBinding{" +
                "function='" + functionName + '\'' +
                ", route='" + routePath + '\'' +
                ", template='" + templateName + '\'' +
                ", context=" + contextExpressions.keySet() +
                '}';
    }
}