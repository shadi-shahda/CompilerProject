package FinalGeneration;

import java.util.HashMap;
import java.util.Map;

public class PythonRuntimeContext {
    private final Map<String, Object> globals = new HashMap<>();

    public void put(String key, Object value) {
        globals.put(key, value);
    }

    public Object get(String key) {
        return globals.get(key);
    }

    public boolean contains(String key) {
        return globals.containsKey(key);
    }

    public Map<String, Object> getGlobals() {
        return globals;
    }

    @Override
    public String toString() {
        return globals.toString();
    }
}
