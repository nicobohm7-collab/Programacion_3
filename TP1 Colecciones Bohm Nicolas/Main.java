import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear la lista de alumnos utilizando List / ArrayList
        List<Alumno> alumnos = new ArrayList<>();

        // Agregar alumnos a la lista (permitiendo duplicados)
        alumnos.add(new Alumno("Nicolás", 9.5));
        alumnos.add(new Alumno("Malena", 10.0));
        alumnos.add(new Alumno("Gabriel", 8.0));
        alumnos.add(new Alumno("Nicolás", 9.5)); // Duplicado para demostrar la regla de List

        // Recorrer e imprimir la lista con bucle for-each
        System.out.println("--- Lista de Alumnos ---");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
}