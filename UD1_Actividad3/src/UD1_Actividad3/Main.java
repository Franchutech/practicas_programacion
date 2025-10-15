package UD1_Actividad3;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba desde casa - UD1_Actividad 3");


        /*Ejercicio 1: Realiza un programa que dada una cantidad de euros que el usuario
        introduce por teclado (múltiplo de 5 €) mostrará los billetes de cada tipo que serán
        necesarios para alcanzar dicha cantidad (utilizando billetes de
        500, 200, 100, 50, 20, 10 y 5). Hay que indicar el mínimo de billetes posible.
        Por ejemplo, si el usuario introduce 145 el programa indicará que será necesario
        1 billete de 100 €, 2 billetes de 20 € y 1 billete de 5 €
        (no será válido por ejemplo 29 billetes de 5, que aunque sume 145 € no es el mínimo
        número de billetes posible). */

        System.out.println("\nEjercicio 1:");
        System.out.println("Un monto en euros:");
        Scanner lector = new Scanner(System.in);
        int monto = lector.nextInt();
        int billetes500 = 0, billetes200 = 0, billetes100 = 0, billetes50 = 0;
        int billetes20 = 0, billetes10 = 0, billetes5 = 0;

        if (monto % 5 != 0) {
            System.out.println("Monto no válido");
            return;
        }

        if (monto >= 500) {
            billetes500 = monto / 500;
            monto = monto % 500;
        }
        if (monto >= 200) {
            billetes200 = monto / 200;
            monto = monto % 200;
        }
        if (monto >= 100) {
            billetes100 = monto / 100;
            monto = monto % 100;
        }
        if (monto >= 50) {
            billetes50 = monto / 50;
            monto = monto % 50;
        }
        if (monto >= 20) {
            billetes20 = monto / 20;
            monto = monto % 20;
        }
        if (monto >= 10) {
            billetes10 = monto / 10;
            monto = monto % 10;
        }
        if (monto >= 5) {
            billetes5 = monto / 5;
            monto = monto % 5;
        }
        if (billetes500 > 0)
            System.out.println("Billetes de 500€: " + billetes500);
        if (billetes200 > 0)
            System.out.println("Billetes de 200€: " + billetes200);
        if (billetes100 > 0)
            System.out.println("Billetes de 100€: " + billetes100);
        if (billetes50 > 0)
            System.out.println("Billetes de 50€: " + billetes50);
        if (billetes20 > 0)
            System.out.println("Billetes de 20€: " + billetes20);
        if (billetes10 > 0)
            System.out.println("Billetes de 10€: " + billetes10);
        if (billetes5 > 0)
            System.out.println("Billetes de 5€: " + billetes5);



        /*Realiza un programa que muestre un menú de opciones como el siguiente:
        1. Sumar
        2. Restar
        3. Multiplicar
        4. Dividir (incluir manejo de división por 0)
        5. Salir
        El menú debe de repetirse hasta que se escoja la opción 5 (Salir). */

        lector = new Scanner (System.in);







    } //void
} //main
