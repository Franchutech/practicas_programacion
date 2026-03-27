package es.fRojas.got;

import java.sql.Connection;

public class CiudadelaApp {
    public static void main(String[] args) {
        System.out.println("Probando conexión de la Ciudadela");

        // Llamamos al método que tú programaste
        Connection con = SQLDataBaseManager.getConnection();

        if (con != null) {
            System.out.println("¡CONEXIÓN EXITOSA! El Maestre ha accedido a la base de datos.");
        } else {
            System.err.println("ERROR: No se pudo establecer la conexión.");
            System.err.println("Revisa que el archivo .dat esté en la ruta correcta y que MySQL esté encendido.");
        }
    }
}