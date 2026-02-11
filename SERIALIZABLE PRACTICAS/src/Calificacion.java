import java.io.Serializable;

public class Calificacion implements Serializable {


    private static final long serialVersionUID = 358918347283281834L;

    private String asignatura;
    private int nota;


    public Calificacion(String asignatura, int nota) {
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public String getAsignatura() {
        return asignatura;
    }


    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Calificacion{" +
                "asignatura='" + asignatura + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }
}
