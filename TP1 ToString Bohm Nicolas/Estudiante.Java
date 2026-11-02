public class Estudiante extends Persona {
    private String carrera;

    // Constructor
    public Estudiante(String nombre, int edad, String carrera) {
        super(nombre, edad);
        this.carrera = carrera;
    }

    // Getters y Setters
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    // Sobrescribimos toString() integrando los datos de Persona y Estudiante
    @Override
    public String toString() {
        return "Estudiante{" + super.toString() + ", carrera='" + carrera + "'}";
    }
}