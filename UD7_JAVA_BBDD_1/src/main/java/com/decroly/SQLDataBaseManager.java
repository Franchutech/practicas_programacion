package com.decroly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataBaseManager {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection(String url, String usuario, String clave){
        Connection connection = null;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión establecida correctamente");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encuentra el driver. Revisa el pom.xml");
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }
        return connection;
    }

}//CIERRE SQLDBManager class
