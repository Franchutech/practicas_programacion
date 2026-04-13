package es.frojas.magic.exceptions;

public class SerVivoNoEncontradoException extends Exception {

    public SerVivoNoEncontradoException(int id) {

        super("AVISO DEL MINISTERIO: El sujeto con ID " + id + " no figura en los registros oficiales.");
    }
}