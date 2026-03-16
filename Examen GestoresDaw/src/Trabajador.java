import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Matcher;
import static java.util.regex.Pattern.matches;


public class Trabajador extends Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = -6746873446663566363L;



    //ATRIBUTOS
    private String numeroSS;
    private String email;
    private Double salario;
    private Departamentos departamento;//ENUM

    private static Double sumaSalarios = 0.0;


    //CONSTRUCTOR

    public Trabajador(String nombre, LocalDate fechaNacimiento, String DNI, String direccion, String numeroSS, String email, Double salario, Departamentos departamento) throws Exception {
        super(nombre, fechaNacimiento, DNI, direccion);
        setNumeroSS(numeroSS);
        setEmail(email);
        this.salario = salario;
        this.departamento = departamento;
        this.sumaSalarios = sumaSalarios;

        this.sumaSalarios = sumaSalarios++;
    }


    //GETTER

    public String getNumeroSS() {
        return numeroSS;
    }

    public String getEmail() {
        return email;
    }

    public Double getSalario() {
        return salario;
    }

    public Departamentos getDepartamento() {
        return departamento;
    }

    public static Double getSumaSalarios() {
        return sumaSalarios;
    }
    //SETTER


    public void setDepartamento(Departamentos departamento) {
        this.departamento = departamento;
    }

    public void setNumeroSS(String numeroSS) throws Exception {
        if (numeroSS != null && numeroSS.matches("^[0-9]{10}$")) {
            throw new Exception("El numeroSS debe tener al menos 10 caracteres.");
        } this.numeroSS = numeroSS;
    }

    public void setEmail(String email) {
        if (email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            this.email = email;
        } else {
            this.email = "INVALIDO";
            System.out.println("Error: El email, debe tener el formato correcto ejemplo@ejemplo.ejem");
        }
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }


    @Override
    public String toString() {
        return super.toString() + "Trabajador{" +
                "numeroSS='" + numeroSS + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                ", departamento=" + departamento +
                ", sumaSalarios=" + sumaSalarios +
                '}';
    }


}//CIERRE CLASE TRABAJADOR
