package mascotas;

/* Clase Canario */
public class Canario extends Ave {

    private String color;

    public Canario(String nombre, int edad, String estado, String fechaNac, String pico, boolean vuela, String color){
        super(nombre, edad, estado, fechaNac, pico, vuela);
        this.color = color;
    }

    @Override
    public void mostrar(){
        System.out.println("Canario: " + nombre + " Color: " + color);
    }

    @Override
    public void hablar(){
        System.out.println("Pio pio");
    }
}
