package UD1_Actividad4;

import java.util.Scanner;
import java.util.Arrays;


public class a4_e9 {
    public static void main(String[] args) {
    Scanner lector =new Scanner(System.in);

    /*Ejercicio 9: Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valores
    enteros aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10). Luego pedirá un valor N
    y mostrará en qué posiciones del array aparece N.*/

    System.out.println("A4_E9");

    //1-Creo el array//
    int [] enteros = new int[100];

    // creo la variable que luego introducirá el usuario//
    int numeroN = 0;
    int contador = 0;

    // relleno el array con un bucle for, y utilizo el tip dado por el profe de Math.random//
    for(int i=0;i<enteros.length;i++){
        enteros[i]= (int) (1 + Math.random()*10);
    }
    //Dice luego pedir al usuario el numero//
    System.out.println("Introduce un número entero N:");
    numeroN = lector.nextInt();

    for(int i=0;i<enteros.length;i++){
        if(enteros[i]==numeroN){
            if (contador == 0) {
                System.out.println("Las ubicaciones en las que hay coincidencia son:");
            }
            System.out.print(i + " ");
            contador++;
        }
    }


/** Que voy aprendiendo?
 * Primero que aqui no puedo usar binarysearch, porque este busca solo en arrays previamente ordenados.
 * en este caso ocupo buscar en un bucle for cada vez que aparezca imprimir la posición, con lo cual Binary,
 * no seria el caso.
 * Aprendi que dentro del for "i" es en si la posición que voy recorriendo, con lo cual, no me había
 * dado cuenta de que en realidad con solo imprimir "i", ya estoy mostrando la posición en la que se cumple
 * el if dentro del for.
 * Para imprimir de manera mas ordenada, lo mejor es siempre crear el contador.
 */

    }//void
}//main
