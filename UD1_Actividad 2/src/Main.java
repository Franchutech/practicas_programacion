package UD1_Actividad2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba correcta desde casa - UD1_Actividad 2");

        /*Ejercicio1: Escribe un programa que pide la edad por teclado y nos muestra el mensaje de “Eres
mayor de edad” solo si lo somos. */

        System.out.println("P2.Ejercicio 1");
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese su edad:");
        int edad = lector.nextInt();
        if (edad >= 18) {
            System.out.println("Usted es mayor de edad");
        } else {
            System.out.println("No eres mayor de edad");
        }
    /*Ejercicio2: Escribe un programa que pide la edad por teclado y nos muestra el mensaje de “eres
mayor de edad” o el mensaje de “eres menor de edad”.  */
        System.out.println("P2.Ejercicio 1");
        lector = new Scanner(System.in);
        System.out.println("Ingrese una edad:");
        int edad2 = lector.nextInt();
        if (edad2 >= 18) {
            System.out.println("Usted es mayor de edad");
        }
        else{
            System.out.println("Eres menor de edad");
        }

    }
}

