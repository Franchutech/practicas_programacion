package UF2_ACTIVIDAD5;

import java.util.Scanner;
import static java.lang.System.in;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("A5_E1");

    /*Ejercicio 1: Crea un programa que pida una cadena de texto por teclado y luego muestre cada
palabra de la cadena en una línea distinta.*/

        System.out.println("Introduzca un texto:");
        String texto = in.nextLine();
        String [] palabras = texto.split(" ");
        System.out.println("A continuacion se mostrará el texto en líneas separadas:");
        for(String palabra : palabras){
            System.out.println(palabra);
        }
//        for(int i = 0; i < texto.length(); i++) {
//            System.out.println(palabras[i]);
//        }

    /*Ejercicio 2: Crea un programa que pida dos cadenas de texto por teclado y luego indique si son
iguales, además de si son iguales sin diferenciar entre mayúsculas y minúsculas. */

        in = new Scanner(System.in);
        System.out.println("A5_E2");

        System.out.println("Introduzca un primer texto:");
        String textoUno = in.nextLine();
        System.out.println("Introduzca un segundo texto:");
        String textoDos = in.nextLine();

        boolean resultado = textoUno.equals(textoDos);
        System.out.println(resultado);

    /*Ejercicio 3: Crea un programa que pida por teclado tres cadenas de texto: nombre y dos apellidos.
    Luego mostrará un código de usuario (en mayúsculas) formado por la concatenación de
    las tres primeras letras de cada uno de ellos. Por ejemplo, si se introduce “Lionel”,
    Tarazón” y “Alcocer” mostrará “LIOTARALC”. */

        in = new Scanner(System.in);
        System.out.println("A5_E3");

        System.out.println("Introduzca un nombre: ");
        String nombre = in.nextLine();
        System.out.println("Introduzca un primer apellido: ");
        String primerApellido = in.nextLine();
        System.out.println("Introduzca un segundo apellido: ");
        String segundoApellido = in.nextLine();

        //aqui debo hacerlo hasta 3 porque el ultimo no cuenta segun las notas//

        String codigo=nombre.substring(0,3) + primerApellido.substring(0,3) +  segundoApellido.substring(0,3);

        String codigoMay= codigo.toUpperCase();
        System.out.println(codigoMay);


        /*En este ejercicio aprendi que si ya declare la variable antes, NO DEBO, volver a crearla.
         * Debo pedir 3 cadenas de texto una para nombre y las otras dos apellido 1 y 2
         * Mostrar un codigo de usuario en MAYUSCULAS que debe formarse de las primeras 3 LETRAS de cada cadena
         * Ejemplo Francella Rojas Castillo (FRAROJCAS), seria mi Codigo, menciona el profe la concatenacion
         * buscar e intentar con la teoría de clase primero.*/



    }//void
}//main