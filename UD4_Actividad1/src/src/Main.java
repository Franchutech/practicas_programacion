import java.util.ArrayList;
import java.util.Iterator;
// import java.util.Collections;


public class Main {
    public static void main(String[] args) {

        //CREAR LISTA
        ArrayList<Producto> productos = new ArrayList<>();

        //LLENAR ARRAYLIST

        Producto p1 = new Producto("Arroz", 10);
        Producto p2 = new Producto("Leche", 5);
        Producto p3 = new Producto("Pan", 7);
        Producto p4 = new Producto("Cafe", 8);
        Producto p5 = new Producto("Azucar", 12);

        //AGREGAR

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);


        //visualizar contenido

        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            System.out.println(p.getNombre() + " - " + p.getCantidad());
        }

        //ELIMINAR
        productos.remove(0); // elimina el primero
        productos.remove(1); // elimina otro

        //AREGAR PRODUCTO NUEVO
        Producto nuevo = new Producto("Galletas", 6);
        productos.add(1, nuevo);

        System.out.println("LISTA MODIFICADA");

        Iterator<Producto> it2 = productos.iterator();
        while (it2.hasNext()) {
            Producto p = it2.next();
            System.out.println(p.getNombre() + " - " + p.getCantidad());
        }

        //VACIAR LA LISTA

        productos.clear();
        System.out.println("Lista vacía. Tamaño: " + productos.size());


        //PUNTO 8
        // Collections.sort(productos);
        // System.out.println("LISTA ORDENADA POR NOMBRE");
        // Iterator<Producto> itOrdenado = productos.iterator();
        // while (itOrdenado.hasNext()) {
        //     Producto p = itOrdenado.next();
        //     System.out.println(p.getNombre() + " - " + p.getCantidad());
        // }

    }//void main
}//Main