package es.frojas.magic.models;

import es.frojas.magic.enums.Nacionalidades;
import es.frojas.magic.enums.TipoSer;
import java.io.Serial;
import java.io.Serializable;

public class Muggle extends SerVivo implements Serializable {

    private String profesion;
    private boolean conoceMundoMagico;

    // CONSTRUCTOR
    public Muggle(int idSerVivo, String nombreSerVivo, Nacionalidades nacionalidadSerVivo,
                  String profesion, boolean conoceMundoMagico) {

        // Enviamos el TipoSer.MUGGLE automáticamente a la madre
        super(idSerVivo, nombreSerVivo, nacionalidadSerVivo, TipoSer.MUGGLE);
        this.profesion = profesion;
        this.conoceMundoMagico = conoceMundoMagico;
    }

    // IMPLEMENTACIÓN DE LA FICHA
    @Override
    public String obtenerFicha() {
        return String.format("""
            -- FICHA DE MUGGLE --
            ID: %d
            Nombre: %s
            Nacionalidad: %s
            Profesión: %s
            ¿Sabe de magia?: %s
            """,
                idSerVivo, nombreSerVivo, nacionalidadSerVivo,
                profesion, conoceMundoMagico ? "SÍ (Bajo vigilancia)" : "NO");
    }

    // GETTERS Y SETTERS
    public String getProfesion() { return profesion; }
    public void setProfesion(String profesion) { this.profesion = profesion; }

    public boolean isConoceMundoMagico() { return conoceMundoMagico; }
    public void setConoceMundoMagico(boolean conoceMundoMagico) { this.conoceMundoMagico = conoceMundoMagico; }
}//CIERRE CLASE MUGGLE
