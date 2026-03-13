import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


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

    private static int contadorHeroes = 1;


    //CONSTRUCTOR

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

    public int getIdHeroe() {
        return idHeroe;
    }

    public Rango getRango() {
        return rango;
    }

    public PoderElemental getPoderElemental() {
        return poderElemental;
    }

    public double getAtaque() {
        return ataque;
    }

    public double getDefensa() {
        return defensa;
    }

    public boolean isActivo() {
        return isActivo;
    }

    public static int getContadorHeroes() {
        return contadorHeroes;
    }


    //SETTERS


    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public void setPoderElemental(PoderElemental poderElemental) {
        this.poderElemental = poderElemental;
    }

    public void setAtaque(double ataque) {
        if (ataque <= 0) this.ataque = 0;
        else if (ataque > 100) this.ataque = 100;
        else this.ataque = ataque;
    }

    public void setDefensa(double defensa) {
        if (defensa <= 0) this.defensa = 0;
        else if (defensa > 100) this.defensa = 100;
        else this.defensa = defensa;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    public static void setContadorHeroes(int contadorHeroes) {
        Heroe.contadorHeroes = contadorHeroes;
    }

    //TO STRING

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
