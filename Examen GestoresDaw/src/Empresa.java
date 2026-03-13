import exceptions.DNIYaRegistradoException;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.io.*;


public abstract class Empresa extends Trabajador implements Serializable {

    @Serial
    private static final long serialVersionUID = -6746873446663566364L;

    private static final String PATH = ".\\src\\resources\\";
    private static final String FILE_DAT = "empresa.dat";



    //ATRIBUTOS

    private String nombreEmpresa;
    private String CIF;
    private LocalDate fechaFundacion;
    Set<String>gestionTrabajadores = new HashSet<>();  //con el Hashset creo que puedo evitar el tema de los duplicados por DNI

    //CONSTRUCTOR


    public Empresa(String nombre, LocalDate fechaNacimiento, String DNI, String direccion, String numeroSS, String email, Double salario, Departamentos departamento, String nombreEmpresa, String CIF, LocalDate fechaFundacion, Set<String> gestionTrabajadores) throws Exception {
        super(nombre, fechaNacimiento, DNI, direccion, numeroSS, email, salario, departamento);
        setNombreEmpresa(nombreEmpresa);
        setCIF(CIF);
        setFechaFundacion(fechaFundacion);
        this.gestionTrabajadores = gestionTrabajadores;

        cargarDatosDAT();
    }

    //GETTERS


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getCIF() {
        return CIF;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public Set<String> getGestionTrabajadores() {
        return gestionTrabajadores;
    }

    //SETTERS


    public void setNombreEmpresa(String nombreEmpresa) throws Exception {
        if (nombreEmpresa != null && nombreEmpresa.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]{2,50}$")) {
            throw new Exception("El nombre de la empresa debe estar entre loos 2 y 50 caracteres");
        }this.nombreEmpresa = nombreEmpresa;

    }

    public void setFechaFundacion(LocalDate fechaFundacion) throws Exception {
        if ((fechaFundacion != null)) {
            throw new Exception("La fecha no puede estar vacía");
        }this.fechaFundacion = fechaFundacion;
    }

    public void setGestionTrabajadores() {
        this.gestionTrabajadores = gestionTrabajadores;
    }

    public void setCIF(String CIF) throws Exception {
        if (CIF != null && CIF.matches("^[A-Z][0-9]{10}$")) {
            throw new Exception("El CIF debe iniciar por una letra mayuscula y tener 10 digitos numericos.");
        }this.CIF = CIF;
    }

    //METODOS

    //METODOREGISTRAR TRABAJADOR

    public void registrarTrabajador(Trabajador nuevoTrabajador) throws DNIYaRegistradoException {
        String dniNuevo = nuevoTrabajador.getDNI();
        boolean yaExiste = false;
        for (Trabajador t : gestionTrabajadores.toArray(new Trabajador[gestionTrabajadores.size()])) {
            if (t.getDNI().equals(dniNuevo)) {
                yaExiste = true;
                throw new DNIYaRegistradoException("El DNI " +  dniNuevo + " ya existe en el sistema.");
            }break;
        }
        if (!yaExiste) {
            gestionTrabajadores.add(dniNuevo);
            nuevoTrabajador.add(getNumeroSS());

        }

    }//CIERRE METODO REGISTRAR TRABAJADOR

    //REGISTRAR GERENTE

    public void registrarGerenteDep(GerenteDep nuevoGerenteDep) throws DNIYaRegistradoException {
        String dniNuevo = nuevoGerenteDep.getDNI();
        boolean yaExiste = false;
        for (GerenteDep gd: gestionTrabajadores.toArray(new GerenteDep[gestionTrabajadores.size()])) {
            if (gd.getDNI().equals(dniNuevo)) {
                yaExiste = true;
                throw new DNIYaRegistradoException("El DNI " +  dniNuevo + " ya existe en el sistema.");
            }break;
        }
        if (!yaExiste) {
            gestionTrabajadores.add(dniNuevo);
            nuevoGerenteDep.add(getNumeroSS());
        }
    }//CIERRE  METODO REGISTRAR GERENTE


    //METODO REGISTRAR DIRECTOR

    public void registrarDirector(Director nuevoDirector) throws DNIYaRegistradoException {
        String dniNuevo = nuevoDirector.getDNI();
        boolean yaExiste = false;
        for (Director d: gestionTrabajadores.toArray(new Director[gestionTrabajadores.size()])) {
            if (d.getDNI().equals(dniNuevo)) {
                yaExiste = true;
                throw new DNIYaRegistradoException("El DNI " +  dniNuevo + " ya existe en el sistema.");
            }break;
        }
        if (!yaExiste) {
            gestionTrabajadores.add(dniNuevo);
            nuevoDirector.add(getNumeroSS());
        }
    }//CIERRE METODO REGISTRAR DIRECTOR

    //METODO ELIMINAR TRABAJADOR
    public boolean eliminarTrabajador(String dni) {
        for (int i = 0; i<gestionTrabajadores.size(); i++) {
            if (gestionTrabajadores.contains(dni)) {
                gestionTrabajadores.remove(dni);
            }
        }
        return false;
    }// CIERRE METODO ELIMINAR TRABAJADOR


    //METODO CARGAR DATOS.DAT

    private void cargarDatosDAT() {
        File fichero = new File(PATH + FILE_DAT);

        if (!fichero.exists()) {
            System.out.println("Primera ejecución: No hay datos binarios que cargar.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            //LEO el objeto Empresa que hay en el archivo
            Empresa auxiliar = (Empresa) ois.readObject();

            // 2. COPIO los datos del archivo a ESTA academia (this)
            this.gestionTrabajadores = auxiliar.getGestionTrabajadores();
            this.nombre = auxiliar.getNombreEmpresa();
            this.CIF = auxiliar.getCIF();
            this.fechaFundacion = auxiliar.getFechaFundacion();

            System.out.println("Datos binarios cargados: " + gestionTrabajadores.size() + " gestioon de trabajadores recuperados.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al recuperar datos binarios.");
        }
    }//CIERRE METODO CARGAR ARCHIVOS DAT



    //TOO STRING


    @Override
    public String toString() {
        return "Empresa{" +
                "nombreEmpresa='" + nombreEmpresa + '\'' +
                ", CIF='" + CIF + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                ", gestionTrabajadores=" + gestionTrabajadores +
                '}';

    }

    //METODO MOSTRAR INFORMACION DE TRABAJADORES

    //Hice el metodo pero por alguna razòn me daba error y preferi comentarlo para no dañar todo lo demas,
    //creo que mi erroor aqui es no saber cual clase debia poner

//        public String mostrarInformacionTrabajadores(){
//        String listado = "Detalle de trabajadores:\n";
////
//        for (Empresa e: setGestionTrabajadores(){
//            listado += "-" + e.getNombre() + e.getNumeroSS() + e.getDNI() + e.getEmail();
//            listado += "\n";
//        }
//        if (gestionTrabajadores.isEmpty()){
//            listado += "La empresa no tiene trabajadores registrados en este momento";
//        }
//        return listado;
//    }



}//CIERRE CLASE EMPRESA
