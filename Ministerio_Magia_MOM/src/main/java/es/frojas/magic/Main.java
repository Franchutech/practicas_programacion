package es.frojas.magic;

import es.frojas.magic.dbconfg.SQLDataBaseManager;
import es.frojas.magic.daos.SerVivoDAO;
import es.frojas.magic.enums.Casas;
import es.frojas.magic.enums.Nacionalidades;
import es.frojas.magic.models.*;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SerVivoDAO dao = new SerVivoDAO();

        System.out.println("🔮 Verificando conexión al MINISTERIO DE MAGIA ");
        Connection con = SQLDataBaseManager.getConnection();

        if (con != null) {
            System.out.println("🧙🏻¡EXCELENTE NO ERES UN MUGGLE! La base de datos responde.");

            int option = -1;
            while (option != 0) {
                System.out.println("\n INICIANDO MINISTERIO DE MAGIA ");
                System.out.println("1. GESTION DE SERES VIVOS (Censo)");
                System.out.println("2. LABORATORIO DE POCIONES");
                System.out.println("3. INVERNADERO DE HERBOLOGÍA");
                System.out.println("4. DEPARTAMENTO DE DEPORTES");
                System.out.println("0. SALIR");
                System.out.print("> Elige: ");

                try {
                    option = Integer.parseInt(sc.nextLine());

                    switch (option) {
                        case 1:
                            abrirGestionCenso(sc, dao);
                            break;
                        case 2:
                            System.out.println("\nAVISO: LABORATORIO DE POCIONES CLAUSURADO.");
                            System.out.println("Un caldero ha explotado y hay vapores de Filtro de Muerta en Vida.");
                            break;
                        case 3:
                            System.out.println("\nAVISO: INVERNADERO DE HERBOLOGÍA CERRADO.");
                            System.out.println("Las Mandrágoras están en época de replantado y sus gritos son letales.");
                            break;
                        case 4:
                            System.out.println("\nAVISO: DEPARTAMENTO DE DEPORTES SIN SERVICIO.");
                            System.out.println("Todo el personal se ha ido al Mundial de Quidditch en Bulgaria.");
                            break;
                        case 0:
                            System.out.println("Cerrando sesión. Travesura realizada.");
                            break;
                        default:
                            System.out.println("Esa opción no existe ni en el Callejón Knockturn.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Introduce un número válido.");
                }
            }
        } else {
            System.err.println("🤬MALDITO MUGGLE!!!!: No se pudo conectar. Revisa QUE HICISTE MAL!!!!.");
        }
    }//CIERRE VOID MAIN

    public static void abrirGestionCenso(Scanner sc, SerVivoDAO dao) {
        int opt = -1;
        while (opt != 0) {
            System.out.println("\nCENSO DEL MINISTERIO");
            System.out.println("1. Registrar Nuevo");
            System.out.println("2. Ver Censo Completo");
            System.out.println("3. Buscar por Nombre");
            System.out.println("4. Buscar por Tipo");
            System.out.println("5. Buscar por ID");
            System.out.println("6. Expulsar (Eliminar)");
            System.out.println("7. Actualizar Datos Básicos");
            System.out.println("0. VOLVER");
            System.out.print("> Opción: ");

            try {
                opt = Integer.parseInt(sc.nextLine());
                switch (opt) {
                    case 1:
                        registrarNuevoSer(sc, dao);
                        break;
                    case 2:
                        for (SerVivo s : dao.obtenerCensoCompleto()) {
                            System.out.println(s.obtenerFicha());
                        }
                        break;
                    case 3:
                        System.out.print("Nombre a buscar: ");
                        String n = sc.nextLine();
                        for (SerVivo s : dao.buscarPorNombre(n)) {
                            System.out.println(s.obtenerFicha());
                        }
                        break;
                    case 4:
                        System.out.print("Tipo (MAGO/MUGGLE/CRIATURA): ");
                        String t = sc.nextLine().toUpperCase();
                        for (SerVivo s : dao.buscarPorTipo(t)) {
                            System.out.println(s.obtenerFicha());
                        }
                        break;
                    case 5:
                        System.out.print("ID a buscar: ");
                        int id = Integer.parseInt(sc.nextLine());
                        SerVivo s = dao.buscarPorId(id);
                        if (s != null) {
                            System.out.println(s.obtenerFicha());
                        } else {
                            System.out.println("No se encontró ese ID.");
                        }
                        break;
                    case 6:
                        System.out.print("ID a expulsar: ");
                        int idB = Integer.parseInt(sc.nextLine());
                        int filas = dao.eliminarSerVivo(idB);
                        System.out.println(filas > 0 ? "Expulsado correctamente." : "No existe.");
                        break;
                    case 7:
                        System.out.print("ID a actualizar: ");
                        int idA = Integer.parseInt(sc.nextLine());
                        System.out.print("Nuevo Nombre: ");
                        String nom = sc.nextLine();
                        System.out.print("Nueva Nacionalidad: ");
                        String nac = sc.nextLine();
                        dao.actualizarDatosBasicos(idA, nom, nac);
                        System.out.println("Datos actualizados.");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error en la entrada de datos.");
            }
        }
    }//CIERRE ABRIR GESTION CENSO

    public static void registrarNuevoSer(Scanner sc, SerVivoDAO dao) {
        try {
            System.out.println("\n¿Qué deseas registrar?");
            System.out.println("1. Mago | 2. Muggle | 3. Criatura");
            int tipo = Integer.parseInt(sc.nextLine());

            System.out.print("Nombre: ");
            String nom = sc.nextLine();
            System.out.print("Nacionalidad (ej. ESPANA, REINO_UNIDO): ");
            Nacionalidades nac = Nacionalidades.valueOf(sc.nextLine().toUpperCase());

            if (tipo == 1) {
                System.out.println("Elige Casa: 1.Gryffindor, 2.Slytherin, 3.Hufflepuff, 4.Ravenclaw");
                int numCasa = Integer.parseInt(sc.nextLine());

                Casas casaSeleccionada = null;
                int idCasa = numCasa; // Guardamos el número para enviarlo al DAO

                if (numCasa == 1) {
                    casaSeleccionada = Casas.GRYFFINDOR;
                } else if (numCasa == 2) {
                    casaSeleccionada = Casas.SLYTHERIN;
                } else if (numCasa == 3) {
                    casaSeleccionada = Casas.HUFFLEPUFF;
                } else if (numCasa == 4) {
                    casaSeleccionada = Casas.RAVENCLAW;
                }

                System.out.print("Patronus: ");
                String pat = sc.nextLine();
                System.out.print("Nivel Mágico (0-10): ");
                int niv = Integer.parseInt(sc.nextLine());
                System.out.print("¿Es Mortífago? (true/false): ");
                boolean mor = Boolean.parseBoolean(sc.nextLine());


                dao.insertarMago(new Mago(0, nom, nac, casaSeleccionada, pat, niv, mor), idCasa);

            } else if (tipo == 2) {
                System.out.print("Profesión: ");
                String prof = sc.nextLine();
                System.out.print("¿Conoce la magia? (true/false): ");
                boolean cono = Boolean.parseBoolean(sc.nextLine());

                dao.insertarMuggle(new Muggle(0, nom, nac, prof, cono));

            } else if (tipo == 3) {
                System.out.print("Peligrosidad (1-5): ");
                int peli = Integer.parseInt(sc.nextLine());
                System.out.print("¿Es domesticable? (true/false): ");
                boolean dom = Boolean.parseBoolean(sc.nextLine());

                dao.insertarCriatura(new Criatura(0, nom, nac, peli, dom));
            }
            System.out.println("\nRegistro completado con éxito.");

        } catch (Exception e) {
            System.out.println("Error al registrar: Revisa que los datos sean correctos.");
        }
    }//CIERRE REGISTRAR NUEVO SER
}//CIERRE MAIN