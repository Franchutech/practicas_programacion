import java.util.Scanner;

public class DawBank {
    public static void main(String[] args) {
        Scanner sc;

        final String ibanPattern = "[A-Z]{2}[0-9]{22}";
        final String titularPattern = "[a-z A-Z]{3,}";

        String titular = MiUtils.comprobarPatronRepetidamente(titularPattern, "Introduce un titular");
        String IBAN = MiUtils.comprobarPatronRepetidamente(ibanPattern, "Introduce un IBAN");

        CuentaBancaria miCuenta = new CuentaBancaria(IBAN, titular);

        String opcion = "";

        do{
            sc = new Scanner(System.in);

            imprimirMenuOpciones();
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(miCuenta.infoCuentaBancaria());
                    break;

                case "2":
                    System.out.println("El IBAN es: " + miCuenta.getIBAN());
                    break;

                case "3":
                    System.out.println("El Titular es: " + miCuenta.getTitular());
                    break;

                case "4":
                    System.out.println("El saldo es: " + miCuenta.getSaldo());
                    break;

                case "5":
                    ingresar(miCuenta);
                    break;

                case "6":
                    retirar(miCuenta);
                    break;

                case "7":
                    System.out.println(miCuenta.infoMovimientos());
                    break;

                case "8":
                    System.out.println("Gracias por elegir DawBANk, hasta la proxima.");
                    break;

                default:
                    System.out.println("Por favor, escoja la opcion correcta (1-8) ejem ejem ejem tonto");
            }

        }while(!opcion.equals("8"));

    }

    private static void retirar(CuentaBancaria miCuenta) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad a ingresar");
        double retirar = sc.nextDouble();

        if(miCuenta.retirar(retirar)){
            System.out.println("La operación se ha realizado con exito");
            if(Math.abs(retirar) > 3000){
                System.out.println("Se ha notificado a hacienda del movimiento");
            }
        }else{
            System.out.println("No se ha realizado la operación porque su saldo quedaria por debajo de -50€");
        }
    }

    private static void ingresar(CuentaBancaria miCuenta) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad a ingresar");
        double cantidad = sc.nextDouble();

        if(miCuenta.ingresar(cantidad)){
            System.out.println("La operación se ha realizado con exito");
            if(cantidad > 3000){
                System.out.println("Se ha notificado a hacienda del movimiento");
            }
        }else{
            System.out.println("Se ha producido un error en el proceso");
        }
    }

    private static void imprimirMenuOpciones() {
        System.out.println("Escoga la opcion que desee");
        System.out.println("1. Datos de la cuenta");
        System.out.println("2. IBAN");
        System.out.println("3. Titular");
        System.out.println("4. Saldo");
        System.out.println("5. Ingreso");
        System.out.println("6. Retirada");
        System.out.println("7. Movimientos");
        System.out.println("8. Salir");
    }
}
