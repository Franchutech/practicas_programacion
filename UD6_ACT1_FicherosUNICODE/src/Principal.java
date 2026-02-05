import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Principal {

    //ELIJO USAR HASMAP para poder en la opcioon 3 buscar o eliminar productos por codigo
    private static Map<String ,Producto> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final String codigoPattern = "[A-Z]{1}[0-9]{4}";//QUIERO QUE TENGA 1 LETRA Y 4 NUMEROS
        final String NombrePattern = "[a-zA-Z\\s]{3,}";//EL NOMBRE QUIERO QUE TENGA AL MENOS 3 LETRAS

        System.out.print("ESTAS INGRESANDO AL FICHERO DE PRODUCTOS");

    String opcion = "";

    do {
        imprimirMenu();
        opcion = input.nextLine();

        switch (opcion) {
            case "1":
            //crear un producto
            break;
            case "2":
            //mostrar productos en existencia
                break;
            case "3":
            //eliminar productos por codigo
                break;
            case "4":
            //guardar productos en el fichero
                break;
            case "5":
                System.out.println("Saliendo del Sistema de Consultas");
            //salir
                break;
            default:
                System.out.println("Opción no válida");
        }

    } while (!opcion.equals("5"));


    }//VOID MAIN

    //METODOS

    //METODO1 MENU
    private static void imprimirMenu(){
        System.out.println("Menu principal:");
        System.out.println("1. Crear Producto.");
        System.out.println("2. Mostrar Productos en Existencia.");
        System.out.println("3. Eliminar Producto por Código.");
        System.out.println("4. Guardar Productos en el fichero.");
        System.out.println("5. Salir.");
    }//METODO MENU PRINCIPAL


}//PRINCIPAL CLASS
