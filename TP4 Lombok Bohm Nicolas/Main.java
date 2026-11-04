import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciar varios objetos Producto
        Producto prod1 = new Producto("P001", "Teclado Mecánico", "TechStore Arg", 45000.0);
        Producto prod2 = new Producto("P002", "Mouse Inalámbrico", "GlobalTech", 22500.0);

        // 2. Instanciar ProductoRecord utilizando los datos de los objetos Producto
        ProductoRecord record1 = new ProductoRecord(prod1.getCodigo(), prod1.getNombre(), prod1.getPrecio());
        ProductoRecord record2 = new ProductoRecord(prod2.getCodigo(), prod2.getNombre(), prod2.getPrecio());

        // 3. Guardarlos en una lista
        List<ProductoRecord> listaProductos = new ArrayList<>();
        listaProductos.add(record1);
        listaProductos.add(record2);

        // 4. Mostrar los productos en consola
        System.out.println("--- Listado de Productos (Records) ---");
        for (ProductoRecord producto : listaProductos) {
            System.out.println(producto);
        }
    }
}