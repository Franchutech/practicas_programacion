import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Cliente {

    //ATRIBUTOS
    private String DNI;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula [] peliculasAlquiladas;

    public static int contadorPeliculasAlquiladas = 0;

    //CONSTRUCTOR
    public Cliente(String DNI, String nombre, String numSocio, String direccion, LocalDate fechaNacimiento,
                   LocalDate fechaBaja, Pelicula[] peliculasAlquiladas) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.numSocio = numSocio;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaBaja = fechaBaja;
        this.peliculasAlquiladas = peliculasAlquiladas;
    }

    //GETTERS

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumSocio() {
        return numSocio;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public Pelicula[] getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    public static int getContadorPeliculasAlquiladas() {
        return contadorPeliculasAlquiladas;
    }


    //SETTER

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPeliculasAlquiladas(Pelicula[] peliculasAlquiladas) {
        this.peliculasAlquiladas = peliculasAlquiladas;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void setNumSocio(String numSocio) {
        this.numSocio = numSocio;
    }


    //METODOS

    public String mostrarinfoCliente(){
        String mostrarinfoCliente = "";
        mostrarinfoCliente += "DNI: " + this.DNI + "\n";
        mostrarinfoCliente += "Nombre: " + this.nombre + "\n";
        mostrarinfoCliente += "NumSocio: " + this.numSocio + "\n";
        mostrarinfoCliente += "Direccion: " + this.direccion + "\n";
        mostrarinfoCliente += "FechaBaja: " + this.fechaBaja + "\n";
        return mostrarinfoCliente;
    }

    //RESTRICCION DEL DNI, EN GESTIONVIDEODAW  (Que es donde se pide sus datos por  medio del Scanner)

    //RESTRINGIR POSIBILIDADES PARA EL NOMBRE (no lo pide el ejercicio, pero ya lo tenia yo hecho de otro)
    public boolean validacionNombre(String nombre) {
        if (nombre == null) return false;
        nombre = nombre.trim(); //valido el espacio del nombre quitando espacios en blanco de los bordes
        //2.debe tener cierta longitud para que realmente sea un nombre
        if (nombre.length() == 0) return false;
        //3.debe tener menos de 50 caracteres
        if (nombre.length() > 50) return false;
        //4. titular deberia tener espacios entre nombre y apellido
        if (!nombre.contains(" ")) return false;
        //5.Deberia tener minimo un nombre unos 5 caracteres
        if (nombre.length() < 3) return false;
        return true;

    }//VALIDAR NOMBRE DEL CLIENTE


    //CREAR METODO PARA RESTRINGIR FORMATO DE NUMSOCIO, con formato S-0001, tengo que revisar si esto va aqui
     //o si deberia ir en GestionVideoDaw

    String numSocioComprobado = MiUtils.comprobarPatronRepetidamente("[a-zA-Z]{1}[-]{1}[0-9]{4}",
            "Introduzca un numero de socio");


    //CREAR METODO PARA RESTRINGIR MINIMO DE EDAD DEL CLIENTE


    //aqui tendria que comparar 2 fecha de nacimiento con la local date now.//31557600(segundos mayot de edad)
    //PASAR A EPOCH LAS FECHAS
    public boolean minimoEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) return false;
        // Segundos que equivalen a 18 años
        long SEGUNDOS_18_ANIOS = 31557600L * 18;
        // Zona horaria del sistema
        ZoneId zoneId = ZoneId.systemDefault();
        // Pasar la fecha de nacimiento a epoch seconds (a medianoche)
        long nacimientoEpoch = fechaNacimiento.atStartOfDay(zoneId).toEpochSecond();
        // Epoch seconds actuales
        long ahoraEpoch = LocalDateTime.now().atZone(zoneId).toEpochSecond();
        // Diferencia entre ambas fechas
        long diferencia = ahoraEpoch - nacimientoEpoch;
        return diferencia >= SEGUNDOS_18_ANIOS;
    }
    //CREAR METODO PARA VER SUS ULTIMAS PELICULAS ALQUILADAS, mostrarPeliculasAlquiladas()




    /*Clase Cliente
La clase Cliente deberá tener los siguientes atributos:
1. DNI: deberá cumplir que este bien formado.
2. Nombre:
3. NumSocio: código único (ej. S-0001);
4. Direccion:
5. FechaNacimiento: es del tipo LocalDate (debe de ser mayor de edad)
6. FechaBaja: es del tipo LocalDate
7. PeliculasAlquiladas (Pelicula [])
Además de los constructores y propiedades necesarios, deberá tener al menos un método
mostrarInfoCilente() para mostrar toda la información de general de ese cliente, un método
para ver sus últimas películas alquiladas mostrarPeliculasAlquiladas().*/



} //MAIN CLASE CLIENTE
