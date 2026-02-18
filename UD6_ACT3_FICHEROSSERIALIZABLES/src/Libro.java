import java.io.Serializable;
import java.time.LocalDate;



public class Libro implements Serializable{


    private static final long serialVersionUID = 8923139209908422753L;


    //CREO LOS ATRIBUTOS

    private String autor;
    private String ISBN;
    private String titulo;
    private LocalDate fechaPublicacion;


    //CREO EL CONSTRUCTOR

    public Libro(LocalDate fechaPublicacion, String titulo, String ISBN, String autor) {
        this.fechaPublicacion = fechaPublicacion;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.autor = autor;
    }

    //GETTERS
    //Para poder manipular la informacion

    public String getAutor() {
        return autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    //SETTERS
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    //TO STRING PARA PODER IMPRIMIR BONITO LAS COSAS


    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }
}
