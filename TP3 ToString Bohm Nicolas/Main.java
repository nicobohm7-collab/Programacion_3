import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> inventario = new ArrayList<>();

        // Creamos algunos productos de prueba
        Producto p1 = new Producto("P001", "Notebook", 1200.50);
        Producto p2 = new Producto("P002", "Mouse", 25.00);
        Producto p3 = new Producto("P001", "Notebook Gamer (Duplicado por código)", 1500.00); // Mismo código que p1

        // Intentamos agregar productos a la lista evitando duplicados con contains()
        agregarProductoUnico(inventario, p1);
        agregarProductoUnico(inventario, p2);
        agregarProductoUnico(inventario, p3); // Este debería ser rechazado por tener el código "P001"

        // Mostramos el resultado final de la lista
        System.out.println("--- Inventario Final ---");
        for (Producto p : inventario) {
            System.out.println(p);
        }
    }

    // Método auxiliar para evitar duplicados usando contains()
    public static void agregarProductoUnico(List<Producto> lista, Producto nuevoProducto) {
        if (lista.contains(nuevoProducto)) {
            System.out.println("¡Aviso! El producto con código '" + nuevoProducto.getCodigo() + "' ya existe en la lista. No se pudo agregar.");
        } else {
            lista.add(nuevoProducto);
            System.out.println("Producto agregado con éxito: " + nuevoProducto.getNombre());
        }
    }
}