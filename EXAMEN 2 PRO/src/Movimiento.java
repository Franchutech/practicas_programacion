import java.time.LocalDate;

/**
 * Movimiento - Representa operaciones bancarias (ingreso/retirada)
 */
public class Movimiento {

    public enum Tipo { INGRESO, RETIRADA }

    private int id;
    private Tipo tipo;
    private double cantidad;
    private LocalDate fecha;

    public Movimiento(int id, Tipo tipo, double cantidad) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = LocalDate.now();
    }

    /** Muestra información del movimiento */
    public void mostrarInfo() {
        System.out.println("ID: " + id + " | " + tipo + " | " + cantidad + "€ | Fecha: " + fecha);
    }
}
