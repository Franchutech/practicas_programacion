import java.io.Serializable;
import java.io.Serial;
import java.util.ArrayList;


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


    public Equipo(String nombreEquipo, String codEquipo, Capitan capitan, int maxHeroes) {
        this.nombreEquipo = nombreEquipo;
        this.codEquipo = codEquipo;
        this.capitan = capitan;
        this.maxHeroes = maxHeroes;
        this.listaHeroes = new ArrayList<>();
    }

    //GETTERS

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public Capitan getCapitan() {
        return capitan;
    }

    public int getMaxHeroes() {
        return maxHeroes;
    }

    public ArrayList<Heroe> getListaHeroes() {
        return listaHeroes;
    }


    //SETTERS

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public void setCapitan(Capitan capitan) {
        this.capitan = capitan;
    }

    public void setMaxHeroes(int maxHeroes) {
        this.maxHeroes = maxHeroes;
    }

    public void setListaHeroes(ArrayList<Heroe> listaHeroes) {
        this.listaHeroes = listaHeroes;
    }


    //TO STRING

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


} //CIERRE CLASE EQUIPO
