package UF2_ACTIVIDAD5;

import java.util.Scanner;

public class A5_E5 {
    public static void main(String[] args) {
        Scanner lector=new Scanner(System.in);
        System.out.println("A5_E5");

        /*Realiza un programa que lea una frase por teclado e indique si la frase es un palíndromo
        o no (ignorando espacios y sin diferenciar entre mayúsculas y minúsculas).
        Supondremos que el usuario solo introducirá letras y espacios (ni comas, ni puntos, ni
        acentos, etc.). Un palíndromo es un texto que se lee igual de izquierda a derecha que de
        derecha a izquierda.*/

        System.out.println("Introduzca un texto para saber si es o no palindromo:");
        String palindromo=lector.nextLine();

        //necesito eliminar los espacios//

        String palindromo2= palindromo.replace(" ","");

        //con el palindromo2, normalizo las letras que haya incluido el usuario//
        String palindromo3=palindromo2.toUpperCase();

        boolean esPalindromo = true;

        for(int i=0;i<palindromo3.length()/2;i++){
            if (palindromo3.charAt(i)!= palindromo3.charAt(palindromo3.length() -1 - i)){
                esPalindromo= false;
                break;
            }//if1
        }//for
        if(esPalindromo){
            System.out.println("El texto introducido es palindromo");
        }else {
            System.out.println("El texto introducido no es palindromo");
        }


        /*ok en este ejercicio:
        * Debo restringir al usuario, para que no se permitan comas, puntos, ni acentos (si me sobra tiempo)
        * Pues bueno lo primero sería pedir el string directamente como un palindromo.
        * Despues haria un palindromo2 pasandolo todo a mayusculas o minusculas para igualar.
        * Luego necesitaria un for que recorra de izquierda a derecha y que a su vez compare de derecha a izquierda
        * (ni siquiera se si se puede hacer esto, pero bueno buscaría si es posible)
        * Y si coincide cad aposición del string, que tire un booleano no se a lo mejor, true o false...
        * si true, entonces imprimir palindromo
        * si false, entonces imprimir no es palindromo*/


    }//void
}//main
