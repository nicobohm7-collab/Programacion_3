import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear objetos Producto completos
        Producto prod1 = new Producto("P001", "Clean Code", 45.50, "Robert C. Martin");
        Producto prod2 = new Producto("P002", "Effective Java", 60.00, "Joshua Bloch");

        // Crear objetos ProductoDTO cargándolos mediante constructores y setters
        ProductoDTO dto1 = new ProductoDTO();
        dto1.setCodigo(prod1.getCodigo());
        dto1.setNombre(prod1.getNombre());
        dto1.setPrecio(prod1.getPrecio());

        ProductoDTO dto2 = new ProductoDTO(prod2.getCodigo(), prod2.getNombre(), prod2.getPrecio());

        // Guardar los objetos ProductoDTO en una lista
        List<ProductoDTO> listaProductosDTO = new ArrayList<>();
        listaProductosDTO.add(dto1);
        listaProductosDTO.add(dto2);

        // Mostrar la lista en consola
        System.out.println("--- Listado de Productos DTO ---");
        for (ProductoDTO dto : listaProductosDTO) {
            System.out.println(dto);
        }
    }
}