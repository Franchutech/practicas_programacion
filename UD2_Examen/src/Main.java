import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // pido los numeros al usuario
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduzca la cantidad total de números que desea utilizar");
        int n = lector.nextInt();

        // con esos numeros creo el array que me permitira recorrerlo
        int[] numeroTotal = new int[n];

        do {
            instrucciones();
            switch (numeroTotal) {
                case 1://modificar seleccion
                    do {
                        instruccionesModificacion();
                        switch () {
                            case 0: // insertar numero
                                //Insertar numero en la ultima posicion
                                System.out.println("Introduzca un el número que desea sustituir en última posición");
                                int num1 = lector.nextInt();
                                for (int i = 0; i < numeroTotal.length - 1; i++) {
                                    numeroTotal[i] = num1;
                                }
                                break;
                            case 1:
                                //Insertar numero en una posicion especifica
                                System.out.println("Introduzca el numero que desea cambiar");
                                int num2 = lector.nextInt();
                                System.out.println("Introduzca la posición en la que desea guardarlo");
                                int num3 = lector.nextInt();
                                for (int i = num3; i < numeroTotal.length; i++) {
                                    i = num2;
                                    System.out.println("El nuevo array es:" + numeroTotal[i]);
                                }
                                break;
                            case 2:
                                //borrar numero de ultima posicion ocupada
                                for (int i = 0; i < numeroTotal.length; i++) {
                                    numeroTotal[i] = numeroTotal[i - 1];
                                }System.out.println("El nuevo array es: " + numeroTotal[i]);
                                break;
                            case 3:
                                //borrar numero de una posicion especifica
                                System.out.println("Introduzca la posición que desea eliminar");
                                int num4 = lector.nextInt();
                                for (int i = num4; i < numeroTotal.length; i++) {
                                    numeroTotal[i] = numeroTotal[i - num4];
                                System.out.println("El nuevo array es:" + numeroTotal[i]);

                                }
                                break;
                            case 4:
                                //modificar numero de una posicion especifica.
                                System.out.println("Introduzca el numero que desea cambiar");
                                int num5 = lector.nextInt();
                                System.out.println("introduzca la posición en la que desea colocar el numero");
                                int num6 = lector.nextInt();
                                for (int i = num6 ; i < numeroTotal.length; i++) {
                                    numeroTotal[i] = num5;
                                    System.out.println("El nuevo array es:" + numeroTotal[i]);

                                }
                                break;
                            case 5:
                                System.out.println("Usted va a salir del programa.");
                                break;
                        } while (n != 5) ;
                    }// do2

            }//do principal
            break;
                case 2:
                    //estadisticas de la seleccion
                    //media
                    System.out.println("La media de todos los valores nulos es:");
                    int media;
                    int contador = 0;
                    for (int i = 0; i < numeroTotal.length; i++) {
                        if (i != 0) {
                            contador++;
                            media = numeroTotal[i] / contador;
                            System.out.println("La media es:" + media);
                        }
                    }
                        //sumar
                        int suma = 0;
                        for (int j = 0; j < numeroTotal.length; j++) {
                            suma += numeroTotal[j];
                        }
                    System.out.println("La suma de todos los valores es:" + suma);
                    //maximo
                        //minimo
                    int max = 0;
                    int min = 0;
                    for (int j = 0; j < numeroTotal.length; j++) {
                        if (i == 0){
                            max = numeroTotal[j];
                            min = numeroTotal[j];
                        }else {
                            if (numeroTotal[j] > max) max = numeroTotal[j];
                            if (numeroTotal[j] < min) min = numeroTotal[j];
                        }
                    } System.out.println("El valor maximo de la colección es: " + max);
                    System.out.println("El valor minimo de la colección es: " + min);
                    break;
                case 3:
                    //Ampliar el valor de la coleccion
                    for (int j = 0; j < numeroTotal.length; j++) {
                        System.out.println("Introduzca el nuevo tamaño del array:");
                        int nuevoTamanio = lector.nextInt();
                        numeroTotal[j] = nuevoTamanio;
                    } System.out.println("El nuevo array es: " + numeroTotal[i]);
                        break;
                case 4:
                    //salir
                    System.out.println("Usted salió del programa");
                    break;

        } while (n != 4);//switch numero total

    }//void main

    //metodo para instrucciones:
    public static void instrucciones() {
        System.out.println("Elija una de las siguientes opciones");
        System.out.println("1. Modificar colección");
        System.out.println("2. Estadísticas de la colección");
        System.out.println("3. Ampliar valor de la colección");
        System.out.println("4. Salir");
    }
    public static void instruccionesModificacion() {
        System.out.println("Elija una de las siguientes opciones");
        System.out.println("1. Insertar número en ultima posicion");
        System.out.println("2. Borrar numero de ultima posicion ocupada");
        System.out.println("3. Borrar numero de una posicion especifica");
        System.out.println("4. Modificar un numero");
        System.out.println("5. Salir");
    }



    }// main


/*Pasos que seguiría:
 * 1. Pedir numeros al usuario con el scanner lector, numero que eligirà el usuario:
 * Esto debo pedir un numero por escaner, si o si tendria que usar un Array, que convierta el numero ingresado
 * por el usuario en un array unidimensional.
 * 2. Debo seguidamente hacer un do while, para meter un switch dentro, que tenga las 4
 * opciones de menu que me pide el ejercicio.
 * 3. Creo que tendria que hacer un segundo switch dentro del promero para el submenu de modificacion de coleccion
 * Dentro de ese menu deben haber submenus, donde sus funcionalidades, deben estar ligadas a metodos.
 * Crear 2 metodos que faciliten el codigo principal
 * Intentar hacer en todos los pasos algo, dejar para el final loque no recuerdo.
 * Y si me da tiempo, intentar mejorar algo.
 * */