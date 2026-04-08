package es.frojas.magic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;

public class SQLDataBaseManager {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static String URL;
    private static String SCHEMA;
    private static String USER;
    private static String PASSWORD;

    //METODO LECTURA.DAT
    private static void lecturaDat() {
        String ruta = "src/main/resources/magic_application.dat";

        try (java.io.BufferedReader br= new BufferedReader
                (new java.io.FileReader("src/main/resources/magic_application.dat"))){
            URL = br.readLine();
            SCHEMA = br.readLine();
            USER = br.readLine();
            PASSWORD = br.readLine();

            System.out.println("Se ha leído toda la información de:" + SCHEMA);

        }catch(IOException e){
            System.err.println("Error en lectura de los datos .DAT" + e.getMessage());
            e.printStackTrace();
        }

    }//CIERRE METODO LECTURA.DAT


    public static Connection getConnection(){
        if (URL == null || SCHEMA == null || USER == null || PASSWORD == null){
            lecturaDat();
        }

        Connection connection = null;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL+SCHEMA,USER,PASSWORD);
            System.out.println("Conexión establecida correctamente");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encuentra el driver. Revisa el pom.xml");
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }
        return connection;
    }


}
