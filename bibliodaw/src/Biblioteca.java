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
    public Biblioteca (String codigo,String nombre,String direccion,String email,String nTelefono) {
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

    public boolean insertarLibro (Libro libro) {
        boolean resultado = false;

        //Toda la logica para insertar un libro
        if(libro != null) {  //para evitar errores de NULL en el futuro
            if(this.nLibrosActuales < this.dimensionInicial) {
                //tengo espacios suficientes
                this.libros[this.nLibrosActuales] = libro;
                resultado = true;
                this.nLibrosActuales++;
            }
            else {
                //no tengo huevos suficientes
                this.ampliarDiemsnionBiblioteca();
                this.libros[this.nLibrosActuales] = libro;
                resultado = true;
                this.nLibrosActuales++;

            }

        }
        return resultado;
    }
    //Metodo ampliar dimension biblioteca
    private void ampliarDiemsnionBiblioteca () {
        Libro[] librosAux = new Libro[this.libros.length + 5];
        for(int i = 0; i < this.libros.length; i++) {
            librosAux[i] = this.libros[i];
        }
        this.libros = librosAux;

    }
}//class biblioteca
