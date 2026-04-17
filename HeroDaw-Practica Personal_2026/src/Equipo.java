import java.io.Serializable;
import java.io.Serial;
import java.util.ArrayList;

/**
 * Clase que representa un equipo de héroes dentro de la academia.
 * Gestiona la agrupación de héroes bajo el mando de un capitán y controla la capacidad máxima del grupo.
 * Implementa Serializable para permitir la persistencia del estado de los equipos.
 * * @author Francella Rojas Castillo
 * @version 1.0
 * @since 2026-03-29
 */
public class Equipo implements Serializable {

    @Serial
    private static final long serialVersionUID = -4468157072246290184L;


    //ATRIBUTOS

    private String nombreEquipo;
    private String codEquipo;
    private Capitan capitan;
    private int maxHeroes;//obligatorio
    private ArrayList<Heroe> listaHeroes;

    //CONSTRUCTOR

    /**
     * Constructor principal para la creación de un equipo.
     * Inicializa la lista de héroes como un ArrayList vacío.
     * * @param nombreEquipo El nombre descriptivo del equipo.
     * @param codEquipo Código identificador único para el equipo.
     * @param capitan Objeto Capitan asignado al mando.
     * @param maxHeroes Cantidad máxima de integrantes permitidos.
     */
    public Equipo(String nombreEquipo, String codEquipo, Capitan capitan, int maxHeroes) {
        this.nombreEquipo = nombreEquipo;
        this.codEquipo = codEquipo;
        this.capitan = capitan;
        this.maxHeroes = maxHeroes;
        this.listaHeroes = new ArrayList<>();
    }

    //GETTERS

    /**
     * Obtiene el nombre del equipo.
     * @return String con el nombre del equipo.
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Obtiene el código identificador del equipo.
     * @return String con el código del equipo.
     */
    public String getCodEquipo() {
        return codEquipo;
    }

    /**
     * Obtiene el capitán asignado al equipo.
     * @return Objeto de tipo Capitan.
     */
    public Capitan getCapitan() {
        return capitan;
    }

    /**
     * Obtiene el límite máximo de héroes del equipo.
     * @return Entero con la capacidad máxima.
     */
    public int getMaxHeroes() {
        return maxHeroes;
    }

    /**
     * Obtiene la lista completa de héroes integrantes.
     * @return ArrayList conteniendo objetos Heroe.
     */
    public ArrayList<Heroe> getListaHeroes() {
        return listaHeroes;
    }


    //SETTERS

    /**
     * Actualiza el nombre del equipo.
     * @param nombreEquipo Nuevo nombre a asignar.
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * Actualiza el código del equipo.
     * @param codEquipo Nuevo código a asignar.
     */
    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    /**
     * Asigna un nuevo capitán al equipo.
     * @param capitan Objeto Capitan a establecer.
     */
    public void setCapitan(Capitan capitan) {
        this.capitan = capitan;
    }

    /**
     * Modifica el límite máximo de héroes permitidos.
     * @param maxHeroes Nuevo entero de capacidad.
     */
    public void setMaxHeroes(int maxHeroes) {
        this.maxHeroes = maxHeroes;
    }

    /**
     * Sustituye la lista de héroes actual por una nueva.
     * @param listaHeroes Nuevo ArrayList de héroes.
     */
    public void setListaHeroes(ArrayList<Heroe> listaHeroes) {
        this.listaHeroes = listaHeroes;
    }


    //TO STRING

    /**
     * Genera una representación textual de la información completa del equipo.
     * @return Cadena con los detalles del equipo, capitán e integrantes.
     */
    @Override
    public String toString() {
        return "Equipo{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", codEquipo='" + codEquipo + '\'' +
                ", capitan=" + capitan +
                ", maxHeroes=" + maxHeroes +
                ", listaHeroes=" + listaHeroes +
                '}';
    }

    //METODOS

    //METODO ELIMINAR HEROE POR DNI Y DEJARLO SIN EQUIPO

    /**
     * Elimina a un héroe de la lista basándose en su DNI y actualiza su estado contractual.
     * * @param dni El documento de identidad del héroe a buscar.
     * @return true si el héroe fue encontrado y eliminado, false en caso contrario.
     */
    public boolean eliminarHeroe(String dni) {
        for (int i = 0; i<listaHeroes.size(); i++) {
            if (listaHeroes.get(i).getDNI().equals(dni)) {
                listaHeroes.get(i).setnContrato("SIN EQUIPO");
                listaHeroes.remove(i);
                return true;
            }

        }
        return false;
    } //FIN METODO ELIMINAR HEROE POR DNI Y DEJARLO SIN EQUIPO


    //METODO PARA CONTAR EL ATAQUE DENTRO DE CADA EQUIPO

    /**
     * Calcula la suma total del poder de ataque de todos los héroes en el equipo.
     * * @return Valor double con la sumatoria del ataque acumulado.
     */
    public double getAtaqueTotal() {
        double suma = 0;
        for (Heroe h : listaHeroes) {
            suma += h.getAtaque(); // Suponiendo que el héroe tiene un atributo ataque
        }
        return suma;
    }//FIN METODO PARA CONTAR ATAQUE


} //CIERRE CLASE EQUIPO