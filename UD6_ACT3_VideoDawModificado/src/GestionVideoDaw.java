import java.time.LocalDate;
import java.util.Scanner;
import exceptions.ArticuloYaRegistradoException;
import exceptions.ClienteYaRegistradoException;

public class GestionVideoDaw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VideoDaw videoDaw = null;

        String archivo = "videodaw.dat";

        try {
            //Intento cargar el objeto VideoDaw desde el archivo
            videoDaw = VideoDaw.cargarDatos(archivo);
            System.out.println("--- DATOS CARGADOS CORRECTAMENTE ---");

        } catch (Exception e) {
            //Si el archivo no existe o da error, creo uno nuevo desde cero
            System.out.println("No se encontraron datos previos. Iniciando registro nuevo...");

            System.out.println(" REGISTRO INICIAL DEL VIDEOCLUB ");
            String cif = MiUtils.comprobarPatronRepetidamente(
                    "[a-zA-Z][0-9]{8}",
                    "Introduzca el CIF (formato A12345678): "
            );

            System.out.print("Introduzca la dirección del videoclub: ");
            String direccionVC = sc.nextLine();

            // 5. Aquí creamos la instancia nueva si la carga falló
            videoDaw = new VideoDaw(cif, direccionVC, LocalDate.now());
            System.out.println("\n VIDEOCLUB REGISTRADO ");
        }


        int opcion = 0;

        do {
            opcion = mostrarMenu(sc);

            switch (opcion) {

                case 1: // REGISTRAR PELÍCULA
                    System.out.println(" ¿QUÉ DESEA REGISTRAR? ");
                    System.out.println("1. Película");
                    System.out.println("2. Videojuego");
                    String tipo = sc.nextLine();

                    System.out.print("Introduzca el título: ");
                    String titulo = sc.nextLine();

                    Articulo nuevoArticulo = null; // Declaro la madre

                    if (tipo.equals("1")) {
                        // LÓGICA DE PELÍCULA
                        System.out.println("Seleccione un género:");
                        for (Genero g : Genero.values()) { System.out.println("- " + g); }
                        Genero genero = Genero.valueOf(sc.nextLine().toUpperCase());

                        // Creo la hija Pelicula
                        nuevoArticulo = new Pelicula("P-001", titulo, genero);

                    } else if (tipo.equals("2")) {
                        // LÓGICA DE VIDEOJUEGO
                        System.out.println("Seleccione plataforma:");
                        for (PLATAFORMAVJ p : PLATAFORMAVJ.values()) { System.out.println("- " + p); }
                        PLATAFORMAVJ plata = PLATAFORMAVJ.valueOf(sc.nextLine().toUpperCase());

                        System.out.println("Seleccione género del videojuego:");
                        for (GeneroVideoJuego gv : GeneroVideoJuego.values()) { System.out.println("- " + gv); }
                        GeneroVideoJuego genvj = GeneroVideoJuego.valueOf(sc.nextLine().toUpperCase());

                        // Creo la hija Videojuego
                        nuevoArticulo = new Videojuego("V-001", titulo, genvj, plata);
                    }

                    // INTENTO DE REGISTRO CON EXCEPCIÓN
                    try {
                        if (nuevoArticulo != null) {
                            videoDaw.registrarArticulo(nuevoArticulo);
                            System.out.println("Artículo registrado con éxito.");
                        }
                    } catch (ArticuloYaRegistradoException e) {
                        // Si el código ya existe, VideoDaw lanza la excepción y la atrapo aquí
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 2: // REGISTRAR CLIENTE
                    System.out.println(" REGISTRO DE CLIENTE ");

                    // 1. Validación de DNI
                    String dni = MiUtils.comprobarPatronRepetidamente(
                            "[0-9]{8}[a-zA-Z]",
                            "Introduzca el DNI (Formato 99999999Z): "
                    );

                    System.out.print("Introduzca el nombre: ");
                    String nombre = sc.nextLine();
                    while (!Cliente.validacionNombre(nombre)) {
                        System.out.print("Nombre no válido. Introduzca nuevamente: ");
                        nombre = sc.nextLine();
                    }

                    System.out.print("Introduzca la dirección: ");
                    String direccion = sc.nextLine();
                    while (!Cliente.validacionDireccion(direccion)) {
                        System.out.print("Dirección no válida. Introduzca nuevamente: ");
                        direccion = sc.nextLine();
                    }

                    // 2. Validación de edad
                    LocalDate fechaNac = leerFechaValida(sc, "Introduzca fecha de nacimiento (AAAA-MM-DD): ");
                    while (!Cliente.esMayorDeEdad(fechaNac)) {
                        System.out.println("Debe ser mayor de edad. Intente de nuevo:");
                        fechaNac = leerFechaValida(sc, "Introduzca fecha de nacimiento (AAAA-MM-DD): ");
                    }

                    // 3. Intento de registro
                    try {
                        Cliente nuevoCliente = new Cliente(dni, nombre, direccion, fechaNac);

                        // llamo al meotodo que cree en VideoDaw que lanza la excepción
                        videoDaw.registrarCliente(nuevoCliente);
                        System.out.println("Cliente registrado correctamente.");

                    } catch (ClienteYaRegistradoException e) {
                        // 4. Si el DNI ya existe, capturamos el error aquí
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 3: // ALQUILAR PELÍCULA
                    System.out.println(" ALQUILAR ARTÍCULO ");

                    System.out.print("Introduzca el código del artículo (P-XXXX o V-XXXX): ");
                    String codAlq = sc.nextLine();

                    // 1. Buscamos de forma genérica en la lista de artículos
                    Articulo artAlquiler = buscarArticulo(videoDaw, codAlq);

                    if (artAlquiler == null) {
                        System.out.println("Artículo no encontrado.");
                    } else {
                        System.out.print("DNI del cliente: ");
                        String dniAlq = sc.nextLine();
                        Cliente cliAlq = buscarCliente(videoDaw, dniAlq);

                        if (cliAlq == null) {
                            System.out.println("Cliente no encontrado.");
                        } else {
                            // 2. Usamos el método polimórfico que creamos en VideoDaw
                            if (videoDaw.alquilarArticulo(artAlquiler, cliAlq)) {
                                System.out.println("Alquiler realizado: " + artAlquiler.getTitulo());
                            } else {
                                System.out.println("ERROR: El artículo ya está alquilado.");
                            }
                        }
                    }
                    break;

                case 4: // DEVOLVER PELÍCULA
                    System.out.println(" DEVOLVER ARTÍCULO ");

                    System.out.print("Código del artículo a devolver: ");
                    String codDev = sc.nextLine();
                    Articulo artDev = buscarArticulo(videoDaw, codDev);

                    if (artDev == null) {
                        System.out.println("Artículo no encontrado.");
                    } else {
                        System.out.print("DNI del cliente: ");
                        String dniDev = sc.nextLine();
                        Cliente cliDev = buscarCliente(videoDaw, dniDev);

                        if (cliDev == null) {
                            System.out.println("Cliente no encontrado.");
                        } else {
                            // 3. Devolvemos usando la lógica genérica
                            if (videoDaw.devolverArticulo(artDev, cliDev)) {
                                System.out.println("Artículo devuelto con éxito.");
                            } else {
                                System.out.println("ERROR: Este cliente no tenía alquilado este artículo.");
                            }
                        }
                    }
                    break;
                case 5: // DAR DE BAJA CLIENTE
                    System.out.println(" DAR DE BAJA CLIENTE ");
                    System.out.print("DNI del cliente: ");
                    String dniBaja = sc.nextLine();

                    if (videoDaw.darBajaCliente(dniBaja)) {
                        System.out.println("Cliente dado de baja.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 6: // DAR DE BAJA PELÍCULA
                    System.out.println(" DAR DE BAJA ARTÍCULO ");
                    System.out.print("Código del artículo: ");
                    String codBaja = sc.nextLine();

                    if (videoDaw.darBajaArticulo(codBaja)) {
                        System.out.println("Artículo dado de baja.");
                    } else {
                        System.out.println("Artículo no encontrado.");
                    }
                    break;

                case 7: // MOSTRAR INFORMACIÓN
                    System.out.println(videoDaw.mostrarInfoVideoClub());
                    System.out.println(videoDaw.mostrarClientesRegistrados());
                    System.out.println(videoDaw.mostrararticulosRegistrados());
                    break;

                case 8:
                    System.out.println("Guardando datos y saliendo...");
                    try {
                        videoDaw.guardarDatos(archivo);
                        System.out.println("¡Datos guardados con éxito!");
                    } catch (Exception e) {
                        System.out.println("Error al guardar el archivo.");
                    }
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 8);
    }

    // MENÚ
    public static int mostrarMenu(Scanner sc) {
        System.out.println("\n MENÚ PRINCIPAL ");
        System.out.println("1. Registrar artículo (Película/Videojuego)");
        System.out.println("2. Registrar cliente");
        System.out.println("3. Alquilar artículo");
        System.out.println("4. Devolver artículo");
        System.out.println("5. Dar de baja cliente");
        System.out.println("6. Dar de baja artículo");
        System.out.println("7. Mostrar información del videoclub");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");

        String entrada = sc.nextLine().trim();
        while (!entrada.matches("[1-8]")) {
            System.out.print("Opción no válida. Ingrese 1-8: ");
            entrada = sc.nextLine().trim();
        }

        return Integer.parseInt(entrada);
    }

    // METODO Buscamos cualquier tipo de artículo (Película o Videojuego)
    public static Articulo buscarArticulo(VideoDaw v, String cod) {
        for (Articulo a : v.getArticulosRegistrados()) {
            if (a.getCod().equalsIgnoreCase(cod)) {
                return a;
            }
        }
        return null;
    }

    //METODO BUSCAR CLIENTE
    public static Cliente buscarCliente(VideoDaw v, String dni) {
        for (Cliente c : v.getClientesRegistrados()) {
            if (c.getDNI().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        return null;
    }

    // LECTURA SEGURA DE FECHA SIN TRY/CATCH
    public static LocalDate leerFechaValida(Scanner sc, String mensaje) {

        LocalDate fecha = null;
        boolean esValida = false;

        while (!esValida) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();

            if (!entrada.matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("Formato inválido. Use AAAA-MM-DD (ej: 1999-11-06).");
                continue;
            }

            String[] partes = entrada.split("-");
            int anio = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int dia = Integer.parseInt(partes[2]);

            if (mes < 1 || mes > 12) continue;
            if (dia < 1 || dia > 31) continue;

            fecha = LocalDate.of(anio, mes, dia);
            esValida = true;
        }

        return fecha;
    }

}

