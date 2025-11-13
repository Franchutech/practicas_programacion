public class Biblioteca {

    //Atributo estatico contador total de libros que ha habido en la biblioteca
    private static int contadorTotal = 0;

    public static int getContadorTotal() {
        return contadorTotal;
    }

    //Atributos encapsulados
    private String codigo;
    private String nombre;
    private String direccion;
    private String email;
    private String nTelefono;

    //Coleccion (array) de libros en la biblioteca
    private Libro[] libros;
    private int nLibrosActuales;
    private final int dimensionInicial = 100;

    //Constructor
    public Biblioteca(String codigo, String nombre, String direccion, String email, String nTelefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.nTelefono = nTelefono;

        this.libros = new Libro[this.dimensionInicial];

        //Esto es importante para la smartbiblioteca
        this.nLibrosActuales = 0;
    }

    public String getCodigo() {
        return this.codigo;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getnTelefono() {
        return this.nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    public boolean insertarLibro(Libro libro) {
        boolean resultado = false;

        //Toda la logica para insertar un libro
        if(libro != null) {
            if(this.nLibrosActuales < this.libros.length) {
                //tengo huecos susicientes
                this.libros[this.nLibrosActuales] = libro;
                resultado = true;
                this.nLibrosActuales++;

                contadorTotal++;
            }
            else{
                //No tengo huecos suficientes
                this.ampliarDimensionBiblioteca();
                this.libros[this.nLibrosActuales] = libro;
                resultado = true;
                this.nLibrosActuales++;

                contadorTotal++;

            }

//            //Algoritmo refinado o refactorizado
//            if(this.nLibrosActuales >= this.libros.length) {
//                this.ampliarDimensionBiblioteca();
//            }
//            this.libros[this.nLibrosActuales] = libro;
//            resultado = true;
//            this.nLibrosActuales++;
        }

        return resultado;
    }

    public Libro getLibroByISBN(String ISBN) {
        int index = -1;
        for(int i = 0; i < this.nLibrosActuales; i++) {
            if (this.libros[i] != null) {
                if (this.libros[i].getISBN().equalsIgnoreCase(ISBN)) {
                    index = i;
                    break; //para eliminar la primera ocurrencia
                }
            }
        }
        if(index == -1) {
            return null;
        }
        else{
            return this.libros[index];
        }

//        //Otra Opcion
//        Libro libro = null;
//        for(int i = 0; i < this.nLibrosActuales; i++) {
//            if (this.libros[i] != null) {
//                if (this.libros[i].getISBN().equalsIgnoreCase(ISBN)) {
//                    libro = libros[i];
//                    break;
//                }
//            }
//        }
//        return libro;

    }

    public boolean eliminarLibro(Libro libro) {
        boolean resultado = false;

        if(libro != null) {
            int index = -1;
            for(int i = 0; i < this.nLibrosActuales; i++) {
                if (this.libros[i] != null) {
                    if (this.libros[i].getISBN().equalsIgnoreCase(libro.getISBN())) {
                        index = i;
                        break; //para eliminar la primera ocurrencia
                    }
                }
            }

            if(index != -1){
                this.libros[index] = null;
                resultado = true;

                //Opcion 1 (Marco): Mover solo el ultimo
                this.libros[index] = this.libros[nLibrosActuales- 1];
                this.libros[nLibrosActuales- 1] = null;
                this.nLibrosActuales--;

//                //Opcion 2: recoloco todo el array
//                for(int i = index +1; i < this.libros.length; i++) {
//                    this.libros[i-1] = this.libros[i];
//                }
//                this.libros[this.libros.length-1] = null;
//                this.nLibrosActuales--;
            }
        }
        return  resultado;
    }

    public String infoBiblioteca(){
        String infoBiblioteca = String.format("Bibilioteca - Nombre: %s, Direccion: %s , " +
                        "Email: %s, Numero telefono: %s"
                , this.nombre, this.direccion, this.email, this.nTelefono);

        StringBuilder sb = new StringBuilder("Biblioteca: \n");
        sb.append("Nombre: " + this.nombre + "\n");
        sb.append("Direccion: " + this.direccion + "\n");
        sb.append("Email: " + this.email + "\n");
        sb.append("Numero telefono: " + this.nTelefono + "\n");

        return sb.toString();
        //return infoBiblioteca;
    }

    public String infoLibros(){
        String infoLibro = "";
        if(this.nLibrosActuales > 0){
            for(int i = 0; i < this.nLibrosActuales; i++){
                if(this.libros[i] != null){
                    infoLibro += this.libros[i].infoLibro() + "\n";
                }
            }
        }
        else{
            infoLibro = "No hay libros en la biblioteca";
        }

        return infoLibro;
    }

    private void ampliarDimensionBiblioteca(){
        Libro[] librosAux = new Libro[this.libros.length + 5];
        for(int i = 0; i < this.libros.length; i++){
            librosAux[i] = this.libros[i];
        }
        this.libros = librosAux;
    }


}