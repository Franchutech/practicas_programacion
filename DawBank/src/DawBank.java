import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

public class DawBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //Pedir los datos al usuario

        System.out.println("A continuación se solicitarán los datos, para la creación de su cuenta bancaria:");
        System.out.println(" Ingrese su nombre completo: ");
        String nombreCompleto = sc.nextLine();



    String opcion;  //recordar usar string siempre para las opciones del switch



    }//main
    public static void menuBancario() {
        System.out.println("---MENÚ BANCARIO---");
        System.out.println("1. Crear cuenta Bancaria");
        System.out.println("2. Mostrar Datos de la cuenta Bancaria");
        System.out.println("3. Mostrar la o las cuentas IBAN asociadas");
        System.out.println("4. Mostrar los datos del titular");
        System.out.println("5. Mostrar el saldo disponible");
        System.out.println("6. Realizar un ingreso");
        System.out.println("7. Realizar un retiro");
        System.out.println("8. Mostrar el histórico de movimientos");
        System.out.println("9. Salir");
        System.out.println("10.Regresar al menu");
    }
}//clase
