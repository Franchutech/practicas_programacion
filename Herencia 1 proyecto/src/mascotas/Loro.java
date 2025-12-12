package mascotas;

/* Clase Loro */
public class Loro extends Ave {

    private String origen;

    public Loro(String nombre, int edad, String estado, String fechaNac, String pico, boolean vuela, String origen){
        super(nombre, edad, estado, fechaNac, pico, vuela);
        this.origen = origen;
    }

    @Override
    public void mostrar(){
        System.out.println("Loro: " + nombre + " Origen: " + origen);
    }

    @Override
    public void hablar(){
        System.out.println("Hola hola");
    }
}
