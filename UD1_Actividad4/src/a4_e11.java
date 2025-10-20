package UD1_Actividad4;

import java.util.Scanner;
import java.util.Arrays;

public class a4_e11 {
    public static void main(String[] args){
        Scanner lector=new Scanner(System.in);

    /*Ejercicio 11: Crea un programa que cree dos arrays de enteros de tamaño 100. Luego introducirá en
el primer array todos los valores del 1 al 100. Por último, deberá copiar todos los valores
del primer array al segundo array en orden inverso, y mostrar ambos por pantalla. */

        //crear 2 arrays//
        int primerGrupo[]= new int [100];
        int segundoGrupo[]= new int[100];


    /*rellenar el array con los numeros del 1 al 100, en este caso i +1 ya que lo empiezo en 1 y llego a 100(limite
        del array)*/

        for(int i =0; i<primerGrupo.length;i++){
            primerGrupo[i]= i + 1;
        }
    //copiar el array del primer grupo en el segundo grupo//

        for(int i = 0; i<segundoGrupo.length;i++){
            segundoGrupo[i]= primerGrupo[primerGrupo.length - i - 1];
        }

        //poner el array en texto con un tostring, para poder imprimir//

        System.out.println("Detalle del array original primerGrupo:" + (Arrays.toString(primerGrupo)));
        System.out.println("Detalle del array original segundoGrupo:" + (Arrays.toString(segundoGrupo)));

/**
 * En este ejercicio me costó demasiado pensar en el "inverso" de un número...no me da el cerebro para verlo
 * tan facilmente.
 * Aprendí como imprimir arrays convirtiendolos a texto, ya en la práctica, es más fácil de lo que parece.
 */
    }// void
} // main
