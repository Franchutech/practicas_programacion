import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Libro {

    private static int contadorTotal = 0;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    //Atributos o campos de la clase (encapsulacion)
    private final int id;
    private String titulo;
    private String autor;
    private int nPaginas;
    private String ISBN;
    private String editora;
    private String fechaPublicacion;
    private int edicion;

    //Constructor / Constructores
    //Constructor con atributos imprescindibles
    public Libro(String titulo, String autor, String ISBN, String fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.edicion = 1;
        this.nPaginas = 1;
        this.editora = "Auto-Publicacion";

        this.id = contadorTotal;
        contadorTotal++;

        //Ejemplo de fecha instantanea
        this.fechaPublicacion = LocalDateTime.now().format(dtf);
    }

    //Constructor con todos los atributos
    public Libro(String titulo, String autor, String ISBN, String fechaPublicacion,
                 String editora, int edicion, int nPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.edicion = edicion;
        this.setnPaginas(nPaginas);
        this.editora = editora;

        this.id = contadorTotal;
        contadorTotal++;

        //Ejemplo de fecha instantanea
        this.fechaPublicacion = LocalDateTime.now().format(dtf);
    }

    /*
        DEFINIMOS LOS GETTER Y SETTER DE LOS ATRIBUTOS
    */

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getFechaPublicacion() {
        return this.fechaPublicacion;
    }

    public int getEdicion() {
        return this.edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getnPaginas() {
        return this.nPaginas;
    }
    public void setnPaginas(int nPaginas) {
        if(nPaginas > 0){
            this.nPaginas = nPaginas;
        }
        else{
            if(this.nPaginas < 1){
                this.nPaginas = 1;
            }
        }
    }

    public String getEditora() {
        return this.editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    //Metodos

    /**
     * Metodo: mostrar informacion del libro
     */
    public String infoLibro(){
        String infoLibro = "";
        infoLibro = "Titulo: " + this.titulo + "\n";
        infoLibro += "Autor: " + this.autor + "\n";
        infoLibro += "ISBN: " + this.ISBN + "\n";
        infoLibro += "Fecha de publicacion: " + this.fechaPublicacion + "\n";
        infoLibro += "Editora: " + this.editora + "\n";
        infoLibro += "Edicion: " + this.edicion + "\n";
        infoLibro += "NPaginas: " + this.nPaginas + "\n";

        //Opcion alternativa usando String-format
        String info = String.format("Libro - Titulo: %s, Autor: %s , Fecha publicacion: %s, Numero de paginas: %s, Edicion: %s, Editorial: %s, ISBN: %s"
                , this.titulo, this.autor, this.fechaPublicacion, this.nPaginas, this.edicion, this.editora, this.ISBN);

        return infoLibro;
    }
}
