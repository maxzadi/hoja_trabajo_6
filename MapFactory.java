import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapFactory {
    public static <K,V> Map<K,V> createMap(String type) {

        switch (type) {

            case "HashMap":
                return new HashMap<K,V>();

            case "TreeMap":
                return new TreeMap<K,V>();

            case "LinkedHashMap":
                return new LinkedHashMap<K,V>();

            default:
                throw new IllegalArgumentException("Tipo de mapa no válido");
        }
    }
}       