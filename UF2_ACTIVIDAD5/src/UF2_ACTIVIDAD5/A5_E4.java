package UF2_ACTIVIDAD5;

import java.util.Scanner;

public class A5_E4 {
    public static void main(String[] args) {
    Scanner lector=new Scanner(System.in);
        System.out.println("A5_E4");

        /*Crea un programa que muestre por pantalla cuantas vocales de cada tipo hay (cuantas
        ‘a’, cuantas ‘e’, etc.) en una frase introducida por teclado. No se debe diferenciar entre
        mayúsculas y minúsculas. Por ejemplo, dada la frase “Mi mama me mima” dirá que hay:
        Nº de A's: 3
        Nº de E's: 1
        Nº de I's: 2
        Nº de O's: 0
        Nº de U's: 0 */

        lector= new Scanner(System.in);
        System.out.println("Introduzca una frase para contar sus vocales:");
        String frase=lector.nextLine();
        String frase2=frase.toUpperCase();

        int contadorA=0;
        int contadorE=0;
        int contadorI=0;
        int contadorO=0;
        int contadorU=0;

        for(int i=0;i<frase2.length();i++){
            if(frase2.charAt(i)=='A'){
                contadorA++;
            }else if(frase2.charAt(i)=='E') {
                contadorE++;
            }else if(frase2.charAt(i)=='I') {
                contadorI++;
            }else if(frase2.charAt(i)=='O') {
                contadorO++;
            }else if(frase2.charAt(i)=='U') {
                contadorU++;
            }
        }//for

        System.out.println("El numero de A`s es:" +  contadorA);
        System.out.println("El numero de E`s es:" +  contadorE);
        System.out.println("El numero de Is es:" +  contadorI);
        System.out.println("El numero de Os es:" +  contadorO);
        System.out.println("El numero de Us es:" +  contadorU);

        /*Ok en este caso lo primero sería pedir al usuario la frase, en un string
        * luego no se creo deberia haber un contador para cada vocal, a, e, i, o y u, definir esa variable con un int
        * y no se si en este caso podría usar un for que recorra todo el string y
        * y sume con cada vocal por ejemplo, if encuentra a entonces contador +1 segun la letra.
        * Aun me falta buscar la teoría para lograrlo, pero haría algo así
        * Luego solo imprimiría.*/


    }//VOID
}//MAIN
