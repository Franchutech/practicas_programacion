import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /*Escribe un programa que pide la edad por teclado y nos muestra el mensaje de “Eres
mayor de edad” solo si lo somos.*/
        System.out.println("Ejercicio1");
        System.out.println("Ingrese su edad:");
        Scanner sc = new Scanner(System.in);
        int edad = sc.nextInt();
        if (edad >= 18) {
            System.out.println("El edad es mayor a 18");
        }else {
            System.out.println("El edad es menor a 18");
        }

        /*Escribe un programa que pide la edad por teclado y nos muestra el mensaje de “eres
mayor de edad” o el mensaje de “eres menor de edad”. */
        System.out.println("Ejercicio2");
        System.out.println("Ingrese una edad:");
        Scanner sc2 = new Scanner(System.in);
        int edad2 = sc2.nextInt();
        if (edad2 >= 18 && edad2 > 0) {
            System.out.println("El edad es mayor de edad");
        }else if (edad2 < 18 && edad2 > 0) {
            System.out.println("Es menor de edad");
        } else {
            System.out.println("La edad no puede ser cero ni menor que cero");
        }

        /*Realiza un programa que muestre por pantalla los 20 primeros números naturales (1, 2,
3... 20). */

        System.out.println("Ejercicio3");
        System.out.println("Los primeros 20 numeros naturales son:");
        for (int i = 1; i <= 20; i++) {
            System.out.println(i);
        }

        /*Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Para ello utiliza un contador y suma de 2 en 2.*/

        System.out.println("Ejercicio4");
        System.out.println("Los numeros pares entre el 1 y el 200 son:");
        for (int i = 2; i <= 200; i+=2) {
        System.out.print(i + ", ");
        }



    }//VOID_MAIN
}//MAIN
