package UD1_Actividad4;

import java.util.Scanner;

public class a4_e8 {
    public static void main(String[] args) {

    Scanner lector = new Scanner(System.in);
    /*Ejercicio 8: Crea un programa que cree un array con 100 números reales aleatorios entre 0.0 y 1.0,
    utilizando Math.random(), y luego le pida al usuario un valor real R. Por último, mostrará
    cuántos valores del array son igual o superiores a R. */

    System.out.println("A4_E8");

    //Creo el array, que debe ser double y debe estar restringido//

    double[] numReales = new double[100];

    //Pide contar los valores que son iguales o superiores, entonces ocupo un contador//
    int contador = 0;


    System.out.println("Ingrese un numero real entre 0.0 y 1.0 al cual llamaremos R:");
    double realR = lector.nextDouble();

    for(int i = 0;i<numReales.length;i++){
        numReales[i]= Math.random();
        if(numReales[i]>=realR) {
            contador++;
        }
    }
        if( contador > 0){
            System.out.print("Los valores iguales o superiores a R dentro del array son: " + contador);
        } else {
            System.out.print("No hay valores iguales o superiores a R dentro del array");
            }

/**
 * Que aprendi de este ejercicio:
 * - Aprendi que cuando piden contar algo, se necesita un contador inicializado en cero.
 * - Aprendi que Math.random tiene por defecto el rango de 0.0 a 1.0 sin incluir el 1.0.
 * - Aprendi que else no lleva parentesis.
 * - Aprendi que no es recomendable usar print dentro de los bucles, ya que se repiten en cada iteracion.
 *   Es mejor usar variables fuera del bucle para mostrar los resultados al final. Normalmente con un "if" variable
   se cumple entonces imprimir tal, sino tal...
 */

    }//void
} // main
