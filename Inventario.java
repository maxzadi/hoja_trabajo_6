import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Inventario {

    public static void cargarInventario(String archivo, Map<String, List<String>> mapa) {


        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split("\\|");

                String categoria = partes[0];
                String producto = partes[1];

                mapa.putIfAbsent(categoria, new ArrayList<>());
                mapa.get(categoria).add(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}