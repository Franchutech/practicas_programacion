import java.util.ArrayList;
import java.util.Iterator;


public class Agenda {

   //CREAR LISTA (ARRAYLIST)
    private ArrayList<Contacto> listaContactos;

    //HACER EL CONSTRUCTOR
    public Agenda() {
        listaContactos = new ArrayList<>();
    }

    //METOODOS

    //METODO1: PARA HACER CRECER LA LISTA AGENDA CON CONTACTOS

    public void addContacto(Contacto newcontacto) {
        for (Contacto contacto : listaContactos) {
            if (contacto.getNombre().equalsIgnoreCase(newcontacto.getNombre())) {
                System.out.println("Error el nombre ya existe");
                return;
            }
        }//METODO1
        listaContactos.add(newcontacto);
        System.out.println("Nuevo Contacto Añadido con Éxito");
    }

    //METODO2: BUSCAR CONTACTO POR NOMBRE

    public void buscarContacto(String nombre) {
        //comparo el nombre de cada contacto de la lista con el String recibido
        for (Contacto contacto : listaContactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado" + contacto.toString());
                return;
            }
        }
        System.out.println("El contacto no existe en la agenda");
        }//METODO2_BUSCARCONTACTO


    //METODO3: ITERATOR PARA ELIMINAR CONTACTOS

    public void eliminarContacto(String nombre) {
        //tomo el contacto Iterator de la lista
        Iterator<Contacto> iterator = listaContactos.iterator();
        //con while me pregunto hay alguien mas adelante?
        while (iterator.hasNext()) {
            //salto al siguiente producto
            Contacto contacto = iterator.next();
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();
                System.out.println("Contacto eliminado" + contacto.toString());
                return;
            }
        }
        System.out.println("Contacto no encontrado");
    }//METODO3

    //METODO4: VISUALIZAR AGENDA

    public void visualizarAgenda() {
        for (Contacto contacto : listaContactos) {
                System.out.println(contacto.toString());
                return;
            }

    }//METODO4

    //METODO5: CONTAR CONTACTOS

    public int contarContactos(){
        return listaContactos.size();
    }//METODO5

    //METODO6: ADICIONAL, COMPROBAR SI LA AGENDA ESTA VACIA

    public boolean estaVacia() {
        boolean vacia = (contarContactos() == 0);
        if (vacia) {
            System.out.println("Agenda vacia" + vacia);
        }
            return vacia;
    }

}//CLASE AGENDA
