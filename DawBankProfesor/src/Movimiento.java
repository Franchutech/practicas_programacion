import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    private int id;
    private LocalDateTime fecha; // CAMBIO
    private Tipo tipo;
    private double cantidad;

    private static int contadorMovimiento = 0;

    // Formatear solo para mostrar la fecha no para guardar
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Movimiento() {}

    public Movimiento(Tipo tipo, double cantidad) {
        this.id = contadorMovimiento;
        this.fecha = LocalDateTime.now(); // GUARDO el objeto fecha actual
        this.tipo = tipo;
        this.cantidad = cantidad;

        contadorMovimiento++;
    }

    // Getters (el de fecha ahora devuelve LocalDateTime)
    public int getId() { return this.id; }
    public LocalDateTime getFecha() { return this.fecha; }
    public Tipo getTipo() { return this.tipo; }
    public double getCantidad() { return this.cantidad; }

    // PUNTO 5: Elimino mostrarInfoMovimiento() y uso toString()
    @Override
    public String toString() {
        String infoMovimiento = "";
        infoMovimiento += "ID: " + this.id + "\n";
        infoMovimiento += "Fecha: " + this.fecha.format(dtf) + "\n";
        infoMovimiento += "Tipo: " + this.tipo + "\n";
        infoMovimiento += "Cantidad: " + this.cantidad + "€" + "\n";
        return infoMovimiento;
    }
}