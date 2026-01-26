import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        //Ejercicio 1
        Scanner entrada = new Scanner(System.in);
        try{
            System.out.println("Ejercicio 1:");
            System.out.println("Introduzca un valor entero");
            int A = entrada.nextInt();
            System.out.println("El valor A introducido es: " + A);
        }catch(InputMismatchException e){
            System.out.println("El valor introducido no es valido ");
            e.printStackTrace();
        }finally{
            System.out.println("Programa finalizado, Ejercicio 1");
        }


        //Ejercicio 2

        try{
            System.out.println("Ejercicio 2:");
            System.out.println("Introduzca un valor entero B:");
            int B = entrada.nextInt();
            System.out.println("Introduzca un valor entero C:");
            int C = entrada.nextInt();
            System.out.println("La división de ambos números es: " + B/C);
        }catch(InputMismatchException e){
            System.out.println("El valor introducido no es un numero entero");
            entrada.nextLine();
            e.printStackTrace();
        }catch (ArithmeticException e){
            System.out.println("El valor introducido no puede ser cero");
            entrada.nextLine();
            e.printStackTrace();
        }finally{
            System.out.println("Programa finalizado, Ejercicio 2");
        }

        //Ejercicio 3
        System.out.println("Ejercicio 3:");
        double [] vector = new double [5];
        int i = 0;

        while(i < 5){
            try {
                System.out.println("Introduzca un valor para la posición " + i + ": ");
                vector[i] = entrada.nextDouble();
                i++;
            }
            catch(InputMismatchException e){
                System.out.println("El valor introducido no es valido ");
                e.printStackTrace();
                entrada.nextLine();
            }
            catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("El array tiene màximo de tamaño 5");
                e.printStackTrace();
                entrada.nextLine();
            }
            finally{
            System.out.println("Programa finalizado, Ejercicio 3");
            }
        }//WHILE


        //Ejercicio 4
        System.out.println("Ejercicio 4:");


    }//VOID MAIN

    //METODOS EJERCICIO #4

    public static void imprimePositivo(int p) throws Exception{
        if(p < 0){
            throw new Exception("El valor introducido no es valido ");
        }
        System.out.println("El valor introducido es: " + p);
    }//IMPRIME POSITIVO METODO
    public static void imprimeNegativo(int n){
        if(n >= 0){
            throw new Exception("El valor introducido no es valido.");
        }
    System.out.println("El valor introducido es: " + n);
    }//IMPRIME NEGATIVO METODO
}//MAIN