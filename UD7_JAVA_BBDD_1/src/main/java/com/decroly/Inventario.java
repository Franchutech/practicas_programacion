package com.decroly;


import java.util.List;
import java.util.Scanner;


public class Inventario {
    public static void main(String[] args) {

        System.out.println("Iniciando sistema MercaDaw...");

        java.sql.Connection conn = SQLDataBaseManager.getConnection();

        if (conn != null) {
            System.out.println("Conexión a la base de datos de MercaDaw establecida correctamente...");
            Scanner input = new Scanner(System.in);

            int opcion = 0;
            SQLAccessProducts acceso = new SQLAccessProducts();
            //LO DECLARO FUERA PARA USARLO EN TODAS LAS CLASES

            do {
            opcion = mostrarMenu(input);
            switch (opcion) {
                case 1:
                    System.out.println("MOSTRANDO TODOS LOS PRODUCTOS DEL INVENTARIO");
                    //LLAMO EL INSTANCIADO
                    List<Producto> productos = acceso.getProducto();
                    //3.FOR-EACH-RECORRIDO
                    for (Producto p: productos) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.println("BUSCAR PRODUCTO POR REFERENCIA");
                    System.out.println("Introduce el número de referencia (formato REF000)");
                    String ref = input.nextLine().trim();
                    //LLAMO EL INSTANCIADO
                    Producto encontrado = acceso.getProductsbyreference(ref);
                    if (encontrado != null) {
                        System.out.println("PRODUCTO ENCONTRADO");
                        System.out.println(encontrado);//llama al to string
                    }else {
                        System.out.println("No existe ningun producto con la referencia:" + ref);
                    }
                    break;
                case 3:
                    System.out.println("BUSCAR PRODUCTO POOR TIPO");
                    break;
                case 4:
                    System.out.println("BUSCAR PRODUCTO POR CANTIDAD");
                    break;
                case 5:
                    System.out.println("INSERTAR UN NUEVO PRODUCTO");
                    break;
                case 6:
                    System.out.println("ELIMINAR PRODUCTO POR REFERENCIA");
                    break;
                case 7:
                    System.out.println("ACTUALIZAR PRODUCTO");
                    break;
                case 8:
                    System.out.println("INSERTAR UN NUEVO TIPO DE PRODUCTO");
                    break;
                case 9:
                    System.out.println("SALIENDO DE MERCADAW...");
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
