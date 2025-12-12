import java.time.LocalDate;

/**
 * Trabajador - Hereda de Persona y añade atributos propios de empleados.
 */
public class Trabajador extends Persona {

    private String numeroSS;
    private LocalDate fechaAlta;

    public Trabajador(String nombre, String dni, String direccion, LocalDate nacimiento) {
        super(nombre, dni, direccion, nacimiento);
        this.numeroSS = generarNumeroSS();
        this.fechaAlta = LocalDate.now();
    }

    /** Genera número aleatorio de Seguridad Social */
    private String generarNumeroSS() {
        return "SS-" + (int)(Math.random() * 900000 + 100000);
    }

    /** Muestra la información extendida */
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número SS: " + numeroSS);
        System.out.println("Fecha Alta: " + fechaAlta);
    }
}
