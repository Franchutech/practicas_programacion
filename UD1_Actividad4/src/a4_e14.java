package UD1_Actividad4;

import java.util.Scanner;
import java.util.Arrays;

public class a4_e14 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("A4_E14");

        /*Ejercicio 14: Crea un programa que cree un array de enteros e introduzca la siguiente secuencia de
        valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta introducir 10 diez veces, y luego la
        muestre por pantalla.*/

        //total de numeros = 55//

        int posicion = 0;

        int enteros[] = new int[55];

        for(int i = 1; i <= 10; i++){
            for(int j = 1; j <= i; j++){
                enteros[posicion] = i;
                posicion++;
            }//for dentro
        }//for fuera

        System.out.println("La secuencia se veria de la siguiente manera:");
        for(int i = 0; i<enteros.length; i++){
            System.out.print(enteros[i] + " ");
        }




        /*Creo un array int de tamaño 55 (lo calcule a mano, porque ni idea de otra forma).
        Declarar una variable posicion = 0. para poder contar laposicion del numero en el que estoy.
        Usar un for externo del 1 al 10.
        Dentro, usar otro for que se repita tantas veces como el número actual.
        En cada repetición, guardar ese número en array[posicion] y aumentar posicion en 1.
        Finalmente, mostrar el array por pantalla en una línea.*/



    }//void
}//main
