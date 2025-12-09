import java.time.LocalDate;
import java.time.LocalDateTime;

public class VideoDaw {

    // ATRIBUTOS
    private String CIF;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula[] peliculasRegistradas;
    private Cliente[] clientesRegistrados;

    private int contadorPeliculas = 0;
    private int contadorClientes = 0;

    // CONSTRUCTOR
    public VideoDaw(String CIF, String direccion, LocalDate fechaAlta) {
        this.CIF = CIF;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;

        this.peliculasRegistradas = new Pelicula[100];
        this.clientesRegistrados = new Cliente[100];
    }

    // GETTERS
    public String getCIF() { return CIF; }
    public String getDireccion() { return direccion; }
    public LocalDate getFechaAlta() { return fechaAlta; }
    public Pelicula[] getPeliculasRegistradas() { return peliculasRegistradas; }
    public Cliente[] getClientesRegistrados() { return clientesRegistrados; }

    // SETTERS
    public void setDireccion(String direccion) { this.direccion = direccion; }

    // VALIDAR FORMATO CIF
    public static boolean validarCIF(String CIF) {
        return CIF.matches("[A-Za-z]{1}[0-9]{8}");
    }

    // MOSTRAR INFO DEL VIDEOCLUB
    public String mostrarInfoVideoClub() {
        String info = "";
        info += "CIF: " + CIF + "\n";
        info += "Direccion: " + direccion + "\n";
        info += "FechaAlta: " + fechaAlta + "\n";
        info += "Total Peliculas Registradas: " + contadorPeliculas + "\n";
        info += "Total Clientes Registrados: " + contadorClientes + "\n";
        return info;
    }

    // MOSTRAR PELÍCULAS REGISTRADAS
    public String mostrarPeliculasRegistradas() {
        String listado = "PELÍCULAS REGISTRADAS:\n";
        for (Pelicula p : peliculasRegistradas) {
            if (p != null) {
                listado += p.getCod() + " - " + p.getTitulo() + "\n";
            }
        }
        return listado;
    }

    // MOSTRAR CLIENTES REGISTRADOS
    public String mostrarClientesRegistrados() {
        String listado = "CLIENTES REGISTRADOS:\n";
        for (Cliente c : clientesRegistrados) {
            if (c != null) {
                listado += c.getNumSocio() + " - " + c.getNombre() + "\n";
            }
        }
        return listado;
    }

    // REGISTRAR CLIENTE (evitar repetidos)
    public boolean registrarCliente(Cliente c) {

        // comprobar duplicado por DNI
        for (Cliente cli : clientesRegistrados) {
            if (cli != null && cli.getDNI().equals(c.getDNI())) {
                return false; // ya existe
            }
        }

        clientesRegistrados[contadorClientes] = c;
        contadorClientes++;
        return true;
    }

    // DAR DE BAJA CLIENTE
    public boolean darBajaCliente(String dni) {
        for (int i = 0; i < clientesRegistrados.length; i++) {
            Cliente c = clientesRegistrados[i];
            if (c != null && c.getDNI().equals(dni)) {
                clientesRegistrados[i].setFechaBaja(LocalDate.now());
                return true;
            }
        }
        return false;
    }

    // REGISTRAR PELÍCULA
    public boolean registrarPelicula(Pelicula p) {

        // evitar repetida por código
        for (Pelicula peli : peliculasRegistradas) {
            if (peli != null && peli.getCod().equals(p.getCod())) {
                return false;
            }
        }

        peliculasRegistradas[contadorPeliculas] = p;
        contadorPeliculas++;
        return true;
    }

    // DAR DE BAJA PELÍCULA
    public boolean darBajaPelicula(String cod) {
        for (int i = 0; i < peliculasRegistradas.length; i++) {
            Pelicula p = peliculasRegistradas[i];
            if (p != null && p.getCod().equals(cod)) {
                peliculasRegistradas[i].setFechaBaja(LocalDate.now());
                return true;
            }
        }
        return false;
    }

    // ALQUILAR PELÍCULA
    public boolean alquilarPelicula(Pelicula p, Cliente c) {

        if (p.isAlquilada()) return false; // ya está alquilada

        p.setAlquilada(true);
        c.addPeliculaAlquilada(p);

        return true;
    }

    // DEVOLVER PELÍCULA
    public boolean devolverPelicula(Pelicula p, Cliente c) {

        if (!p.isAlquilada()) return false; // no está alquilada

        // comprobar 48h
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime alquiler = p.getFechaAlquiler();

        if (alquiler != null &&
                alquiler.plusHours(48).isBefore(ahora)) {
            System.out.println("ATENCIÓN: La película supera las 48 horas de alquiler.");
        }

        p.setAlquilada(false);
        c.removePeliculaAlquilada(p);

        return true;
    }

}
