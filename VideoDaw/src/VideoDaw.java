import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VideoDaw {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    //atributos
    private int CIF;
    private String direccion;
    private LocalDate fechaAlta;







    /*Clase VideoDaw
La clase VideoDaw deberá tener los siguientes atributos:
1. CIF: deberá cumplir que este bien formado.
2. Direccion:
3. FechaAlta: tipo LocalDate
4. PelículasRegistradas (Pelicula [])
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
