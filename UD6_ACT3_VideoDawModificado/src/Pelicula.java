import java.io.Serial;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

public class Pelicula extends Articulo implements Serializable {

    @Serial
    private static final long serialVersionUID = -5452698551965501642L;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    // ATRIBUTOS

    private Genero genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    //CONTADOR

    public static int contadorPelicula = 0;


    //CONSTRUCTOR

    public Pelicula(String cod, String titulo, Genero genero) {
        super(cod, titulo); // Pasamos el código y el título a la clase Articulo
        this.genero = genero;
        this.isAlquilado = false; // Usa el nombre que pusimos en Articulo
        this.fechaAlquiler = null;
    }



    //GETTERS


    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public Genero getGenero() {
        return genero;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public static int getContadorPelicula() {
        return contadorPelicula;
    }

    //SETTERS


    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setAlquilada(boolean alquilada) {
        isAlquilada = alquilada;
    }

    // GENERADOR DE CÓDIGO ÚNICO
    private String generarCodigoPelicula() {
        contadorPelicula++;
        return String.format("P-%04d", contadorPelicula);
    }

    //TO STRING


    @Override
    public String toString() {
        return super.toString() + "Pelicula" +
                "dtf=" + dtf +
                ", genero=" + genero +
                ", fechaAlquiler=" + fechaAlquiler +
                ", isAlquilada=" + isAlquilada +
                '}';
    }

    //METODO MOSTRAR INFO

    public String mostrarInfoPelicula() {
        String info = "";
        info += "Cod: " + getCod() + "\n";
        info += "Titulo: " + getTitulo() + "\n";
        info += "Genero: " + getGenero() + "\n";
        info += "Fecha Registro: " + getFechaRegistro() + "\n";
        info += "Fecha Baja: " + getFechaBaja() + "\n";
        info += "Fecha Alquiler: " + getFechaAlquiler() + "\n";
        info += "¿Alquilada?: " + isAlquilada + "\n"; //COMO ES BOOLEANO SE USA ISALQUILADA EN LUGAR DE GET
        return info;
    }

}
