public class AvisarHaciendaException extends Exception {

    public AvisarHaciendaException(Cliente cliente, String iban, Tipo tipo) {
        super("Aviso a Hacienda: El cliente " + cliente.getNombre() +
                " con IBAN " + iban + " ha realizado una operación de tipo " + tipo);
    }
}
