import java.time.LocalDate;

public class Cliente extends Persona {
    private String telefono;
    private String email;
    private String direccion;


    //CONSTRUCTOR

    //PRIMERO LLAMO A LO DE PERSONA CON EL SUPER
    public Cliente(String Nombre, String DNI, LocalDate fechaNac,
                   String telefono, String email, String direccion) throws CuentaException {
        super(Nombre, DNI, fechaNac);

        //AQUI CREO LOS NUEVOS ATRIBUTOS // y luego llamo los setters que acabo de crear abajo.

        this.setTelefono(telefono);
        this.setEmail(email);
        this.setDireccion(direccion);
    }

//SETTERS

    public void setTelefono(String telefono) throws CuentaException {
        if (telefono.length() < 9 || !telefono.matches("^[0-9]{9}$")) {
            throw new CuentaException("El telefono no es valido debe tener al menos 9 caracteres");
        }
        this.telefono = telefono;
    }//IFTELEFONO


    public void setEmail(String email) throws CuentaException {
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new CuentaException("El formato del email no es válido.");
        }
        this.email = email;
    }

    public void setDireccion(String direccion) throws CuentaException {
        if (direccion == null || direccion.length() < 5) {
            throw new CuentaException("La dirección es demasiado corta o inválida.");
        }
        this.direccion = direccion;
    }
    //GETTERS


    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    //TOSTRING (GENERADO AUTOMATICAMENTE)

    @Override
    public String toString() {
        return "Cliente{" +
                "telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

}//MAIN PERSONA
