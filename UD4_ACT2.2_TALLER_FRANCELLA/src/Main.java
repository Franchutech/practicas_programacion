import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creo el objeto taller
        Taller miTaller = new Taller();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- GESTIÓN DEL TALLER ---");
            System.out.println("1. Añadir coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Visualizar matrículas (keySet)");
            System.out.println("4. Visualizar coches (values)");
            System.out.println("5. Visualizar taller completo (entrySet)");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            // Leo la opción como String y la convierto a número
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    miTaller.anadeElemento();
                    break;
                case 2:
                    miTaller.eliminaElemento();
                    break;
                case 3:
                    miTaller.visualizaMatriculas();
                    break;
                case 4:
                    miTaller.visualizaCoches();
                    break;
                case 5:
                    miTaller.visualizaTaller();
                    break;
                case 6:
                    System.out.println("Cerrando el taller");
                    break;
                default:
                    System.out.println("Esa opción no existe.");
                    break;
            }

        } while (opcion != 6);
    }
}