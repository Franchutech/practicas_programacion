import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que representa a un Héroe en el sistema, extendiendo las capacidades de una Persona.
 * Incluye atributos específicos de combate, rangos y poderes elementales.
 * Implementa Serializable para la persistencia de datos de los héroes.
 * * @author Francella Rojas Castillo
 * @version 1.0
 * @since 2026-03-29
 */
public class Heroe extends Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 4185660051459301052L;

    //ATRIBUTOS

    private  int idHeroe;
    private Rango rango;
    private PoderElemental poderElemental;
    private double ataque;
    private double defensa;
    private boolean isActivo;

    /**
     * Contador estático para la generación automática y única de identificadores de héroes.
     */
    private static int contadorHeroes = 1;


    //CONSTRUCTOR

    /**
     * Constructor completo para la creación de un Héroe.
     * Inicializa los atributos heredados de Persona y los propios de la clase Heroe.
     * * @param nombre Nombre del héroe.
     * @param fechaNacimiento Fecha de nacimiento del héroe.
     * @param DNI Documento de identidad.
     * @param direccion Dirección de residencia.
     * @param nContrato Número de contrato asociado.
     * @param rango Rango jerárquico del héroe.
     * @param poderElemental Tipo de poder elemental que posee.
     * @param ataque Valor de ataque (validado entre 0 y 100).
     * @param defensa Valor de defensa (validado entre 0 y 100).
     * @param isActivo Estado de disponibilidad del héroe.
     */
    public Heroe(String nombre, LocalDate fechaNacimiento, String DNI, String direccion,
                 String nContrato, Rango rango, PoderElemental poderElemental, double ataque, double defensa, boolean isActivo) {
        super(nombre, fechaNacimiento, DNI, direccion, nContrato);
        this.rango = rango;
        this.poderElemental = poderElemental;
        setAtaque(ataque);
        setDefensa(defensa);
        this.isActivo = isActivo;

        this.idHeroe = contadorHeroes++;
    }


    //GETTERS

    /**
     * Obtiene el identificador único del héroe.
     * @return idHeroe entero.
     */
    public int getIdHeroe() {
        return idHeroe;
    }

    /**
     * Obtiene el rango actual del héroe.
     * @return Objeto de tipo Rango.
     */
    public Rango getRango() {
        return rango;
    }

    /**
     * Obtiene el poder elemental del héroe.
     * @return Objeto de tipo PoderElemental.
     */
    public PoderElemental getPoderElemental() {
        return poderElemental;
    }

    /**
     * Obtiene el valor de ataque del héroe.
     * @return Valor double de ataque.
     */
    public double getAtaque() {
        return ataque;
    }

    /**
     * Obtiene el valor de defensa del héroe.
     * @return Valor double de defensa.
     */
    public double getDefensa() {
        return defensa;
    }

    /**
     * Indica si el héroe se encuentra activo en el sistema.
     * @return true si está activo, false en caso contrario.
     */
    public boolean isActivo() {
        return isActivo;
    }

    /**
     * Obtiene el estado actual del contador global de héroes.
     * @return Valor del contador estático.
     */
    public static int getContadorHeroes() {
        return contadorHeroes;
    }


    //SETTERS


    /**
     * Actualiza el rango del héroe.
     * @param rango Nuevo rango a asignar.
     */
    public void setRango(Rango rango) {
        this.rango = rango;
    }

    /**
     * Actualiza el poder elemental del héroe.
     * @param poderElemental Nuevo poder a asignar.
     */
    public void setPoderElemental(PoderElemental poderElemental) {
        this.poderElemental = poderElemental;
    }

    /**
     * Establece el valor de ataque aplicando reglas de negocio (rango 0-100).
     * @param ataque Valor de ataque sugerido.
     */
    public void setAtaque(double ataque) {
        if (ataque <= 0) this.ataque = 0;
        else if (ataque > 100) this.ataque = 100;
        else this.ataque = ataque;
    }

    /**
     * Establece el valor de defensa aplicando reglas de negocio (rango 0-100).
     * @param defensa Valor de defensa sugerido.
     */
    public void setDefensa(double defensa) {
        if (defensa <= 0) this.defensa = 0;
        else if (defensa > 100) this.defensa = 100;
        else this.defensa = defensa;
    }

    /**
     * Cambia el estado de activación del héroe.
     * @param activo Nuevo estado booleano.
     */
    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    /**
     * Permite modificar el contador estático de héroes (usado principalmente en sincronización).
     * @param contadorHeroes Nuevo valor para el contador inicial.
     */
    public static void setContadorHeroes(int contadorHeroes) {
        Heroe.contadorHeroes = contadorHeroes;
    }

    //TO STRING

    /**
     * Devuelve una representación detallada del héroe, incluyendo los datos de Persona.
     * @return Cadena de texto con toda la información del héroe.
     */
    @Override
    public String toString() {
        return super.toString() + "Heroe{" +
                "idHeroe=" + idHeroe +
                ", rango=" + rango +
                ", poderElemental=" + poderElemental +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", isActivo=" + isActivo +
                '}';
    }
}//CIERRE CLASE HEROE