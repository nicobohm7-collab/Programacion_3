import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 2. Usar HashMap<String, Curso> donde la clave es el código del curso
        Map<String, Curso> cursos = new HashMap<>();

        // 3. Agregar varios cursos
        cursos.put("MAT101", new Curso("Matemática I", "Ana Pérez"));
        cursos.put("PROG3", new Curso("Programación III", "Carlos Gómez"));
        cursos.put("BD1", new Curso("Bases de Datos I", "María Rodríguez"));

        // 4. Recuperar un curso por clave
        System.out.println("--- Búsqueda de curso por clave ---");
        String codigoBuscado = "PROG3";
        Curso cursoEncontrado = cursos.get(codigoBuscado);
        if (cursoEncontrado != null) {
            System.out.println("Código: " + codigoBuscado + " -> " + cursoEncontrado);
        }
        System.out.println();

        // 5. Recorrer el map con entrySet() e imprimir las entradas
        System.out.println("--- Listado completo de Cursos (entrySet) ---");
        for (Map.Entry<String, Curso> entry : cursos.entrySet()) {
            System.out.println("Clave (Código): " + entry.getKey() + " | Valor: " + entry.getValue());
        }
    }
}