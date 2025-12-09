import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    // ATRIBUTOS
    private String cod;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public static int contadorPelicula = 0;

    // CONSTRUCTOR PRINCIPAL
    public Pelicula(String titulo, Genero genero) {
        this.cod = generarCodigoPelicula();
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDate.now();
        this.fechaBaja = null;
        this.fechaAlquiler = null;
        this.isAlquilada = false;
    }

    // GENERADOR DE CÓDIGO ÚNICO
    private String generarCodigoPelicula() {
        contadorPelicula++;
        return String.format("P-%04d", contadorPelicula);
    }

    // GETTERS
    public String getCod() {
        return cod;
    }
    public String getTitulo() {
        return titulo;
    }
    public Genero getGenero() {
        return genero;
    }
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }
    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }
    public boolean isAlquilada() {
        return isAlquilada;
    }

    // SETTERS
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    public void setAlquilada(boolean alquilada) {
        this.isAlquilada = alquilada;
        this.fechaAlquiler = alquilada ? LocalDateTime.now() : null;
    }

    // MÉTODO MOSTRAR INFO
    public String mostrarInfoPelicula() {
        String info = "";
        info += "Codigo: " + cod + "\n";
        info += "Titulo: " + titulo + "\n";
        info += "Genero: " + genero + "\n";
        info += "Fecha Registro: " + fechaRegistro + "\n";
        info += "Fecha Baja: " + fechaBaja + "\n";
        info += "Fecha Alquiler: " + fechaAlquiler + "\n";
        info += "¿Alquilada?: " + isAlquilada + "\n";
        return info;
    }

}
