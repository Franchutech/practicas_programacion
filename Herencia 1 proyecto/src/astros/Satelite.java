package astros;

/* Clase Satelite, hereda de Astro */
public class Satelite extends Astro {

    private Planeta planeta;

    public Satelite(double masa, double diametro, double rotacion, double traslacion, double distancia, double temperatura, double gravedad, Planeta planeta){
        super(masa, diametro, rotacion, traslacion, distancia, temperatura, gravedad);
        this.planeta = planeta;
    }

    @Override
    public void mostrar(){
        System.out.println("SATELITE");
        System.out.println("Masa: " + masa);
        System.out.println("Diametro: " + diametro);
        System.out.println("Rotacion: " + rotacion);
        System.out.println("Traslacion: " + traslacion);
        System.out.println("Distancia: " + distancia);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Gravedad: " + gravedad);
        System.out.println("Orbita a planeta");
    }
}
