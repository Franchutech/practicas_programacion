

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando carpeta Actividad 6...");

        System.out.println("A6_E1");

        /* Ejercicio 1: Crea un programa que cree una matriz de tamaño 5x5 que almacene los números del 1 al 25
        y luego muestre la matriz por pantalla.*/

        int [][] numeros = new int[5][5];
        int contador = 1;

        for (int i=0; i<numeros.length;i++) {
            for (int j=0; j<numeros[i].length;j++){
                numeros[i][j]=contador;
                contador++;
                System.out.println(numeros[i][j] +"");

        /*Ejercicio 2: Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas de
        multiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por pantalla.*/

        System.out.println("A6_E2");

        int[][] tablas = new int[10][10];
        int multiplicador = 1;
        contador = 1;

        for(int k =0; k<tablas.length;k++){
            for(int l=0; l<tablas[k].length;k++){
                tablas[k][l] = multiplicador;
                contador++;
            }
        }



            }//void
        } //main









    }//void
}//main
