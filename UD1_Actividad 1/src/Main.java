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
        System.out.println("\nIntroduce un numero:");
        double numero1 = lector.nextDouble();
        System.out.println("\nIntroduce otro numero:");
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
        System.out.println("\nIntroduce un radio:");
        lector = new Scanner(System.in);
        double radio = lector.nextDouble();
        System.out.println("La longitud del radio es: " + radio);
        System.out.println("La longitud de la circunferencia es:" + (2 * Math.PI * radio) );
        System.out.println("El volumen de la esfera de" + radio +":"+ ((4/3) * Math.PI * Math.pow(radio,3)));

        /*
        Escribe un programa que dado el precio de un articulo y el precio de venta real nos
muestre el porcentaje de descuento realizado.
         */
        System.out.println("\nEjercicio 06");
        System.out.println("\nIntroduce un precio de costo:");
        lector = new Scanner(System.in);
        double precio = lector.nextDouble();
        System.out.println("\nIntroduce un precio de venta:");
        lector= new Scanner(System.in);
        double precioVenta = lector.nextDouble();
        System.out.println("Ingresa el precio costo de un producto:" + precio);
        System.out.println("Ingresa el precio venta de un producto:" + precioVenta);
        System.out.println("El porcentaje de descuento realizado es:"+ (((precioVenta-precio) / precioVenta) * 100));

        /*
        Escribe un programa que lea un valor correspondiente a una distancia en millas marinas
y escriba la distancia en metros. Sabiendo que una milla marina equivale a 1.852 metros.
        */
        System.out.println("\nEjercicio 07");
        lector = new Scanner(System.in);
        System.out.println("\nIntroduce dato en millas:");
        double datoMillas = lector.nextDouble();
        System.out.println("El valor en metros equivale a:" + (datoMillas * 1852));

        /*
        Escribe un programa que lee dos números y los visualiza en orden ascendente.
         */
        System.out.println("\nEjercicio 08");
        lector = new Scanner(System.in);
        System.out.println("\nIntroduce un numero:");
        double numeroUno = lector.nextDouble();
        System.out.println("\nIntroduce otro numero:");
        double numeroDos = lector.nextDouble();
        System.out.println("El orden ascendente de los números es:" +
                Math.min (numeroUno,numeroDos) + " , " + Math.max (numeroUno,numeroDos));

      /*
      Escribe un programa que lee dos números y nos dice cuál es el mayor o si son iguales.
       */
       System.out.println("\nEjercicio 09");
       lector = new Scanner(System.in);
       System.out.println("\nIntroduce un número:");
       double primerNumero = lector.nextDouble();
       System.out.println("\nIntroduce otro número:");
       double segundoNumero = lector.nextDouble();
       System.out.println("El numero mayor es:" + Math.max(primerNumero, segundoNumero));
       System.out.println("El primernumero es igual que el otro nùmero:" + (primerNumero == segundoNumero));

       /*
       Escribe un programa que lea tres números distintos y nos diga cuál es el mayor.
        */
       System.out.println("\nEjercicio 10");
       lector= new Scanner(System.in);
       System.out.println("\nIntroduce un número a:");
       double numeroA = lector.nextDouble();
       System.out.println("\nIntroduce un número b:");
       double numeroB = lector.nextDouble();
       System.out.println("\nIntroduce un número c:");
       double numeroC = lector.nextDouble();
       double max = Math.max(Math.max(numeroA, numeroB), numeroC);
       System.out.println("El mayor entre a, b y c es:" + max);


       /*
       Escribe un programa que lee dos números, calcula y muestra el valor de su suma, resta,
      producto y división. (Ten en cuenta la división por cero).
        */

        System.out.println("\nEjercicio 11");
        lector= new Scanner(System.in);
        System.out.println("\nIntroduce el numerador para una divisiòn A:");
        double numA = lector.nextDouble();
        System.out.println("\nIntroduce el divisor para una divisiòn distinto de cero B:");
        double numB = lector.nextDouble();
        System.out.println("La Suma de A y B es:" + (numA + numB));
        System.out.println("La Resta de A y B es:" + (numA - numB));
        System.out.println("El producto de A y B es:" + (numA * numB));
        System.out.println("La división de A y B es:" + (numA / numB));

        /*
         Escribe un programa que lee 2 números y muestra el mayor.
         */
        System.out.println("Ejercicio 12");
        lector = new Scanner(System.in);
        System.out.println("\nIntroduce un número C:");
        double numC = lector.nextDouble();
        System.out.println("\nIntroduce otro númer D:");
        double numD = lector.nextDouble();
        System.out.println("El numero mayor es:" + Math.max(numC, numD));

        /*
        Escribe un programa que lee un número y me dice si es positivo o negativo
        consideraremos el cero como positivo.
         */
        System.out.println("Ejercicio 13");
        lector = new Scanner(System.in);
        System.out.println("\nIntroduce un número:");
        double numE = lector.nextDouble();
        System.out.println("¿el número es positivo?" + (numE >= 0));
        System.out.println("¿El número es negativo?" +(numE < 0));

        







    }
}