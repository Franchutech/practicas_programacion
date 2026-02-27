import java.time.LocalDate;
import java.io.Serializable;

//CLASE MADRE DE LOS CLIENTES

public class Persona implements Serializable {


    private static final long serialVersionUID = -8277680958705568161L;

    //ATRIBUTOS
    protected String DNI;
    protected String nombre;
    protected String direccion;
    protected LocalDate fechaNacimiento;


    //CONSTRUCTOR

    public Persona(String DNI, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }


    //GETTERS


    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    //SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //TOSTRING

    @Override
    public String toString() {
        return "Persona{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}//CIERRE CLASE PERSONA
