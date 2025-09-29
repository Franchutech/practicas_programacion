//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 1: Escribe un programa que dé los “buenos días”.
        System.out.println("\nEjercicio 01");
        System.out.println("Buenos Días");

        /*
        Ejercicio 2: Escribe un programa que calcule y muestre el área de un cuadrado de lado igual a 5.
         */
        System.out.println("\nEjercicio 02");
        double lado = 5;
        double area = lado * lado;
        System.out.println("El área del cuadrado es: " + area);

        /*
        Ejercicio 3: Escribe un programa que calcule el área de un cuadrado cuyo lado se introduce por
teclado.
         */

        System.out.println("\nEjercicio 03");
        Scanner sc =  new Scanner(System.in);
        System.out.println("Introduce el valor del lado del cuadrado:");
        double lado2= sc.nextDouble();

        double area2= lado2 * lado2;
        System.out.println("Lado: " + lado2);
        System.out.println("Area: " + area2);

        /*
        Escribe un programa que lea dos números, calcule y muestre el valor de sus suma, resta,
producto y división.
         */

        System.out.println("\nEjercicio 04");
        Scanner lector =  new Scanner(System.in);
        double numero1 = lector.nextDouble();
        double numero2 = lector.nextDouble();
        System.out.println("La suma de los numeros es:" + numero1 + numero2);
        System.out.println("La resta de los numeros es:" + (numero1 - numero2));
        System.out.println("La multiplicación de los numeros es:" + (numero1 * numero2));
        System.out.println("La division de los numeros es:" + (numero1 / numero2));

     /*
     Escribe un programa que toma como dato de entrada un número que corresponde a la
longitud de un radio y nos escribe la longitud de la circunferencia, el área del círculo y el
volumen de la esfera que corresponden con dicho radio. (C = 2pir / V = (4/3)πr³)
      */
        System.out.println("\nEjercicio 05");
        Scanner lector2 = new Scanner(System.in);
        double radio = lector2.nextDouble();
        System.out.println("La longitud del radio es: " + radio);
        System.out.println("La longitud de la circunferencia es:" + (2 * Math.PI * radio) );
        System.out.println("El volumen de la esfera de" + radio +":"+ ((4/3) * Math.PI * Math.pow(radio,3)));

        /*
        Escribe un programa que dado el precio de un articulo y el precio de venta real nos
muestre el porcentaje de descuento realizado.
         */
        System.out.println("\nEjercicio 06");
        Scanner lector3 = new Scanner(System.in);
        System.out.println("Ingresa el precio costo de un producto:");
        Scanner lector4 =  new Scanner(System.in);
        System.out.println("Ingresa el precio venta de un producto:");
    }
}