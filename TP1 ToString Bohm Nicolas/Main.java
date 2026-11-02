import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creamos la lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();

        // Agregamos los objetos a la lista con los datos del ejemplo
        estudiantes.add(new Estudiante("Juan", 20, "Ingeniería en Sistemas"));
        estudiantes.add(new Estudiante("María", 22, "Diseño Gráfico"));
        estudiantes.add(new Estudiante("Pedro", 21, "Medicina"));

        // Mostramos el contenido completo imprimiendo directamente la lista
        System.out.println(estudiantes);
    }
}