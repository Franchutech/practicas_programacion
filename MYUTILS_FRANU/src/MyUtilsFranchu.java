import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MyUtilsFranchu {

    // 1. VALIDAR NOMBRE: Letras, tildes, ñ y espacios (2-50 chars).
    public static boolean esNombreValido(String n) {
        return n != null && n.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]{2,50}$");
    }

    // 2. VALIDAR EMAIL: Formato estándar.
    public static boolean esEmailValido(String e) {
        return e != null && e.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }

    // 3. VALIDAR TELÉFONO: 9 dígitos (empieza por 6, 7, 8 o 9).
    public static boolean esTelefonoValido(String t) {
        return t != null && t.matches("^[6-9][0-9]{8}$");
    }

    // 4. VALIDAR DNI: 8 números y 1 letra final (Mayúscula).
    public static boolean esDNIValido(String d) {
        return d != null && d.matches("^[0-9]{8}[A-Z]$");
    }

    // 5. VALIDAR CÓDIGO (Ej: VideoDaw/HeroDaw): Letra + 4/5 números.
    public static boolean esCodigoValido(String c) {
        return c != null && c.matches("^[A-Z][0-9]{4,5}$");
    }

    // 6. LEER ENTERO (Seguro): Bucle hasta que sea número.
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try { return Integer.parseInt(sc.nextLine()); }
            catch (NumberFormatException e) { System.out.println("❌ Error: Número entero no válido."); }
        }
    }

    // 7. CONVERTIR TEXTO A FECHA: Para LocalDate.
    // Formato esperado: dd/MM/yyyy (ej: 13/03/2026)
    public static LocalDate leerFecha(Scanner sc, String mensaje) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print(mensaje + " (dd/MM/yyyy): ");
            try { return LocalDate.parse(sc.nextLine(), fmt); }
            catch (DateTimeParseException e) { System.out.println("❌ Error: Formato de fecha inválido."); }
        }
    }

    // 8. LECTURA DE FECHA Y HORA (Registro exacto)
    // Formato esperado: dd/MM/yyyy HH:mm (ej: 13/03/2026 14:30)
    public static LocalDateTime leerFechaHora(Scanner sc, String mensaje) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        while (true) {
            System.out.print(mensaje + " (dd/MM/yyyy HH:mm): ");
            try {
                return LocalDateTime.parse(sc.nextLine(), fmt);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Error: Formato de fecha y hora inválido (Recuerda el espacio entre fecha y hora).");
            }
        }
    }

    // 9. OBTENER FECHA Y HORA ACTUAL (Automático)
    // Útil para registros que se hacen "ahora mismo" sin preguntar al usuario.
    public static LocalDateTime ahora() {
        return LocalDateTime.now();
    }


    // =====================================================================
    // ############################ MÉTODOS (10+) ##########################
    // =====================================================================

    /* NOTA: Estos métodos se adaptan a la clase de tu examen.
       Solo cambia "Object" o "Persona" por el nombre de tu clase. */

    // 10. BÚSQUEDA POR IDENTIFICADOR (dni, codigo, id)
    // Se usa para: Localizar un objeto en una lista antes de borrarlo o editarlo.
    public static Object buscarPorId(ArrayList<Object> lista, String idBusqueda) {
        for (Object item : lista) {
            // Aquí llamarías al getter de tu clase: item.getDNI() o item.getCodigo()
            // if (item.getIdentificador().equalsIgnoreCase(idBusqueda)) return item;
        }
        return null;
    }

    // 11. FILTRADO DE LISTAS (mostrar por categoría)
    // Se usa para: "Mostrar solo películas de terror" o "Héroes de rango S".
    public static ArrayList<Object> filtrarPorCategoria(ArrayList<Object> listaOriginal, String filtro) {
        ArrayList<Object> listaFiltrada = new ArrayList<>();
        for (Object item : listaOriginal) {
            // if (item.getCategoria().equalsIgnoreCase(filtro)) listaFiltrada.add(item);
        }
        return listaFiltrada;
    }

    // 12. CÁLCULO DE PROMEDIOS (estadísticas)
    // Se usa para: "Media de ataque", "Media de saldo", "Nota media".
    public static double calcularMedia(ArrayList<Object> lista) {
        if (lista.isEmpty()) return 0;
        double suma = 0;
        for (Object item : lista) {
            // suma += item.getValorNumerico();
        }
        return suma / lista.size();
    }

    // 13. BUSCAR EL MEJOR/PEOR (máximos y mínimos)
    // Se usa para: "El héroe más fuerte", "La película más barata".
    public static Object buscarMejor(ArrayList<Object> lista) {
        if (lista.isEmpty()) return null;
        Object mejor = lista.get(0);
        for (Object item : lista) {
            // if (item.getValor() > mejor.getValor()) mejor = item;
        }
        return mejor;
    }

    // 14. ELIMINAR ELEMENTO (borrado lógico o físico)
    // Se usa para: "Dar de baja a un socio" o "Eliminar equipo".
    public static boolean eliminarDeLista(ArrayList<Object> lista, String idEliminar) {
        for (int i = 0; i < lista.size(); i++) {
            // if (lista.get(i).getId().equals(idEliminar)) {
            //     lista.remove(i);
            //     return true;
            // }
        }
        return false;
    }

    // 15. COMPROBAR EXISTENCIA (duplicados)
    // Se usa para: No registrar dos veces el mismo DNI o Código.
    public static boolean yaExiste(ArrayList<Object> lista, String id) {
        // return buscarPorId(lista, id) != null;
        return false;
    }


    /* =====================================================================
################### ESQUELETOS PARA EL SWITCH #######################
=====================================================================

COPIA ESTO COMO REFERENCIA PARA SABER QUÉ HACER EN CADA CASE:

--- CASE: REGISTRAR ALGO (Ej: Crear Héroe o Película) ---
    1. Pedir datos con MyUtilsFranchu.leerEntero o sc.nextLine.
    2. Validar con MyUtilsFranchu.esNombreValido o similares.
    3. Si es válido: Crear el objeto -> Objeto o = new Objeto(...);
    4. Llamar al método de la academia: miAcademia.registrar(o);
    5. Mostrar mensaje de éxito.

--- CASE: BUSCAR Y MOSTRAR (Ej: Ver datos de un socio) ---
    1. Pedir el identificador (DNI/Código).
    2. Llamar al buscador: Objeto encontrado = miAcademia.buscar(id);
    3. IF (encontrado != null) -> sout(encontrado);
    4. ELSE -> sout("No existe");

--- CASE: REALIZAR OPERACIÓN (Ej: Alquilar o Asignar) ---
    1. Pedir ID de la Persona y ID del Objeto (Peli/Equipo).
    2. Buscar ambos objetos en sus listas.
    3. IF (ambos existen) ->
          try { miAcademia.operacion(persona, objeto); }
          catch (Exception e) { sout(e.getMessage()); }
    4. ELSE -> sout("Uno de los dos no existe");

--- CASE: ELIMINAR (Ej: Borrar registro) ---
    1. Pedir ID a borrar.
    2. IF (miAcademia.eliminar(id)) -> sout("Borrado");
    3. ELSE -> sout("No encontrado");

--- CASE: LISTAR (Ej: Mostrar todo) ---
    1. IF (miAcademia.getLista().isEmpty()) -> sout("Vacío");
    2. ELSE -> Bucle for-each para imprimir la lista.

--- CASE: GUARDAR Y SALIR ---
    1. Llamar a miAcademia.guardarDatos();
    2. sout("Datos salvados. Adiós");
    3. opcion = 0; (Para romper el do-while)
*/
}//CIERRE CLASE MY UTILS