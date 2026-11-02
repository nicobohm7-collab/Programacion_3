import java.util.Objects;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;

    // Constructor
    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    // equals() basado en el código del producto
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    // hashCode() consistente con equals() (utiliza el mismo atributo 'codigo')
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    // Representación en texto
    @Override
    public String toString() {
        return "Producto{codigo='" + codigo + "', nombre='" + nombre + "', precio=" + precio + "}";
    }
}