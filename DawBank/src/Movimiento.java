import java.time.LocalDateTime;

public class Movimiento {


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
        fecha = LocalDateTime.now();

    }

    //metodo

    public String mostrarInfoMovimiento(){
        String mostrarinfo = "";
        mostrarinfo += "Tipo: " + tipo + "\n";
        mostrarinfo += "Cantidad: " + cantidad + "\n";
        mostrarinfo += "ID: " + id + "\n";
        mostrarinfo += "Fecha: " + fecha + "\n";
        return mostrarinfo;
    }


} //cierre class movimiento