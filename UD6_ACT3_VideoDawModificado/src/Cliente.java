import java.io.Serial;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;


//CLASE HIJA DE PERSONA

public class Cliente extends Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 5763763823792632766L;


    // ATRIBUTOS

    private String numSocio;
    private LocalDate fechaBaja;
    private ArrayList<Articulo> articulosAlquilados;

    public static int contadorSocios = 0;

    // CONSTRUCTOR

    public Cliente(String DNI, String nombre, String direccion,
                   LocalDate fechaNacimiento) {
        super(DNI, nombre, direccion, fechaNacimiento);
        this.fechaBaja = null;
        this.numSocio = generarNumSocio();
        this.articulosAlquilados = new ArrayList<>();

    }
    //GETTERS


    public String getNumSocio() {
        return numSocio;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public ArrayList<Articulo> getArticulosAlquilados() {
        return articulosAlquilados;
    }

    //SETTERS

    public void setArticulosAlquilados(ArrayList<Articulo> articulosAlquilados) {
        this.articulosAlquilados = articulosAlquilados;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }


    // GENERAR SOCIO ÚNICO TIPO S-0001
    private String generarNumSocio() {
        contadorSocios++;
        return String.format("S-%04d", contadorSocios);
    }


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
        info += "DNI: " + getDNI() + "\n";
        info += "Nombre: " + getNombre() + "\n";
        info += "Direccion: " + getDireccion() + "\n";
        info += "Fecha baja: " + getFechaBaja() + "\n";
        info += "NumSocio: " + getNumSocio() + "\n";
        info += "FechaNacimiento: " + getFechaNacimiento()+ "\n";

        return info;
    }

    // MOSTRAR ARTÍCULOS ALQUILADOS
    public String mostrarArticulosAlquilados() {
        String listado = "Artículos alquilados por " + getNombre() + ":\n";

        // for-each para recorrer la lista dinámica
        for (Articulo a : articulosAlquilados) {
            listado += "- " + a.getTitulo() + " (" + a.getCod() + ")\n";
        }

        // Si la lista está vacía
        if (articulosAlquilados.isEmpty()) {
            listado += "No tiene artículos alquilados en este momento.";
        }

        return listado;
    }

    //METODO PARA AÑADIR ARTICULOS
    public void addArticuloAlquilado(Articulo a) {
        articulosAlquilados.add(a);
    }

    //METODO PARA ELIMINAR ARTICULOS
    public boolean removeArticuloAlquilado(Articulo a) {
        return articulosAlquilados.remove(a);

    }


    @Override

    //CON SUPER.TOSTRING me traigo lo de la clase madre mas lo nuevo.
    public String toString() {
        return super.toString() + " [Cliente: " +
                "numSocio='" + numSocio + '\'' +
                ", fechaBaja=" + fechaBaja +
                ", articulosAlquilados=" + articulosAlquilados +
                ']';
    }


}//CIERRE CLASE CLIENTE
