package es.frojas.jfx.apppersonasfx.model;

import es.frojas.jfx.apppersonasfx.configuration.SQLDataBaseManager;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SQLAccessPersona {

    public static List<Persona> getAllPersonas(){
        List<Persona> personas = new LinkedList<>();

        //SETENCIA SQL
        String sqlpersonas = "SELECT * FROM personas";

        try(Connection conexion = SQLDataBaseManager.getConnection();
            Statement statement = conexion.createStatement();
            ResultSet resultSets = statement.executeQuery(sqlpersonas)) {


            while (resultSets.next()){
                String dni = resultSets.getNString(1);
                String name = resultSets.getNString(2);
                String surname = resultSets.getNString(3);
                String email = resultSets.getNString(4);
                int age = resultSets.getInt(5);
                String phone = resultSets.getNString(6);

                //USO DEL BUILDER
                Persona p = Persona.builder()
                        .dni(dni)
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .age(age)
                        .phone(phone)
                        .build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return personas;

    }//CIERRE LIST PERSONA GET ALL PERSONAS METODO

    public static Persona getPersonaByDni(String dni) {
        Persona p = null;
        String sqlpersonas = "SELECT * FROM personas WHERE dni=?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlpersonas)){
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String dniDB = resultSet.getNString(1);
                String name = resultSet.getNString(2);
                String surname = resultSet.getNString(3);
                String email = resultSet.getNString(4);
                int age = resultSet.getInt(5);
                String phone = resultSet.getNString(6);

                //USO DEL BUILDER
                Persona pDB = Persona.builder()
                        .dni(dniDB)
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .age(age)
                        .phone(phone)
                        .build();
            }

    }catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return p;
    }

    public static Persona getPersonaByEmail(String email){
        Persona p = null;
        String sqlpersonas = "SELECT * FROM personas WHERE email=?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlpersonas)){
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String dniDB = resultSet.getNString(1);
                String name = resultSet.getNString(2);
                String surname = resultSet.getNString(3);
                String emailDB = resultSet.getNString(4);
                int age = resultSet.getInt(5);
                String phone = resultSet.getNString(6);

                //USO DEL BUILDER
                Persona pDB = Persona.builder()
                        .dni(dniDB)
                        .name(name)
                        .surname(surname)
                        .email(emailDB)
                        .age(age)
                        .phone(phone)
                        .build();
            }

    }catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return p;
    }

    public boolean createPersona(Persona persona){
        boolean result=false;

        String sqlInsertpersonas = "INSERT INTO perso (dni, name, surname, email, age, phone) VALUES (?,?,?,?,?,?)";


        try(Connection connection = SQLDataBaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlInsertpersonas)){
            statement.setString(1, persona.getDni());
            statement.setString(2, persona.getName());
            statement.setString(3, persona.getSurname());
            statement.setString(4, persona.getEmail());
            statement.setInt(5, persona.getAge());
            statement.setString(6, persona.getPhone());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public boolean updatePersona(Persona persona){
        boolean result=false;
        String sqlUpdatePersona = "UPDATE person SET name = ?, surname = ?, " +
                "email = ?, age = ?, phone = ? WHERE dni = ?";

        try(Connection connection = SQLDataBaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlUpdatePersona)){
            statement.setString(2, persona.getName());
            statement.setString(3, persona.getSurname());
            statement.setString(4, persona.getEmail());
            statement.setInt(5, persona.getAge());
            statement.setString(6, persona.getPhone());

            //para el where
            statement.setString(1, persona.getDni());

        }catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

        return result;
    }
    public boolean deletePersonaByDNI(String dni){
        boolean result=false;
        String sqlDeletepersonas = "DELETE FROM personas WHERE dni=?";

        try(Connection connection = SQLDataBaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlDeletepersonas)){
            statement.setString(1,dni);
            statement.execute();
            result=true;

        }catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return false;
    }


}//CIERRE ACCESS PERSONA
