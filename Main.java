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
        scanner.nextLine();      
        System.out.println("\n");

        Map<String, List<String>> mapa; //                  Mapa del inventario
        Map<String, Integer> coleccion; //                  Mapa con la cantidad de producto del usuario
        Map<String, Map<String, Integer>> usuario; //       Mapa con categoria y producto del usuario
        
        if(opcion == 1) {
            mapa = MapFactory.createMap("HashMap");
            coleccion = MapFactory.createMap("HashMap");
            usuario = MapFactory.createMap("HashMap");

        
        }
        else if(opcion == 2) {
            mapa = MapFactory.createMap("TreeMap"); 
            coleccion = MapFactory.createMap("TreeMap"); 
            usuario = MapFactory.createMap("TreeMap"); 


        }
        else {
            mapa = MapFactory.createMap("LinkedHashMap");
            coleccion = MapFactory.createMap("LinkedHashMap");
            usuario = MapFactory.createMap("LinkedHashMap");


        }

        Inventario.cargarInventario("inventario.txt", mapa);

        // Menu de operaciones
        while(opcion != 0){
        System.out.println("Seleccione una operacion:");
        System.out.println("0. Salir");
        System.out.println("1. Agregar un producto a la colección del usuario");
        System.out.println("2. Mostrar la categoría de un producto");
        System.out.println("3. Mostrar articulos de la coleccion");
        System.out.println("4. Mostrar articulos de la coleccion(ordenados por categoría)");
        System.out.println("5. Mostrar el producto y la categoría del inventario");
        System.out.println("6. Mostrar el producto y la categoría existentes del inventario(ordenados por categoría)");
        opcion = scanner.nextInt();  
        scanner.nextLine();      
        System.out.println("\n");
        
        String categoria;
        String producto;
        Integer cantidad;

        switch (opcion) {
            case 1:
                System.out.println("Ingresa la categoria del producto: ");
                categoria = scanner.nextLine().trim();
                if(!mapa.containsKey(categoria)){
                    System.out.println("La categoría no existe.");
                    break;
                }
                System.out.println("Ingresa el nombre del producto: ");
                producto = scanner.nextLine().trim();
                if(mapa.get(categoria).contains(producto) == false){
                    System.out.println("El producto no existe en esta categoría.");
                    break;
                }
                System.out.println("Ingrese la cantidad de productos: ");
                cantidad = scanner.nextInt();
                scanner.nextLine();      
                System.out.println("\n");

                usuario.putIfAbsent(categoria, coleccion);
                
                Map<String, Integer> nuevo = usuario.get(categoria);

                nuevo.put(producto, nuevo.getOrDefault(producto, 0) + cantidad);
                
                break;
        
            default:
                break;
        }
        }

    }
    
}