



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

        //VUELVO A HACER ITERATOR CON EL NUEVO PRODUCTO

        Iterator<Producto> it2 = productos.iterator();
        while (it2.hasNext()) {
            Producto p = it2.next();
            System.out.println(p.getNombre() + " - " + p.getCantidad());
        }

        //VACIAR LA LISTA

        productos.clear();
        System.out.println("Lista vacía. Tamaño: " + productos.size());

        //ORDENAR LA COLECCION

        Collections.sort(productos);
        System.out.println("LISTA ORDENADA POR NOMBRE");
        Iterator<Producto> itOrdenado = productos.iterator();

        //VISUALIZAR EL ORDEN CON ITERATOR
        while (itOrdenado.hasNext()) {
            Producto p = itOrdenado.next();
            System.out.println(p.getNombre() + " - " + p.getCantidad());
        }


        //Eliminar producto pan
        //Se puede hacer de 2 formas una con el auxiliar por nombre de producto, y otra con
        // el index que serìa por la posiciòn en la que se encuentra.
        // Producto aux = null;
        //int index = -1;
        //for(Producto p : productos){
            //if(p.getNombre().equalsIgnoreCase("pan")){
                //aux = p;
                //index = productos.indexOf(p);
                //break;
            //}
       //}

        //if(aux != null){
            //productos.remove(aux);
        //}

        //productos.remove(index);


        //VISUALIZAR CON FOR EN VEZ DE ITERATOR

        //Collections.sort(prooductos);
        //System.out.println("Lista Ordenada con For)
        //for(Producto p: productos){
        //System.out.println(p);
    //}


    }//void main
}//Main