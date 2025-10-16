package UD1_Actividad4;

import java.util.Scanner;
import java.util.Arrays;

public class a4_e5 {
    public static void main(String[] args) {

        /*Ejercicio 5: Crea un programa que pida veinte números reales por teclado, los almacene en un array
        y luego lo recorra para calcular y mostrar la media: (suma de valores) / nº de valores. */

        Scanner lector = new Scanner(System.in);

        System.out.println("Ejercicio A4_E5");

        double sumaNumeros = 0.0;
        double media;

        double numReales[] = new double[20];
        System.out.println("Ingrese la cantidad de 20 numeros reales:");
        for (int i = 0; i < numReales.length; i++) {
            numReales[i] = lector.nextDouble();
            sumaNumeros += numReales[i];
        }
        media = sumaNumeros / numReales.length;
        System.out.println("La media de los numeros ingresados es:" + media);


    }//void
}//main
