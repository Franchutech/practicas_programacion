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
        } else if (edad2 < 18 && edad2 >= 0) {
            System.out.println("Eres menor de edad");
        } else {
            System.out.println("La edad no tiene sentido");
        }

    /*Ejercicio3: Realiza un programa que muestre por pantalla los 20 primeros números naturales (1, 2,
3... 20). */
        System.out.println("\nP3.Ejercicio 3");
        for(int i = 1; i <= 20; i++){
            System.out.println("El numero natural es: " + i);
        }
    /* Ejercicio 4: Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Para ello utiliza un contador y suma de 2 en 2.
    */
        System.out.println("\nP3.Ejercicio 4");
        for (int i = 2; i <= 200; i += 2) {
            System.out.print(i + ", ");
        }
    /*Ejercicio 5: Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Esta vez utiliza un contador sumando de 1 en 1.
    */
        System.out.println("\nP3.Ejercicio 5");

        for (int i = 1; i <= 200; i++) {
            if (i % 2 == 0) {
                System.out.print(i + ", ");
            }
        }
    /*Ejercicio 6: Realiza un programa que muestre los números desde el 1 hasta un número N que se
        introducirá por teclado.*/
        System.out.println("\nP3.Ejercicio 6");
        System.out.println("Introduce un número:");
        lector = new Scanner(System.in);
        int maxN;
        maxN = lector.nextInt();
        for (int i = 1; i <= maxN; i++) {
            System.out.print(i + ", ");
        }
    /* Ejercicio 7: Escribe un programa que lea una calificación numérica entre 0 y 10 y la transforma en
calificación alfabética, escribiendo el resultado.
• de 0 a <3 Muy Deficiente.
• de 3 a <5 Insuficiente.
• de 5 a <6 Bien.
• de 6 a <9 Notable
• de 9 a 10 Sobresaliente*/
        System.out.println("\nP3.Ejercicio 7");
        System.out.println("Introduce una calificación:");
        lector = new Scanner(System.in);
        double nota;
        nota = lector.nextDouble();
        if (nota < 0.0 || nota > 10.0) {
            System.out.println("Valor no definido" + nota);
        }
        if (nota >= 0 && nota < 3) {
            System.out.println("Muy Deficiente");
        }
        if (nota >= 3 && nota < 5) {
            System.out.println("Insuficiente");
        }
        if (nota >= 5 && nota < 6) {
            System.out.println("Bien");
        }
        if (nota >= 6 && nota < 9) {
            System.out.println("Notable");
        }
        if (nota >= 9 && nota <= 10) {
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
        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        System.out.println("El factorial es:" + factorial);
    /* Ejercicio 9: Escribe un programa que recibe como datos de entrada una hora expresada en horas,
minutos y segundos que nos calcula y escribe la hora, minutos y segundos que serán,
transcurrido un segundo.*/
        lector = new Scanner(System.in);

        System.out.println("\nEjercicio 09");

        System.out.println("Introduce los segundos: ");
        int segundos = lector.nextInt();
        System.out.println("Introduce los minutos:" );
        int minutos = lector.nextInt();
        System.out.println("Introduce las horas: ");
        int horas = lector.nextInt();


        segundos ++;

        if(segundos >= 60){

            minutos ++;
            segundos = 0;

            if(minutos >= 60){
                horas++;
                minutos = 0;

                if(horas >= 24){
                    horas = 0;
                }
            }
        }
        System.out.println("La hora dada un segundo despuès es: " + horas + ":" + minutos + ":" + segundos);


    /*Ejercicio 10: Realiza un programa que lea 10 números no nulos y luego muestre un mensaje de si ha
leído algún número negativo o no.
    */
        System.out.println("\nEjercicio 10");
        lector = new Scanner(System.in);

        boolean hayNegativos = false;
        for(int i = 0; i < 10; i++){
            System.out.println("Introduce un numero  distinto de cero: ");
            double n = lector.nextDouble();
            if(n < 0){
                hayNegativos = true;
            }
        }
        System.out.println("Hay numeros negativos: " + hayNegativos);

        /*
        Ejercicio 11: Realiza un programa que lea 10 números no nulos
        y luego muestre un mensaje indicando cuántos son positivos y cuantos negativos.
        */
        System.out.println("\nEjercicio 11");
        lector = new Scanner(System.in);

        int nPositivos = 0;
        int nNegativos = 0;
        for(int i = 0; i < 10; i++){
            System.out.println("Introduce un numero  distinto de cero: ");
            double n = lector.nextDouble();
            if(n < 0){
                nNegativos ++;
            }
            if(n > 0){
                nPositivos++;
            }
        }
        System.out.println("Hay " + nNegativos + "numeros negativos y hay " + nPositivos + " numeros positivos");

/* Ejercicio 12: Realiza un programa que lea una secuencia de números no nulos hasta que se introduzca
un 0, y luego muestre si ha leído algún número negativo, cuantos positivos y cuantos
negativos.  */

        System.out.println("\nEjercicio 12");
        lector = new Scanner(System.in);


        int contarPositivos = 0;
        int contarNegativos = 0;

        int secuencia;
        do {
            System.out.println("Introduce números:");
            secuencia = lector.nextInt();

            if (secuencia > 0) {
                contarPositivos++;
            } else {
                contarNegativos++;
            }
        } while (secuencia != 0);

/* Ejercicio 13: Realiza un programa que calcule y escriba la suma y el producto de los 10 primeros
números naturales. */

        System.out.println("\nEjercicio 13");

        int suma = 0;
        int mult = 1;

        for(int i = 1; i <= 10; i++){
            suma += i;
            mult *= i;
        }
        System.out.println("La suma de los primeros 10 numeros naturales es:" + suma);
        System.out.println("El producto de los primeros 10 numeros naturales es:" + mult);

/* Ejercicio 14: Escribe un programa que calcula el salario neto semanal de un trabajador en función del
número de horas trabajadas y la tasa de impuestos de acuerdo a las siguientes hipótesis:
• Las primeras 35 horas se pagan a tarifa normal.
• Las horas que pasen de 35 se pagan a 1,5 veces la tarifa normal.
• Las tasas de impuestos son:
• Los primeros 500 euros son libres de impuestos.
• Los siguientes 400 tienen un 25% de impuestos.
• Los restantes un 45% de impuestos.
Escribir nombre, salario bruto, tasas y salario neto.  */

        System.out.println("\nEjercicio 14");

        //Solicitud de datos:

        lector = new Scanner(System.in);
        System.out.println("Introduce el nombre del Empleado:");
        String nombre = lector.nextLine();
        System.out.println("Introduce el salario bruto semanal para calcular su salario neto:");
        double salario_bruto = lector.nextInt();
        System.out.println("Introduce el total de horas laboradas:");
        int horasl = lector.nextInt();

        double salario_bruto_hora = salario_bruto / 40;


        //Restricciones:

        if(salario_bruto == 0){
            System.out.println("El salario no puede ser cero");
        }
        if(horasl > 70){
            System.out.println("No es posible una jornada laboral de más de 70 horas");
        }
        if(horasl == 0){
            System.out.println("Las horas laboradas no pueden ser cero");
        }
        if(horasl <= 35){
            System.out.println("El salario neto de " + nombre + " es: " + salario_bruto_hora * horas );
        }
        if(horasl > 35){
            System.out.println("El salario neto de " + nombre + " es: " + salario_bruto_hora * horas * 1.5);
        }
    /* Los siguientes 400 no es lo mismo que de 0 en adelante sino mas bien solo el monto que sea mayor a 500 los 500
        iniciales siempre se mantienen */

    }
}

