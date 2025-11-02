

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando carpeta Actividad 6...");

        System.out.println("A6_E1");

        /* Ejercicio 1: Crea un programa que cree una matriz de tamaño 5x5 que almacene los números del 1 al 25
        y luego muestre la matriz por pantalla.*/

        int[][] numeros = new int[5][5];
        int contador = 1;

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = contador;
                contador++;
                System.out.print(numeros[i][j] + " ");
            }
            System.out.println();
        }
        /*Ejercicio 2: Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas de
        multiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por pantalla.*/

        System.out.println("A6_E2");

        int[][] tablas = new int[10][10];
        int multiplicador;

        for (int l = 0; l < tablas.length; l++) {

            for (int k = 0; k < tablas[l].length; k++) {
                multiplicador = (l + 1) * (k + 1);
                tablas[l][k] = multiplicador;
                System.out.print(tablas[l][k] + " ");
            }
            System.out.println();
        }

        /*Ejercicio 3: Crea un programa que cree una matriz de tamaño NxM (tamaño introducido por teclado) e
        introduzca en ella NxM valores (también introducidos por teclado). Luego deberá recorrer la
        matriz y al final mostrar por pantalla cuántos valores son mayores que cero, cuántos son
        menores que cero y cuántos son igual a cero. */
        Scanner lector = new Scanner(System.in);

        System.out.println("A6_E3");

        System.out.println("Introduzca la cantidad de filas para su Array:");
        int N = lector.nextInt();
        System.out.println("Introduzca la cantidad de columnas para su Array:");
        int M = lector.nextInt();

        int menor = 0;
        int mayor = 0;
        int iguales = 0;

        int[][] matriz = new int[N][M];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Introduce el valor para la fila " + (i + 1) + ", columna " + (j + 1) + ": ");
                matriz[i][j] = lector.nextInt();
                if (matriz[i][j] > 0) {
                    mayor++;
                } else if (matriz[i][j] < 0) {
                    menor++;
                } else {
                    iguales++;
                }
            }//segundo for
        }//primer for
        System.out.println("Los numeros iguales a cero son: " + iguales);
        System.out.println("Los numeros menores a cero son: " + menor);
        System.out.println("Los numeros mayores a cero son: " + mayor);

        /*Aqui lo que tendria que hacer primero es traer el scanner (refrescarlo)
         * Pedir al usuario 2 entradas una N y una M para el tamaño del array bidimencional
         * Luego de eso tendria que hacer un for dentro de otro for para recorrerlos
         * Y finalmente creo que un if debajo del segundo for para condicionar los valores, a mayor, igual, menor*/

        /*Ejercicio 4: Necesitamos crear un programa para almacenar las notas de 4 alumnos (llamados “Alumno
        1”, “Alumno 2”, etc.) y 5 asignaturas. El usuario introducirá las notas por teclado y luego el
        programa mostrará la nota mínima, máxima y media de cada alumno. */

        System.out.println("A6_E4");
        lector = new Scanner(System.in);


        double[][] notas = new double[4][5];

        double max;
        double min;
        double media;

        for (int i = 0; i < notas.length; i++) {
            max = 0;
            min = 10;
            media = 0;
            for (int j = 0; j < notas[i].length; j++) {
                System.out.print("Introduce el valor para el alumno " + (i + 1) + ", y para la asignatura " + (j + 1) + ": ");
                notas[i][j] = lector.nextDouble();
                if (notas[i][j] > max) {
                    max = notas[i][j];
                } else if (notas[i][j] < min) {
                    min = notas[i][j];
                }
                media = media + notas[i][j];

            }//segundo for
            media = media / 5;
            System.out.println("Alumno " + (i + 1) + " nota minima: " + min + " nota máxima: " + max +
                    " nota media: " + media);

        }//primer for


        /* Ok aqui lo primero que creo que debo hacer es pues refrescar el scanner, porque lo voy a necesitar.
         * Luego tendría que hacer el array bidimencional una para las filas de los 4 alumnos y otra para las 5 asginaturas.
         * Luego creo las 3 variables que voy a necesitar para trabajar en el caso. Min, Max, Media.
         * Luego crearía los for para recorrer el array, al ser bidimencional, sería un for dentro de otro. El primero
         * recorrería la fila (alumnos), y el segundo la columna (las asignaturas)
         * Dentro del primer for los alumnos, defino las variantes, (recordar que debe ser a la inversa, si es max 0 y si es min 10,
         * para que cuente bien.
         * En el segundo for el que recorre las asignaturas, ocupo pedirle al usuario que ingrese la nota
         * y pues leo la nota con el lector (siempre dentro del segundo for)
         * Luego tendría que hacer las comparaciones ya dentro del segundo for, que seria con los if / else if
         * si el array es mayor que, menor que, y darle el nuevo valor a max y a min del tamaño del array si eso se cumple
         * Fuera del if y el else, defino la media como media+ array
         * y pues finalmente después dle segundo for y antes de cerrar el primero, mostrar la media real que seria la media / 5
         * y mostrar el resultado.
         */

        /*Ejercicio 5:Necesitamos crear un programa para registrar sueldos de hombres y mujeres de una empresa
        y detectar si existe brecha salarial entre ambos. El programa pedirá por teclado la información
        de N personas distintas (valor también introducido por teclado). Para cada persona, pedirá su
        género (0 para varón y 1 para mujer) y su sueldo. Esta información debe guardarse en una única
        matriz. Luego se mostrará por pantalla el sueldo medio de cada género. */

        System.out.println("A6_E5");
        lector = new Scanner(System.in);

        System.out.println("Introduzca la cantidad de empleados para su Array:");
        int empleados = lector.nextInt();


        //Armo el array porque ya tendría todo

        double registros[][] = new double[empleados][2];

        int hombres = 0;
        int mujeres = 0;
        double salarioHombres = 0;
        double salarioMujeres = 0;

        for (int i = 0; i < registros.length; i++) {
            System.out.println("Introduzca un 0 si el empleado es un Hombre y un 1 si el empleado es una mujer:");
            int genero = lector.nextInt();
            while (genero != 0 && genero != 1) {
                System.out.println("Ingrese un número válido o 0 o 1:");
                System.out.println("Introduzca un 0 si el empleado es un Hombre y un 1 si el empleado es una mujer:");
                genero = lector.nextInt();
            }
            System.out.println("Introduzca el salario para el empleado:");
            double salario = lector.nextDouble();
            registros [i][0] = genero;
            registros [i][1] = salario;

            if (genero == 0) {
                hombres++;
                salarioHombres = salarioHombres + salario;
            } else if (genero == 1) {
                mujeres++;
                salarioMujeres = salarioMujeres + salario;
            }
        }//for
        double mediaHombres = salarioHombres / hombres;
        double mediaMujeres = salarioMujeres / mujeres;

        System.out.println("La media de salario en hombres: " +  mediaHombres);
        System.out.println("La media de salario en mujeres: " +  mediaMujeres);

        //La brecha salarial sería:

        if (mediaHombres > mediaMujeres) {
            System.out.println("Existe una brecha salarial a favor de los hombres");
        }else if (mediaHombres < mediaMujeres) {
            System.out.println("Existe una brecha salarial a favor de los mujeres");
        }else {
            System.out.println("No existe una brecha salarial entre hombres y mujeres");
        }




        /*
         * 1- Refrescar el lector.
         * 2- Pedir al usuario con un System.out.print la cantidad de empleados (filas del array).
         * 3- Las columnas serán 2 (una para género y otra para salario).
         * 4- Crear el array de tamaño [empleados][2].
         * 5- Crear contadores y acumuladores:
         *      int hombres = 0; int mujeres = 0;
         *      double sumaHombres = 0; double sumaMujeres = 0;
         * 6- Usar un solo for, porque hay dos columnas fijas.
         *      - Pedir el género (0 o 1) y el salario.
         *      - Guardarlos en la matriz.
         *      - Si el género es 0, sumar al total de hombres y acumular su salario.
         *      - Si el género es 1, sumar al total de mujeres y acumular su salario.
         * 7- Al terminar el for, calcular los sueldos medios:
         *      mediaHombres = sumaHombres / hombres;
         *      mediaMujeres = sumaMujeres / mujeres;
         * 8- Imprimir los resultados.
         * 9- Comparar las medias. Si son diferentes, existe brecha salarial.
         * Wow, mi profe se ha vuelto loco jajaja.
         */

    }//void
}//main
