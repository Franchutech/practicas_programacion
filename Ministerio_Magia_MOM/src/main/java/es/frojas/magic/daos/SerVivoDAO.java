package es.frojas.magic.daos;

import es.frojas.magic.dbconfg.SQLDataBaseManager;
import es.frojas.magic.enums.Casas;
import es.frojas.magic.enums.Nacionalidades;
import es.frojas.magic.models.Mago;
import es.frojas.magic.models.Muggle;
import es.frojas.magic.models.Criatura;
import es.frojas.magic.models.SerVivo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SerVivoDAO {




    public int insertarMago (Mago m, int idCasa) {
        int response = -1;

        String sql = "INSERT INTO ser_vivo (nombre_ser_vivo, nacionalidad_ser_vivo, tipo_ser_vivo, " +
                     "id_casa, patronus, nivel_magico, es_mortifago) " +
                     " VALUES (?, ?, 'MAGO', ?, ?, ?, ?)";

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
            System.out.println("Error al insertar mago" +  e.getMessage());
        }
    return response;
    }//CIERRE INSERTAR MAGO


    //INICIO INSERTAR MUGGLE
    public int insertarMuggle (Muggle m) {
        int response = -1;

        String sql = "INSERT INTO ser_vivo (nombre_ser_vivo, nacionalidad_ser_vivo," +
                " tipo_ser_vivo, conoce_mundo_magico, profesion)" +
                " VALUES (?, ?, 'MUGGLE', ?, ?)";

        try (Connection connection =SQLDataBaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, m.getNombreSerVivo());
            statement.setString(2, m.getNacionalidadSerVivo().name());
            statement.setBoolean(3, m.isConoceMundoMagico());
            statement.setString(4, m.getProfesion());

            response = statement.executeUpdate();

        }catch (Exception e){
            System.out.println("Error al insertar muggle" + e.getMessage());
        }
        return response;

    }//CIERRA INSERTAR MUGGLE

    //INICIO INSERTAR CRIATURA

    public int insertarCriatura (Criatura c) {
        int response = -1;

        String sql = "INSERT INTO ser_vivo (nombre_ser_vivo, nacionalidad_ser_vivo," +
                " tipo_ser_vivo, nivel_peligrosidad, es_domesticable) " +
                " VALUES (?, ?, 'CRIATURA', ?, ?)";

        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, c.getNombreSerVivo());
            statement.setString(2, c.getNacionalidadSerVivo().name());
            statement.setInt(3, c.getNivelPeligrosidad());
            statement.setBoolean(4, c.isEsDomesticable());

            response = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar criatura" + e.getMessage());
        }
        return response;
    }//CIERRA INSERTAR CRIATURA

//VER CENSO COMPLETO SENTENCIA SQL

    public List<SerVivo> obtenerCensoCompleto(){
        List<SerVivo> lista = new  LinkedList<>();
        String sql = "SELECT * FROM ser_vivo";

        try (Connection connection = SQLDataBaseManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet dataset = statement.executeQuery(sql);
            ){
            while(dataset.next()) {
                String tipo = dataset.getString("tipo_ser_vivo");

                int id = dataset.getInt("id_ser_vivo");
                String nombre = dataset.getString("nombre_ser_vivo");
                Nacionalidades nac = Nacionalidades.valueOf(dataset.getString("nacionalidad_ser_vivo"));

                if(tipo.equals("MAGO")){
                    String patronus = dataset.getString("patronus");
                    int nivelMagico = dataset.getInt("nivel_peligrosidad");
                    boolean esMortifago = dataset.getBoolean("es_mortifago");

                    int idCasaBD = dataset.getInt("id_casa");
                    Casas casaEnum =  null;

                    if (idCasaBD == 1) casaEnum = Casas.GRYFFINDOR;
                    else if (idCasaBD == 2) casaEnum = Casas.SLYTHERIN;
                    else if (idCasaBD == 3) casaEnum = Casas.HUFFLEPUFF;
                    else if (idCasaBD == 4) casaEnum = Casas.RAVENCLAW;

                    lista.add(new Mago(id, nombre, nac, casaEnum, patronus, nivelMagico, esMortifago));

                }else if(tipo.equals("MUGGLE")){
                    String profesion =  dataset.getString("profesion");
                    boolean conoceMagia = dataset.getBoolean("conoce_mundo_magico");

                    lista.add(new Muggle(id, nombre, nac, profesion, conoceMagia));

                }else if(tipo.equals("CRIATURA")){
                    int nivelPeligrosidad  = dataset.getInt("nivel_peligrosidad");
                    boolean esDomesticable = dataset.getBoolean("es_domesticable");

                    lista.add(new Criatura(id, nombre, nac, nivelPeligrosidad, esDomesticable));
                }
            }

        }catch (Exception e){
            System.out.println("Error al obtenerCensoCompleto" + e.getMessage());
        }
    return lista;

    }//CIERRE VER CENSO COMPLETO


    //SENTENCIA BUSCAR POR NOMBRE
    public List<SerVivo> buscarPorNombre(String nombreBusqueda){
        List<SerVivo> resultados = new  LinkedList<>();
        String sql = "SELECT * FROM ser_vivo WHERE nombre_ser_vivo LIKE ?";

        try (Connection connection = SQLDataBaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            //hago el filtro
            statement.setString(1,"%" + nombreBusqueda + "%");
            try (ResultSet dataSet = statement.executeQuery()){
                while(dataSet.next()) {
                    String tipo = dataSet.getString("tipo_ser_vivo");
                    int id = dataSet.getInt("id_ser_vivo");
                    String nombre = dataSet.getString("nombre_ser_vivo");
                    Nacionalidades nac = Nacionalidades.valueOf(dataSet.getString("nacionalidad_ser_vivo"));

                    if (tipo.equals("MAGO")) {
                        String patronus = dataSet.getString("patronus");
                        int nivelMagico = dataSet.getInt("nivel_magico");
                        boolean esMortifago = dataSet.getBoolean("es_mortifago");

                        // Tratamiento de la Casa (ID a Enum)
                        int idCasaBD = dataSet.getInt("id_casa");
                        Casas casaEnum = null;
                        if (idCasaBD == 1) casaEnum = Casas.GRYFFINDOR;
                        else if (idCasaBD == 2) casaEnum = Casas.SLYTHERIN;
                        else if (idCasaBD == 3) casaEnum = Casas.HUFFLEPUFF;
                        else if (idCasaBD == 4) casaEnum = Casas.RAVENCLAW;

                        resultados.add(new Mago(id, nombre, nac, casaEnum, patronus, nivelMagico, esMortifago));

                    } else if (tipo.equals("MUGGLE")) {
                        String profesion = dataSet.getString("profesion");
                        boolean conoceMagia = dataSet.getBoolean("conoce_mundo_magico");

                        resultados.add(new Muggle(id, nombre, nac, profesion, conoceMagia));

                    } else if (tipo.equals("CRIATURA")) {
                        int nivelPeligrosidad = dataSet.getInt("nivel_peligrosidad");
                        boolean esDomesticable = dataSet.getBoolean("es_domesticable");

                        resultados.add(new Criatura(id, nombre, nac, nivelPeligrosidad, esDomesticable));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar por nombre: " + e.getMessage());
        }
        return resultados;
    }//CIERRE SENTENCIA BUSCAR POR NOMBRE


    //BUSCAR POR TIPO (MAGO, MUGGLE o CRIATURA)
    public List<SerVivo> buscarPorTipo(String tipoBusqueda) {
        List<SerVivo> lista = new LinkedList<>();
        String sql = "SELECT * FROM ser_vivo WHERE tipo_ser_vivo = ?";

        try (Connection connection = SQLDataBaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tipoBusqueda.toUpperCase());

            try (ResultSet dataset = statement.executeQuery()) {
                while (dataset.next()) {
                    String tipo = dataset.getString("tipo_ser_vivo");
                    int id = dataset.getInt("id_ser_vivo");
                    String nombre = dataset.getString("nombre_ser_vivo");
                    Nacionalidades nac = Nacionalidades.valueOf(dataset.getString("nacionalidad_ser_vivo"));

                    if (tipo.equals("MAGO")) {
                        String patronus = dataset.getString("patronus");
                        int nivelMagico = dataset.getInt("nivel_magico");
                        boolean esMortifago = dataset.getBoolean("es_mortifago");

                        int idCasaBD = dataset.getInt("id_casa");
                        Casas casaEnum = null;
                        if (idCasaBD == 1) casaEnum = Casas.GRYFFINDOR;
                        else if (idCasaBD == 2) casaEnum = Casas.SLYTHERIN;
                        else if (idCasaBD == 3) casaEnum = Casas.HUFFLEPUFF;
                        else if (idCasaBD == 4) casaEnum = Casas.RAVENCLAW;

                        lista.add(new Mago(id, nombre, nac, casaEnum, patronus, nivelMagico, esMortifago));

                    } else if (tipo.equals("MUGGLE")) {
                        String profesion = dataset.getString("profesion");
                        boolean conoceMagia = dataset.getBoolean("conoce_mundo_magico");

                        lista.add(new Muggle(id, nombre, nac, profesion, conoceMagia));

                    } else if (tipo.equals("CRIATURA")) {
                        int nivelPeli = dataset.getInt("nivel_peligrosidad");
                        boolean esDomestico = dataset.getBoolean("es_domesticable");

                        lista.add(new Criatura(id, nombre, nac, nivelPeli, esDomestico));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar por tipo: " + e.getMessage());
        }
        return lista;

    } // CIERRE BUSCAR POR TIPO


    //BUSCAR POR ID ÚNICO
    public SerVivo buscarPorId(int idBusqueda) {
        SerVivo sv = null;
        String sql = "SELECT * FROM ser_vivo WHERE id_ser_vivo = ?";

        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idBusqueda);

            try (ResultSet dataset = statement.executeQuery()) {
                if (dataset.next()) { // Uso IF en vez de WHILE porque solo hay uno
                    String tipo = dataset.getString("tipo_ser_vivo");
                    int id = dataset.getInt("id_ser_vivo");
                    String nombre = dataset.getString("nombre_ser_vivo");
                    Nacionalidades nac = Nacionalidades.valueOf(dataset.getString("nacionalidad_ser_vivo"));

                    if (tipo.equals("MAGO")) {
                        String patronus = dataset.getString("patronus");
                        int nivelMagico = dataset.getInt("nivel_magico");
                        boolean esMortifago = dataset.getBoolean("es_mortifago");

                        int idCasaBD = dataset.getInt("id_casa");
                        Casas casaEnum = null;
                        if (idCasaBD == 1) casaEnum = Casas.GRYFFINDOR;
                        else if (idCasaBD == 2) casaEnum = Casas.SLYTHERIN;
                        else if (idCasaBD == 3) casaEnum = Casas.HUFFLEPUFF;
                        else if (idCasaBD == 4) casaEnum = Casas.RAVENCLAW;

                        sv = new Mago(id, nombre, nac, casaEnum, patronus, nivelMagico, esMortifago);

                    } else if (tipo.equals("MUGGLE")) {
                        String profesion = dataset.getString("profesion");
                        boolean conoceMagia = dataset.getBoolean("conoce_mundo_magico");

                        sv = new Muggle(id, nombre, nac, profesion, conoceMagia);

                    } else if (tipo.equals("CRIATURA")) {
                        int nivelPeli = dataset.getInt("nivel_peligrosidad");
                        boolean esDomestico = dataset.getBoolean("es_domesticable");

                        sv = new Criatura(id, nombre, nac, nivelPeli, esDomestico);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar por ID: " + e.getMessage());
        }
        return sv; //si no se encuentra devuelvo un null

    } // CIERRE BUSCAR POR ID

// EXPULSAR SER VIVO POR ID (ELIMINAR)
public int eliminarSerVivo(int id) {
    int response = -1;
    String sql = "DELETE FROM ser_vivo WHERE id_ser_vivo = ?";

    try (Connection connection = SQLDataBaseManager.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        // executeUpdate me devuelve el número de filas borradas (1 si existía, 0 si no)
        response = statement.executeUpdate();

    } catch (Exception e) {
        System.out.println("Error al expulsar ser vivo: " + e.getMessage());
    }

    return response;
} // CIERRE ELIMINAR SER VIVO

    //ACTUALIZAR DATOS BÁSICOS (Nombre y Nacionalidad)
    public int actualizarDatosBasicos(int id, String nuevoNombre, String nuevaNac) {
        int response = -1;
        // Uso el ID como la "referencia" única para saber a quién actualizar
        String sql = "UPDATE ser_vivo SET nombre_ser_vivo = ?, nacionalidad_ser_vivo = ? WHERE id_ser_vivo = ?";

        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nuevoNombre);
            statement.setString(2, nuevaNac);
            statement.setInt(3, id);

            response = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al actualizar datos básicos: " + e.getMessage());
        }
        return response;
    } //CIERRE ACTUALIZAR SER VIVO


}//CIERRE CLASE SERVIVO DAO
