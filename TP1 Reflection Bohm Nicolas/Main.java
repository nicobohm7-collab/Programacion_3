import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            // Obtener la referencia de la clase Persona
            Class<?> clasePersona = Class.forName("Persona");

            // 1. Obtener e imprimir sus constructores
            System.out.println("--- 1. Constructores de la clase ---");
            Constructor<?>[] constructores = clasePersona.getDeclaredConstructors();
            for (Constructor<?> constructor : constructores) {
                System.out.println(constructor);
            }

            // 2. Instanciar un objeto utilizando reflection
            Constructor<?> constructorParam = clasePersona.getConstructor(String.class, int.class);
            Object personaObj = constructorParam.newInstance("Nicolás", 19);
            System.out.println("\n--- 2. Objeto instanciado por reflection correctamente ---");

            // 3. Modificar el valor del atributo privado 'nombre' en tiempo de ejecución
            Field campoNombre = clasePersona.getDeclaredField("nombre");
            campoNombre.setAccessible(true); // Ignorar el encapsulamiento privado
            campoNombre.set(personaObj, "Carlos");
            System.out.println("--- 3. Atributo 'nombre' modificado a 'Carlos' ---");

            // 4. Invocar un método que muestre la información de la persona
            Method metodoMostrar = clasePersona.getMethod("mostrarInformacion");
            System.out.print("--- 4. Información actual: ");
            metodoMostrar.invoke(personaObj);

            // 5. Modificar el acceso e invocar el método privado 'saludar()'
            Method metodoSaludar = clasePersona.getDeclaredMethod("saludar");
            metodoSaludar.setAccessible(true); // Permitir acceso al método privado
            String resultadoSaludo = (String) metodoSaludar.invoke(personaObj);
            System.out.println("--- 5. Resultado del método privado saludar(): " + resultadoSaludo + " ---");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}