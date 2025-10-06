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
        System.out.println("P2.Ejercicio 2");
        lector = new Scanner(System.in);
        System.out.println("Ingrese una edad:");
        int edad2 = lector.nextInt();
        if (edad2 >= 18) {
            System.out.println("Usted es mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
    /*Ejercicio3: Realiza un programa que muestre por pantalla los 20 primeros números naturales (1, 2,
3... 20). */
        System.out.println("P3.Ejercicio 3");
        System.out.println("Introduce un número máximo:");
        lector = new Scanner(System.in);
        int max;
        max = lector.nextInt();
        for (int i = 1; i <= max; i++) {
            System.out.println(i);
        }
    /* Ejercicio 4: Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Para ello utiliza un contador y suma de 2 en 2.
    */
        System.out.println("P3.Ejercicio 4");
        for (int n = 2; n <= 200; n += 2){
            System.out.println(n);
        }
    /*Ejercicio 5: Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Esta vez utiliza un contador sumando de 1 en 1.
    */
        System.out.println("P3.Ejercicio 5");
        for (int m = 1; m <= 200; m += 1){
            System.out.println(m);
        }
    /*Ejercicio 6: Realiza un programa que muestre los números desde el 1 hasta un número N que se
        introducirá por teclado.*/
        System.out.println("P3.Ejercicio 6");
        System.out.println("Introduce un número:");
        lector = new Scanner(System.in);
        int maxN;
        maxN= lector.nextInt();
        for (int f = 1; f <= maxN; f++){
            System.out.println(f);
        }
    /* Ejercicio 7: Escribe un programa que lea una calificación numérica entre 0 y 10 y la transforma en
calificación alfabética, escribiendo el resultado.
• de 0 a <3 Muy Deficiente.
• de 3 a <5 Insuficiente.
• de 5 a <6 Bien.
• de 6 a <9 Notable
• de 9 a 10 Sobresaliente*/
        System.out.println("P3.Ejercicio 7");
        System.out.println("Introduce una calificación:");
        lector = new Scanner(System.in);
        double nota;
        nota = lector.nextDouble();
        

    }
}

