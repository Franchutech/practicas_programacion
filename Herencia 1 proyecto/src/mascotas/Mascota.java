

package mascotas;

/* Clase abstracta base Mascota */
public abstract class Mascota {

    protected String nombre;
    protected int edad;
    protected String estado;
    protected String fechaNac;

    public Mascota(String nombre, int edad, String estado, String fechaNac) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNac = fechaNac;
    }

    public abstract void mostrar();

    public abstract void hablar();

}
