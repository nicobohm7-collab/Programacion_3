import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Lista de ejemplo para probar las operaciones
        List<Alumno> alumnos = Arrays.asList(
            new Alumno("Ana", 8.5, "1A"),
            new Alumno("Carlos", 6.0, "1B"),
            new Alumno("Beatriz", 9.0, "1A"),
            new Alumno("Daniel", 4.5, "1B"),
            new Alumno("Elena", 7.5, "1A"),
            new Alumno("Federico", 8.0, "1B"),
            new Alumno("Gabriel", 6.5, "1A")
        );

        // ==========================================
        // 1. Nombres de alumnos aprobados (nota >= 7) en mayúsculas y ordenados
        // ==========================================
        System.out.println("--- 1. Alumnos aprobados (mayúsculas y ordenados) ---");
        List<String> aprobadosMayusculas = alumnos.stream()
            .filter(a -> a.getNota() >= 7.0)                // Intermedia: filtra nota >= 7
            .map(a -> a.getNombre().toUpperCase())          // Intermedia: transforma a mayúsculas
            .sorted()                                       // Intermedia: ordena alfabéticamente
            .collect(Collectors.toList());                  // Terminal: recolecta en una lista

        aprobadosMayusculas.forEach(System.out::println);


        // ==========================================
        // 2. Calcular el promedio general de notas
        // ==========================================
        System.out.println("\n--- 2. Promedio general de notas ---");
        double promedioGeneral = alumnos.stream()
            .mapToDouble(Alumno::getNota)                   // Intermedia: mapea a DoubleStream
            .average()                                      // Terminal: calcula la media
            .orElse(0.0);                                   // Valor por defecto si la lista está vacía

        System.out.println("Promedio: " + promedioGeneral);


        // ==========================================
        // 3. Agrupar alumnos por curso usando Collectors.groupingBy()
        // ==========================================
        System.out.println("\n--- 3. Alumnos agrupados por curso ---");
        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
            .collect(Collectors.groupingBy(Alumno::getCurso)); // Terminal: agrupa por clave 'curso'

        // Imprimir el resultado del agrupamiento
        alumnosPorCurso.forEach((curso, lista) -> {
            System.out.println("Curso " + curso + ": " + lista);
        });


        // ==========================================
        // 4. Obtener los 3 mejores promedios
        // ==========================================
        System.out.println("\n--- 4. Los 3 mejores promedios ---");
        List<Alumno> top3Alumnos = alumnos.stream()
            .sorted(Comparator.comparingDouble(Alumno::getNota).reversed()) // Intermedia: ordena de mayor a menor nota
            .limit(3)                                                       // Intermedia: limita a los primeros 3
            .collect(Collectors.toList());                                  // Terminal: recolecta en lista

        top3Alumnos.forEach(a -> System.out.println(a.getNombre() + " - " + a.getNota()));
    }
}