public class CuentaBancaria {

    //atributos y campos de la clase

    private final String iban;
    private final String titular;
    private double saldo;
    private Movimiento[] movimientos;
    private int contadorInternoMovimientos = 0; // para guardar movimientos en el array

    // Constructor
    public CuentaBancaria(String iban, String titular, double saldo) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
        this.movimientos = new Movimiento[100]; // máximo 100 movimientos
    }//constructor

    //GETTER
    public String getIban() {
        return this.iban;
    }
    public double getSaldo() {
        return this.saldo;
    } //tener cuidado con los double, escribirlos en minuscula.

    //SETTER
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }

    //METODOS

    /*Validacion IBAN (al final no use esto, sino mas bien el de MiUtils del profe, pero lo dejo acá porque
    me costo mucho hacerlo*/

    public boolean requerimientosIban() {
        //1. no deberia ser nulo, por lo que uso un booleano.
        if (iban == null) return false;
        //2. longitud maxima que permite es 24 digitos.
        if (iban.length() != 24) return false;
        //3. Los 2 primeros digitos deben ser letras.
        char letra1 = iban.charAt(0);
        char letra2 = iban.charAt(1);
        if (!Character.isLetter(letra1) || !Character.isLetter(letra2)) return false;
        //4. El resto deben ser numeros
        for (int i = 2; i < iban.length(); i++) {
            if (!Character.isDigit(iban.charAt(i))) {
                return false;
            }
        }
        //y si todo lo anterior se da entonces el booleano debería pasar a verdadero
        return true;
    }//requerimientosiban metodo

    // metodo agregar movimientos (contarlos para el array)
    public void agregarMovimiento(Movimiento m) {
        if (contadorInternoMovimientos < movimientos.length) {
            movimientos[contadorInternoMovimientos] = m;
            contadorInternoMovimientos++;
        }
    }

        //METODO PARA INGRESAR DINERO

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            if (saldo < 0) {
                System.err.println("AVISO: Saldo negativo");
            }
            if (cantidad > 3000) {
                System.out.println("AVISO: Notificar a hacienda");
            }
            Movimiento m = new Movimiento("Ingreso", cantidad);
            agregarMovimiento(m);
        }
    }
    //METODO PARA RETIRAR DINERO

    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            return;
        }
        double saldoFuturo = saldo - cantidad;
        if (saldoFuturo < -50) {
            System.err.println("Saldo por debajo del limite permitido");
            return;
        }

        // Si la operación se permite:
        saldo = saldoFuturo;
        if (saldo < 0) {
            System.err.println("AVISO: Saldo negativo");
        }
        if (cantidad > 3000) {
            System.out.println("AVISO: Notificar a hacienda");
        }
        Movimiento m = new Movimiento("Retirada", cantidad);
        agregarMovimiento(m);
    }

    // Metodo mostrar movimientos

    public void mostrarMovimientos() {
        for (int i = 0; i < contadorInternoMovimientos; i++) {
            System.out.println(movimientos[i].mostrarInfoMovimiento());
        }
    }

    //Método mostrar informacion de la cuenta

    public String mostrarInfoCuenta() {
        String info = "";
        info += "IBAN: " + iban + "\n";
        info += "Titular: " + titular + "\n";
        info += "Saldo: " + saldo + "\n";
        info += "Movimientos realizados: " + contadorInternoMovimientos + "\n";

        return info;
    }

    //METODO VALIDAR NOMBRE DEL TITULAR
        //1.no debe ser nulo, por lo que uso un boolean
    public static boolean validacionTitular(String titular) {
        if (titular == null) return false;
        titular = titular.trim(); //valido el espacio del nombre quitando espacios en blanco de los bordes
        //2.debe tener cierta longitud para que realmente sea un nombre
        if (titular.length() == 0) return false;
        //3.debe tener menos de 50 caracteres
        if(titular.length() > 50) return false;
        //4. titular deberia tener espacios entre nombre y apellido
        if (!titular.contains(" ")) return false;
        //5.Deberia tener minimo un nombre unos 5 caracteres
        if (titular.length() < 5) return false;

        return true;
    }//validarNombreTitular


} //class CuentaBancaria

