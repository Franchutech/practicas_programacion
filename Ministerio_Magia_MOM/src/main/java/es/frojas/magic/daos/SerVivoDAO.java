package es.frojas.magic.daos;

import es.frojas.magic.dbconfg.SQLDataBaseManager;
import es.frojas.magic.enums.Nacionalidades;
import es.frojas.magic.models.Mago;
import es.frojas.magic.models.SerVivo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SerVivoDAO {


    public int insertarMago (Mago m, int idCasa) {
        int response = -1;

        String sql = """
             INSERT INTO ser_vivo (nombre_ser_vivo, nacionalidad_ser_vivo, tipo_ser_vivo, 
                                 id_casa, patronus, nivel_magico, es_mortifago) 
            VALUES (?, ?, 'MAGO', ?, ?, ?, ?
            """;

    try (Connection connection = SQLDataBaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ){
        statement.setString(1, m.getNombreSerVivo());
        statement.setString(2, m.getNacionalidadSerVivo().name());

        statement.setInt(3, idCasa);
        statement.setString(4, m.getpatronus());
        statement.setInt(5, m.getNivelMagico());
        statement.setBoolean(6, m.isEsMortifago());

        response = statement.executeUpdate();


        }catch (Exception e){
            System.out.println("Error al insertar mago");
        }
    return response;
    }

}//CIERRE CLASE SERVIVO DAO
