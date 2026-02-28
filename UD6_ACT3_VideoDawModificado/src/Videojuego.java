import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Videojuego extends Articulo implements Serializable{


    @Serial
    private static final long serialVersionUID = -7404079771132447219L;


    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    // ATRIBUTOS

    private GeneroVideoJuego generovjuego;
    private PLATAFORMAVJ plataformavj;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilado;

    //CONTADOR

    public static int contadorVideoJuegos = 0;


    //CONSTRUCTOR

    public Videojuego(String cod, String titulo, GeneroVideoJuego generovjuego, PLATAFORMAVJ plataformavj) {
        super(cod, titulo);
        this.generovjuego = generovjuego;
        this.plataformavj = plataformavj;
        this.fechaAlquiler = null;
        this.isAlquilado = false;
    }



    //GETTERS

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public GeneroVideoJuego getGenerovjuego() {
        return generovjuego;
    }
    public PLATAFORMAVJ getPlataformavj() {
        return plataformavj;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilado;
    }

    public static int getContadorVideoJuegos() {
        return contadorVideoJuegos;
    }


    //SETTERS

    public void setDtf(DateTimeFormatter dtf) {
        this.dtf = dtf;
    }

    public void setGenerovjuego(GeneroVideoJuego generovjuego) {
        this.generovjuego = generovjuego;
    }

    public void setPlataformavj(PLATAFORMAVJ plataformavj) {
        this.plataformavj = plataformavj;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setAlquilada(boolean alquilada) {
        isAlquilado = alquilada;
    }


    //TO STRING


    @Override
    public String toString() {
        return super.toString() + "VideoJuegos" +
                "dtf=" + dtf +
                ", genero=" + generovjuego +
                ", plataforma=" + plataformavj +
                ", fechaAlquiler=" + fechaAlquiler +
                ", isAlquilado=" + isAlquilado +
                '}';
    }

    //METODO MOSTRAR INFO

    public String mostrarInfoVideoJuego() {
        String info = "";
        info += "Cod: " + getCod() + "\n";
        info += "Titulo: " + getTitulo() + "\n";
        info += "Genero: " + getGenerovjuego()+ "\n";
        info += "Plataforma: " + getPlataformavj() + "\n";
        info += "Fecha Registro: " + getFechaRegistro() + "\n";
        info += "Fecha Baja: " + getFechaBaja() + "\n";
        info += "Fecha Alquiler: " + getFechaAlquiler() + "\n";
        info += "¿Alquilado?: " + isAlquilada() + "\n"; //COMO ES BOOLEANO SE USA ISALQUILADA EN LUGAR DE GET
        return info;
    }


}
