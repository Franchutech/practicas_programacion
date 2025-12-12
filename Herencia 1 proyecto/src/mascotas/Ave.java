package mascotas;

/* Clase abstracta Ave, hereda de Mascota */
public abstract class Ave extends Mascota {

    protected String pico;
    protected boolean vuela;

    public Ave(String nombre, int edad, String estado, String fechaNac, String pico, boolean vuela){
        super(nombre, edad, estado, fechaNac);
        this.pico = pico;
        this.vuela = vuela;
    }
}
