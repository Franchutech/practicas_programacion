import java.time.LocalDate;
import java.io.Serializable;
import java.time.LocalDateTime;

//CLASE MADRE DE LOS ARTICULOS

public class Articulo implements Serializable {

    private static final long serialVersionUID = -1050932028895202237L;


    //ATRIBUTOS

    protected String cod;
    protected String titulo;
    protected LocalDate fechaRegistro;
    protected LocalDate fechaBaja;
    protected boolean isAlquilado;
    protected LocalDateTime fechaAlquiler;


    //CONSTRUCTOR

    public Articulo(String cod, String titulo) {
        this.cod = cod;
        this.titulo = titulo;

        this.fechaRegistro = LocalDate.now(); //la fecha en la que se hace el registro
        this.fechaBaja = null; //un articulo nuevo no tendria fecha de baja aun
        this.isAlquilado = false;
        this.fechaAlquiler = null;
    }

    //GETTERS

    public String getCod() {
        return cod;
    }

    public String getTitulo() {
        return titulo;
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


    //SETTERS

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public boolean isAlquilado() {
        return isAlquilado;
    }
    public void setAlquilado(boolean alquilado) {
        isAlquilado = alquilado;
    }
    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;

    }


    //TO STRING
    @Override
    public String toString() {
        return "Articulo{" +
                "cod='" + cod + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaBaja=" + fechaBaja +
                '}';
    }

} //CIERRE CLASE ARTICULO
