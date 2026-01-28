public class gato {
    private String nombre;
    private int edad;

    // Constructor con parámetros que puede lanzar excepciones
    public gato(String nombre, int edad) throws Exception {
        setNombre(nombre);
        setEdad(edad);
    }

    // Getters y Setters con validaciones
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