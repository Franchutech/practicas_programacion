import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * MiUtils - Clase de utilidades generales para leer datos y validar patrones.
 * Mantiene un único Scanner y provee funciones de apoyo para todo el programa.
 */
public class MiUtils {

    // Scanner único para evitar cierre de System.in
    private static final Scanner SC = new Scanner(System.in);

    /** Lee un texto con mensaje */
    public static String leerTexto(String mensaje) {
        System.out.println(mensaje);
        return SC.nextLine();
    }

    /** Lee un entero */
    public static int leerEntero(String mensaje) {
        return Integer.parseInt(leerTexto(mensaje));
    }

    /** Lee un decimal */
    public static double leerDecimal(String mensaje) {
        return Double.parseDouble(leerTexto(mensaje));
    }

    /** Verifica si un texto cumple un patrón */
    public static boolean comprobarPatron(String patron, String texto) {
        return texto.matches(patron);
    }

    /** Pide un dato repetidamente hasta cumplir un patrón */
    public static String comprobarPatronRepetidamente(String patron, String mensaje) {
        String texto;
        boolean ok;
        do {
            texto = leerTexto(mensaje);
            ok = comprobarPatron(patron, texto);
            if (!ok) System.out.println("Formato incorrecto, inténtelo de nuevo.");
        } while (!ok);
        return texto;
    }

    /** Verifica mayoría de edad */
    public static boolean minimoEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) return false;

        long SEG_18 = 31557600L * 18;
        long nac = fechaNacimiento.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();

        return now - nac >= SEG_18;
    }
}
