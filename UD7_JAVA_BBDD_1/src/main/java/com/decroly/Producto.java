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
    public Producto(int id, String referencia, String nombre, String descripcion, int tipo_id, int cantidad, double precio, int descuento, int iva, boolean aplicar_dto){
        this.id = id;
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoId = tipo_id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicar_dto;

    }

    //GETTERS

    public int getId() {
        return id;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getTipoId() {
        return tipoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public int getIva() {
        return iva;
    }

    public boolean isAplicarDto() {
        return aplicarDto;
    }

    //SETTERS

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", referencia='" + referencia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipoId=" + tipoId +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", descuento=" + descuento +
                ", iva=" + iva +
                ", aplicarDto=" + aplicarDto +
                '}';
    }
}//CIERRE CLASE PRODUCTO
