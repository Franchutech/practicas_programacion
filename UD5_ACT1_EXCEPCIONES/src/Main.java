import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        //Ejercicio 1
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.println("Ejercicio 1:");
            System.out.println("Introduzca un valor entero");
            int A = entrada.nextInt();
            System.out.println("El valor A introducido es: " + A);
        } catch (InputMismatchException e) {
            System.out.println("El valor introducido no es valido ");
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado, Ejercicio 1");
        }


        //Ejercicio 2

        try {
            System.out.println("Ejercicio 2:");
            System.out.println("Introduzca un valor entero B:");
            int B = entrada.nextInt();
            System.out.println("Introduzca un valor entero C:");
            int C = entrada.nextInt();
            System.out.println("La división de ambos números es: " + B / C);
        } catch (InputMismatchException e) {
            System.out.println("El valor introducido no es un numero entero");
            entrada.nextLine();
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("El valor introducido no puede ser cero");
            entrada.nextLine();
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado, Ejercicio 2");
        }

        //Ejercicio 3
        System.out.println("Ejercicio 3:");
        double[] vector = new double[5];
        int i = 0;

        while (i < 5) {
            try {
                System.out.println("Introduzca un valor para la posición " + i + ": ");
                vector[i] = entrada.nextDouble();
                i++;
            } catch (InputMismatchException e) {
                System.out.println("El valor introducido no es valido ");
                e.printStackTrace();
                entrada.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("El array tiene màximo de tamaño 5");
                e.printStackTrace();
                entrada.nextLine();
            } finally {
                System.out.println("Programa finalizado, Ejercicio 3");
            }
        }//WHILE


        //Ejercicio 4
        System.out.println("Ejercicio 4:");
        System.out.println("\nEjercicio 4 (Pruebas):");
        try {
            imprimePositivo(10);
            imprimePositivo(-5); // Esto lanzará excepción
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            imprimeNegativo(-10);
            imprimeNegativo(5); // Esto lanzará excepción
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // Ejercicio 5
        System.out.println("\nEjercicio 5 (Pruebas de clase gato):");
        try {
            //Crear un gato correcto
            gato gatoValido = new gato("Misifú", 5);
            gatoValido.imprimir();

            //Forzar error de nombre (menos de 3 letras)
            gato gatoError = new gato("Yo", 3);
            gatoError.imprimir();

        } catch (Exception e) {
            System.out.println("Se ha capturado una excepción de gato: " + e.getMessage());
            e.printStackTrace();
        }

        //Ejercicio 6
        System.out.println("\nEjercicio 6: Introduzca datos de 5 gatos");
        // CREO LISTA PARA GUARDAR LOS GATOS
        java.util.ArrayList<gato> listaGatos = new java.util.ArrayList<>();

        // EL BUCLE NO PARA HASTA QUE TENGA 5 GATOS
        while (listaGatos.size() < 5) {
            try {
                System.out.println("\nDatos del gato # " + (listaGatos.size() + 1));

                System.out.print("Nombre (mínimo 3 letras): ");
                String nGato = entrada.next();

                System.out.print("Edad: ");
                int eGato = entrada.nextInt();

                //INTENTO CREAR EL GATO SI FALLA SALTA A CATCH
                gato nuevoGato = new gato(nGato, eGato);
                listaGatos.add(nuevoGato);
                System.out.println("Gato añadido correctamente.");

            } catch (InputMismatchException e) {
                System.out.println("Error: La edad debe ser un número entero.");
                e.printStackTrace();
                entrada.nextLine(); // Limpiamos el búfer para que no se bloquee
            } catch (Exception e) {
                // ATRAPO LA EXCEPCION PERSONALIZADA
                System.out.println("Error al validar el gato: " + e.getMessage());
                e.printStackTrace();
            }
        }

        //CUANDO CMPLETO LA LISTA, MUESTRO LOS GATOS
        System.out.println("\nLISTA FINAL DE GATITOS");
        for (gato g : listaGatos) {
            g.imprimir();
        }

        entrada.close(); //CIERRO SCANNER
    }//VOID MAIN

    //METODOS EJERCICIO #4

    public static void imprimePositivo(int p) throws Exception {
        if (p < 0) throw new Exception("Error: El valor es negativo");
        System.out.println("Valor positivo: " + p);
    }

    public static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) throw new Exception("Error: El valor es positivo o cero");
        System.out.println("Valor negativo: " + n);
}

}//MAIN