package mascotas;

/* Clase Inventario para gestionar mascotas */
public class Inventario {

    private Mascota[] lista;
    private int contador;

    public Inventario(int max){
        lista = new Mascota[max];
        contador = 0;
    }

    public void insertar(Mascota m){
        if(contador < lista.length){
            lista[contador] = m;
            contador++;
        }
    }

    public void mostrarTodos(){
        for(int i=0; i<contador; i++){
            lista[i].mostrar();
        }
    }
}
