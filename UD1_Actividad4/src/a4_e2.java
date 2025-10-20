package UD1_Actividad4;

import java.util.Scanner;

public class a4_e2 {
    public static void main(String[] args) {

        /*Ejercicio 2: Crea un programa que pida diez números reales por teclado, los almacene en un array,
y luego muestre la suma de todos los valores. */
        System.out.println("Ejercicio A4_E2");

        Scanner lector = new Scanner(System.in);
        double suma = 0.0;
        double numerosR [] = new double[10];
        System.out.println("Ingrese diez numeros reales:");

        for (int i = 0; i < numerosR.length; i++) {
            numerosR[i] = lector.nextDouble();
            suma += numerosR[i];
        }

        System.out.println("La suma de los numeros ingresados es:" + suma);


    } //void
} //main
