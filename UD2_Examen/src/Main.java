package UD2_Examen;

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
        int opcion;
        int caso;

        do {
            instrucciones();
            System.out.println("Elija una de las opciones del menu:");
            opcion = lector.nextInt();

            switch (opcion) {
                case 1://modificar seleccion
                    do {
                        instruccionesModificacion();
                        System.out.println("Elija una de las opciones del menu:");
                        caso = lector.nextInt();
                        switch (caso) {
                            case 1: // insertar numero en la última posición
                                System.out.println("Introduzca un el número que desea sustituir en última posición");
                                int num1 = lector.nextInt();
                                numeroTotal[numeroTotal.length - 1] = num1;
                                System.out.println("Número insertado correctamente en la última posición");
                                break;
                            case 2:
                                //Insertar numero en una posicion especifica
                                System.out.println("Introduce el número:");
                                int nuevoNumero = lector.nextInt();
                                System.out.println("Introduce la posición (0 a " + (numeroTotal.length - 1) + "):");
                                int posicion = lector.nextInt();

                                if (posicion >= 0 && posicion < numeroTotal.length) {
                                    numeroTotal[posicion] = nuevoNumero;
                                    System.out.println("Número insertado correctamente en posición " + posicion);
                                } else {
                                    System.out.println("Posición inválida.");
                                }
                                break;
                            case 3:
                                //borrar numero de ultima posicion ocupada
                                numeroTotal[numeroTotal.length - 1] = 0;
                                System.out.println("Última posición vaciada.");
                                break;
                            case 4:
                                //borrar numero de una posicion especifica
                                System.out.println("Introduce la posición a borrar:");
                                int pos = lector.nextInt();
                                if (pos >= 0 && pos < numeroTotal.length) {
                                    numeroTotal[pos] = 0;
                                    System.out.println("Posición " + pos + " borrada.");
                                } else {
                                    System.out.println("Posición inválida.");
                                }
                                break;
                            case 5:
                                //modificar numero de una posicion especifica.
                                System.out.println("Introduzca la posición a modificar:");
                                int posModificar = lector.nextInt();
                                if (posModificar >= 0 && posModificar < numeroTotal.length) {
                                    System.out.println("Introduzca el nuevo valor:");
                                    int nuevoValor = lector.nextInt();
                                    numeroTotal[posModificar] = nuevoValor;
                                    System.out.println("Posición " + posModificar + " modificada con éxito.");
                                } else {
                                    System.out.println("Posición inválida.");
                                }
                                break;
                            case 6:
                                System.out.println("Usted va a salir del programa.");
                                break;
                        }
                    } while (caso != 6);
                    //do principal
                    break;

                case 2: {
                    // Estadísticas de la colección
                    System.out.println("ESTADÍSTICAS DE LA COLECCIÓN");

                    int suma = 0;
                    int contadorNoNulos = 0;
                    int max = numeroTotal[0];
                    int min = numeroTotal[0];

                    for (int i = 0; i < numeroTotal.length; i++) {
                        int valor = numeroTotal[i];
                        suma += valor;

                        if (valor != 0) {
                            contadorNoNulos++;
                        }

                        if (valor > max) max = valor;
                        if (valor < min) min = valor;
                    }

                    double media;
                    if (contadorNoNulos > 0) {
                        media = (double) suma / contadorNoNulos;
                    } else {
                        media = 0;
                    }

                    System.out.println("Suma total: " + suma);
                    System.out.println("Media de valores no nulos: " + media);
                    System.out.println("Valor máximo: " + max);
                    System.out.println("Valor mínimo: " + min);
                    break;
                }
                case 3:
                    //Ampliar el valor de la coleccion
                    System.out.println("Introduce el nuevo tamaño del array (actual: " + numeroTotal.length + "):");
                    int nuevoTamanio = lector.nextInt();

                    if (nuevoTamanio <= numeroTotal.length) {
                        System.out.println("El nuevo tamaño debe ser mayor que el actual.");
                    } else {
                        int[] nuevoArray = new int[nuevoTamanio];
                        for (int i = 0; i < numeroTotal.length; i++) {
                            nuevoArray[i] = numeroTotal[i];
                        }
                        numeroTotal = nuevoArray;
                        System.out.println("Colección ampliada correctamente. Nuevo tamaño: " + numeroTotal.length);
                    }
                    break;
                case 4: {
                    //salir
                    System.out.println("Usted salió del programa");
                    break;
                }
            }
            while (opcion != 4) ;
        }//void main
    }
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
        System.out.println("2. Insertar número en una posición específica");
        System.out.println("3. Borrar numero de ultima posicion ocupada");
        System.out.println("4. Borrar numero de una posicion especifica");
        System.out.println("5. Modificar un numero");
        System.out.println("6. Salir");
    }

}// main
