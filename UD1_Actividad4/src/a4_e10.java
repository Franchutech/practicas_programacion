package UD1_Actividad4;

import java.util.Scanner;

public class a4_e10 {
    public static void main(String[] args) {
        Scanner lector=new Scanner(System.in);

    /*Ejercicio 10: Crea un programa para realizar cálculos relacionados con la altura (en metros) de
personas. Pedirá un valor N y luego almacenará en un array N alturas introducidas por teclado.
Luego mostrará la altura media, máxima y mínima, así como cuántas personas miden por encima
y por debajo de la media. */

        System.out.println("A4_E10");



        //Intentar definir el tamaño del array, le preguntaré al usuario cuantas alturas, quiere ingresar//
        int n = 0;

        System.out.println("Indica cuantas alturas deseas ingresar a este programa:");
        n = lector.nextInt();


        //ahora que tengo el tamaño del array n puedo definir el array

        double alturasDetalle []= new double[n];

        // ahora ocuparia definir las variables que usare más adelante //

        double suma = 0;
        double min= Double.MAX_VALUE;
        double max= Double.MIN_VALUE;

        //rellenar el array con las alturas//

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese las alturas en formato 1,65 por ejemplo: ");
            alturasDetalle[i] = lector.nextDouble();
            suma += alturasDetalle[i];
            if (i == 0) {
                min = alturasDetalle[i];
                max = alturasDetalle[i];
            }
            if (alturasDetalle[i] < min) {
                min = alturasDetalle[i];
            }
            if (alturasDetalle[i] > max) {
                max = alturasDetalle[i];
            }
        }

        //debo definir que es una media //
        double media = suma / n;


        // ahora deben haber contadores, que lleven la cuenta cuantos son mayores que la media y cuantos menores//

        int mayores = 0;
        int menores = 0;

        // y pues tendria que recorrer de nuevo el array para saber cuales cumplen y sumarle a cada//


        for (int i = 0; i < n; i++) {
            if (alturasDetalle[i] > media) {
                mayores++;
            }
            if (alturasDetalle[i] < media) {
                menores++;
            }
        }

        // finalmente tendria que mostrar por pantalla todo lo que pide el ejercicio ...//
        System.out.println("El total de alturas ingresada fue: " + n);
        System.out.println("La altura máxima es: " + max);
        System.out.println("La altura mínima es: " + min);
        System.out.println("La media de los numeros ingresados es: " + media);
        System.out.println("La cantidad de alturas mayor a la media es: " + mayores);
        System.out.println("La cantidad de alturas menor a la media es: " + menores);


        /**
         * - Ok en este ejercicio, ya de entrada interpretandolo, tuve que darle mucha cabeza, porque
         * Me costó entender que ocupo saber "cuantas alturas" va a ingresar el usuario, porque sin saber
         * cuantas son, no podria saber de que tamaño es el array, indistintamente de las alturas.
         * Finalmente como JAVA ejecuta el codigo linea a linea, decidi primeramente preguntar, al usuario
         * cuantas alturas va a ingresar, para así poder definirle a java primero el tamaño del array (pero
         * me costó 1 hora llegar a esa conclusión, brutal).
         * - Otra cosa que aprendi es que una variable se puede definir no solo en cero, sino tambien en el tamaño
         * de un scanner ingresado por el usuario.
         */

    } //void
}//main
