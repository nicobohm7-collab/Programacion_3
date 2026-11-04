public class Persona {
    private String nombre;
    private int edad;

    public Persona() {
        this.nombre = "Sin nombre";
        this.edad = 0;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    private String saludar() {
        return "Hola";
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " | Edad: " + edad);
    }
}