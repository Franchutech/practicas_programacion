import java.io.Serializable;

// La clase debe ser Serializable para poder usarse en ficheros binarios

public class Producto implements Serializable {
    // Atributos solicitados
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    // Constructor
    public Producto(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Método toString para mostrar la información fácilmente

    @Override
    public String toString() {
        return "ID: " + codigo + " | Nombre: " + nombre + " | Stock: " + cantidad + " | Precio: " + precio + "€";
    }
}