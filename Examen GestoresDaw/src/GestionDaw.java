
import exceptions.DNIYaRegistradoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


public class GestionDaw {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a GestiónDaw");


        int opcion = -1;

        do {
            Menu();
            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("ESTADO DE LA SINCRONIZACIÓN");

                        break;
                    case 2:
                        System.out.println("REGISTRAR TRABAJADOR");

                        break;

                    case 3:
                        System.out.println("\n-INFORMACION GENERAL DE LA EMPRESA");

                        break;
                    case 4:
                        System.out.println("\nDETALLE DE LA ACADEMIA");


                        break;
                    case 5:

                        break;
                    case 6:

                        break;

                    case 7:

                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Introduzca un numero valido");

            }

        }while (opcion != 0) ;//CIERRE DEL DO WHILE

    }//CIERRE VOID MAIN

        public static void Menu () {
            System.out.println("\n MENÚ GESTION DAW");
            System.out.println("1. Sincronizar Datos (DAT)");
            System.out.println("2. Crear trabajador");
            System.out.println("3. Registrar ");
            System.out.println("4. Mostrar Info ");
            System.out.println("5. ");
            System.out.println("6. Eliminar  por DNI");
            System.out.println("0. Guardar y Salir");
            System.out.print(">> Seleccione opción: ");
        }//CIERRE MENU

}//CIERRE MAIN




