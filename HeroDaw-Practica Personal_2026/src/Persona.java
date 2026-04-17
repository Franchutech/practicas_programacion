import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que representa a una persona física dentro del sistema.
 * Implementa Serializable para permitir la persistencia de datos.
 * * @author Francella Rojas Castillo
 * @version 1.0
 * @since 2026-03-29
 */
public class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = -6746873446663566362L;


//ATRIBUTOS

    protected String nombre;
    protected LocalDate fechaNacimiento;
    protected String DNI;
    protected String direccion;
    protected String nContrato;

//CONSTRUCTOR

    /**
     * Constructor principal para crear una instancia de Persona.
     * * @param nombre Nombre completo de la persona.
     * @param fechaNacimiento Fecha de nacimiento (LocalDate).
     * @param DNI Documento Nacional de Identidad con validación de formato.
     * @param direccion Dirección de residencia.
     * @param nContrato Número de contrato con formato específico.
     */
    public Persona(String nombre, LocalDate fechaNacimiento, String DNI, String direccion, String nContrato) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        setDNI(DNI);
        this.direccion = direccion;
        setnContrato(nContrato);
    }

//GETTERS

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre almacenado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la fecha de nacimiento.
     * @return Objeto LocalDate con la fecha.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtiene el DNI.
     * @return El DNI validado.
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Obtiene la dirección.
     * @return La dirección almacenada.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Obtiene el número de contrato.
     * @return El número de contrato validado.
     */
    public String getnContrato() {
        return nContrato;
    }


    //SETTERS

    /**
     * Establece el nombre de la persona.
     * @param nombre Nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la fecha de nacimiento.
     * @param fechaNacimiento Nueva fecha a asignar.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Establece la dirección.
     * @param direccion Nueva dirección a asignar.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Establece y valida el número de contrato.
     * Debe iniciar por una letra seguido de 5 dígitos.
     * @param nContrato El número de contrato a validar.
     */
    public void setnContrato(String nContrato) {
        if (nContrato != null && nContrato.matches("^[A-Z][0-9]{5}$")) {
            this.nContrato= nContrato;
        } else {
            this.nContrato = "INVALIDO";
            System.out.println("Error: El nContrato debe tener 5 digitos entre letras y numeros iniciando por una letra");
        }

        this.nContrato = nContrato;
    }

    /**
     * Establece y valida el DNI.
     * Debe iniciar por una letra y terminar con 8 números (según la lógica implementada).
     * @param DNI El DNI a validar.
     */
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


    /**
     * Genera una representación en cadena de los datos de la persona.
     * @return String con los atributos detallados.
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", DNI='" + DNI + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nContrato='" + nContrato + '\'' +
                '}';
    }


}//CIERRE CLASE ABSTRACTA PERSONA