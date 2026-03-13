import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Matcher;
import static java.util.regex.Pattern.matches;

public class Director extends Persona implements Serializable {

        @Serial
    private static final long serialVersionUID = -6746873446663566366L;

    //ATRIBUTOS

    private String numeroTelefono;
    private boolean cocheEmpresa;


    //CONSTRUCTOOR

    public Director(String nombre, LocalDate fechaNacimiento, String DNI, String direccion, String numeroTelefono, boolean cocheEmpresa) {
        super(nombre, fechaNacimiento, DNI, direccion);
        setNumeroTelefono(numeroTelefono);
        this.cocheEmpresa = cocheEmpresa;
    }

    //GETTERS

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public boolean isCocheEmpresa() {
        return cocheEmpresa;
    }


    //SETTERS

    public void setNumeroTelefono(String numeroTelefono) {
        if (numeroTelefono != null && numeroTelefono.matches("^[6-9][0-9]{8}$")) {
            this.numeroTelefono = numeroTelefono;
        }


    }

    public void setCocheEmpresa(boolean cocheEmpresa) {
        this.cocheEmpresa = cocheEmpresa;
    }

    @Override
    public String toString() {
        return super.toString() + "Director{" +
                "numeroTelefono=" + numeroTelefono +
                ", cocheEmpresa=" + cocheEmpresa +
                '}';
    }



}//CIERRE CLASE DIRECTOR
