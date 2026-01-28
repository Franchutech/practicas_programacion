public class gato {
    private String nombre;
    private int edad;

    // CONSTRUCTOR QUE PUEDA LANZAR EXCEPCIONES DIRECTO DEL SET
    public gato(String nombre, int edad) throws Exception {
        this.setNombre(nombre);
        this.setEdad(edad);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre.length() < 3) {
            throw new Exception("El nombre debe tener al menos 3 caracteres.");
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws Exception {
        if (edad < 0) {
            throw new Exception("La edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    public void imprimir() {
        System.out.println("Gato: " + nombre + " | Edad: " + edad);
    }
}