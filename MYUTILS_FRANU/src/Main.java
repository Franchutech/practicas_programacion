import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---------------------------------------------------------------------
        // 1. VALIDAR NOMBRE (Usando un bucle para obligar al usuario)
        // ---------------------------------------------------------------------
        String nombreFinal; // Aquí guardaremos el nombre solo cuando sea válido
        while (true) {
            System.out.print("Introduzca nombre: ");
            String entrada = sc.nextLine();

            // Llamamos a MyUtils. Si devuelve TRUE, el nombre es correcto
            if (MyUtilsFranchu.esNombreValido(entrada)) {
                nombreFinal = entrada; // Guardamos el valor
                break; // Salimos del bucle porque ya es válido
            } else {
                System.out.println("❌ Formato incorrecto. Solo letras y mínimo 2.");
            }
        }

        // ---------------------------------------------------------------------
        // 2. VALIDAR EMAIL (Uso directo en un if)
        // ---------------------------------------------------------------------
        System.out.print("Introduzca email: ");
        String emailTemporal = sc.nextLine();

        if (MyUtilsFranchu.esEmailValido(emailTemporal)) {
            System.out.println("✅ Email guardado con éxito.");
            // Aquí ya podrías hacer: miObjeto.setEmail(emailTemporal);
        }

        // ---------------------------------------------------------------------
        // 3. VALIDAR TELÉFONO
        // ---------------------------------------------------------------------
        System.out.print("Introduzca teléfono: ");
        String tlf = sc.nextLine();
        if (MyUtilsFranchu.esTelefonoValido(tlf)) {
            System.out.println("✅ Teléfono correcto.");
        }

        // ---------------------------------------------------------------------
        // 4. VALIDAR DNI
        // ---------------------------------------------------------------------
        System.out.print("Introduzca DNI (8 números y letra): ");
        String dni = sc.nextLine();
        if (MyUtilsFranchu.esDNIValido(dni)) {
            System.out.println("✅ DNI validado.");
        }

        // ---------------------------------------------------------------------
        // 5. VALIDAR CÓDIGO (Para películas, héroes o productos)
        // ---------------------------------------------------------------------
        System.out.print("Introduzca Código (Ej: P1234): ");
        String codigo = sc.nextLine();
        if (MyUtilsFranchu.esCodigoValido(codigo)) {
            System.out.println("✅ Código registrado.");
        }

        // ---------------------------------------------------------------------
        // 6. LEER ENTERO (La forma más limpia de usarlo)
        // ---------------------------------------------------------------------
        // No necesitas if ni while, MyUtils ya tiene el bucle dentro.
        // El programa no pasará de esta línea hasta que el usuario ponga un número.
        int edad = MyUtilsFranchu.leerEntero(sc, "Introduzca la edad: ");
        System.out.println("Edad registrada: " + edad);

        // ---------------------------------------------------------------------
        // 7. LEER FECHA (Para objetos Persona o Heroe)
        // ---------------------------------------------------------------------
        // MyUtils gestiona el error de formato (dd/mm/yyyy).
        LocalDate fechaNacimiento = MyUtilsFranchu.leerFecha(sc, "Fecha de nacimiento");

        // ---------------------------------------------------------------------
        // 8. LEER FECHA Y HORA (Para registros o alquileres)
        // ---------------------------------------------------------------------
        // Ideal para cuando el usuario elige cuándo quiere una cita o entrega.
        LocalDateTime fechaCita = MyUtilsFranchu.leerFechaHora(sc, "Fecha y hora del evento");

        // ---------------------------------------------------------------------
        // 9. OBTENER FECHA Y HORA ACTUAL (Automático)
        // ---------------------------------------------------------------------
        // Esto NO pide nada al usuario. Se usa para poner la "fecha de hoy" a algo.
        LocalDateTime ahoraMismo = MyUtilsFranchu.ahora();
        System.out.println("Operación realizada el: " + ahoraMismo);


            // =====================================================================
    // ############################ MÉTODOS ################################
    // =====================================================================

    /* ESTA PARTE VA DENTRO DE TU CLASE GESTORA (Academia, VideoDaw, Banco...)
       Son los motores que procesan la información de las listas.
    */

    // 10. BÚSQUEDA Y FILTRADO (Localizar objetos específicos)

    // A. BUSCAR POR IDENTIFICADOR ÚNICO (DNI, Código, IBAN)
    // Se usa para: Saber si alguien existe antes de hacer nada con él.
            public Persona buscarPorDni(String dni) {
                for (Persona p : listaPersonas) {
                    if (p.getDNI().equalsIgnoreCase(dni)) return p;
                }
                return null; // Si no lo encuentra devuelve "vacío"
            }

    // B. FILTRAR POR ATRIBUTO (Ver solo una categoría)
    // Se usa para: "Mostrar solo héroes activos" o "Películas de terror".
            public ArrayList<Heroe> filtrarActivos() {
                ArrayList<Heroe> soloActivos = new ArrayList<>();
                for (Heroe h : listaHeroes) {
                    if (h.isActivo()) soloActivos.add(h);
                }
                return soloActivos;
            }


    // 11. GESTIÓN DE OPERACIONES (Acciones que cambian el estado)

    // A. REALIZAR REGISTRO O ASIGNACIÓN (Con excepciones)
    // Se usa para: Meter un héroe en un equipo o alquilar una película.
            public void realizarAsignacion(Heroe h, Equipo e) throws Exception {
                if (e.getListaHeroes().size() >= e.getMaxHeroes()) {
                    throw new Exception("El equipo está lleno.");
                }
                e.getListaHeroes().add(h);
            }

    // B. ELIMINAR O DAR DE BAJA (Borrado físico de la lista)
    // Se usa para: Despedir a un empleado o borrar una cuenta bancaria.
            public boolean darDeBaja(String identificador) {
                for (int i = 0; i < listaGeneral.size(); i++) {
                    if (listaGeneral.get(i).getId().equals(identificador)) {
                        listaGeneral.remove(i);
                        return true;
                    }
                }
                return false;
            }


    // 12. CÁLCULOS Y ESTADÍSTICAS (Números y promedios)

    // A. CALCULAR PROMEDIO (Media aritmética)
    // Se usa para: "Nota media de alumnos" o "Ataque medio del equipo".
            public double obtenerMedia() {
                if (lista.isEmpty()) return 0;
                double suma = 0;
                for (Objeto o : lista) suma += o.getValor();
                return suma / lista.size();
            }

    // B. BUSCAR EL MÁXIMO (El mejor de la lista)
    // Se usa para: "El jugador con más puntos" o "La película más cara".
            public Objeto obtenerElMejor() {
                if (lista.isEmpty()) return null;
                Objeto mejor = lista.get(0);
                for (Objeto o : lista) {
                    if (o.getValor() > mejor.getValor()) mejor = o;
                }
                return mejor;
            }


    // ---------------------------------------------------------------------
    /* ESTA PARTE VA DENTRO DEL MAIN (En el Switch)
       Es la forma de conectar tu menú con los métodos de arriba.
    */

    // 13. CÓMO LLAMAR A LAS BÚSQUEDAS
    // Caso: "Quiero ver los datos de un DNI"
            String dniInput = sc.nextLine();
            Persona encontrada = miAcademia.buscarPorDni(dniInput);
            if (encontrada != null) {
                System.out.println(encontrada.toString());
            }

    // 14. CÓMO LLAMAR A LAS OPERACIONES (Con Try-Catch)
    // Caso: "Registrar un alquiler o asignar equipo"
            try {
                miAcademia.realizarAsignacion(h, e);
                System.out.println("✅ Éxito");
            } catch (Exception err) {
                System.out.println("❌ Fallo: " + err.getMessage());
            }

    // 15. CÓMO LLAMAR A LOS LISTADOS FILTRADOS
    // Caso: "Mostrar solo los que cumplen una condición"
            for (Heroe h : miAcademia.filtrarActivos()) {
                System.out.println(h.getNombre());
            }

    // 16. CÓMO LLAMAR A LAS ESTADÍSTICAS
    // Caso: "Ver el promedio y el mejor de la academia"
            System.out.println("Media: " + miAcademia.obtenerMedia());
            System.out.println("El mejor es: " + miAcademia.obtenerElMejor().getNombre());
    } // Cierre VOID Main
} // Cierre Clase MAIN