package es.frojas.magic.models;

import es.frojas.magic.enums.Nacionalidades;
import es.frojas.magic.enums.TipoSer;
import java.io.Serial;
import java.io.Serializable;

public class Criatura extends SerVivo implements Serializable {

    @Serial
    private static final long serialVersionUID = 9823471293847L;

    private int nivelPeligrosidad; // Escala 1 a 5 (X, XX, XXX, XXXX, XXXXX)
    private boolean esDomesticable;

    // CONSTRUCTOR
    public Criatura(int idSerVivo, String nombreSerVivo,
                    Nacionalidades nacionalidadSerVivo,
                    int nivelPeligrosidad, boolean esDomesticable) {

        // Le doy el  TipoSer.CRIATURA_FANTASTICA  a la madre
        super(idSerVivo, nombreSerVivo, nacionalidadSerVivo,
                TipoSer.CRIATURA_FANTASTICA);
        this.setNivelPeligrosidad(nivelPeligrosidad);
        this.esDomesticable = esDomesticable;
    }

    // IMPLEMENTACIÓN DE LA FICHA
    @Override
    public String obtenerFicha() {
        String clasificaciónX = "X".repeat(Math.max(0, nivelPeligrosidad));
        return String.format("""
            -- FICHA DE CRIATURA MÁGICA --
            ID: %d
            Especie: %s
            Origen: %s
            Clasificación MOM: %s (%d)
            ¿Domesticable?: %s
            """,
                idSerVivo, nombreSerVivo, nacionalidadSerVivo,
                clasificaciónX, nivelPeligrosidad,
                esDomesticable ? "SÍ" : "NO - REQUIERE PERMISO ESPECIAL");
    }

    // GETTER Y SETTER
    public int getNivelPeligrosidad() { return nivelPeligrosidad; }

    public void setNivelPeligrosidad(int nivelPeligrosidad) {
        if (nivelPeligrosidad >= 1 && nivelPeligrosidad <= 5) {
            this.nivelPeligrosidad = nivelPeligrosidad;
        } else {
            System.out.println("Error: La peligrosidad debe ser de 1 a 5 (X a XXXXX)");
        }
    }

    public boolean isEsDomesticable() { return esDomesticable; }
    public void setEsDomesticable(boolean esDomesticable) { this.esDomesticable = esDomesticable; }

}//CIERRE CLASE CRIATURA