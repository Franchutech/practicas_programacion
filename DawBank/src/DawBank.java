import java.util.Scanner;

public class DawBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  //RECORDAR SIEMPRE CERRAR EL SCANNER AL FINAL DE PROGRAMA


        //validacion de la cuenta iban con MiUtils del profe

        String ibanComprobado = MiUtils.comprobarPatronRepetidamente("[a-zA-Z]{2}[0-9]{22}",
                "Introduzca el IBAN");

        String titularComprobado;

        //bucle para pedir nombre del titular

        System.out.print("Introduzca el titular: ");

        boolean titularComprobadoValido = false;
        do {
            titularComprobado = sc.nextLine();
            titularComprobadoValido = CuentaBancaria.validacionTitular(titularComprobado);

            if  (!titularComprobadoValido) {
                System.out.println("Introduzca el titular valido");

            }else {
                System.out.println("Nombre del titular registrado: " + titularComprobado);
            }

        }while(!titularComprobadoValido);

        //guardar en una cuenta los datos comprobados.

        CuentaBancaria cuentaReal = new CuentaBancaria(ibanComprobado, titularComprobado, 0);


        //MENU PARA EL USUARIO

        String opcion = "";    //RECORDAR SIEMPRE USAR STRING PARA ESTO.

        do {
            mostrarMenu();
            opcion = sc.nextLine();

            switch (opcion) {

                case "1":
                    System.out.println(cuentaReal.mostrarInfoCuenta());
                    break;

                case "2":
                    System.out.println("IBAN: " + cuentaReal.getIban());
                    break;

                case "3":
                    System.out.println("Titular: " + titularComprobado);
                    break;

                case "4":
                    System.out.println("Saldo actual: " + cuentaReal.getSaldo());
                    break;

                case "5":
                    System.out.print("Cantidad a ingresar: ");
                    double cantidadIngreso = Double.parseDouble(sc.nextLine());
                    cuentaReal.ingresar(cantidadIngreso);
                    break;

                case "6":
                    System.out.print("Cantidad a retirar: ");
                    double cantidadRetiro = Double.parseDouble(sc.nextLine());
                    cuentaReal.retirar(cantidadRetiro);
                    break;

                case "7":
                    cuentaReal.mostrarMovimientos();
                    break;

                case "8":
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != "8");  //COMILLAS PORQUE ES STRING
        

    } //void

    public static void mostrarMenu() {
        System.out.println("----- MENÚ BANCARIO -----");
        System.out.println("1. Mostrar datos de la cuenta");
        System.out.println("2. Mostrar IBAN");
        System.out.println("3. Mostrar titular");
        System.out.println("4. Mostrar saldo");
        System.out.println("5. Realizar un ingreso");
        System.out.println("6. Realizar un retiro");
        System.out.println("7. Mostrar histórico de movimientos");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }//metodo mostrar menu

} //clase