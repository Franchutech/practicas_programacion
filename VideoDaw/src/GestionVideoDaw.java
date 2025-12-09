import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // === REGISTRO INICIAL DEL VIDEOCLUB ===
        System.out.println(" REGISTRO INICIAL DEL VIDEOCLUB ");

        String cif;
        do {
            cif = MiUtils.leerTextoPantalla("Introduzca el CIF (formato A12345678): ");
            if (!VideoDaw.validarCIF(cif)) {
                System.out.println("CIF incorrecto.");
            }
        } while (!VideoDaw.validarCIF(cif));

        String direccionVC = MiUtils.leerTextoPantalla("Introduzca la dirección del videoclub: ");
        LocalDate fechaAltaVC = LocalDate.now();

        VideoDaw videoDaw = new VideoDaw(cif, direccionVC, fechaAltaVC);

        System.out.println("\n VIDEOCLUB REGISTRADO ");

        // === MENÚ PRINCIPAL ===
        int opcion = 0;
        do {

            opcion = mostrarMenu(sc);

            switch (opcion) {

                // 1. REGISTRAR PELÍCULA
                case 1:
                    System.out.println(" REGISTRO DE PELÍCULA ");
                    String titulo = MiUtils.leerTextoPantalla("Introduzca el título de la película:");

                    System.out.println("Seleccione un género:");
                    for (Genero g : Genero.values()) {
                        System.out.println("- " + g);
                    }

                    String generoStr = sc.nextLine().toUpperCase();
                    Genero genero = Genero.valueOf(generoStr);

                    Pelicula nuevaPelicula = new Pelicula(titulo, genero);

                    if (videoDaw.registrarPelicula(nuevaPelicula)) {
                        System.out.println("Película registrada correctamente.");
                    } else {
                        System.out.println("ERROR: La película ya existe.");
                    }
                    break;

                // 2. REGISTRAR CLIENTE
                case 2:
                    System.out.println(" REGISTRO DE CLIENTE ");

                    String dni = MiUtils.comprobarPatronRepetidamente(
                            "[0-9]{8}[a-zA-Z]",
                            "Introduzca el DNI (Formato 99999999Z): "
                    );

                    String nombre = MiUtils.leerTextoPantalla("Introduzca el nombre:");
                    while (!Cliente.validacionNombre(nombre)) {
                        nombre = MiUtils.leerTextoPantalla("Nombre no válido. Introduzca nuevamente:");
                    }

                    String direccion = MiUtils.leerTextoPantalla("Introduzca la dirección:");
                    while (!Cliente.validacionDireccion(direccion)) {
                        direccion = MiUtils.leerTextoPantalla("Dirección no válida. Introduzca nuevamente:");
                    }

                    // ➤ AHORA SÍ USAMOS LECTURA SEGURA
                    LocalDate fechaNac = leerFechaValida(sc, "Introduzca fecha de nacimiento (AAAA-MM-DD): ");
                    while (!Cliente.esMayorDeEdad(fechaNac)) {
                        System.out.println("Debe ser mayor de edad. Intente de nuevo:");
                        fechaNac = leerFechaValida(sc, "Introduzca fecha de nacimiento (AAAA-MM-DD): ");
                    }

                    Cliente nuevoCliente = new Cliente(dni, nombre, direccion, fechaNac);

                    if (videoDaw.registrarCliente(nuevoCliente)) {
                        System.out.println("Cliente registrado correctamente.");
                    } else {
                        System.out.println("ERROR: El cliente ya está registrado.");
                    }
                    break;

                // 3. ALQUILAR PELÍCULA
                case 3:
                    System.out.println(" ALQUILAR PELÍCULA ");

                    System.out.print("Código de película (P-XXXX): ");
                    String codPeliAlq = sc.nextLine();

                    Pelicula peliculaAAlquilar = buscarPelicula(videoDaw, codPeliAlq);
                    if (peliculaAAlquilar == null) {
                        System.out.println("Película no encontrada.");
                        break;
                    }

                    System.out.print("DNI del cliente: ");
                    String dniAlquiler = sc.nextLine();

                    Cliente clienteAlquiler = buscarCliente(videoDaw, dniAlquiler);
                    if (clienteAlquiler == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    if (videoDaw.alquilarPelicula(peliculaAAlquilar, clienteAlquiler)) {
                        System.out.println("Película alquilada correctamente.");
                    } else {
                        System.out.println("ERROR: La película ya está alquilada.");
                    }
                    break;

                // 4. DEVOLVER PELÍCULA
                case 4:
                    System.out.println(" DEVOLVER PELÍCULA ");

                    System.out.print("Código de película: ");
                    String codPeliDev = sc.nextLine();

                    Pelicula peliculaADevolver = buscarPelicula(videoDaw, codPeliDev);
                    if (peliculaADevolver == null) {
                        System.out.println("Película no encontrada.");
                        break;
                    }

                    System.out.print("DNI del cliente: ");
                    String dniDev = sc.nextLine();

                    Cliente clienteDev = buscarCliente(videoDaw, dniDev);
                    if (clienteDev == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    if (videoDaw.devolverPelicula(peliculaADevolver, clienteDev)) {
                        System.out.println("Película devuelta correctamente.");
                    } else {
                        System.out.println("ERROR: No se pudo devolver.");
                    }
                    break;

                // 5. DAR DE BAJA CLIENTE
                case 5:
                    System.out.println(" DAR DE BAJA CLIENTE ");
                    System.out.print("DNI del cliente: ");
                    String dniBaja = sc.nextLine();

                    if (videoDaw.darBajaCliente(dniBaja)) {
                        System.out.println("Cliente dado de baja.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                // 6. DAR DE BAJA PELÍCULA
                case 6:
                    System.out.println(" DAR DE BAJA PELÍCULA ");
                    System.out.print("Código de película: ");
                    String codBaja = sc.nextLine();

                    if (videoDaw.darBajaPelicula(codBaja)) {
                        System.out.println("Película dada de baja.");
                    } else {
                        System.out.println("Película no encontrada.");
                    }
                    break;

                // 7. MOSTRAR INFORMACIÓN DEL VIDEOCLUB
                case 7:
                    System.out.println(videoDaw.mostrarInfoVideoClub());
                    System.out.println(videoDaw.mostrarClientesRegistrados());
                    System.out.println(videoDaw.mostrarPeliculasRegistradas());
                    break;

                // 8. SALIR
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 8);
    }

    // MENÚ SEGURO
    public static int mostrarMenu(Scanner sc) {

        System.out.println("\n MENÚ PRINCIPAL ");
        System.out.println("1. Registrar película");
        System.out.println("2. Registrar cliente");
        System.out.println("3. Alquilar película");
        System.out.println("4. Devolver película");
        System.out.println("5. Dar de baja cliente");
        System.out.println("6. Dar de baja película");
        System.out.println("7. Mostrar información del videoclub");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");

        String entrada = sc.nextLine().trim();

        while (!entrada.matches("[1-8]")) {
            System.out.println("Opción no válida. Debe ser un número del 1 al 8.");
            System.out.print("Seleccione una opción: ");
            entrada = sc.nextLine().trim();
        }

        return Integer.parseInt(entrada);
    }

    // BUSCAR PELÍCULA
    public static Pelicula buscarPelicula(VideoDaw v, String cod) {
        for (Pelicula p : v.getPeliculasRegistradas()) {
            if (p != null && p.getCod().equals(cod)) return p;
        }
        return null;
    }

    // BUSCAR CLIENTE
    public static Cliente buscarCliente(VideoDaw v, String dni) {
        for (Cliente c : v.getClientesRegistrados()) {
            if (c != null && c.getDNI().equals(dni)) return c;
        }
        return null;
    }

    // LECTURA SEGURA DE FECHA
    public static LocalDate leerFechaValida(Scanner sc, String mensaje) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = null;

        boolean fechaValida = false;

        while (!fechaValida) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();

            if (!entrada.matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("Formato incorrecto. Use AAAA-MM-DD (ej: 1999-11-06).");
                continue;
            }

            try {
                fecha = LocalDate.parse(entrada, formatter);
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Fecha inválida. Intente otra vez.");
            }
        }

        return fecha;
    }

}
