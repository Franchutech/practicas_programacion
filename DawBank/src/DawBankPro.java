import java.util.Scanner;

public class DawBankPro {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ARRAY para almacenar varias cuentas
        CuentaBancaria[] cuentas = new CuentaBancaria[5];
        int numCuentas = 0;

        // Referencia a la cuenta activa
        CuentaBancaria cuentaActiva = null;

        int opcion = 0;

        do {
            mostrarMenuPrincipal();
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1: // Crear nueva cuenta
                    if (numCuentas >= 5) {
                        System.out.println("No se pueden crear más cuentas.");
                        break;
                    }

                    System.out.println("=== Crear nueva cuenta bancaria ===");

                    String iban = MiUtils.comprobarPatronRepetidamente(
                            "[a-zA-Z]{2}[0-9]{22}",
                            "Introduzca el IBAN");

                    boolean validoNombre = false;
                    String titular = "";

                    do {
                        System.out.print("Introduzca el titular: ");
                        titular = sc.nextLine();
                        validoNombre = CuentaBancaria.validacionTitular(titular);

                        if (!validoNombre) {
                            System.out.println("Titular no válido, inténtelo de nuevo.");
                        }
                    } while (!validoNombre);

                    cuentas[numCuentas] = new CuentaBancaria(iban, titular, 0);
                    cuentaActiva = cuentas[numCuentas]; // la nueva será la activa
                    numCuentas++;

                    System.out.println("Cuenta creada correctamente.");
                    break;

                case 2: // Listar todas las cuentas
                    if (numCuentas == 0) {
                        System.out.println("No hay cuentas creadas.");
                        break;
                    }

                    System.out.println(" LISTA DE CUENTAS ");
                    for (int i = 0; i < numCuentas; i++) {
                        System.out.println(i + ". " + cuentas[i].getIban()
                                + " - " + cuentas[i].mostrarInfoCuenta());
                    }
                    break;

                case 3: // Elegir cuenta activa
                    if (numCuentas == 0) {
                        System.out.println("Debe crear al menos una cuenta.");
                        break;
                    }

                    System.out.println("Seleccione número de cuenta:");
                    for (int i = 0; i < numCuentas; i++) {
                        System.out.println(i + ". " + cuentas[i].getIban());
                    }

                    int idx = Integer.parseInt(sc.nextLine());

                    if (idx < 0 || idx >= numCuentas) {
                        System.out.println("Índice no válido.");
                        break;
                    }

                    cuentaActiva = cuentas[idx];
                    System.out.println("Cuenta activa cambiada.");
                    break;

                case 4: // Operaciones bancarias SOLO si hay cuenta activa
                    if (cuentaActiva == null) {
                        System.out.println("Debe seleccionar una cuenta activa primero.");
                        break;
                    }

                    menuOperaciones(cuentaActiva, sc);
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // MENÚ PRINCIPAL
    public static void mostrarMenuPrincipal() {
        System.out.println("DAWBANK PRO");
        System.out.println("1. Crear cuenta bancaria");
        System.out.println("2. Listar cuentas");
        System.out.println("3. Seleccionar cuenta activa");
        System.out.println("4. Operar con la cuenta activa");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // MENU DE OPERACIONES DE UNA CUENTA CONCRETA
    public static void menuOperaciones(CuentaBancaria cuenta, Scanner sc) {

        int opcion = 0;

        do {
            System.out.println("OPERACIONES PARA: " + cuenta.getIban() + "-");
            System.out.println("1. Mostrar datos de la cuenta");
            System.out.println("2. Mostrar saldo");
            System.out.println("3. Ingresar dinero");
            System.out.println("4. Retirar dinero");
            System.out.println("5. Mostrar movimientos");
            System.out.println("6. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    System.out.println(cuenta.mostrarInfoCuenta());
                    break;

                case 2:
                    System.out.println("Saldo: " + cuenta.getSaldo());
                    break;

                case 3:
                    System.out.print("Cantidad a ingresar: ");
                    double ingreso = Double.parseDouble(sc.nextLine());
                    cuenta.ingresar(ingreso);
                    break;

                case 4:
                    System.out.print("Cantidad a retirar: ");
                    double retiro = Double.parseDouble(sc.nextLine());
                    cuenta.retirar(retiro);
                    break;

                case 5:
                    cuenta.mostrarMovimientos();
                    break;

                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 6);
    }

}

