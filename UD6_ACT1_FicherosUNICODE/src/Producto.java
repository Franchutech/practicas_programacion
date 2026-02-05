


public class Producto {

    //PROPIEDADES-ATRIBUTOS

    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    //CONSTRUCTOR

    public Producto(String codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }//CONSTRUCTOR

    //GETTERS

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    //SETTERS

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }//SETTER EXCEPTION CODIGO

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//SETTER EXCEPTION NOMBRE

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }//SETTER EXCEPTION CANTIDAD

    public void setPrecio(double precio) {
        this.precio = precio;
    }//SETTER EXCEPTION PRECIOO


    //TO STRING GENERADO AUTOMATICAMENTE

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }


    //VER LO DE PONER METODOS, EN LUGAR DE EXCEPCIONES


}//MAIN PRODUCTO
