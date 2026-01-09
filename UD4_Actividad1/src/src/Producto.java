

public class Producto implements Comparable<Producto>{
    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }//public Producto

    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    @Override
    public int compareTo(Producto otro) {
        if (otro != null) {
            return this.nombre.compareTo(otro.nombre);
        }
        return 0;
    }

}//class Producto
