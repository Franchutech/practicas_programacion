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
        } else if(edad2 <18 && edad2 >= 0) {
            System.out.println("Eres menor de edad");
        }
        else{
            System.out.println("La edad no tiene sentido");
        }

    /*Ejercicio3: Realiza un programa que muestre por pantalla los 20 primeros números naturales (1, 2,
3... 20). */
        System.out.println("\nP3.Ejercicio 3");
        System.out.println("Introduce un número máximo:");
        lector = new Scanner(System.in);
        int max;
        max = lector.nextInt();
        for (int i = 1; i <= max; i++) {
            System.out.print(i + ", ");
        }
    /* Ejercicio 4: Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Para ello utiliza un contador y suma de 2 en 2.
    */
        System.out.println("\nP3.Ejercicio 4");
        for (int i = 2; i <= 200; i += 2){
            System.out.print(i + ", ");
        }
    /*Ejercicio 5: Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Esta vez utiliza un contador sumando de 1 en 1.
    */
        System.out.println("\nP3.Ejercicio 5");

            for (int i = 1; i <= 200; i++) {
                if(i % 2 == 0){
                System.out.print(i + ", ");
            }
        }
    /*Ejercicio 6: Realiza un programa que muestre los números desde el 1 hasta un número N que se
        introducirá por teclado.*/
        System.out.println("\nP3.Ejercicio 6");
        System.out.println("Introduce un número:");
        lector = new Scanner(System.in);
        int maxN;
        maxN= lector.nextInt();
        for (int i = 1; i <= maxN; i++){
            System.out.print(i + ", ");
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
        if(nota < 0.0 || nota > 10.0){
            System.out.println ("Valor no definido" + nota);
        }
        if(nota >= 0 && nota < 3){
            System.out.println("Muy Deficiente");
        }
        if(nota >=3 && nota < 5){
            System.out.println("Insuficiente");
        }
        if(nota >=5 && nota < 6){
            System.out.println("Bien");
        }
        if(nota >=6 && nota <9){
            System.out.println("Notable");
        }
        if(nota >= 9 && nota <= 10){
            System.out.println("Sobresaliente");
        }
    /*Ejercicio 8: Realiza un programa que lea un número positivo N y calcule y visualice su factorial N!
Siendo el factorial:
• 0! = 1
• 1! = 1
• 2! = 2 * 1
• 3! = 3 * 2* 1
• N! = N * (N-1) * (N-2)........* 3*2*1 */
        System.out.println("\nEjercicio 8");
        System.out.println("Introduce un número entero para calcular su factorial:");
        lector = new Scanner(System.in);
        int num;
        int factorial = 1;
        num = lector.nextInt();
        for (int i = 1; i <= num; i++){
            factorial = factorial * i;
        }
    System.out.println ("El factorial es:" + factorial);
    /*
    Escribe un programa que recibe como datos de entrada una hora expresada en horas,
minutos y segundos que nos calcula y escribe la hora, minutos y segundos que serán,
transcurrido un segundo.
     */
        lector = new Scanner(System.in);

        System.out.println("\nEjercicio 9");
        System.out.println("Introduce la hora:");
        int hora;
        hora = lector.nextInt();
        System.out.println("Introduce los minutos:");
        int min;
        min = lector.nextInt();
        System.out.println("Introduce los segundos:");
        int segundos;
        segundos = lector.nextInt();

        int segundo = 1;
        int time = hora + min + segundos;

            for (int i = 1; i <= segundo; i++){

        }


    }
}

