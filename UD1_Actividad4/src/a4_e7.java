package UD1_Actividad4;
import java.util.Scanner;
import java.util.Arrays;

public class a4_e7 {
    public static void main(String[] args) {

    Scanner lector =  new Scanner(System.in);

    /*Ejercicio 7: Crea un programa que pida dos valores enteros P y Q, luego cree un array que contenga
    todos los valores desde P hasta Q, y lo muestre por pantalla. */

    System.out.println("A4_E7");

    //pedir los valores
    System.out.println("Ingrese un numero entero P:");
    int numeroP = lector.nextInt();

    System.out.println("Ingrese un numero entero Q:");
    int numeroQ = lector.nextInt();

    //creo el array desde hasta
    int ingreso[] = new int[numeroQ - numeroP+1];

    //lleno el array desde hasta.
    for(int i = 0; i < ingreso.length; i++){
        ingreso[i] = numeroP+i;
        System.out.println("El array desde P hasta Q:" + ingreso[i]);
    }


    }//void
} //main
