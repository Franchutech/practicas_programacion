package es.frojas.magic.models;

import es.frojas.magic.enums.Nacionalidades;
import es.frojas.magic.enums.TipoSer;

import java.io.Serial;
import java.io.Serializable;

//CLASE BASE PARA TODOS LOS QUE PERTENENCEN AL MUNDO MAGICO

//la puedo hacer abstracta porque un ser vivo no camina por diagon alley, o es un mago, o un muggle, etc..

public abstract class SerVivo implements Serializable {


    @Serial
    private static final long serialVersionUID = 3341869030353414165L;

    protected int idSerVivo;
    protected String nombreSerVivo;
    protected Nacionalidades nacionalidadSerVivo;
    protected TipoSer tipoSerVivo;

    //CONSTRUCTOR
    public SerVivo(int idSerVivo, String nombreSerVivo, Nacionalidades nacionalidadSerVivo, TipoSer tipoSerVivo) {
        this.idSerVivo = idSerVivo;
        this.nombreSerVivo = nombreSerVivo;
        this.nacionalidadSerVivo = nacionalidadSerVivo;
        this.tipoSerVivo = tipoSerVivo;
    }
    //METODO ABSTRACTO PORQUE DEPENDE DE QUIEN LO RELLENE y porque
    //la clase principal no sabe como es la ficha eso lo hará cada hijo.

    public abstract String obtenerFicha();

    //GETTERS


    public int getIdSerVivo() {
        return idSerVivo;
    }

    public String getNombreSerVivo() {
        return nombreSerVivo;
    }

    public Nacionalidades getNacionalidadSerVivo() {
        return nacionalidadSerVivo;
    }

    public TipoSer getTipoSerVivo() {
        return tipoSerVivo;
    }

    //SETTERS

    public void setIdSerVivo(int idSerVivo) {
        this.idSerVivo = idSerVivo;
    }

    public void setNombreSerVivo(String nombreSerVivo) {
        this.nombreSerVivo = nombreSerVivo;
    }

    public void setNacionalidadSerVivo(Nacionalidades nacionalidadSerVivo) {
        this.nacionalidadSerVivo = nacionalidadSerVivo;
    }

    public void setTipoSerVivo(TipoSer tipoSerVivo) {
        this.tipoSerVivo = tipoSerVivo;
    }


}//CIERRE CLASE SERVIVO
