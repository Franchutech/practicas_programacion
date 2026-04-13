package es.frojas.magic;

import es.frojas.magic.dbconfg.SQLDataBaseManager;
import es.frojas.magic.daos.SerVivoDAO;
import es.frojas.magic.enums.Casas;
import es.frojas.magic.enums.Nacionalidades;
import es.frojas.magic.exceptions.SerVivoNoEncontradoException;
import es.frojas.magic.models.*;

import java.sql.Connection;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SerVivoDAO dao = new SerVivoDAO();

        System.out.println("🔮 Verificando conexión al MINISTERIO DE MAGIA ");
        Connection con = SQLDataBaseManager.getConnection();

        if (con != null) {
            System.out.println("🧙🏻¡EXCELENTE! La base de datos del Ministerio responde.");

            int opt = -1;
            while (opt != 0) {
                System.out.println(" MENÚ CENSO DEL MINISTERIO DE MAGIA");
                System.out.println("1. Registrar Nuevo Ser Vivo");
                System.out.println("2. Ver Censo Completo");
                System.out.println("3. Buscar por Nombre");
                System.out.println("4. Buscar por Tipo");
                System.out.println("5. Buscar por ID único");
                System.out.println("6. Expulsar Ser Vivo (Eliminar)");
                System.out.println("7. Actualizar Datos Básicos");
                System.out.println("0. SALIR DE LA APLICACIÓN");
                System.out.print("\n> Elija trámite ministerial: ");

                try {
                    opt = Integer.parseInt(sc.nextLine());

                    switch (opt) {
                        case 1:
                            registrarNuevoSer(sc, dao);
                            break;
                        case 2:
                            List<SerVivo> listaCenso = dao.obtenerCensoCompleto();
                            for (SerVivo s : listaCenso) {
                                System.out.println(s.obtenerFicha());
                            }
                            break;
                        case 3:
                            System.out.print("Nombre a buscar: ");
                            String nombreBusq = sc.nextLine();
                            for (SerVivo s : dao.buscarPorNombre(nombreBusq)) {
                                System.out.println(s.obtenerFicha());
                            }
                            break;
                        case 4:
                            System.out.print("Tipo (MAGO/MUGGLE/CRIATURA): ");
                            String tipoBusq = sc.nextLine().toUpperCase();
                            for (SerVivo s : dao.buscarPorTipo(tipoBusq)) {
                                System.out.println(s.obtenerFicha());
                            }
                            break;
                        case 5:
                            System.out.print("ID del Ser Vivo: ");
                            int idBusq = Integer.parseInt(sc.nextLine());
                            try {
                                SerVivo encontrado = dao.buscarPorId(idBusq);
                                System.out.println(encontrado.obtenerFicha());
                            } catch (SerVivoNoEncontradoException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 6:
                            System.out.print("ID del ser a expulsar (o 0 para cancelar): ");
                            int idBorrar = Integer.parseInt(sc.nextLine());

                            if (idBorrar == 0) {
                                System.out.println("Operación cancelada. El sujeto permanece en el censo.");
                            } else {
                                int resultBorrado = dao.eliminarSerVivo(idBorrar);
                                if (resultBorrado > 0) {
                                    System.out.println("Sujeto expulsado correctamente.");
                                } else {
                                    System.out.println("No se encontró ningún registro con ese ID.");
                                }
                            }
                            break;

                        case 7:
                            System.out.print("ID a actualizar (o 0 para cancelar): ");
                            int idAct = Integer.parseInt(sc.nextLine());

                            if (idAct == 0) {
                                System.out.println("Actualización cancelada.");
                            } else {
                                System.out.print("Nuevo Nombre: ");
                                String nuevoNom = sc.nextLine();
                                System.out.print("Nueva Nacionalidad: ");
                                String nuevaNac = sc.nextLine();
                                dao.actualizarDatosBasicos(idAct, nuevoNom, nuevaNac);
                                System.out.println("Datos actualizados.");
                            }
                            break;
                        case 0:
                            System.out.println("Travesura realizada... Cerrando sesión.");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Introduce un número válido para el menú.");
                }
            }
        } else {
            System.err.println("🤬 MALDITO MUGGLE !!! Revisa que hiciste mal.");
        }
    }

    // MÉTODO DE REGISTRO INTEGRADO
    public static void registrarNuevoSer(Scanner sc, SerVivoDAO dao) {
        try {
            System.out.println("\n¿Qué desea registrar?");
            System.out.println("1. Mago | 2. Muggle | 3. Criatura");
            int tipo = Integer.parseInt(sc.nextLine());

            System.out.print("Nombre: ");
            String nom = sc.nextLine();
            System.out.print("Nacionalidad (ej. INGLATERRA, ESPANA, FRANCESA): ");
            Nacionalidades nac = Nacionalidades.valueOf(sc.nextLine().toUpperCase());

            if (tipo == 1) {
                System.out.println("Seleccione Casa: 1.Gryffindor, 2.Slytherin, 3.Hufflepuff, 4.Ravenclaw");
                int numCasa = Integer.parseInt(sc.nextLine());

                Casas casaSel = null;
                if (numCasa == 1) casaSel = Casas.GRYFFINDOR;
                else if (numCasa == 2) casaSel = Casas.SLYTHERIN;
                else if (numCasa == 3) casaSel = Casas.HUFFLEPUFF;
                else if (numCasa == 4) casaSel = Casas.RAVENCLAW;

                System.out.print("Patronus: ");
                String pat = sc.nextLine();
                System.out.print("Nivel Mágico (1-10): ");
                int niv = Integer.parseInt(sc.nextLine());
                System.out.print("¿Es Mortífago? (true/false): ");
                boolean mor = Boolean.parseBoolean(sc.nextLine());

                dao.insertarMago(new Mago(0, nom, nac, casaSel, pat, niv, mor), numCasa);

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
            System.out.println("Registro realizado con éxito.");

        } catch (Exception e) {
            System.out.println("Error al registrar: Datos inválidos o nacionalidad no reconocida.");
        }
    }
}