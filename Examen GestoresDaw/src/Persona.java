import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = -6746873446663566362L;


//ATRIBUTOS

    protected String nombre;
    protected LocalDate fechaNacimiento;
    protected String DNI;
    protected String direccion;

//CONSTRUCTOR

    public Persona(String nombre, LocalDate fechaNacimiento, String DNI, String direccion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        setDNI(DNI);
        this.direccion = direccion;
    }

//GETTERS

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDNI() {
        return DNI;
    }

    public String getDireccion() {
        return direccion;
    }


    //SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDNI(String DNI) {
        if (DNI != null && DNI.matches("^[A-Z][0-9]{8}$")) {
            this.DNI = DNI;
        } else {
            this.DNI = "INVALIDO";
            System.out.println("Error: El DNI debe iniciar por 8 numeros y terminar con una letra.");
        }
        this.DNI = DNI;
    }

    //TO STRING PARA IMPRESION


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", DNI='" + DNI + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }



}//CIERRE CLASE ABSTRACTA PERSONA
