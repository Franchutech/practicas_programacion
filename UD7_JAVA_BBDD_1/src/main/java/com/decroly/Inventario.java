package com.decroly;

import java.sql.Connection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Inventario {
    public static void main(String[] args) {
        System.out.println("Iniciando sistema MercaDaw...");

        String url = "";
        String user = "";
        String password = "";

        try (BufferedReader br = new BufferedReader(new FileReader("application.dat"))) {
            url = br.readLine();
            user = br.readLine();
            password = br.readLine();
        } catch (IOException e) {
            System.out.println("Error critico: no se pudo leer el archivo de configuracion");
            return; //sino hay datos puedo seguir
        }
        //PRUEBO LA CONECCION A LA OTRA CLASE.
        Connection conn = SQLDataBaseManager.getConnection(url, user, password);
        if (conn != null) {
            System.out.println("Conexion establecida, puedo trabajar con MercaDaw");
            probarConexionReal(conn);

            //Aquì si todo funciona bien tendria que ir el menu

            //MENU
            mostrarMenu();


        } else {
            System.out.println("Fallo la conexion. Revisa los datos en application.dat");
            System.out.println("Verifica que MySQL esté encendido y que el usuario/clave sean correctos.");
        }


    }// CIERRE VOID MAIN



    //METODO PRUEBA DE CONEXIÓN

    public static void probarConexionReal(Connection conn) {
        String sql = "SELECT COUNT(*) AS total FROM productos";

        try (java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                int total = rs.getInt("total");
                System.out.println(">>> PRUEBA EXITOSA: Hay " + total + " productos en la base de datos.");
            }
        } catch (java.sql.SQLException e) {
            System.out.println(">>> ERROR DE PRUEBA: Conectado pero no puedo leer la tabla: " + e.getMessage());
        }
    }//FIN METODO PRUEBA DE CONEXION

    //METODO PARA EL MENU

    public static void mostrarMenu(Scanner input) {
        System.out.println("\n MENÚ PRINCIPAL ");
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
            System.out.print("Opción no válida. Ingrese 1-8: ");
            entrada = input.nextLine().trim();
        }

        return Integer.parseInt(entrada);
    }


}//CIERRE INVENTARIO
