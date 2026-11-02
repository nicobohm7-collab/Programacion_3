import java.util.List;

public class Curso {
    private String nombre;
    private String profesor;
    private List<Estudiante> listaDeEstudiantes;

    public Curso(String nombre, String profesor, List<Estudiante> listaDeEstudiantes) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.listaDeEstudiantes = listaDeEstudiantes;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getProfesor() { return profesor; }
    public void setProfesor(String profesor) { this.profesor = profesor; }

    public List<Estudiante> getListaDeEstudiantes() { return listaDeEstudiantes; }
    public void setListaDeEstudiantes(List<Estudiante> listaDeEstudiantes) { this.listaDeEstudiantes = listaDeEstudiantes; }

    // Sobrescribimos toString() para formatear la salida jerárquica del curso y sus alumnos
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso: ").append(nombre).append("\n");
        sb.append("Profesor: ").append(profesor).append("\n");
        sb.append("Cantidad de alumnos: ").append(listaDeEstudiantes.size()).append("\n");
        sb.append("Listado de Estudiantes:\n");
        
        for (Estudiante estudiante : listaDeEstudiantes) {
            sb.append("  - ").append(estudiante.toString()).append("\n");
        }
        
        return sb.toString();
    }
}