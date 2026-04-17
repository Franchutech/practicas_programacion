import exceptions.CapacidadExcedidaException;
import exceptions.HeroeYaRegistradoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

/**
 * Clase central del sistema que gestiona la lógica de la Academia de Héroes.
 * Administra la persistencia de datos (CSV y DAT), la gestión de equipos y
 * el registro de personal.
 * * @author Francella Rojas Castillo
 * @version 1.0
 * @since 2026-03-29
 */
public class Academia implements Serializable {

    @Serial
    private static final long serialVersionUID = -1740119966371832974L;

    /** Rutas y nombres de archivos para la persistencia de datos. */
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

    /**
     * Constructor de Academia. Inicializa las listas y lanza los procesos
     * de carga de datos desde fuentes externas (CSV y Binario).
     * * @param nombre Nombre de la academia.
     * @param CIF Código de Identificación Fiscal con validación.
     * @param fechaFundacion Fecha de creación de la institución.
     */
    public Academia(String nombre, String CIF, LocalDate fechaFundacion) {
        this.nombre = nombre;
        this.setCIF(CIF);
        this.fechaFundacion = fechaFundacion;
        this.listaEquipo = new ArrayList<>();
        this.listaPersonas = new ArrayList<>();

        // LLAMO A LOS MÉTODOS AQUÍ DENTRO
        cargarDatosCSV();
        cargarDatosDAT();
    }

    //GETTERS

    /** @return Nombre de la academia. */
    public String getNombre() {
        return nombre;
    }

    /** @return CIF validado de la academia. */
    public String getCIF() {
        return CIF;

    }

    /** @return Fecha de fundación. */
    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    /** @return Lista de equipos registrados. */
    public ArrayList<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    /** @return Lista de personas cargadas desde el sistema. */
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    //SETTERS

    /** @param nombre Nuevo nombre de la academia. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el CIF validando que cumpla el formato de una letra y ocho números.
     * @param CIF Cadena con el CIF a validar.
     */
    public void setCIF(String CIF) {
        if (CIF != null && CIF.matches("^[A-Z][0-9]{8}$")) {
            this.CIF = CIF;
        } else {
            this.CIF = "INVALIDO";
            System.out.println("Error: El CIF debe tener 1 letra y 8 números.");
        }
    }


    /** @param fechaFundacion Nueva fecha de fundación. */
    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    /** @param listaEquipo Nueva lista de equipos. */
    public void setListaEquipo(ArrayList<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }


    //TO STRING

    /**
     * Genera un resumen textual de la academia y sus equipos.
     * @return Cadena descriptiva del objeto.
     */
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

    /**
     * Lee el archivo CSV de personas y carga los objetos en la lista de personas.
     * Utiliza BufferedReader para un procesamiento eficiente de líneas[cite: 221].
     */
    private void cargarDatosCSV() {

        try(FileReader fr = new FileReader(PATH + FILE_CSV);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            while ((linea = br.readLine()) != null){
                if (!linea.trim().isEmpty()){  //si la linea no està vacia entonces....

                    //TROCEO EL CSV EN PARTES POR CADA PUNTO Y COMA
                    String[] partes = linea.split(";");

                    //aqui convierto cada "parte" en una variable del tipo que tengo en la clase persona

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

    /**
     * Recupera el estado previo de la academia desde un archivo serializado (.dat).
     * Si el archivo no existe, se considera la primera ejecución del sistema.
     */
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

    /**
     * Serializa el objeto Academia actual en un archivo binario para su persistencia.
     */
    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH + FILE_DAT))) {
            oos.writeObject(this); // Guardo el objeto Academia completo con sus listas
            System.out.println("Datos guardados en binario correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar en binario: " + e.getMessage());
        }
    }

    //METODO REGISTRAR UN EQUIPO, VERIFICANDO QUE EL DNI DEL CAPITAN NO ESTE ASIGNADO A OTRO

    /**
     * Registra un nuevo equipo validando que el capitán no lidere ya otro equipo existente.
     * @param nuevoEquipo El equipo a dar de alta.
     */
    public void registrarEquipo(Equipo nuevoEquipo) {
        String dniNuevo = nuevoEquipo.getCapitan().getDNI();
        boolean yaExiste = false;
        for (Equipo e : listaEquipo) {
            if (e.getCapitan().getDNI().equals(dniNuevo)) {
                yaExiste = true;
                break;
            }
        }
        if (yaExiste) {
            System.out.println("El Capitan con numero de DNI" + dniNuevo + "ya se encuentra registrado");

        } else {
            this.listaEquipo.add(nuevoEquipo);
            System.out.println("Equipo registrado correctamente.");

        }

    }//CIERRE REGISTRAR EQUIPO

    //METODO ASIGNAR HEROE A EQUIPO

    /**
     * Asigna un héroe a un equipo específico, validando capacidad y duplicados.
     * Actualiza el contrato del héroe basándose en el código del equipo.
     * * @param h Héroe a asignar.
     * @param e Equipo destino.
     * @throws HeroeYaRegistradoException Si el héroe ya está en el equipo.
     * @throws CapacidadExcedidaException Si el equipo ha alcanzado su límite máximo. [cite: 170]
     */
    public void asignarHeroeAEquipo(Heroe h, Equipo e) throws HeroeYaRegistradoException, CapacidadExcedidaException {
        if (e.getListaHeroes().size() >= e.getMaxHeroes()) {
            throw new CapacidadExcedidaException("El equipo " + e.getNombreEquipo() + " está lleno.");
        }

        // AQUÍ FALTABA EL IF
        for (Heroe heroeExistente : e.getListaHeroes()) {
            if (heroeExistente.getDNI().equals(h.getDNI())) {
                throw new HeroeYaRegistradoException("El heroe " + h.getNombre() + " ya se encuentra en este equipo.");
            }
        }

        String contrato = "HERO-" + e.getCodEquipo();
        h.setnContrato(contrato);
        e.getListaHeroes().add(h);
        System.out.println("Heroe registrado correctamente con contrato: " + contrato);

    }//CIERRE ASIGNAR HEROE A EQUIPO

    //METODO CALCULO DE ESTADISTICAS

    /**
     * Calcula y muestra por consola promedios de ataque y el equipo más fuerte de la academia.
     */
    public void calcularEstadistica() {

        //VALIDO SI EXISTEN O NO EQUIPOS
        if (listaEquipo.isEmpty()) {
            System.out.println("No hay equipos suficientes para calcular una estadística");
            return;
        }
        //VARIABLES
        double sumaAtaqueTotal = 0;
        int totalHeroes = 0;

        //VARIABLES PARA BUSCAR AL MEJOR

        Equipo mejorEquipo = listaEquipo.get(0); //ASUMO QUE EL PRIMERO O UNICO SERÁ EL MEJOR SIEMPRE
        double maxAtaque = -1;//COMO DEBE SER MAYOR QUE CERO PONGO LA META EN -1 PARA QUE SIEMPRE SE CUMPLA QUE ALGUIEN ES MEJOR QUE ESO

        System.out.println("REPORTE DE ESTADÍSTICAS ACADEMIA");
        System.out.println("Equipos evaluados:");

        for (Equipo e : listaEquipo) {
            double ataqueDelEquipo = e.getAtaqueTotal();
            System.out.println("- " + e.getNombreEquipo() + " | Poder: " + ataqueDelEquipo);

            sumaAtaqueTotal += e.getAtaqueTotal();

            //EQUIPO MAS FUERTE
            if (ataqueDelEquipo > maxAtaque) {
                maxAtaque = ataqueDelEquipo;
                mejorEquipo = e;
            }
        }
        //PROMEDIO DE TODOS
        double promedio  = sumaAtaqueTotal / listaEquipo.size();

        System.out.println("ESTADÍSTICAS DE LA ACADEMIA");
        System.out.println("Total de equipos: " + listaEquipo.size());
        System.out.println("Total de héroes activos: " + totalHeroes);
        System.out.println("Promedio de ataque por equipo: " + promedio);
        System.out.println("EQUIPO DESTACADO: " + mejorEquipo.getNombreEquipo() + " con " + maxAtaque + " pts.");


    }//CIERRE METODO CALCULAR ESTADISTICA


}//CIERRE CLASE PRINCIPAL ACADEMIA