import java.util.Arrays;
import java.util.List;

public class Main {

    // Método genérico para imprimir listas de cualquier tipo de dato[cite: 3]
    public static <T> void imprimirLista(List<T> lista) {
        for (T elemento : lista) {
            System.out.println("Elemento: " + elemento);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Lista de Cadenas (String) ---");
        List<String> cadenas = Arrays.asList("Java", "Genéricos", "UTN");
        imprimirLista(cadenas); //[cite: 3]

        System.out.println("\n--- 2. Lista de Enteros (Integer) ---");
        List<Integer> enteros = Arrays.asList(19, 2026, 3);
        imprimirLista(enteros); //[cite: 3]
    }
}