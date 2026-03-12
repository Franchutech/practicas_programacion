package com.decroly;

public class Producto {
    private int id;
    private String referencia;
    private String nombre;
    private String descripcion;
    private int tipoId;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicarDto;

    // Constructor vacío (necesario para JDBC a veces)
    public Producto(){

    }
}//CIERRE CLASE PRODUCTO
