public class CuentaBancaria {

    private String IBAN;
    private String titular;
    private double saldo;

    private Movimiento[] movimientos;

    private int contadorMovimientos;

    public CuentaBancaria(String IBAN, String titular) {
        this.IBAN = IBAN;
        this.titular = titular;

        this.movimientos = new Movimiento[100];
        this.saldo = 0.0;

        this.contadorMovimientos = 0;
    }

    public String getIBAN() {
        return this.IBAN;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean ingresar(double valor) {
        boolean retorno = false;
        double valorAbsoluto = Math.abs(valor);
        this.saldo += valorAbsoluto;
        retorno = true;
        //generar movimiento
        this.generarMovimiento(Tipo.INGRESO, valorAbsoluto);
        return retorno;
    }

    public boolean retirar(double valor) {
        boolean retorno = false;
        double valorAbsoluto = Math.abs(valor);
        if((this.saldo - valorAbsoluto) >= -50) {
            this.saldo -= valorAbsoluto;
            this.generarMovimiento(Tipo.RETIRADA, valorAbsoluto);
            retorno = true;
        }
        return retorno;
    }

    public void generarMovimiento(Tipo tipo, double cantidad) {
        if(this.contadorMovimientos < this.movimientos.length) {
            this.movimientos[this.contadorMovimientos] = new Movimiento(tipo, cantidad);
        }
        else if(this.contadorMovimientos >= this.movimientos.length) {
            this.ampliarDimensionMovimientos();
            this.movimientos[this.contadorMovimientos] = new Movimiento(tipo, cantidad);
        }
        this.contadorMovimientos++;
    }

    private void ampliarDimensionMovimientos(){
        Movimiento[] movimientosAux = new Movimiento[this.movimientos.length + 10];
        for(int i = 0; i < this.movimientos.length; i++){
            movimientosAux[i] = this.movimientos[i];
        }
        this.movimientos = movimientosAux;
    }

    public String infoCuentaBancaria() {
        String info = "";
        info += "Titular: " + this.titular + "\n";
        info += "IBAN: " + this.IBAN + "\n";
        info += "Saldo: " + this.saldo + "\n";
        return info;
    }

    public String infoMovimientos() {
        String info = "";
        if(this.contadorMovimientos > 0) {
            for(int i = 0; i < this.contadorMovimientos; i++){
                info += this.movimientos[i].mostrarInfoMovimiento() + "\n";
            }
        }else{
            info = "No hay movimientos";
        }
        return info;
    }
}