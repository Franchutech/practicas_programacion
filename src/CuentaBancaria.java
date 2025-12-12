/**
 * CuentaBancaria - Contiene saldo y un historial de movimientos.
 */
public class CuentaBancaria {

    private String iban;
    private String titular;
    private double saldo;
    private Movimiento[] movimientos;
    private int contador;

    public CuentaBancaria(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0;
        this.movimientos = new Movimiento[100];
        this.contador = 0;
    }

    /** Registra ingreso */
    public void ingreso(double cantidad) {
        saldo += cantidad;
        movimientos[contador] =
                new Movimiento(contador + 1, Movimiento.Tipo.INGRESO, cantidad);
        contador++;
    }

    /** Registra retirada */
    public void retirada(double cantidad) {
        saldo -= cantidad;
        movimientos[contador] =
                new Movimiento(contador + 1, Movimiento.Tipo.RETIRADA, cantidad);
        contador++;
    }

    /** Muestra historial */
    public void mostrarMovimientos() {
        for (int i = 0; i < contador; i++) {
            movimientos[i].mostrarInfo();
        }
    }

    /** Muestra datos generales */
    public void mostrarInfo() {
        System.out.println("Cuenta IBAN: " + iban);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }
}
