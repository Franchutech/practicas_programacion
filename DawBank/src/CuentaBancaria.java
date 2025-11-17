import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    //Validacion IBAN

    public boolean requerimientosIban() {
        //1. no deberia ser nulo, por lo que uso un booleano.

        if (iban == null) return false;

        //2. longitud maxima que permite es 22 digitos.
        if (iban.length() != 22) return false;


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

    //metodo para ingresar dinero

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            Movimiento m = new Movimiento("Ingreso", cantidad);
            agregarMovimiento(m);
        }
    }

    //metodo para retirar dinero

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            Movimiento m = new Movimiento("Retirada", cantidad);
            agregarMovimiento(m);
        }
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

    //limitar el nombre del usuario a X cantidad de dígitos



} //class CuentaBancaria

