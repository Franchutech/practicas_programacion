package UD1_Actividad4;

import java.util.Arrays;
import java.util.Scanner;

public class a4_e3 {
    public static void main(String[] args) {

    /*Ejercicio 3: Crea un programa que pida diez números reales por teclado, los almacene en un array,
y luego lo recorra para averiguar el máximo y mínimo y mostrarlos por pantalla.*/

        System.out.println("Ejercicio A4_E3");

        Scanner lector = new Scanner(System.in);
        double numReales [] = new double[10];
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        System.out.println("Ingrese diez numeros reales:");

        for (int i = 0; i < numReales.length; i++) {
            numReales[i] = lector.nextDouble();
        }

        for (int i =0; i < numReales.length; i++){
            max = Math.max(numReales[i], max);
            min = Math.min(numReales[i], min);
        }

        System.out.println("El nùmero màximo es: " + max);
        System.out.println("El nùmero minimo es: " + min);


    }//void
} //main
