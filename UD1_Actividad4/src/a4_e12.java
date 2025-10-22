package UD1_Actividad4;

import java.util.Scanner;
import java.util.Arrays;

public class a4_e12 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("A4_E12");

    /*Ejercicio 12: Crea un programa que cree un array de 10 enteros y luego muestre el siguiente menú
    con distintas opciones:
    a. Mostrar valores.
    b. Introducir valor.
    c. Salir.
    La opción ‘a’ mostrará todos los valores por pantalla. La opción ‘b’ pedirá un valor V y una
    posición P, luego escribirá V en la posición P del array. El menú se repetirá indefinidamente hasta
    que el usuario elija la opción ‘c’ que terminará el programa. */

        int original[]= new int[10];

        for (int i = 0; i < original.length; i++) {
            original[i]= i;
        }

        int valorV = 0;
        int posicionP = 0;

        String opcion = "c";
        do{
            lector = new Scanner(System.in);
            System.out.println("\nEscoja una opción dentro de las siguientes:");
            System.out.println("a. Mostrar los valores");
            System.out.println("b. Ingresar los valores");
            System.out.println("c. Cerrar el programa");

            opcion = lector.nextLine();
            switch (opcion) {
                case "a":
                    System.out.println("El array en este momento es:" + (Arrays.toString(original)));

                    break;
                //(restringir al usuario)//
                case "b":
                    System.out.println("Introduce un valor V para reubicar en el Array: ");
                    valorV = lector.nextInt();
                    System.out.println("Introduce la posición en la que quieres ubicar el valor: ");
                    posicionP = lector.nextInt();
                    if (posicionP >= 0 && posicionP < original.length) {
                        original[posicionP] = valorV;
                    } else {
                        System.out.println("Posición no válida");
                    }
                    break;
                case "c":
                    System.out.println("Cerrar el programa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Elija una opcion correcta");
            }
        }while(!opcion.equalsIgnoreCase("c"));
        //mientras el while sea distinto de a, para asegurar que se ejecutará mientras usuario no presione a//
        //ignore case, elimina mayusculas y minusculas, no diferencia//

        /**Notas personales:
         * 1-Crear un array de tamaño 10.
         * 2-Rellenar ese array con un for, que sume 1 en cada vuelta, hasta llegar a 10 (con el length).
         * 3-Crear las variables necesarias (definirlas antes del do-while), creo que requeriría de entrada
         * crear a valorV=0, posicionP=0.
         * 3A-Aqui debería crear un do while con un switch de 3 opciones a/b/c.
         * declaro la "opcion" que romperá el bucle en el switch
         * Abro el do, y lo cierro con un while (para escribir dentro), el while debe ser diferente a la opcion
         * que romperá el bucle, de esta manera continuará hasta que se llegue a esa opción.
         * en el scanner de la opcion uso nextline porque las opciones son letras y no números.
         * Lo primero que pongo dentro del DO es el scanner, para poder pedir datos dentro del bucle.
         * Imprimo todas las opciones que tiene el usuario.
         * Pido con el scanner que elija una opcion y pues seria un scanner del tipo nextline, por ser letras.
         * Empiezo a trabajar en cada uno de los casos del switch.
         * El caso "a" es el más facil porque solamente debe imprimir el array que haya en ese momento.
         * que en este caso con un toString, lo imprimiría y listo.
         * El caso "b" es más complejo porque tengo que pedir datos, ubicar los datos dentro del array.
         *en b tengo que restringir la posición al tamaño del array, porque si el usuario se sale, java
         * me dará un error.
         *el "c" es el mas facil tambien solo salir del switch.
         */


    }//void
} //main
