import java.util.Scanner;
import java.time.LocalDate;

public class DawBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String ibanPattern = "[A-Z]{2}[0-9]{22}";
        final String titularPattern = "[a-zA-Z\\s]{3,}";

        System.out.println("-BIENVENIDO A DAWBANK-");

        // 1. Pido datos para crear el objeto Cliente (Punto 6.B y 6.C)
        String Nombre = MiUtils.comprobarPatronRepetidamente(titularPattern, "Introduce el nombre del titular");
        String DNI = MiUtils.comprobarPatronRepetidamente("^([0-9]{8}[A-Z])", "Introduce el DNI");

        // Uso una fecha por defecto para no complicar el Scanner ahora
        LocalDate fechaNac = LocalDate.of(1995, 5, 15);

        Cliente cliente = null;
        try {
            // Cro el cliente (puede lanzar CuentaException por sus setters)
            cliente = new Cliente(Nombre, DNI, fechaNac, "600123123", "cliente@email.com", "Calle Mayor 1");
        } catch (CuentaException e) {
            System.out.println("Error al crear el cliente: " + e.getMessage());
            e.printStackTrace();
            return; // Si no hay cliente, no puedo seguir
        }

        String IBAN = MiUtils.comprobarPatronRepetidamente(ibanPattern, "Introduce un IBAN");

        // 2. Creo la cuenta con el objeto Cliente
        CuentaBancaria miCuenta = new CuentaBancaria(IBAN, cliente);

        String opcion = "";

        do {
            imprimirMenuOpciones();
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    // Punto 5: Muestro info usando el toString()
                    System.out.println(miCuenta.toString());
                    break;

                case "2":
                    System.out.println("El IBAN es: " + miCuenta.getIBAN());
                    break;

                case "3":
                    // Accedo al nombre a través del objeto cliente
                    System.out.println("El Titular es: " + miCuenta.getCliente().getNombre());
                    break;

                case "4":
                    System.out.println("El saldo es: " + miCuenta.getSaldo() + "€");
                    break;

                case "5":
                    ingresar(miCuenta);
                    break;

                case "6":
                    retirar(miCuenta);
                    break;

                case "7":
                    // Punto 6.G: Muestro movimientos de la colección
                    System.out.println(miCuenta.infoMovimientos());
                    break;

                case "8":
                    System.out.println("Gracias por elegir DawBANK, hasta la próxima.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (!opcion.equals("8"));
    }

    private static void ingresar(CuentaBancaria miCuenta) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad a ingresar:");
        try {
            double cantidad = Double.parseDouble(sc.nextLine());
            miCuenta.ingresar(cantidad);
            System.out.println("Operación realizada con éxito.");
        } catch (AvisarHaciendaException e) {
            // Punto 6.F: Capturo aviso de hacienda, pero la operación se hizo
            System.out.println("AVISO: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error inesperado.");
            e.printStackTrace();
        }
    }

    private static void retirar(CuentaBancaria miCuenta) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad a retirar:");
        try {
            double cantidad = Double.parseDouble(sc.nextLine());
            miCuenta.retirar(cantidad);
            System.out.println("Operación realizada con éxito.");
        } catch (CuentaException e) {
            // Punto 6.E: Error de saldo u otros
            System.out.println("ERROR DE CUENTA: " + e.getMessage());
            e.printStackTrace();
        } catch (AvisarHaciendaException e) {
            // Punto 6.F: Movimiento >= 3000
            System.out.println("AVISO HACIENDA: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error en el sistema.");
            e.printStackTrace();
        }
    }

    private static void imprimirMenuOpciones() {
        System.out.println("\n--- MENÚ DAWBANK ---");
        System.out.println("1. Datos de la cuenta");
        System.out.println("2. IBAN");
        System.out.println("3. Titular");
        System.out.println("4. Saldo");
        System.out.println("5. Ingreso");
        System.out.println("6. Retirada");
        System.out.println("7. Movimientos");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }
}