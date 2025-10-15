package UD1_Actividad4;

import java.util.Scanner;

public class a4_e1 {
    public static void main(String[] args) {


        /* Ejercicio 1: Crea un programa que pida diez números reales por teclado, los almacene en un array,
        y luego muestre todos sus valores.*/
        System.out.println("Ejercicio A4_E1");

        Scanner lector = new Scanner(System.in);

        double[] numerosReales = new double[10];
        int i;
        System.out.println("Ingrese diez numeros reales:");

        for (i = 0; i < 10; i++) {
            numerosReales[i] = lector.nextDouble();
        }
        System.out.println("Los numeros reales ingresados fueron:");
        for (i = 0; i < 10; i++) {
            System.out.println(numerosReales[i]);
        }









    } //void
} //main
