import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CuentaBancaria {

    //atributos y campos de la clase

    //La cuenta IBAN es un String porque son letras y numeros y no se operan entre ellas, es solo un dato.

    private final String iban;
    private final String titular;
    private double saldo;
    private Movimiento[] movimientos;//array de la clase movimiento

    //constructor de atributos

    public CuentaBancaria(String iban, String titular,  double saldo, String movimientos) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
        this.movimientos = new Movimiento[100];
    }//constructor

    //GETTER
    public String getIban() {
        return this.iban;
    }
    public String getTitular() {
        return this.titular;
    }
    public Double getSaldo() {
        return this.saldo;
    }

    //SETTER
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public void setIban(String iban) {
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }
    //metodos

    public String requerimientosIban() {
        if (iban != null) {
       //necesito hacer que la cuenta iban no tenga mas de 22 digitos
            //necesito que tenga 2 letras al inicio y el resto numeros
            //
        }
    }
















} //class CuentaBancaria

