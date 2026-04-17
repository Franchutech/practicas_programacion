import java.io.Serializable;
import java.time.LocalDate;
import java.io.Serial;

/**
 * Clase que representa a un Capitán en el sistema.
 * Un Capitán es un Héroe especializado que aporta atributos adicionales de liderazgo y estrategia.
 * Implementa Serializable para permitir la persistencia de datos.
 * * @author Francella Rojas Castillo
 * @version 1.0
 * @since 2026-03-29
 */
public class Capitan extends Heroe implements Serializable {


    @Serial
    private static final long serialVersionUID = -6164008229508081004L;


    //ATRIBUTOS

    private String codCapitan;
    private double estrategia;
    private double liderazgo;

    //CONSTRUCTOR


    /**
     * Constructor completo para la clase Capitan.
     * Inicializa los atributos heredados de Heroe y Persona, además de los específicos de mando.
     * * @param nombre Nombre del capitán. [cite: 169]
     * @param fechaNacimiento Fecha de nacimiento. [cite: 169]
     * @param DNI Documento de identidad. [cite: 169]
     * @param direccion Dirección de residencia. [cite: 169]
     * @param nContrato Número de contrato asignado. [cite: 169]
     * @param rango Rango del héroe. [cite: 169]
     * @param poderElemental Tipo de poder. [cite: 169]
     * @param ataque Valor de ataque. [cite: 169]
     * @param defensa Valor de defensa. [cite: 169]
     * @param isActivo Estado de actividad. [cite: 169]
     * @param codCapitan Código identificador único del capitán. [cite: 169]
     * @param estrategia Nivel de estrategia (validado 0-100). [cite: 169]
     * @param liderazgo Nivel de liderazgo (validado 0-100). [cite: 169]
     */
    public Capitan(String nombre, LocalDate fechaNacimiento, String DNI, String direccion, String nContrato, Rango rango, PoderElemental poderElemental, double ataque, double defensa, boolean isActivo, String codCapitan, double estrategia, double liderazgo) {
        super(nombre, fechaNacimiento, DNI, direccion, nContrato, rango, poderElemental, ataque, defensa, isActivo);
        this.codCapitan = codCapitan;
        setEstrategia(estrategia);
        setLiderazgo(liderazgo);
    }

    //GETTERS


    /**
     * Obtiene el código identificador del capitán.
     * @return String con el código. [cite: 171]
     */
    public String getCodCapitan() {
        return codCapitan;
    }

    /**
     * Obtiene el valor de estrategia del capitán.
     * @return Valor double de estrategia. [cite: 171]
     */
    public double getEstrategia() {
        return estrategia;
    }

    /**
     * Obtiene el valor de liderazgo del capitán.
     * @return Valor double de liderazgo. [cite: 171]
     */
    public double getLiderazgo() {
        return liderazgo;
    }

    //SETTERS


    /**
     * Establece el valor de estrategia aplicando validación de rango (0-100).
     * @param estrategia Valor de estrategia a asignar. [cite: 169]
     */
    public void setEstrategia(double estrategia) {
        if (estrategia <= 0)  this.estrategia = 0;
        else if (estrategia > 100) this.estrategia = 100;
        else this.estrategia = estrategia;
    }

    /**
     * Establece el valor de liderazgo aplicando validación de rango (0-100).
     * @param liderazgo Valor de liderazgo a asignar. [cite: 169]
     */
    public void setLiderazgo(double liderazgo) {
        if (liderazgo <= 0)  this.liderazgo = 0;
        else if (liderazgo > 100) this.liderazgo = 100;
        else this.liderazgo = liderazgo;
    }

    //TOSTRING


    /**
     * Genera una representación en texto de la información del capitán, concatenando los datos de la superclase.
     * @return Cadena con los detalles completos del capitán. [cite: 171]
     */
    @Override
    public String toString() {
        return super.toString() + "Capitan{" +
                "codCapitan='" + codCapitan + '\'' +
                ", estrategia=" + estrategia +
                ", liderazgo=" + liderazgo +
                '}';
    }

}//CIERRE CLASE CAPITAN