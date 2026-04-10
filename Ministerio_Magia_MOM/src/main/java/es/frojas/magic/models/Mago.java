package es.frojas.magic.models;

import es.frojas.magic.enums.Casas;
import es.frojas.magic.enums.Nacionalidades;
import es.frojas.magic.enums.TipoSer;

import java.io.Serial;
import java.io.Serializable;


public class Mago extends SerVivo implements Serializable {


    @Serial
    private static final long serialVersionUID = 7137714643816666798L;

    private Casas casas;
    private String patronus; // lo traigo de SQL
    private int nivelMagico;
    private boolean esMortifago;

    //CONSTRUCTOR


    public Mago(int idSerVivo, String nombreSerVivo, Nacionalidades nacionalidadSerVivo,
                Casas casas, String patronus,
                int nivelMagico, boolean esMortifago) {
        // Aquí le paso el TipoSer.MAGO directamente a la madre
        super(idSerVivo, nombreSerVivo, nacionalidadSerVivo, TipoSer.MAGO);
        this.casas = casas;
        this.patronus = patronus;
        this.esMortifago = esMortifago;
        this.setNivelMagico(nivelMagico);
    }


    //GETTERS

    public Casas getCasas() {
        return casas;
    }

    public String getpatronus() {
        return patronus;
    }

    public int getNivelMagico() {
        return nivelMagico;
    }

    public boolean isEsMortifago() {
        return esMortifago;
    }


    //SETTERS


    public void setCasas(Casas casas) {
        this.casas = casas;
    }

    public void setpatronus(String patronus) {
        this.patronus = patronus;
    }

    public void setNivelMagico(int nivelMagico) {
        if (nivelMagico >= 0 && nivelMagico <= 10){
            this.nivelMagico = nivelMagico;
        }else  {
            System.out.println("El nivel magico es invalido, el rango del Ministerio de Magia es del 0 al 10");
        }

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
            Nivel: %d
            Mortífago: %b
            """,
                idSerVivo, nombreSerVivo, nacionalidadSerVivo,
                casas, patronus, nivelMagico, esMortifago);
    }
}//CIERRE CLASE PRINCIPAL MAGO
