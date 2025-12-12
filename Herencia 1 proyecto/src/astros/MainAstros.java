package astros;

/* prueba del modelo de astros */
public class MainAstros {

    public static void main(String[] args){

        Planeta tierra = new Planeta(5.9,12742,24,365,149e6,15,9.8,5);

        Satelite luna = new Satelite(7.3,3474,655,27,384400,-53,1.6,tierra);

        tierra.agregarSatelite(luna);

        tierra.mostrar();
    }
}
