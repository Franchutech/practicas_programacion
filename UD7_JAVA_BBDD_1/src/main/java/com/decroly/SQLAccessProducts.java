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


    //INICIO METODO PARA BUSCAR POR CANTIDAD IGUAL O MENOR A LA INTRODUCIDA POR EL USUARIO

    public List<Producto>getProductsbyCantidad(int cantidadMax) {
        List<Producto>listaPorCantidad=new LinkedList<>();

        String sql = "SELECT * FROM productos WHERE cantidad = ?";

        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,cantidadMax);
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
                    listaPorCantidad.add(p);
                }
            }

        }catch (Exception e){
            System.out.println("Error al buscar por cantidad" + e.getMessage());
        }

        return listaPorCantidad;

    }//CIERRE METODO BUSQUEDA POR CANTIDAD


    //CREAR METODO PARA INSERTAR NUEVOS PRODUCTOS

    public int insertarProductos(Producto p) {
        int response = -1;

        String sql = "INSERT INTO productos (referencia, nombre, descripcion," +
                " tipo_id, cantidad, precio, descuento, iva, aplicar_dto)" + "VALUES (?, ?, ?," +
                " ?, ?, ?, ?, ?, ?)";

        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1,p.getReferencia());
            statement.setString(2,p.getNombre());
            statement.setString(3,p.getDescripcion());
            statement.setInt(4,p.getTipoId());
            statement.setInt(5,p.getCantidad());
            statement.setDouble(6,p.getPrecio());
            statement.setDouble(7,p.getDescuento());
            statement.setInt(8,p.getIva());
            statement.setBoolean(9,p.isAplicarDto());

            response=statement.executeUpdate();

        }catch (Exception e){
            System.out.println("Error al insertar producto" + e.getMessage());
        }
    return response;

    }//CIERRE CLASE INSERTAR PRODUCTO


    //METODO PARA ELIMINAR PRODUCTOS POR REFERENCIA

    public int eliminarProductos(Producto p) {
        int filasAfectadas= -1;
        String sql = "DELETE FROM productos WHERE referencia = ?";

        try (Connection connection = SQLDataBaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1,p.getReferencia());
            filasAfectadas=statement.executeUpdate();

        }catch (Exception e){
            System.out.println("Error al eliminar producto" + e.getMessage());
        }

    return filasAfectadas;

    }//CIERRE METODO ELIMINAR PRODUCTOS


    //METODO ACTUALIZAR PRODUCTO

    public int actualizarProductos(String ref, String descr, int cant, double precio,
                                   int desc, boolean aplica  ) {
        int response = -1;
        String sql = "UPDATE productos SET descripcion = ?, cantidad = ?, precio = ?, descuento = ?, boolean = ? WHERE referencia = ? ";

        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1,descr);
            statement.setInt(2,cant);
            statement.setDouble(3,precio);
            statement.setInt(4,desc);
            statement.setBoolean(5,aplica);
            statement.setString(6,ref);

            response=statement.executeUpdate();

        }catch (Exception e){
            System.out.println("Error al actualizar producto" + e.getMessage());
        }
    return response;
    }//CIERRE METODO ACTUALIZAR PRODUCTOS


    //METODO PARA INSERTAR NUEVO TIPO

    public int insertarNuevoTipo(String nombreTipo) {
    int response = -1;
    // SQL simple: el ID se genera solo
    String sql = "INSERT INTO tipos (nombre) VALUES (?)";

    try (Connection connection = SQLDataBaseManager.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, nombreTipo);
        response = statement.executeUpdate();

    } catch (Exception e) {
        System.out.println("Error al insertar tipo: " + e.getMessage());
    }
    return response;
}//CIERRE METODO INSERTAR NUEVO TIPO



}//CIERRE CLASE ACCESS PRODUCTS
