import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Lista de ejemplo con diversos productos
        List<Producto> productos = Arrays.asList(
            new Producto("Laptop Pro", "Tecnología", 1200.0, 5),
            new Producto("Mouse Inalámbrico", "Tecnología", 45.0, 30),
            new Producto("Teclado Mecánico", "Tecnología", 85.0, 15),
            new Producto("Cafetera Automática", "Hogar", 180.0, 8),
            new Producto("Licuadora Vaso de Vidrio", "Hogar", 95.0, 12),
            new Producto("Escritorio Elevable", "Oficina", 350.0, 4)
        );

        // =========================================================================
        // 1. Listar los productos con precio mayor a 100, ordenados por precio descendente.
        // =========================================================================
        System.out.println("--- 1. Productos con precio > 100 (orden descendente) ---");
        List<Producto> filtradosOrdenados = productos.stream()
            .filter(p -> p.getPrecio() > 100.0) // Operación intermedia: filtra precio > 100[cite: 2]
            .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed()) // Orden descendente
            .collect(Collectors.toList());

        filtradosOrdenados.forEach(System.out::println);


        // =========================================================================
        // 2. Agrupar productos por categoría y calcular el stock total.
        // =========================================================================
        System.out.println("\n--- 2. Stock total por categoría ---");
        Map<String, Integer> stockPorCategoria = productos.stream()
            .collect(Collectors.groupingBy(
                Producto::getCategoria,
                Collectors.summingInt(Producto::getStock) // Suma el stock de cada grupo
            ));

        stockPorCategoria.forEach((categoria, stockTotal) -> 
            System.out.println("Categoría: " + categoria + " | Stock Total: " + stockTotal)
        );


        // =========================================================================
        // 3. Generar un String separando con ";" cada producto que contenga nombre y precio, 
        //    usando map + collect(joining).
        // =========================================================================
        System.out.println("\n--- 3. Reporte en String con nombre y precio ---");
        String reporteString = productos.stream()
            .map(p -> p.getNombre() + " ($" + p.getPrecio() + ")") // Transforma a formato texto[cite: 2]
            .collect(Collectors.joining("; "));                    // Une los elementos separados por ";"[cite: 2]

        System.out.println(reporteString);


        // =========================================================================
        // 4. Calcular el precio promedio general y por categoría.
        // =========================================================================
        System.out.println("\n--- 4. Precios promedio general y por categoría ---");
        
        // Promedio general
        double precioPromedioGeneral = productos.stream()
            .mapToDouble(Producto::getPrecio)
            .average()
            .orElse(0.0);
        System.out.println("Precio promedio general: $" + precioPromedioGeneral);

        // Promedio por categoría
        Map<String, Double> promedioPorCategoria = productos.stream()
            .collect(Collectors.groupingBy(
                Producto::getCategoria,
                Collectors.averagingDouble(Producto::getPrecio) // Calcula la media aritmética del precio
            ));

        promedioPorCategoria.forEach((categoria, promedio) -> 
            System.out.println("Categoría: " + categoria + " | Precio Promedio: $" + promedio)
        );
    }
}