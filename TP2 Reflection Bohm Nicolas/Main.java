import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. Uso de la clase genérica Caja<T> ---");
        
        // Caja genérica para String[cite: 2]
        Caja<String> cajaDeTexto = new Caja<>();
        cajaDeTexto.guardar("Hola, esto es una caja con texto genérico");
        String texto = cajaDeTexto.obtener(); // No requiere casting explícito
        System.out.println("Caja<String> contiene: " + texto);

        // Caja genérica para Integer[cite: 2]
        Caja<Integer> cajaDeNumero = new Caja<>();
        cajaDeNumero.guardar(19);
        Integer numero = cajaDeNumero.obtener(); // No requiere casting explícito
        System.out.println("Caja<Integer> contiene: " + numero);

        System.out.println("\n--- 2. Comparación con colecciones sin genéricos ---");
        
        // Lista sin genéricos (Raw Types)[cite: 2]
        List listaSinGenericos = new ArrayList();
        listaSinGenericos.add("Texto de prueba");
        listaSinGenericos.add(42); // Almacenado genéricamente como Object

        // Recuperar requiere un casting manual y propenso a errores
        String elementoTexto = (String) listaSinGenericos.get(0);
        System.out.println("Elemento recuperado con casting: " + elementoTexto);

        // Ejemplo del peligro de no usar genéricos: compila bien pero explota en ejecución
        try {
            // Intentar recuperar un Integer tratándolo como String genera una excepción en tiempo de ejecución
            String errorCasting = (String) listaSinGenericos.get(1); 
        } catch (ClassCastException e) {
            System.out.println("¡Excepción capturada!: ClassCastException al intentar castear un Integer a String sin genéricos.");
        }

        System.out.println("\n--- 3. Conclusión sobre Genéricos ---");
        System.out.println("- Los genéricos aportan reutilización de código y seguridad de tipos en tiempo de compilación[cite: 2].");
        System.out.println("- Evitan errores imprevistos de conversión de tipos (ClassCastException) que antes solo se detectaban corriendo el programa.");
    }
}