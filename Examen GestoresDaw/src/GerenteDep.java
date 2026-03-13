import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import static java.util.regex.Pattern.matches;

public abstract class GerenteDep extends Trabajador implements Serializable {

    @Serial
    private static final long serialVersionUID = -6746873446663566364L;

    //ATRIBUTOS

    public int trabajador;//LO COLOOCO TEMPORAL PORQUE PIENSO ME PUEDE AYUDAR A CONTAR TRABAJADORES DESDE EL CONSTRUCTOR
    private GerenciaDepartments gerenciadept; //ENUM
    private ArrayList<Trabajador> trabajadores;
    private boolean isActivo; //LO COLOCO TEMPORAL PENSANDO LA UTILIZARE PARA SABER SI UN TRABAJADOR ESTA ACTIVO O NO
    private Double costeSalarial; //LO COLOCO PENSANDO QUE ME AYUDARA A SACAR LOS COSTOS TOTALES DE SALARIO CON UN METODO


    private static int conteoTrabajador = 1;

    //CONSTRUCTOR

    public GerenteDep(String nombre, LocalDate fechaNacimiento, String DNI, String direccion, String numeroSS, String email, Double salario, Departamentos departamento, int trabajador, GerenciaDepartments gerenciadept, ArrayList<Trabajador> trabajadores, boolean isActivo) throws Exception {
        super(nombre, fechaNacimiento, DNI, direccion, numeroSS, email, salario, departamento);
        this.trabajador = trabajador;
        this.gerenciadept = gerenciadept;
        this.trabajadores = trabajadores;
        this.isActivo = isActivo;

        this.trabajador = conteoTrabajador++; //suma de los trabajadores
    }

    public int getTrabajador() {
        return trabajador;
    }

    public GerenciaDepartments getGerenciadept() {
        return gerenciadept;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public boolean isActivo() {
        return isActivo;
    }

    public static int getConteoTrabajador() {
        return conteoTrabajador;
    }


    //SETTERS


    public void setTrabajador(int trabajador) {
        this.trabajador = trabajador;
    }

    public void setGerenciadept(GerenciaDepartments gerenciadept) {
        this.gerenciadept = gerenciadept;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    public static void setConteoTrabajador(int conteoTrabajador) {
        GerenteDep.conteoTrabajador = conteoTrabajador;
    }

    //TOSTRING

    @Override
    public String toString() {
        return super.toString() + "GerenteDep{" +
                "trabajador=" + trabajador +
                ", gerenciadept=" + gerenciadept +
                ", trabajadores=" + trabajadores +
                ", isActivo=" + isActivo +
                '}';
    }

    //METODOS

    //COSTE TOTAL SALARIAL DEPARTAMENTAL, SUMA DE SALARIOS
    //PODRIA IR A CLASE TRABAJADOR, A VER SI AHI PUEDO DE UNA VEZ PONER UN CONTADOR SUMANDO LOS SALARIOS
    //Y AQUI SOLO LO IMPRIMIRIA...
    //En principio lo logre, en la clase trabajador, deberia hacerse la suma de los salarios Y AQUI AL TO STRING, ESTAR
    //HERENDANDO DEBERIA HALAR CON EL SUPER.TOSTRING  PUES ESA INFORMACION



    //TRABAJADOR ES ACTIVO O NO?, SI ME DA TIEMPO AL FINAL DEL EXAMEN PENSAR COMO HACERLO. (O SI LO NECESITO ANTES REVISAR)

    //MOSTRAR INFO DEPARTAMENTO

    public String mostrarInfoDepartamento(){
        String listado ="Información del Departamento por: " + getDepartamento() + ":\n";
        for (Trabajador t :  getTrabajadores()) {
            listado += t.toString();
        }
        if (trabajadores.isEmpty()) {
            listado += "No existen trabajadores en este momento.";
        }
        return listado;

    }//CIERRE METODO MOSTRAS INFODEPARTAMENTO


}//CIERRE CLASE GERENTE DEPT
