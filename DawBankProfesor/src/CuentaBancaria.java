import java.util.ArrayList;

public class CuentaBancaria {

    private String IBAN;
    private double saldo;
    public Cliente cliente;

    //ACTUALIZO AQUI EN VEZ DE ARRAY, UNA COLECCION
    private ArrayList<Movimiento> movimiento;

    public CuentaBancaria(String IBAN, Cliente cliente) {
        this.IBAN = IBAN;
        this.cliente = cliente;
        this.movimiento = new ArrayList<>(); // CREO UNA COLECCION VACIA YA NO CON LIMITE DE 100
        this.saldo = 0.0;
    }

    public String getIBAN() {
        return IBAN;
    }
    public double getSaldo() {
        return saldo;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void ingresar(double valor) throws AvisarHaciendaException {
        double valorAbsoluto = Math.abs(valor);
        this.saldo += valorAbsoluto;
        this.generarMovimiento(Tipo.INGRESO, valorAbsoluto);

        if (valorAbsoluto >= 3000) {
            throw new AvisarHaciendaException(cliente, IBAN, Tipo.INGRESO);
        }
    }

    public void retirar(double valor) throws CuentaException, AvisarHaciendaException {
        double valorAbsoluto = Math.abs(valor);

        if ((this.saldo - valorAbsoluto) < -50) {
            throw new CuentaException("Error: Saldo insuficiente. El descubierto máximo es de -50€.");
        }
        this.saldo -= valorAbsoluto;
        this.generarMovimiento(Tipo.RETIRADA, valorAbsoluto);

        if (valorAbsoluto >= 3000) {
            throw new AvisarHaciendaException(cliente, IBAN, Tipo.RETIRADA);
        }
    }

    public void generarMovimiento(Tipo tipo, double cantidad) {
        this.movimiento.add(new Movimiento(tipo, cantidad));
    }

    //LO CAMBIO A TO STRING como hice en movimiento (aunque no lo pide la practica)
    @Override
    public String toString() {
        return " DATOS DE LA CUENTA \n" +
                "Titular: " + this.cliente + "\n" +
                "IBAN: " + this.IBAN + "\n" +
                "Saldo actual: " + this.saldo + "€\n" +
                "--";
    }

    public String infoMovimientos() {
        String info = "";
        if (this.movimiento.isEmpty()) {
            info = "No hay movimientos";
        } else {
            for (Movimiento m : this.movimiento) {
                info += m.toString() + "\n";
            }
        }
        return info;
    }

}//CLASE CUENTABANCARIA