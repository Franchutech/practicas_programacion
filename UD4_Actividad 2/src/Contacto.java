public class Contacto {


    //1. DEFINO LOS ATRIBUTOS

    private String nombre;
    private String telefono;
    private String correo;


    //2. HACER EL CONSTRUCTOR PARA ESOS ATRIBUTOS

    public Contacto(String nombre, String telefono, String correo) {
        setNombre(nombre);
        setTelefono(telefono);
        setCorreo(correo);
    }

    //COMO ESOS ATRIBUTOS TIENEN ESPECIFICACIONES, TENGO QUE VALIDAR,
    //CADA DATO QUE INGRESA POR EL PUBLIC.

    //POR EJEMPLO EL TELEFONO, DEBE CUMPLIR CON ESTO
    //teléfono (válido siempre que empiece
    // por 6,7 o 9 y tenga en total 9 dígitos)

    //VALIDACION DEL TELEFONO
    public boolean validarTelefono(String telefono) {
     return telefono.matches("^[679][0-9]{8}$");
    }

    //AHORA REQUIERO VALIDAR EL NOMBRE
    //nombre (válido siempre que comience
    // por mayúsculas y contenga letras)

    public boolean validarNombre(String nombre) {
        return nombre.matches("^[A-Z][a-zA-Z]+$");
    } //CON EL + DIGO, DEBE HABER AL MENOS UNA LETRA DESPUES DE LA PRIMERA.


    //AHORA REQUIERO VALIDAR EL EMAIL.
    //correo (válido siempre que aparezcan en la cadena:
    // (carácter a-z ó dígito ó _ ó . ó -), (el
    //símbolo @), (caracteres a-z),( punto),
    // ( entre dos y cuatro caracteres a-z).

    //RECORDAR NO DEJAR ESPACIOS EN BLANCO CON REGEX

    public boolean validarCorreo(String correo) {

        return correo.matches("^[a-z0-9_.-]+@[a-z]+\\.[a-z]{2,4}$");
    }

    //HACER LOS SETTERS

    public void setNombre(String nombre) {
        if (validarNombre(nombre)) { // LlamO EL FILTRO
            this.nombre = nombre;
        } else {
            System.out.println("Error: El nombre no cumple el formato.");
        }
    }

    public void setTelefono(String telefono) {
        if (validarTelefono(telefono)) { // LLAMO EL FILTRO
            this.telefono = telefono;
        } else {
            System.out.println("Error: El teléfono debe tener 9 dígitos y empezar por 6, 7 o 9.");
        }
    }

    public void setCorreo(String correo) {
        if (validarCorreo(correo)) { // LLAMO EL FILTRO
            this.correo = correo;
        } else {
            System.out.println("Error: Formato de correo electrónico incorrecto.");
        }
    }

//GETTERS

    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }

//tostring

    @Override
    public String toString() {
        return "NOMBRE: " + nombre + " | TEL: " + telefono + " | EMAIL: " + correo;
    }


}//Clase Conctacto
