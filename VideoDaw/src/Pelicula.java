import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    //ATRIBUTOS
    private String Cod;
    private String Titulo;
    private LocalDate FechaRegistro;
    private LocalDate FechaBaja;
    private LocalDate FechaAlquiler;
    private boolean isAlquilada;
    private String Fecha;

    public static int contadorPelicula = 0;

    //CONSTRUCTOR

    public Pelicula(String cod, String titulo, LocalDate fechaRegistro, LocalDate fechaBaja, LocalDate fechaAlquiler,
                    String isAlquilada, LocalDate fecha) {
        this.Cod = cod;
        this.Titulo = titulo;
        this.FechaRegistro = fechaRegistro;
        this.FechaBaja = fechaBaja;
        this.FechaAlquiler = fechaAlquiler;
        this.isAlquilada = true;
        contadorPelicula++;  //esperando que esto me ayude a contar el total de peliculas alquiladas por cliente

        fecha = LocalDate.from(LocalDateTime.now()); // esperando que esto me registre la fecha exacta de las consultas que hago
    }//constructor pelicula

    //GETTERS
    public String getCod() {
        return Cod;
    }
    public String getTitulo() {
        return Titulo;
    }
    public LocalDate getFechaRegistro() {
        return FechaRegistro;
    }
    public LocalDate getFechaBaja() {
        return FechaBaja;
    }
    public LocalDate getFechaAlquiler() {
        return FechaAlquiler;
    }
    public boolean isAlquilada() {
        return isAlquilada;
    }

    //METODO
    public String mostrarinfoPelicula() {
    String mostrarinfoPelicula = "";
    mostrarinfoPelicula = "Codigo: " + Cod;
    mostrarinfoPelicula = "Titulo: " + Titulo;
    mostrarinfoPelicula = "Fecha: " + FechaRegistro;
    mostrarinfoPelicula = "Fecha: " + FechaBaja;
    mostrarinfoPelicula = "Fecha: " + FechaAlquiler;
    return mostrarinfoPelicula;
    }


    /*Clase Película
La clase Película deberá tener los siguientes atributos:
1. Cod: identificador único de la Película (ej. P-0001).
2. Titulo:
3. Género: tipo ENUM
4. FechaRegistro: es del tipo LocalDate
5. FechaBaja: es del tipo LocalDate
6. FechaAlquiler: es del tipo LocalDateTime
7. IsAlquilada: tipo boolean
Además de los constructores y propiedades necesarios, deberá tener al menos un método
mostrarInfoPelicula() para mostrar toda la información de esa película.*/

} //CIERRE CLASS PELICULA
