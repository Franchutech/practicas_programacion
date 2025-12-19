
public class ContactoEmpresa extends Contacto {
    private String web;

    public ContactoEmpresa(String nombre, String telefono, String web) {
        super(nombre, telefono);
        this.web = web;
    }

    @Override
    public String toString() {
        return "Empresa - Nombre: " + nombre + ", Teléfono: " + telefono + ", Web: " + web;
    }
}
