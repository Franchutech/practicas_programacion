import java.time.LocalDate;

public class Persona {
    private String Nombre;
    private String DNI;
    private LocalDate FechaNac;

//CONSTRUCTOR

    public Persona(String Nombre, String DNI, LocalDate fechaNac)throws CuentaException {
        this.setDNI(DNI);
        this.setNombre(Nombre);
        this.setFechaNac(fechaNac);

    }//CONSTRUCTOR

//VALIDACION DE DATOS PERSONAS

    public boolean validarNombre (String Nombre)
    {return Nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$");}


    public boolean validarDNI (String DNI)
    {return DNI.matches("^([0-9]{8}|[XYZ][0-9]{7})[TRWAGMYFPDXBNJZSQVHLCKE]$");}


//VALIDACIOON DE FECHA CON LOCAL DATE (si la fecha es posterior a hoy entonces no es una fecha de nacimiento)
    public boolean validarfechaNac (LocalDate fechaNac) {
        if (fechaNac.isAfter(LocalDate.now())) {
            return false;
        }
        return true;
    }

//SETTERS

    public void setNombre(String Nombre) throws CuentaException{
        if (Nombre.length() < 3) {
            throw new CuentaException("Nombre NO VÁLIDO o demasiado corto, debe contener al menos 3 letras");
        }
        this.Nombre = Nombre;
    }

    public void setDNI(String DNI) throws CuentaException{
        boolean validoDNI = this.validarDNI(DNI);
        if (!validoDNI){
            throw new CuentaException("El formato de DNI/NIE no es vàlido");
    }
        this.DNI = DNI;
    }

    public void setFechaNac(LocalDate fechaNac) throws CuentaException{
        if (!validarfechaNac(fechaNac)){
            throw new CuentaException("Fecha nacimiento no valido");
        }
        this.FechaNac = fechaNac;
    }

//GETTERS
    public String getNombre() {
        return Nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public LocalDate getFechaNac() {
        return FechaNac;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Persona [Nombre =" + Nombre + ", DNI =" + DNI + ", FechaNac=" + FechaNac + "]";
    }

}//MAIN PERSONA
