package exceptions;

/**
 * Excepción personalizada para controlar el registro de héroes en el sistema.
 * Se lanza cuando se intenta asignar un héroe a un equipo en el que ya figura como integrante.
 * * @author Francella Rojas Castillo
 * @version 1.0
 * @since 2026-03-29
 */
public class HeroeYaRegistradoException extends Exception {

    /**
     * Construye una nueva excepción con un mensaje detallado.
     * * @param message Texto explicativo que describe la causa del error.
     */
    public HeroeYaRegistradoException(String message) {
        super(message);
    }
}