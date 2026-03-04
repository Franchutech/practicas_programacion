import java.io.Serializable;
import java.time.LocalDate;
import java.io.Serial;


public class Capitan extends Heroe implements Serializable {


    @Serial
    private static final long serialVersionUID = -6164008229508081004L;


    //ATRIBUTOS

    private String codCapitan;
    private double estrategia;
    private double liderazgo;

    //CONSTRUCTOR


    public Capitan(String nombre, LocalDate fechaNacimiento, String DNI, String direccion, String nContrato, Rango rango, PoderElemental poderElemental, double ataque, double defensa, boolean isActivo, String codCapitan, double estrategia, double liderazgo) {
        super(nombre, fechaNacimiento, DNI, direccion, nContrato, rango, poderElemental, ataque, defensa, isActivo);
        this.codCapitan = codCapitan;
        setEstrategia(estrategia);
        setLiderazgo(liderazgo);
    }

    //GETTERS


    public String getCodCapitan() {
        return codCapitan;
    }

    public double getEstrategia() {
        return estrategia;
    }

    public double getLiderazgo() {
        return liderazgo;
    }

    //SETTERS


    public void setEstrategia(double estrategia) {
        if (estrategia <= 0)  this.estrategia = 0;
        else if (estrategia > 100) this.estrategia = 100;
        else this.estrategia = estrategia;
    }

    public void setLiderazgo(double liderazgo) {
        if (liderazgo <= 0)  this.liderazgo = 0;
        else if (liderazgo > 100) this.liderazgo = 100;
        else this.liderazgo = liderazgo;
    }

    //TOSTRING


    @Override
    public String toString() {
        return super.toString() + "Capitan{" +
                "codCapitan='" + codCapitan + '\'' +
                ", estrategia=" + estrategia +
                ", liderazgo=" + liderazgo +
                '}';
    }

}//CIERRE CLASE CAPITAN
