import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CuentaBancaria {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    //atributos y campos de la clase
    private final int iban;
    private String titular;
    private double saldo;
    private Movimiento[] movimientos;//array de la clase movimiento

    //constructor de atributos impresindibles

public CuentaBancaria(int iban, String titular,  double saldo, String movimientos) {
    this.iban = iban;
    this.titular = titular;
    this.saldo = saldo;
    this.movimientos = new Movimiento[100];

}

//GETTER
public int getIban() {
    return iban;
}
public String getTitular() {
    return titular;
}
public Double getSaldo() {
    return saldo;
}


//SETTER









} //class CuentaBancaria

