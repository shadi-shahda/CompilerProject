package CompilerOutput;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;

public class AstJsonWriter {

    public void write(Object astRoot, String outputPath) throws IOException {

        String json;

        try {
            json = toJson(
                    astRoot,
                    0,
                    new IdentityHashMap<>()
            );
        } catch (IllegalAccessException e) {
            throw new IOException(
                    "Failed to convert AST to JSON.",
                    e
            );
        }

        Path path = Paths.get(outputPath);

        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        Files.writeString(
                path,
                json,
                StandardCharsets.UTF_8
        );

        System.out.println(
                "AST JSON file generated: "
                        + path.toAbsolutePath()
        );
    }


    private String toJson(
            Object value,
            int indent,
            IdentityHashMap<Object, Boolean> visited
    ) throws IllegalAccessException {

        if (value == null) {
            return "null";
        }

        if (
                value instanceof String
                        || value instanceof Character
                        || value instanceof Enum<?>
        ) {
            return "\"" + escape(value.toString()) + "\"";
        }

        if (
                value instanceof Number
                        || value instanceof Boolean
        ) {
            return value.toString();
        }


        /*
         * List / Collection
         */
        if (value instanceof Collection<?> collection) {

            StringBuilder result = new StringBuilder();

            result.append("[\n");

            int index = 0;

            for (Object item : collection) {

                result.append(
                        spaces(indent + 2)
                );

                result.append(
                        toJson(
                                item,
                                indent + 2,
                                visited
                        )
                );

                if (index < collection.size() - 1) {
                    result.append(",");
                }

                result.append("\n");

                index++;
            }

            result.append(
                    spaces(indent)
            );

            result.append("]");

            return result.toString();
        }


        /*
         * Map
         */
        if (value instanceof Map<?, ?> map) {

            StringBuilder result = new StringBuilder();

            result.append("{\n");

            int index = 0;

            for (
                    Map.Entry<?, ?> entry
                    : map.entrySet()
            ) {

                result.append(
                        spaces(indent + 2)
                );

                result.append("\"")
                        .append(
                                escape(
                                        extractMapKey(
                                                entry.getKey()
                                        )
                                )
                        )
                        .append("\": ");

                result.append(
                        toJson(
                                entry.getValue(),
                                indent + 2,
                                visited
                        )
                );

                if (index < map.size() - 1) {
                    result.append(",");
                }

                result.append("\n");

                index++;
            }

            result.append(
                    spaces(indent)
            );

            result.append("}");

            return result.toString();
        }


        /*
         * Prevent circular references
         */
        if (visited.containsKey(value)) {

            return "\"<circular-reference>\"";
        }

        visited.put(value, true);


        /*
         * AST Object
         */
        StringBuilder result = new StringBuilder();

        result.append("{\n");

        result.append(
                spaces(indent + 2)
        );

        result.append("\"type\": \"")
                .append(
                        escape(
                                value.getClass()
                                        .getSimpleName()
                        )
                )
                .append("\"");


        Field[] fields =
                value.getClass().getFields();

        for (Field field : fields) {

            if (
                    Modifier.isStatic(
                            field.getModifiers()
                    )
            ) {
                continue;
            }

            Object fieldValue =
                    field.get(value);

            result.append(",\n");

            result.append(
                    spaces(indent + 2)
            );

            result.append("\"")
                    .append(
                            escape(field.getName())
                    )
                    .append("\": ");

            result.append(
                    toJson(
                            fieldValue,
                            indent + 2,
                            visited
                    )
            );
        }

        result.append("\n");

        result.append(
                spaces(indent)
        );

        result.append("}");

        visited.remove(value);

        return result.toString();
    }


    private String spaces(int count) {
        return " ".repeat(count);
    }


    private String escape(String value) {

        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
    private String extractMapKey(Object key) {

        if (key == null) {
            return "null";
        }

        try {
            Field valueField =
                    key.getClass().getField("value");

            Object value =
                    valueField.get(key);

            if (value != null) {
                return String.valueOf(value);
            }

        } catch (
                NoSuchFieldException
                | IllegalAccessException ignored
        ) {
        }

        return String.valueOf(key);
    }
}