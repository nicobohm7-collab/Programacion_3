import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creamos la lista de alumnos para el primer curso
        List<Estudiante> alumnosCurso1 = new ArrayList<>();
        alumnosCurso1.add(new Estudiante("Juan", 20, "Ingeniería en Sistemas"));
        alumnosCurso1.add(new Estudiante("María", 22, "Diseño Gráfico"));
        alumnosCurso1.add(new Estudiante("Pedro", 21, "Medicina"));

        // Creamos la lista de alumnos para el segundo curso
        List<Estudiante> alumnosCurso2 = new ArrayList<>();
        alumnosCurso2.add(new Estudiante("Lucía", 23, "Arquitectura"));
        alumnosCurso2.add(new Estudiante("Marcos", 19, "Ingeniería en Sistemas"));

        // Instanciamos los cursos (Composición)
        Curso curso1 = new Curso("Estructuras de Datos", "Prof. Carlos Ruiz", alumnosCurso1);
        Curso curso2 = new Curso("Programación III", "Prof. Ana Gómez", alumnosCurso2);

        // Imprimimos los cursos en consola (invoca automáticamente al toString() de Curso)
        System.out.println(curso1);
        System.out.println("--------------------------------------------------");
        System.out.println(curso2);
    }
}