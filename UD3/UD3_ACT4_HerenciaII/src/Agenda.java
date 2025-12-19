
import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }

    public boolean anadirContacto(Contacto c) {
        if (existeContacto(c.getNombre())) {
            return false;
        }
        contactos.add(c);
        return true;
    }

    public boolean eliminarContacto(String nombre) {
        int pos = buscaContacto(nombre);
        if (pos >= 0) {
            contactos.remove(pos);
            return true;
        }
        return false;
    }

    public boolean existeContacto(String nombre) {
        return buscaContacto(nombre) >= 0;
    }

    public void listarContactos() {
        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }

    public int buscaContacto(String nombre) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }
}