import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;


public class Academia implements Serializable {

    @Serial
    private static final long serialVersionUID = -1740119966371832974L;

    //DEFINO LAS RUTAS POR TEMAS DE ORDEN:
    private static final String PATH = ".\\src\\resources\\";
    private static final String FILE_CSV = "PersonasBBDD.csv";
    private static final String FILE_DAT = "academia.dat";


    //ATRIBUTOS

    private String nombre;
    private String CIF;
    private LocalDate fechaFundacion;
    private ArrayList<Equipo> listaEquipo;
    private ArrayList<Persona> listaPersonas;

    //CONSTRUCTOR

    public Academia(String nombre, String CIF, LocalDate fechaFundacion) {
        this.nombre = nombre;
        setCIF(CIF);
        this.fechaFundacion = fechaFundacion;
        this.listaEquipo = new ArrayList<>();
        this.listaPersonas = new ArrayList<>();
    }

    //GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getCIF() {
        return CIF;

    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public ArrayList<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    //SETTERS


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCIF(String CIF) {
        if (CIF != null && CIF.matches("^[A-Z][0-9]{8}$")) {
            this.CIF = CIF;
        } else {
            this.CIF = "INVALIDO";
            System.out.println("Error: El CIF debe tener 1 letra y 8 números.");
        }
    }


    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public void setListaEquipo(ArrayList<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }


    //TO STRING

    @Override
    public String toString() {
        return "Academia{" +
                "nombre='" + nombre + '\'' +
                ", CIF='" + CIF + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                ", listaEquipo=" + listaEquipo +
                '}';
    }

    //METODO CARGAR DATOS CSV

    //AQUI INTENTO ABRIR EL ARCHIVO CON LA RUTA QUE ESTABLECI PREVIAMENTE

    private void cargarDatosCSV () {

        try(FileReader fr = new FileReader(PATH + FILE_CSV);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            while ((linea = br.readLine()) != null){
                if (!linea.trim().isEmpty()){  //si la linea no està vacia entonces....

                    //TROCEO EL CSV EN PARTES POR CADA PUNTO Y COMA
                    String[] partes = linea.split(";");

                    //aqui convierto cada "parte" en una variable del tipo que tengo en la clase producto.

                    String nombre = partes[0].trim();
                    String dni = partes[1].trim();


                    //y ahora si que lo tengo en partes y "definido en tipos de variables" pues ya creo el objeto.
                    //que es cada objeto persona original de la base de datos como tal


                    Persona p = new Persona(nombre, null, dni, null, null);
                    listaPersonas.add(p);
                }
            }
            System.out.println("Productos del CSV cargados correctamente" + listaPersonas.size());

        }catch (IOException | NumberFormatException e){
            e.printStackTrace();
        }//CIERRE CATCH

    }//CIERRE CARGA DE DATOS CSV


    //INICIO CLASE CARTA DE DATOS BINARIOS

    private void cargarDatosDAT() {
        File fichero = new File(PATH + FILE_DAT);

        if (!fichero.exists()) {
            System.out.println("Primera ejecución: No hay datos binarios que cargar.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            //LEO el objeto Academia que hay en el archivo
            Academia auxiliar = (Academia) ois.readObject();

            // 2. COPIO los datos del archivo a ESTA academia (this)
            this.listaEquipo = auxiliar.getListaEquipo();
            this.nombre = auxiliar.getNombre();
            this.CIF = auxiliar.getCIF();
            this.fechaFundacion = auxiliar.getFechaFundacion();

            System.out.println("Datos binarios cargados: " + listaEquipo.size() + " equipos recuperados.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al recuperar datos binarios.");
        }
    }//CIERRE METODO CARGAR ARCHIVOS DAT

    //METODO GUARDAR DATOS BAT (SE HACE SIEMPRE PORQUE SINO EL BAT NO VA A EXISTIR NUNCA)

    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH + FILE_DAT))) {
            oos.writeObject(this); // Guardo el objeto Academia completo con sus listas
            System.out.println("Datos guardados en binario correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar en binario: " + e.getMessage());
        }
    }

    //METODO REGISTRAR UN EQUIPO, VERIFICANDO QUE EL DNI DEL CAPITAN NO ESTE ASIGNADO A OTRO

    public void registrarEquipo(Equipo nuevoEquipo) {
        String dniNuevo = nuevoEquipo.getCapitan().getDNI();
        boolean yaExiste = false;
        for (Equipo e : listaEquipo) {
            if (e.getCapitan().getDNI().equals(dniNuevo)) {
                yaExiste = true;
                break;
            }
        }
        if (!yaExiste) {
            System.out.println("El Capitan con numero de DNI" + dniNuevo + "ya se encuentra registrado");

        } else {
            this.listaEquipo.add(nuevoEquipo);
            System.out.println("Equipo registrado correctamente.");

        }

    }//CIERRE REGISTRAR EQUIPO


    }//CIERRE CLASE PRINCIPAL ACADEMIA


