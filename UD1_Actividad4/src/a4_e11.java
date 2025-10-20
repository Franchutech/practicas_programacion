package UD1_Actividad4;

import java.util.Scanner;

public class a4_e11 {
    public static void main(String[] args){
        Scanner lector=new Scanner(System.in);

    /*Ejercicio 11: Crea un programa que cree dos arrays de enteros de tamaño 100. Luego introducirá en
el primer array todos los valores del 1 al 100. Por último, deberá copiar todos los valores
del primer array al segundo array en orden inverso, y mostrar ambos por pantalla. */

    //crear 2 variables//
        int GrupoUno = 0;
        int GrupoDos = 0;

        //crear 2 arrays//
        int primerGrupo[]= new int [100];
        int segundoGrupo[]= new int[100];


    /*rellenar el array con los numeros del 1 al 100, en este caso i +1 ya que lo empiezo en 1 y llego a 100(limite
        del array)*/

        for(int i =1; i<primerGrupo.length;i++){
            primerGrupo[i]= i + 1;
            primerGrupo[i]= GrupoUno;
        }
    //copiar el array del primer grupo en el segundo grupo//

        for(int i = 0; i<segundoGrupo.length;i++){
            primerGrupo[i]=segundoGrupo[i];
            segundoGrupo[i]= GrupoDos;
            //ordenar los valores del segundo grupo en inverso//

        }
    System.out.println("Detalle del array original primerGrupo:" + GrupoUno);
    System.out.println("Detalle del array que copia segundoGrupo:" + GrupoDos);




    }// void
} // main
