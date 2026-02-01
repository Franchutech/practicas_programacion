import java.time.LocalDate;

public class Persona {
    protected String Nombre;
    protected String DNI;
    protected LocalDate FechaNac;

    // CONSTRUCTOR
    public Persona(String Nombre, String DNI, LocalDate fechaNac) throws CuentaException {
        this.setDNI(DNI);
        this.setNombre(Nombre);
        this.setFechaNac(fechaNac);
    }

    // VALIDACION DE DATOS
    public boolean validarNombre(String Nombre) {
        return Nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    public boolean validarDNI(String DNI) {
        return DNI.matches("^([0-9]{8}|[XYZ][0-9]{7})[TRWAGMYFPDXBNJZSQVHLCKE]$");
    }

    public boolean validarfechaNac(LocalDate fechaNac) {
        return !fechaNac.isAfter(LocalDate.now());
    }

    // SETTERS
    public void setNombre(String Nombre) throws CuentaException {
        if (Nombre.length() < 3 || !validarNombre(Nombre)) {
            throw new CuentaException("Nombre NO VÁLIDO (mínimo 3 letras y solo caracteres alfabéticos)");
        }
        this.Nombre = Nombre;
    }

    public void setDNI(String DNI) throws CuentaException {
        if (!validarDNI(DNI)) {
            throw new CuentaException("El formato de DNI/NIE no es válido");
        }
        this.DNI = DNI;
    }

    public void setFechaNac(LocalDate fechaNac) throws CuentaException {
        if (!validarfechaNac(fechaNac)) {
            throw new CuentaException("Fecha de nacimiento no válida (no puede ser futura)");
        }
        this.FechaNac = fechaNac;
    }

    // GETTERS
    public String getNombre() { return Nombre; }
    public String getDNI() { return DNI; }
    public LocalDate getFechaNac() { return FechaNac; }

    @Override
    public String toString() {
        return "Persona [Nombre=" + Nombre + ", DNI=" + DNI + ", FechaNac=" + FechaNac + "]";
    }
}