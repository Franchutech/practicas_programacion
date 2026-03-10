import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.*;
import java.io.Serializable;
import exceptions.ArticuloYaRegistradoException;
import exceptions.ClienteYaRegistradoException;

public class VideoDaw implements Serializable {
    @Serial
    private static final long serialVersionUID = 1210630457771155714L;


    // ATRIBUTOS
    private String CIF;
    private String direccion;
    private LocalDate fechaAlta;
    private ArrayList<Articulo> articulosRegistrados;//ANUAR RECOMIENDA TRABAJAR ESTO CON MAPA, PARA EVITAR REPETIDOS
    private ArrayList<Cliente> clientesRegistrados;//ANUAR RECOMIENDA TRABAJAR ESTO CON MAPA, PARA EVITAR REPETIDOS


    //CONSTRUCTOR

    public VideoDaw(String CIF, String direccion, LocalDate fechaAlta) {
        this.CIF = CIF;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.articulosRegistrados = new ArrayList<>();
        this.clientesRegistrados = new ArrayList<>();

    }

    // GETTERS

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public ArrayList<Articulo> getArticulosRegistrados() {
        return articulosRegistrados;
    }

    public ArrayList<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    // SETTERS

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    // MOSTRAR INFO DEL VIDEOCLUB

    public String mostrarInfoVideoClub() {
        String info = "";
        info += "CIF: " + CIF + "\n";
        info += "Direccion: " + direccion + "\n";
        info += "FechaAlta: " + fechaAlta + "\n";
        info += "Total Articulos Registrados: " + articulosRegistrados.size() + "\n";
        info += "Total Clientes Registrados: " + clientesRegistrados.size() + "\n";
        return info;
    }

    // MOSTRAR ARTICULOS REGISTRADAS

    public String mostrararticulosRegistrados() {
        String listado = "ARTICULOS REGISTRADOS:\n";
        if (articulosRegistrados.isEmpty()) {
            listado += "No hay articulos registrados\n";
        } else {
            for (Articulo a : articulosRegistrados) {
                listado += a.toString() + "\n";
            }
        }
        return listado;
    }


    // MOSTRAR CLIENTES REGISTRADOS

    public String mostrarClientesRegistrados() {
        String listado = "CLIENTES REGISTRADOS:\n";
        if (clientesRegistrados.isEmpty()) {
            listado += "No hay clientes registrados\n";
        }else  {
            for (Cliente c : clientesRegistrados) {
                listado += "- " + c.getNombre() + " (Socio: " + c.getNumSocio() + ")\n";
            }
        }
        return listado;
    }

    // REGISTRAR CLIENTE +EXCEPCION

    public boolean registrarCliente(Cliente c) throws ClienteYaRegistradoException {
    for (Cliente cli : clientesRegistrados) {
        if (cli.getDNI().equalsIgnoreCase(c.getDNI())) {
            throw new ClienteYaRegistradoException("El cliente con DNI " + c.getDNI() + " ya existe.");
        }
    }
    return clientesRegistrados.add(c);
}

    // DAR DE BAJA CLIENTE
    public boolean darBajaCliente(String dni) {
    for (Cliente c : clientesRegistrados) {
        if (c.getDNI().equalsIgnoreCase(dni)) {
            c.setFechaBaja(LocalDate.now());
            return true;
        }
    }
    return false;
}


    // REGISTRAR ARTICULO

    public boolean registrarArticulo(Articulo a) throws ArticuloYaRegistradoException {
        for (Articulo art : articulosRegistrados) {
            if (art.getCod().equalsIgnoreCase(a.getCod())) {
                throw new ArticuloYaRegistradoException("El artículo con código " + a.getCod() + " ya existe.");
            }
        }
        return articulosRegistrados.add(a);
    }

    // DAR DE BAJA ARTICULO
    public boolean darBajaArticulo(String cod) {
    for (Articulo a : articulosRegistrados) {
        if (a.getCod().equalsIgnoreCase(cod)) {
            a.setFechaBaja(LocalDate.now());
            return true;
        }
    }
    return false;
}

    // ALQUILAR PELÍCULA
    public boolean alquilarArticulo(Articulo a, Cliente c) {
    if (a.isAlquilado()) {
        return false;
    }

    // Marco como alquilado y ponemos la fecha actual
    a.setAlquilado(true);
    a.setFechaAlquiler(LocalDateTime.now());

    // Lo añado la lista del cliente (el método que ya hicimos en Cliente)
    c.addArticuloAlquilado(a);

    return true;
}

    // DEVOLVER ARTICULO
    public boolean devolverArticulo(Articulo a, Cliente c) {

    // COMPRUEBO SI EL ARTICULO ESTA ALQUILADO
    if (!a.isAlquilado()) {
        return false;
    }

    // RESETEAR EL ESTADO DEL ARTICULO AHORA ESTA DISPONIBLE DE NUEVO
    a.setAlquilado(false);
    a.setFechaAlquiler(null);

    // 3. Lo quitO de la lista del cliente
    // Como use ArrayList,
    return c.removeArticuloAlquilado(a);
}

    // MÉTODO PARA GUARDAR TODO EL VIDEOCLUB EN UN ARCHIVO

    public void guardarDatos(String nombreFichero) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            oos.writeObject(this); // Se guarda a sí mismo con todo lo que tiene dentro
        }
    }

// MÉTODO PARA CARGAR DATOS (Este es estático porque crea un objeto nuevo)
    public static VideoDaw cargarDatos(String nombreFichero) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            return (VideoDaw) ois.readObject();
        }
    }

}//CIERRE CLASE VIDEODAW

