import java.time.LocalDate;

public class Cliente {

    // ATRIBUTOS
    private String DNI;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula[] peliculasAlquiladas;

    public static int contadorSocios = 0;

    // CONSTRUCTOR
    public Cliente(String DNI, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaBaja = null;
        this.numSocio = generarNumSocio();
        this.peliculasAlquiladas = new Pelicula[10];
    }

    // GENERAR SOCIO ÚNICO TIPO S-0001
    private String generarNumSocio() {
        contadorSocios++;
        return String.format("S-%04d", contadorSocios);
    }

    // GETTERS
    public String getDNI() { return DNI; }
    public String getNombre() { return nombre; }
    public String getNumSocio() { return numSocio; }
    public String getDireccion() { return direccion; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public LocalDate getFechaBaja() { return fechaBaja; }
    public Pelicula[] getPeliculasAlquiladas() { return peliculasAlquiladas; }

    // SETTERS
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setFechaBaja(LocalDate fechaBaja) { this.fechaBaja = fechaBaja; }

    // VALIDACIÓN DE NOMBRE
    public static boolean validacionNombre(String nombre) {
        if (nombre == null) return false;
        nombre = nombre.trim();
        if (nombre.length() < 3 || nombre.length() > 50) return false;
        if (!nombre.contains(" ")) return false;
        return true;
    }

    // VALIDACIÓN DE DIRECCIÓN
    public static boolean validacionDireccion(String direccion) {
        if (direccion == null) return false;
        direccion = direccion.trim();
        if (direccion.length() < 8 || direccion.length() > 50) return false;
        if (!direccion.contains(" ")) return false;
        return true;
    }

    // COMPROBAR MAYORÍA DE EDAD
    public static boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        return MiUtils.minimoEdad(fechaNacimiento);
    }

    // MOSTRAR INFO
    public String mostrarinfoCliente() {
        String info = "";
        info += "DNI: " + this.DNI + "\n";
        info += "Nombre: " + this.nombre + "\n";
        info += "NumSocio: " + this.numSocio + "\n";
        info += "Direccion: " + this.direccion + "\n";
        info += "FechaNacimiento: " + this.fechaNacimiento + "\n";
        info += "FechaBaja: " + this.fechaBaja + "\n";
        return info;
    }

    // MOSTRAR PELÍCULAS ALQUILADAS
    public String mostrarPeliculasAlquiladas() {
        String listado = "Películas alquiladas por " + nombre + ":\n";
        for (Pelicula p : peliculasAlquiladas) {
            if (p != null) {
                listado += "- " + p.getTitulo() + " (" + p.getCod() + ")\n";
            }
        }
        return listado;
    }

    // MÉTODO PARA QUE EL CLIENTE PUEDA AÑADIR UNA PELÍCULA A SU LISTA
    public boolean addPeliculaAlquilada(Pelicula p) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] == null) {
                peliculasAlquiladas[i] = p;
                return true;
            }
        }
        return false; // No hay espacio
    }

    // MÉTODO PARA QUITAR UNA PELÍCULA AL DEVOLVERLA
    public boolean removePeliculaAlquilada(Pelicula p) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] != null && peliculasAlquiladas[i].getCod().equals(p.getCod())) {
                peliculasAlquiladas[i] = null;
                return true;
            }
        }
        return false;
    }

}
