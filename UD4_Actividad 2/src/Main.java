import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Agenda miAgenda = new Agenda();
        Scanner entrada = new Scanner(System.in);
        String opcion = "";

        do {
            System.out.println("\nGESTIÓN DE AGENDA ");
            System.out.println("1. Añadir nuevo contacto");
            System.out.println("2. Buscar contacto por nombre");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Visualizar toda la agenda");
            System.out.println("5. Ver número total de contactos");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            // CORRECCIÓN AQUÍ: Usamos nextLine para que no quede el "ENTER" pendiente
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Introduce nombre: ");
                    String nom = entrada.nextLine();

                    System.out.print("Introduce teléfono: ");
                    String tel = entrada.nextLine();

                    System.out.print("Introduce correo: ");
                    String cor = entrada.nextLine();

                    Contacto nuevo = new Contacto(nom, tel, cor);
                    miAgenda.addContacto(nuevo);
                    break;

                case "2":
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscar = entrada.nextLine();
                    miAgenda.buscarContacto(nombreBuscar);
                    break;

                case "3":
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreEliminar = entrada.nextLine();
                    miAgenda.eliminarContacto(nombreEliminar);
                    break;

                case "4":
                    miAgenda.visualizarAgenda();
                    break;

                case "5":
                    System.out.println("Total de contactos: " + miAgenda.contarContactos());
                    break;

                case "0":
                    System.out.println("Cerrando agenda...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (!opcion.equals("0"));

        entrada.close();
    }
}