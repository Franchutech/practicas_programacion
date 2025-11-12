public class Biblioteca {

    //ATRIBUTOS encapsulados

    private String codigo;
    private String nombre;
    private String direccion;
    private String email;
    private String nTelefono;

    //Coleccion (array) de libros en la biblioteca
    private Libro[] libros;
    private int nLibrosActuales;
    private final int dimensionInicial = 100;
    //recordar que final es para que no cambie en todo el programa (private final int)

    //Constructor
    public Biblioteca(String codigo, String nombre, String direccion, String email, String nTelefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.nTelefono = nTelefono;

        //se define el tamaño del array con la dimension inicial
        this.libros = new Libro[this.dimensionInicial];

        //esto es importante para la smartbiblioteca
        this.nLibrosActuales = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public String getnTelefono() {
        return this.nTelefono;
    }

    //setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }
    //acumulador booleano (para insertar cosas a la coleccion

    public boolean insertarLibro(Libro libro) {
        boolean resultado = false;

        //Toda la logica para insertar un libro
        if (libro != null) {  //para evitar errores de NULL en el futuro
            if (this.nLibrosActuales < this.dimensionInicial) {
                //tengo espacios suficientes
                this.libros[this.nLibrosActuales] = libro;
                resultado = true;
                this.nLibrosActuales++;
            } else {
                //no tengo hueCos suficientes
                this.ampliarDiemsnionBiblioteca();
                this.libros[this.nLibrosActuales] = libro;
                resultado = true;
                this.nLibrosActuales++;

            }

        }
        return resultado;
    }

    //Por orden es ideal poner la parte "privada" abajo del codigo"
    //METODOS AUXILIARES
    //Metodo ampliar dimension biblioteca

    public Libro getLibrobyISBN(String ISBN) {
        int index = -1;
        for (int i = 0; i < this.nLibrosActuales; i++) {
            if(this.libros[i] != null){
                if(this.libros[i].getISBN().equals(ISBN)){
                    index = i;
                    break;  // para eliminar la primera ocurrencia
                }
            }
        }
        if(index == -1){
            return null;
        }
        else{
            return this.libros[index];
        }
    }


    public boolean eliminarLibro(Libro libro) {
        boolean resultado = false;

        int index = -1;

        if (libro != null) {
            for (int i = 0; i < this.nLibrosActuales; i++) {
                if (this.libros[i] != null) {
                    if (this.libros[i].getISBN().equalsIgnoreCase(libro.getISBN())) {
                        index = i;
                        break; // para eliminar la primera ocurrencia
                    }
                }
            }
            if (index != -1) {
                this.libros[index] = null;
                resultado = true;

                //Opcion 1(Marco): Mover solo el ultimo (si el orden no tiene sentido o me da igual)
                this.libros[index] = this.libros[nLibrosActuales - 1];
                this.libros[nLibrosActuales - 1] = null;
                this.nLibrosActuales--;

//                //Opcion 2(Diego): recolocar todo el array (si el orden es importante o alfabetico)
//                for(int i = index + 1; i < this.libros.length; i++) {
//                    this.libros[i-1] = this.libros[i];
//                }
//                this.libros[this.libros.length-1] = null;
//                this.nLibrosActuales--;
            }

        }
        return resultado;
    }

    public String infoBiblioteca() {
        String infoBiblioteca = String.format("Biblioteca - Nombre:%, Direccion: %s, Email: %s, Numero telefono: %s"
                , this.nombre, this.direccion, this.email, this.nTelefono);
        return infoBiblioteca;


        //opcion 2
//        StringBuilder sb = new StringBuilder();
//        sb.append("Biblioteca ");
//        sb.append("Nombre: " + this.nombre + "\n");
//        sb.append("Direccion: " + this.direccion + "\n");
//        sb.append("Email: " + this.email + "\n");
//        sb.append("Numero telefono: " + this.nTelefono + "\n");
//        return sb.toString();
    }

    public String infoLibros() {
        String infoLibro = "";
        if (this.nLibrosActuales > 0) {
            for (int i = 0; i < this.nLibrosActuales; i++) {
                if (this.libros[i] != null) {
                    infoLibro += this.libros[i].infoLibro() + "\n";
                }
            }
        } else {
            infoLibro = "No hay Libros en la Biblioteca";
        }
        return infoLibro;
    }



    private void ampliarDiemsnionBiblioteca () {
        Libro[] librosAux = new Libro[this.libros.length + 5];
        for(int i = 0; i < this.libros.length; i++) {
            librosAux[i] = this.libros[i];
        }
        this.libros = librosAux;

    }
}//class biblioteca
