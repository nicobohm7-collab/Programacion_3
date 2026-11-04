public class Main {
    public static void main(String[] args) {
        // 2. Crear instancias de Usuario utilizando el patrón Builder
        Usuario usuario1 = Usuario.builder()
                .id(1L)
                .nombre("Nicolás")
                .email("nicolas@email.com")
                .build();

        Usuario usuario2 = Usuario.builder()
                .id(2L)
                .nombre("Malena")
                .email("malena@email.com")
                .build();

        // 3. Imprimir los datos por consola (toString generado automáticamente por @Data)
        System.out.println("--- Usuario 1 ---");
        System.out.println(usuario1);

        System.out.println("\n--- Usuario 2 ---");
        System.out.println(usuario2);
    }
}