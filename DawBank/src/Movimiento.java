import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    //atributos
    private int id;
    private LocalDateTime fecha;
    private String tipo;
    private double cantidad;

    public static int contadorMovimientos = 0;

//constructor

    public Movimiento(String tipo, double cantidad){
        this.tipo = tipo;
        this.cantidad = cantidad;

        this.id = contadorMovimientos;
        contadorMovimientos++;
        fecha = LocalDateTime.now();  //este pone el momento exacto de cada movimiento

    }

    //getters

    public int getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public double getCantidad() {
        return cantidad;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }

    //metodos

    public String mostrarInfoMovimiento(){
        String mostrarinfo = "";
        mostrarinfo += "Tipo: " + tipo + "\n";
        mostrarinfo += "Cantidad: " + cantidad + "\n";
        mostrarinfo += "ID: " + id + "\n";
        mostrarinfo += "Fecha: " + fecha.format(dtf) + "\n";
        return mostrarinfo;
    }

} //cierre class movimiento