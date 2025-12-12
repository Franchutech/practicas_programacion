package mascotas;

/* Clase Perro */
public class Perro extends Mascota {

    private String raza;

    public Perro(String nombre, int edad, String estado, String fechaNac, String raza){
        super(nombre, edad, estado, fechaNac);
        this.raza = raza;
    }

    @Override
    public void mostrar(){
        System.out.println("Perro: " + nombre + " Raza: " + raza);
    }

    @Override
    public void hablar(){
        System.out.println("Guau guau");
    }
}
