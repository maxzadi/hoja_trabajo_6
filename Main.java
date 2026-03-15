import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Selección de implementacion
        System.out.println("Seleccione la implementación de Map que desea:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int opcion = scanner.nextInt();        

        Map<String, List<String>> mapa;
        
        if(opcion == 1) mapa = MapFactory.createMap("HashMap");
        else if(opcion == 2)  mapa = MapFactory.createMap("TreeMap"); 
        else mapa = MapFactory.createMap("LinkedHashMap");

        Inventario.cargarInventario("inventario.txt", mapa);
    }
}