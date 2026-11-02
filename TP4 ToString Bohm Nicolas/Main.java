import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Creamos un HashSet para almacenar productos únicos
        Set<Producto> inventarioSet = new HashSet<>();

        // Instanciamos productos (p1 y p3 comparten el mismo código "P001")
        Producto p1 = new Producto("P001", "Notebook", 1200.50);
        Producto p2 = new Producto("P002", "Mouse", 25.00);
        Producto p3 = new Producto("P001", "Notebook Gamer (Duplicado)", 1500.00); 

        // Agregamos los productos al HashSet
        inventarioSet.add(p1);
        inventarioSet.add(p2);
        inventarioSet.add(p3); // Este elemento será rechazado automáticamente por el HashSet

        // Mostramos el contenido final de la colección
        System.out.println("--- Inventario en HashSet (Sin duplicados) ---");
        for (Producto p : inventarioSet) {
            System.out.println(p);
        }
        
        System.out.println("\nTotal de productos únicos en el Set: " + inventarioSet.size());
    }
}