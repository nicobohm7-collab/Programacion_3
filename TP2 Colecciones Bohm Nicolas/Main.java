import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Crear el Set utilizando HashSet para garantizar la unicidad
        Set<Producto> productos = new HashSet<>();

        // Insertar productos, incluyendo duplicados por código
        productos.add(new Producto("P001", "Laptop Gamer"));
        productos.add(new Producto("P002", "Mouse Inalámbrico"));
        productos.add(new Producto("P003", "Teclado Mecánico"));
        
        // Intentar agregar duplicados (mismo código "P001" y "P002")
        productos.add(new Producto("P001", "Laptop Duplicada")); 
        productos.add(new Producto("P002", "Mouse Duplicado"));

        // Recorrer e imprimir el Set con bucle for-each
        System.out.println("--- Lista de Productos (Sin Duplicados) ---");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}