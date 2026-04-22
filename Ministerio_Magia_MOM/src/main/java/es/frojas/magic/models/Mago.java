package es.frojas.magic.models;

import es.frojas.magic.enums.Casas;
import es.frojas.magic.enums.Nacionalidades;
import es.frojas.magic.enums.TipoSer;
import es.frojas.magic.enums.EstatusSangre;

import java.io.Serial;
import java.io.Serializable;


public class Mago extends SerVivo implements Serializable {


    @Serial
    private static final long serialVersionUID = 7137714643816666798L;

    private Casas casas;
    private String patronus; // lo traigo de SQL
    private EstatusSangre estatusSangre;
    private boolean esMortifago;

    //CONSTRUCTOR


    public Mago(int idSerVivo, String nombreSerVivo, Nacionalidades nacionalidadSerVivo,
                Casas casas, String patronus,
                EstatusSangre estatusSangre, boolean esMortifago) {
        // Aquí le paso el TipoSer.MAGO directamente a la madre
        super(idSerVivo, nombreSerVivo, nacionalidadSerVivo, TipoSer.MAGO);
        this.casas = casas;
        this.patronus = patronus;
        this.esMortifago = esMortifago;
        this.estatusSangre = estatusSangre;
    }


    //GETTERS

    public Casas getCasas() {
        return casas;
    }

    public String getPatronus() {
        return patronus;
    }

    public boolean isEsMortifago() {
        return esMortifago;
    }

    public EstatusSangre getEstatusSangre() {
        return estatusSangre;
    }

    //SETTERS


    public void setCasas(Casas casas) {
        this.casas = casas;
    }

    public void setpatronus(String patronus) {
        this.patronus = patronus;
    }

    public void setEstatusSangre(EstatusSangre estatusSangre) {
        this.estatusSangre = estatusSangre;
    }

    public void setEsMortifago(boolean esMortifago) {
        this.esMortifago = esMortifago;
    }

    @Override
    public String obtenerFicha() {
        return String.format("""
            --- FICHA DE MAGO ---
            ID: %d
            Nombre: %s
            Nacionalidad: %s
            Casa: %s
            Patronus: %s
            Estatus de Sangre: %s
            Mortífago: %s
            """,
                idSerVivo, nombreSerVivo, nacionalidadSerVivo,
                casas, patronus, estatusSangre, esMortifago ? "SÍ" : "NO");
    }
}//CIERRE CLASE PRINCIPAL MAGO
