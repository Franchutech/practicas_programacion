import java.time.LocalDate;
import java.util.Scanner;
import exceptions.CapacidadExcedidaException;
import exceptions.HeroeYaRegistradoException;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //CARGO LA ACADEMIA
        Academia miacademia = new Academia("HeroAcademy", "E12523698", LocalDate.now());

        System.out.println("Bienvenido a Mi Academia");
        System.out.println("Datos Cargados" + miacademia.getListaPersonas().size() + "ciudadanos listos.");


        //MENU
        //recordar darle un valor para que java no se ponga loco...
        int opcion =-1;

        do {
            Menu();
            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("ESTADO DE LA SINCRONIZACIÓN");
                        if (miacademia.getListaPersonas().isEmpty() && miacademia.getListaEquipo().isEmpty()) {
                            System.out.println("No se detectaron datos en los archivos externos");
                        }else  {
                            System.out.println("DATOS SINCRONIZADOS CORRECTAMENTE");
                            System.out.println("  -> Personas en Base de Datos (CSV): " + miacademia.getListaPersonas().size());
                            System.out.println("  -> Equipos recuperados (DAT): " + miacademia.getListaEquipo().size());
                        }
                        break;
                    case 2:
                        System.out.println("BIENVENIDO A CREAR NUEVO EQUIPO");
                        System.out.println("Introduzca el nombre del Capitán");
                        String nombreCapitan = sc.nextLine();
                        System.out.println("Introduzca la edad del Capitan");
                        int edadCapitan = Integer.parseInt(sc.nextLine());

                        if (edadCapitan < 18){
                            System.out.println("Error el Capitan debe ser mayor de edad");
                        }else {
                            System.out.println("Introduzca el DNI del Capitan");
                            String dniCap = sc.nextLine();
                            System.out.println("Introduzca el nombre del Equipo");
                            String nombreEquipo = sc.nextLine();
                            System.out.println("Introduzca un código para el Equipo");
                            String codigoEquipo = sc.nextLine();
                            System.out.println("Introduzca la cantidad máxima de Heroes para el Equipo");
                            int maxHeroes = Integer.parseInt(sc.nextLine());

                            Capitan capitan = new Capitan(nombreCapitan, null, dniCap, null, null, null, null, 0, 0, true, null, 0, 0.0);

                            Equipo nuevoEquipo = new Equipo(nombreEquipo, codigoEquipo, (Capitan) capitan, maxHeroes);

                            miacademia.registrarEquipo(nuevoEquipo);
                        }
                        break;

                    case 3:
                        System.out.println("\n-REGISTRAR HÉROE EN EQUIPO");

                        System.out.print("Introduzca el DNI del Héroe: ");
                        String dniBusqueda = sc.nextLine();

                        System.out.print("Introduzca el nombre del Equipo: ");
                        String nombreEqBusqueda = sc.nextLine();

                        Heroe heroeEncontrado = null;
                        Equipo equipoEncontrado = null;

                        //BUSCO EL HEROE
                        for (Persona p : miacademia.getListaPersonas()) {
                            if (p.getDNI().equalsIgnoreCase(dniBusqueda)) {
                                // Si lo encuentro lo convierto a Heroe
                                heroeEncontrado = new Heroe(p.getNombre(), p.getFechaNacimiento(), p.getDNI(), p.getDireccion(), null, null, null, 0, 0, true);
                                break;
                            }
                        }

                        //BUSCAR EL EQUIPO
                        for (Equipo eq : miacademia.getListaEquipo()) {
                            if (eq.getNombreEquipo().equalsIgnoreCase(nombreEqBusqueda)) {
                                equipoEncontrado = eq;
                                break;
                            }
                        }
                        if (heroeEncontrado != null && equipoEncontrado != null) {
                            try {
                                miacademia.asignarHeroeAEquipo(heroeEncontrado, equipoEncontrado);
                                System.out.println("Héroe registrado correctamente.");
                            } catch (HeroeYaRegistradoException | CapacidadExcedidaException e) {
                                System.out.println("ERROR: " + e.getMessage());
                            }
                        } else {
                            System.out.println("ERROR: No se encontró al héroe o al equipo.");
                        }
                        break;
                    case 4:
                        System.out.println("\nDETALLE DE LA ACADEMIA");

                        //VALIDO SI TENGO ALGO QUE MOSTRAR
                        if (miacademia.getListaEquipo().isEmpty()) {
                            System.out.println("La academia aún no tiene equipos registrados.");
                        } else {
                            // Recorremos cada equipo de la academia
                            for (Equipo eq : miacademia.getListaEquipo()) {
                                System.out.println("\nDETALLES");
                                System.out.println("EQUIPO: " + eq.getNombreEquipo().toUpperCase() + " [" + eq.getCodEquipo() + "]");
                                System.out.println("CAPITÁN: " + eq.getCapitan().getNombre() + " (DNI: " + eq.getCapitan().getDNI() + ")");
                                System.out.println("CAPACIDAD: " + eq.getListaHeroes().size() + "/" + eq.getMaxHeroes());
                                System.out.println("HÉROES INTEGRANTES:");

                                // Si el equipo no tiene héroes todavía
                                if (eq.getListaHeroes().isEmpty()) {
                                    System.out.println(" (Este equipo aún no tiene héroes asignados)");
                                } else {
                                    // Recorremos la lista de héroes de ESTE equipo
                                    for (Heroe h : eq.getListaHeroes()) {
                                        System.out.println("   -> ID: " + h.getIdHeroe() + " | Nombre: " + h.getNombre() +
                                                " | Poder: " + h.getPoderElemental() + " | Ataque: " + h.getAtaque());
                                    }
                                }
                            }
                            System.out.println("FIN DE LA INFORMACIÓN");
                        }
                        break;
                    case 5:
                        miacademia.calcularEstadistica();
                        break;
                    case 6:
                        System.out.println("\nELIMINAR HÉROE POR DNI");
                        System.out.print("Introduzca el DNI del héroe a eliminar: ");
                        String dniEliminar = sc.nextLine();

                        boolean encontrado = false;

                        for (Equipo eq : miacademia.getListaEquipo()) {
                            // Uso el metodo que ya habia hecho en EQUIPO para eliminar
                            // Este método devuelve 'true' si lo encuentra y lo borra
                            if (eq.eliminarHeroe(dniEliminar)) {
                                System.out.println("Héroe con DNI " + dniEliminar + " eliminado del equipo " + eq.getNombreEquipo());
                                encontrado = true;
                                break; // Si ya lo encontre y borramos, salgo del bucle
                            }
                        }

                        if (!encontrado) {
                            System.out.println("No se encontró ningún héroe con ese DNI en ningún equipo.");
                        }
                        break;

                    case 7:
                        System.out.println("\nGUARDANDO DATOS Y SALIENDO");
                        // Llamo al método que serializa toda la academia en el archivo .dat
                        miacademia.guardarDatos();

                        System.out.println("Todos los equipos y héroes han sido guardados en academia.dat");
                        System.out.println("¡Suerte en la misión, Academia cerrada!");
                        break;

                }//CIERRE DEL SWITCH

            } catch (NumberFormatException e) {
                System.out.println("Introduzca un numero valido");

            }
        } while (opcion != 0);//CIERRE DEL DO WHILE



    }//CIERRE VOID MAIN

    private static void Menu() {
        System.out.println("\n MENÚ ACADEMIA DE HÉROES");
        System.out.println("1. Sincronizar Datos (CSV/DAT)");
        System.out.println("2. Crear Equipo (Requiere Capitán)");
        System.out.println("3. Registrar Héroe en Equipo");
        System.out.println("4. Mostrar Info Academia (Detalle completo)");
        System.out.println("5. Mostrar Estadísticas (Promedios)");
        System.out.println("6. Eliminar Héroe por DNI");
        System.out.println("0. Guardar y Salir");
        System.out.print(">> Seleccione opción: ");
    }//CIERRE METODO MENU

}//CIERRE CLASE PRINCIPAL