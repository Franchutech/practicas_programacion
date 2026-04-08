package es.frojas.magic;


import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 🔮 Verificando conexión al Ministerio ---");

        Connection con = SQLDataBaseManager.getConnection();

        if (con != null) {
            System.out.println("🧙🏻¡EXCELENTE NO ERES UN MUGGLE! La base de datos responde.");
        } else {
            System.err.println("🤬MALDITO MUGGLE!!!!: No se pudo conectar. Revisa QUE HICISTE MAL!!!!.");
        }
    }
}