public class Main {
    public static void main(String[] args) {
        // 1. Instanciar utilizando el constructor vacío (@NoArgsConstructor) y usar setters
        Persona persona1 = new Persona();
        persona1.setNombre("Nicolás");
        persona1.setEdad(19);

        // 2. Instanciar utilizando el constructor lleno (@AllArgsConstructor)
        Persona persona2 = new Persona("Malena", 19);

        // Mostrar los atributos en consola usando getters
        System.out.println("--- Persona 1 (Constructor vacío + Setters) ---");
        System.out.println("Nombre: " + persona1.getNombre() + " | Edad: " + persona1.getEdad());

        System.out.println("\n--- Persona 2 (Constructor lleno) ---");
        System.out.println("Nombre: " + persona2.getNombre() + " | Edad: " + persona2.getEdad());
    }
}