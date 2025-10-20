package UD1_Actividad4;

import java.util.Scanner;
import java.util.Arrays;

public class a4_e6 {
    public static void main(String[] args) {

    Scanner lector = new Scanner(System.in);

    /*Ejercicio 6: Crea un programa que pida dos valores enteros N y M, luego cree un array de tamaño
    N, escriba M en todas sus posiciones y lo muestre por pantalla. */

    System.out.println("A4_E6");

    System.out.println("Ingresa un numero entero N:");

    int numeroN = lector.nextInt();

    System.out.println("Ingresa un numero entero M:");

    int numeroM = lector.nextInt();

    int ingreso[] = new int[numeroN];

    for(int i = 0; i < ingreso.length; i++) {
        ingreso[i] = numeroM;
        System.out.print(ingreso[i]);
    }





    } //void
} //main
