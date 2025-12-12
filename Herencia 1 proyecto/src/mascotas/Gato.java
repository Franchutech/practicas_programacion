package mascotas;

/* Clase Gato */
public class Gato extends Mascota {

    private String color;

    public Gato(String nombre, int edad, String estado, String fechaNac, String color){
        super(nombre, edad, estado, fechaNac);
        this.color = color;
    }

    @Override
    public void mostrar(){
        System.out.println("Gato: " + nombre + " Color: " + color);
    }

    @Override
    public void hablar(){
        System.out.println("Miau miau");
    }
}
