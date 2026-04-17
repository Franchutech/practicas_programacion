package exceptions;

/**
 * Excepción personalizada para gestionar el control de aforo en los equipos.
 * Se lanza cuando se intenta añadir un nuevo integrante a un equipo que ya ha alcanzado
 * su límite máximo de héroes permitidos.
 * * @author Francella Rojas Castillo
 * @version 1.0
 * @since 2026-03-29
 */
public class CapacidadExcedidaException extends Exception {

    /**
     * Construye una nueva excepción con un mensaje descriptivo del error.
     * * @param message Texto que detalla la capacidad excedida y el equipo afectado.
     */
    public CapacidadExcedidaException(String message) {
        super(message);
    }
}