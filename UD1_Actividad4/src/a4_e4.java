package UD1_Actividad4;

import java.util.Arrays;
import java.util.Scanner;

public class a4_e4 {
    public static void main(String[] args) {

    /*Ejercicio 4:Crea un programa que pida veinte números enteros por teclado, los almacene en un
    array y luego muestre por separado la suma de todos los valores positivos y negativos.*/

    System.out.println("A4_E4");
    Scanner lector=new Scanner(System.in);

    int sumaNegativos = 0;
    int sumaPositivos = 0;

    int numerosIngresados[] = new int[20];

    System.out.println("Ingresa 20 numeros enteros:");

    for(int i=0;i<numerosIngresados.length;i++){
        numerosIngresados[i]=lector.nextInt();
        if(numerosIngresados[i]>0) {
            sumaPositivos += numerosIngresados[i];
        }
        if(numerosIngresados[i]<0) {
            sumaNegativos += numerosIngresados[i];
        }
    }

    System.out.println("La suma de los numeros negativos es:" + sumaNegativos);
    System.out.println("La suma de los numeros positivos es:" + sumaPositivos);



    }//void
}//main
