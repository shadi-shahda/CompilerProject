package RuntimeServer;

import java.util.List;
import java.util.Map;

public class JsonUtil {

    public static String toJson(Object value) {
        if (value == null) {
            return "null";
        }

        if (value instanceof String stringValue) {
            return "\"" + escape(stringValue) + "\"";
        }

        if (value instanceof Number || value instanceof Boolean) {
            return String.valueOf(value);
        }

        if (value instanceof Map<?, ?> mapValue) {
            return mapToJson(mapValue);
        }

        if (value instanceof List<?> listValue) {
            return listToJson(listValue);
        }

        return "\"" + escape(String.valueOf(value)) + "\"";
    }

    private static String mapToJson(Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean first = true;

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!first) {
                sb.append(",");
            }

            sb.append("\"")
                    .append(escape(String.valueOf(entry.getKey())))
                    .append("\":")
                    .append(toJson(entry.getValue()));

            first = false;
        }

        sb.append("}");
        return sb.toString();
    }

    private static String listToJson(List<?> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        boolean first = true;

        for (Object item : list) {
            if (!first) {
                sb.append(",");
            }

            sb.append(toJson(item));
            first = false;
        }

        sb.append("]");
        return sb.toString();
    }

    private static String escape(String value) {
        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}