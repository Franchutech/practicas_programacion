import java.util.Scanner;

public class DawBank1_sin_internet {
    Scanner lector = new Scanner(System.in);
    int opcion;

    do{
        menuBancario();
        opcion = lector.nextInt();
        switch (opcion) {
            case 1:
        }
    }


    public static void menuBancario() {
        System.out.println("---MENÚ BANCARIO---");
        System.out.println("1. Ver datos de la cuenta");
        System.out.println("2. Mostrar la cuenta IBAN");
        System.out.println("3. Nombre del Titular");
        System.out.println("4. Saldo disponible");
        System.out.println("5. Realizar un ingreso");
        System.out.println("6. Realizar un retiro");
        System.out.println("7. Mostrar el historial de movimientos");
        System.out.println("8. Regresar al menú");
        System.out.println("9. Salir");
    }//instrucciones

}//class principal Dawbank1
