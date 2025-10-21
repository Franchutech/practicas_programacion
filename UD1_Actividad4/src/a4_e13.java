package UD1_Actividad4;

import java.util.Scanner;
import java.util.Arrays;

public class a4_e13 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("A4_E13");

        /*Ejercicio 13: Crea un programa que permita al usuario almacenar una secuencia aritmética en un
        array y luego mostrarla. Una secuencia aritmética es una serie de números que
        comienza por un valor inicial V, y continúa con incrementos de I. Por ejemplo, con V=1
        e I=2, la secuencia sería 1, 3, 5, 7, 9… Con V=7 e I=10, la secuencia sería 7, 17, 27, 37… El
        programa solicitará al usuario V, I además de N (nº de valores a crear).*/

        int tamanoN = 0;
        int inicialV = 0;
        int incrementoI = 0;

        System.out.println("Introduce el tamaño que tendrá tu array");
        tamanoN = lector.nextInt();

        while (tamanoN <= 0) {
            System.out.println("El tamaño del array no puede ser menor o igual que cero");
            tamanoN = lector.nextInt();
        }
        System.out.println("Introduce el valor inicial de tu array");
        inicialV = lector.nextInt();
        System.out.println("Introduce el incremento que quieres en tu array");
        incrementoI = lector.nextInt();

        int secuencia[] = new int[tamanoN];

        //aqui me faltaria limitar al usuario para que los numeros no den error//

        System.out.print("El array con su incremental seria: ");
        for(int i = 0; i<secuencia.length; i++){
            secuencia[i] = inicialV + (i * incrementoI);
            System.out.print(secuencia[i] + " ");
        }



    /*Crear variables N, V, I.
    Pedir al usuario con Scanner.
    Crear un array de tamaño N.
    Recorrerlo con un solo for:
    en cada iteración, calcular el valor aplicando el incremento.
    asignarlo a la posición correspondiente del array.
    Mostrar la secuencia por pantalla (con otro for o dentro del mismo).*/


        }//void
    }//main