import java.util.Scanner;

public class Libro {


   // Atributos atributos
   // campos de

    //la clase(encapsulacion)

    private String titulo;
    private String autor;
    private int nPaginas;
    private String ISBN;
    private String editora;
    private String fechaPublicaciones;
    private int edicion;


//Constructor / Constructores

    public Libro(String titulo, String ISBN, String fechaPublicaciones, String autor) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.fechaPublicaciones = fechaPublicaciones;
        this.autor = autor;
        this.edicion = 1;
        this.nPaginas = 1;
        this.editora = "Auto-publicaciòn";
    }

    //constructor con todos los atributos.
    public Libro(String titulo, String autor, String ISBN, String fechaPublicaciones,
                 String editora, int nPaginas, String edicion) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.fechaPublicaciones = fechaPublicaciones;
        this.autor = autor;
        this.editora = editora;
        this.setnPaginas(nPaginas);
        this.edicion = Integer.parseInt(edicion);
    }
    /*
     * DEFINIMOS LOS GETTER Y SETTER DE LOS ATRIBUTOS
     * */
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getFechaPublicaciones() {
        return this.fechaPublicaciones;
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
    }
    public String getEditora() {
        return this.editora;
}
    public void setEditora(String editora) {
        this.editora = editora;
}

//METODOS

    /**Metodo mostrar informacion del libro, se encarga de preprarlo para poder pintar cada libro despues*/

    public String infoLibro() {
        String infoLibro = "";
        infoLibro += "Titulo: " + this.titulo + "\n";
        infoLibro += "Autor: " + this.autor + "\n";
        infoLibro += "ISBN: " + this.ISBN + "\n";
        infoLibro += "Editora: " + this.editora + "\n";
        infoLibro += "N<UNK> Paginas: " + this.nPaginas + "\n";
        infoLibro += "Edicion: " + this.edicion + "\n";
        infoLibro += "Fecha: " + this.fechaPublicaciones + "\n";

        String info = String.format("Libro - Titulo: %s, Autor: %s, Fecha publicación: %s, Numero de paginas: %s, Edicion: %s, ISBN: %s",
                this.titulo, this.autor, this.editora, this.nPaginas, this.edicion, this.fechaPublicaciones, this.ISBN);

        return infoLibro;
    }
}// main class


