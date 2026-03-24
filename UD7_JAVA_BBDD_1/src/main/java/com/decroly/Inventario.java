package com.decroly;


import java.util.Scanner;


public class Inventario {
    public static void main(String[] args) {

        System.out.println("Iniciando sistema MercaDaw...");

        java.sql.Connection conn = SQLDataBaseManager.getConnection();

        if (conn != null) {
            System.out.println("Conexión a la base de datos de MercaDaw establecida correctamente...");
            Scanner input = new Scanner(System.in);

            int opcion = 0;
            do {
            opcion = mostrarMenu(input);
            switch (opcion) {
                case 1:
                    break;

            }
        }while (opcion!=9);

    }else {
        System.out.println("ERROR: No se puede conectar a la base de datos");
    }



    }// CIERRE VOID MAIN


    //METODO PARA EL MENU

    public static int mostrarMenu(Scanner input) {
        System.out.println("\n BIENVENIDO A MERCADAW");
        System.out.println("\n  MENÚ PRINCIPAL");
        System.out.println("1. Mostrar todos los productos en el inventario");
        System.out.println("2. Buscar producto por referencia");
        System.out.println("3. Buscar producto por tipo");
        System.out.println("4. Buscar producto por cantidad");
        System.out.println("5. Insertar un nuevo producto"); //(no permitir referencias repetidas)
        System.out.println("6. Eliminar producto por referencia");  //referencia no valida
        System.out.println("7. Actualizar producto"); //(descripción, cantidad, precio, descuento, AplicarDto).
        System.out.println("8. Insertar un nuevo tipo de producto ");
        System.out.print("9. Salir.");

        String entrada = input.nextLine().trim();
        while (!entrada.matches("[1-9]")) {
            System.out.print("Opción no válida. Ingrese 1-9: ");
            entrada = input.nextLine().trim();
        }

        return Integer.parseInt(entrada);
    }


}//CIERRE INVENTARIO
