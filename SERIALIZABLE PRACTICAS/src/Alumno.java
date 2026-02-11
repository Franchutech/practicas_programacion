import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Alumno implements Serializable {


    private static final long serialVersionUID = 3412296677215719969L;


    private String nombre;
    private String apellido;
    private String email;
    private int edad;

    List<Calificacion> calificaciones;

    public Alumno(String nombre, String apellido, String email, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.calificaciones = new LinkedList<>();
    }

    public void calificar(String asignatura, int nota) {
        this.calificaciones.add(new Calificacion(asignatura,nota));
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                '}';
    }
}
