package astros;

/* Clase Planeta, hereda de Astro */
public class Planeta extends Astro {

    private Satelite[] satelites;
    private int contador;

    public Planeta(double masa, double diametro, double rotacion, double traslacion, double distancia, double temperatura, double gravedad, int max){
        super(masa, diametro, rotacion, traslacion, distancia, temperatura, gravedad);
        satelites = new Satelite[max];
        contador = 0;
    }

    public void agregarSatelite(Satelite s){
        /* inserta si hay espacio */
        if(contador < satelites.length){
            satelites[contador] = s;
            contador++;
        }
    }

    @Override
    public void mostrar(){
        System.out.println("PLANETA");
        System.out.println("Masa: " + masa);
        System.out.println("Diametro: " + diametro);
        System.out.println("Rotacion: " + rotacion);
        System.out.println("Traslacion: " + traslacion);
        System.out.println("Distancia: " + distancia);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Gravedad: " + gravedad);

        System.out.println("Satelites:");
        for(int i=0; i<contador; i++){
            satelites[i].mostrar();
        }
    }
}
