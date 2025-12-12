import java.time.LocalDate;

/**
 * Empresa - Contiene un array de trabajadores y métodos de gestión.
 */
public class Empresa {

    private String nombre;
    private String cif;
    private LocalDate fechaFundacion;
    private Trabajador[] trabajadores;
    private int contador;

    public Empresa(String nombre, String cif, LocalDate fechaFundacion, int max) {
        this.nombre = nombre;
        this.cif = cif;
        this.fechaFundacion = fechaFundacion;
        this.trabajadores = new Trabajador[max];
        this.contador = 0;
    }

    /** Registra un trabajador si hay espacio y no está repetido */
    public boolean registrarTrabajador(Trabajador t) {
        if (contador >= trabajadores.length) return false;
        if (buscarTrabajador(t.getDni()) != null) return false;

        trabajadores[contador++] = t;
        return true;
    }

    /** Busca un trabajador por DNI */
    public Trabajador buscarTrabajador(String dni) {
        for (int i = 0; i < contador; i++) {
            if (trabajadores[i].getDni().equals(dni)) return trabajadores[i];
        }
        return null;
    }

    /** Elimina un trabajador usando swap con el último */
    public boolean eliminarTrabajador(String dni) {
        for (int i = 0; i < contador; i++) {
            if (trabajadores[i].getDni().equals(dni)) {
                trabajadores[i] = trabajadores[contador - 1];
                trabajadores[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    /** Muestra datos de la empresa */
    public void mostrarInformacion() {
        System.out.println("EMPRESA:");
        System.out.println("Nombre: " + nombre);
        System.out.println("CIF: " + cif);
        System.out.println("Fundación: " + fechaFundacion);
        System.out.println("Trabajadores act.: " + contador);
    }

    /** Muestra lista de trabajadores */
    public void mostrarTrabajadores() {
        for (int i = 0; i < contador; i++) {
            trabajadores[i].mostrarInfo();
        }
    }
}
