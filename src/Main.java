import java.time.LocalDate;

/**
 * Main - Maneja el menú principal y coordina Empresa y CuentaBancaria.
 */
public class Main {

    public static void main(String[] args) {

        Empresa empresa = null;
        CuentaBancaria cuenta = null;

        int opcion;

        do {
            opcion = mostrarMenu();

            switch (opcion) {

                case 1 -> {
                    String nombre = MiUtils.leerTexto("Nombre Empresa:");
                    String cif = MiUtils.comprobarPatronRepetidamente("[A-Z]\\d{10}", "CIF:");
                    empresa = new Empresa(nombre, cif, LocalDate.now(), 50);
                }

                case 2 -> {
                    if (empresa == null) {
                        System.out.println("Primero cree la empresa.");
                        break;
                    }

                    String dni = MiUtils.comprobarPatronRepetidamente("\\d{8}[A-Z]", "DNI:");
                    String nombre = MiUtils.leerTexto("Nombre:");
                    String dir = MiUtils.leerTexto("Dirección:");

                    empresa.registrarTrabajador(
                            new Trabajador(nombre, dni, dir, LocalDate.of(1990, 1, 1))
                    );
                }

                case 3 -> {
                    if (empresa != null) {
                        empresa.mostrarInformacion();
                        empresa.mostrarTrabajadores();
                    }
                }

                case 4 -> {
                    String iban = MiUtils.comprobarPatronRepetidamente("[A-Z]{2}\\d{22}", "IBAN:");
                    String titular = MiUtils.leerTexto("Titular:");
                    cuenta = new CuentaBancaria(iban, titular);
                }

                case 5 -> {
                    if (cuenta == null) {
                        System.out.println("Primero cree la cuenta.");
                        break;
                    }

                    int op = MiUtils.leerEntero("1 Ingreso / 2 Retirada:");
                    double cant = MiUtils.leerDecimal("Cantidad:");

                    if (op == 1) cuenta.ingreso(cant);
                    else cuenta.retirada(cant);
                }

                case 6 -> {
                    if (cuenta != null) {
                        cuenta.mostrarInfo();
                        cuenta.mostrarMovimientos();
                    }
                }
            }

        } while (opcion != 7);

        System.out.println("Fin del programa.");
    }

    /** Menú principal separado en método limpio */
    public static int mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Crear Empresa");
        System.out.println("2. Registrar Trabajador");
        System.out.println("3. Mostrar Empresa");
        System.out.println("4. Crear Cuenta Bancaria");
        System.out.println("5. Ingreso / Retirada");
        System.out.println("6. Mostrar Cuenta");
        System.out.println("7. Salir");

        return MiUtils.leerEntero("Opción:");
    }
}
