package com.decroly;

import java.sql.Connection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Inventario {
    public static void main(String[] args) {
        System.out.println("Iniciando sistema MercaDaw...");

        String url ="";
        String user ="";
        String password ="";

        try (BufferedReader br = new BufferedReader(new FileReader("application.dat"))) {
            url = br.readLine();
            user = br.readLine();
            password = br.readLine();
        }catch (IOException e){
            System.out.println("Error critico: no se pudo leer el archivo de configuracion");
            return; //sino hay datos puedo seguir
        }
        //PRUEBO LA CONECCION A LA OTRA CLASE.
        Connection conn = SQLDataBaseManager.getConnection(url,user,password);
        if (conn !=null) {
            System.out.println("Conexion establecida, puedo trabajar con MercaDaw");
        }else {
            System.out.println("Fallo la conexion. Revisa los datos en application.dat");
            System.out.println("Verifica que MySQL esté encendido y que el usuario/clave sean correctos.");
            }
    }// CIERRE VOID MAIN

}//CIERRE INVENTARIO
