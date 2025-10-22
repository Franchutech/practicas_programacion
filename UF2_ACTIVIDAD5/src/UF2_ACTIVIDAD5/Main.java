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





    }//void
}//main