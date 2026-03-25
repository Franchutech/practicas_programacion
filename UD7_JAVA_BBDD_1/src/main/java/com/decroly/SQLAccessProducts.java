package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SQLAccessProducts {

    public List<Producto>getProducto(){

        List<Producto>listaProductos=new LinkedList<>();


        //SENTENCIA SQL

        String getnombreProductos = "SELECT * FROM productos";

        try (Connection connection = SQLDataBaseManager.getConnection();
             Statement statement = connection.createStatement();
        ResultSet dataset = statement.executeQuery(getnombreProductos);){
            while (dataset.next()){
                int id = dataset.getInt("id");
                String referencia = dataset.getString("referencia");
                String nombre = dataset.getString("nombre");
                String descripcion = dataset.getString("descripcion");
                int tipo_id = dataset.getInt("tipo_id");
                int cantidad = dataset.getInt("cantidad");
                double precio = dataset.getDouble("precio");
                int descuento = dataset.getInt("descuento");
                int iva = dataset.getInt("iva");
                boolean aplicar_dto = dataset.getBoolean("aplicar_dto");


                Producto p = new Producto(id, referencia, nombre, descripcion, tipo_id,
                        cantidad, precio, descuento, iva, aplicar_dto);
                System.out.println(p);
                listaProductos.add(p);

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listaProductos;

    }//CIERRE METODO LISTA DE PRODUCTOS


    //CREO METODO PARA LLAMAR POR REFERENCIA

    public Producto getProductsbyreference(String referencia) {
        Producto p = null;

        String sql = "SELECT * FROM productos WHERE referencia = ?";

        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1,referencia);
            try (ResultSet dataset = statement.executeQuery()){
                while (dataset.next()){
                    p = new Producto(
                            dataset.getInt("id"),
                            dataset.getString("referencia"),
                            dataset.getString("nombre"),
                            dataset.getString("descripcion"),
                            dataset.getInt("tipo_id"),
                            dataset.getInt("cantidad"),
                            dataset.getDouble("precio"),
                            dataset.getInt("descuento"),
                            dataset.getInt("iva"),
                            dataset.getBoolean("aplicar_dto")
                    );
                }
            }

        }catch (Exception e){
            System.out.println("Error al buscar por referencia" + e.getMessage());
        }
        return p;

    }//CIERRE METODO GET PRODUCTOS BY REFERENCE

    //CREO METODO PARA LLAMAR POR TIPO

    public List<Producto> getProductsbyTipo(int tipo_id) {
        List<Producto>listaPorTipo=new LinkedList<>();

        String sql = "SELECT * FROM productos WHERE tipo_id = ?";

        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,tipo_id);
            try (ResultSet dataset = statement.executeQuery()){
                while (dataset.next()){
                    Producto p = new Producto(
                            dataset.getInt("id"),
                            dataset.getString("referencia"),
                            dataset.getString("nombre"),
                            dataset.getString("descripcion"),
                            dataset.getInt("tipo_id"),
                            dataset.getInt("cantidad"),
                            dataset.getDouble("precio"),
                            dataset.getInt("descuento"),
                            dataset.getInt("iva"),
                            dataset.getBoolean("aplicar_dto")
                    );
                    listaPorTipo.add(p);
                }
            }

        }catch (Exception e){
            System.out.println("Error al buscar por tipo" + e.getMessage());
        }
        return listaPorTipo;
    }//CIERRE METODO OBTENER PRODUCTOS POR TIPO

}//CIERRE CLASE ACCESS PRODUCTS
