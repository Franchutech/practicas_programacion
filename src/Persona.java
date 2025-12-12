import java.time.LocalDate;

/**
 * Clase base Persona. Representa datos comunes compartidos por muchas clases.
 */
public class Persona {

    protected String nombre;
    protected String dni;
    protected String direccion;
    protected LocalDate fechaNacimiento;

    public Persona(String nombre, String dni, String direccion, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    /** Devuelve el DNI (clave para búsquedas) */
    public String getDni() {
        return dni;
    }

    /** Muestra datos generales de la persona */
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha Nacimiento: " + fechaNacimiento);
    }
}
