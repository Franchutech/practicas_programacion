
public class ContactoPersona extends Contacto {
    private String cumpleanos;

    public ContactoPersona(String nombre, String telefono, String cumpleanos) {
        super(nombre, telefono);
        this.cumpleanos = cumpleanos;
    }

    @Override
    public String toString() {
        return "Persona - Nombre: " + nombre + ", Teléfono: " + telefono + ", Cumpleaños: " + cumpleanos;
    }
}
