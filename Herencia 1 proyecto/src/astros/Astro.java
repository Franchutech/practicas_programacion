package astros;

/* Clase abstracta base para astros */
public abstract class Astro {

    /* atributos comunes */
    protected double masa;
    protected double diametro;
    protected double rotacion;
    protected double traslacion;
    protected double distancia;
    protected double temperatura;
    protected double gravedad;

    public Astro(double masa, double diametro, double rotacion, double traslacion, double distancia, double temperatura, double gravedad){
        /* inicializa atributos */
        this.masa = masa;
        this.diametro = diametro;
        this.rotacion = rotacion;
        this.traslacion = traslacion;
        this.distancia = distancia;
        this.temperatura = temperatura;
        this.gravedad = gravedad;
    }

    /* metodo abstracto */
    public abstract void mostrar();
}
