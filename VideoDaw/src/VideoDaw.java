import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VideoDaw {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    //atributos
    private int CIF;
    private String direccion;
    private LocalDate fechaAlta;
    private Pregistrada[] pregistradas;
    private Cregistrado[] cregistrados;

    private int contadorPRegistradas =0;
    private int contadorCRegistrados =0;

    //CONSTRUCTOR

    public VideoDaw(DateTimeFormatter dtf, int CIF, String direccion, LocalDate fechaAlta, Pregistrada[] pregistradas,
                    Cregistrado[] cregistrados) {
        this.dtf = dtf;
        this.CIF = CIF;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.pregistradas = new Pregistrada[100];
        this.cregistrados = new Cregistrado[100];
    }
    //GETTERS

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public int getCIF() {
        return CIF;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public Pregistrada[] getPregistradas() {
        return pregistradas;
    }

    public Cregistrado[] getCregistrados() {
        return cregistrados;
    }


    //SETTERS

    public void setCregistrados(Cregistrado[] cregistrados) {
        this.cregistrados = cregistrados;
    }

    public void setPregistradas(Pregistrada[] pregistradas) {
        this.pregistradas = pregistradas;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }




    /*Clase VideoDaw
La clase VideoDaw deberá tener los siguientes atributos:
1. CIF: deberá cumplir que este bien formado.
2. Direccion:
3. FechaAlta: tipo LocalDate
4. PelículasRegistradas (Pelicula []) // revisar a fondo los errores.
5. ClientesRegistrados (Cliente [])
Además de los constructores y propiedades necesarios, deberá tener al menos
• Un método mostrarInfoVideoClub () para mostrar toda la información de general de
este VideoClub.
• Un método para ver sus películas registradas mostrarPeliculasRegistradas().
• Un método para los clientes registrados mostrarClientesRegistrados(): comprobar que
no este repetido en el videoclub
• Un método para alquilar una película alquilarPelicula(Pelicula p, cliente c): comprobar
que esa película no este ya alquilada.
2
MP_0485 - PROGRAMACIÓN
• Un método para devolver una película devolverPelicula(Pelicula p, cliente c):  deberá
comprobar que no haya excedido el tiempo máximo de 48 horas, en caso de excederlo
mostrara un mensaje de advertencia.
• Un método para dar de baja un cliente darBajaCliente(cliente c)
• Un método para dar registrar un cliente registrarCliente(cliente c): comprobar que no
este ya registrado. */


} //principalClass VideoDaw
