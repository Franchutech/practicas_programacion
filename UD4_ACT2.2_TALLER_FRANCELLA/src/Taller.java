import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Taller {
    // 1. ATRIBUTOS
    private HashMap<String, Coche> listaCoches;
    private Scanner entrada;

    // 2. CONSTRUCTOR
    public Taller() {
        this.listaCoches = new HashMap<>();
        this.entrada = new Scanner(System.in);
    }

    //MÉTODOS DE GESTORES

    // Añado un coche validando matrícula y que no esté repetida
    public void anadeElemento() {
        System.out.println("Introduce la matrícula (4 números y 3 letras): ");
        String matricula = entrada.nextLine();

        // Validación de formato (4 números y 3 letras)
        if (matricula.matches("^[0-9]{4}[A-Z]{3}$")) {

            // Compruebo si la matrícula ya existe en el mapa (containsKey)
            if (listaCoches.containsKey(matricula)) {
                System.out.println("Error: Ya existe un coche con esa matrícula.");
            } else {
                // Si es nueva, pido el resto de datos
                System.out.println("Introduce el color:");
                String color = entrada.nextLine();
                System.out.println("Introduce la marca:");
                String marca = entrada.nextLine();

                // Creo el objeto Coche y lo guardo con put
                Coche nuevoCoche = new Coche(color, marca);
                listaCoches.put(matricula, nuevoCoche);
                System.out.println("Coche añadido correctamente.");
            }
        } else {
            System.out.println("Error: Formato de matrícula incorrecto.");
        }
    }

    // Elimino un coche por su matrícula
    public void eliminaElemento() {
        System.out.println("Introduce la matrícula del coche a borrar:");
        String matricula = entrada.nextLine();

        // Intento borrar. remove() devuelve el objeto si existía o null si no
        if (listaCoches.remove(matricula) != null) {
            System.out.println("Coche eliminado con éxito.");
        } else {
            System.out.println("Error: No existe ningún coche con esa matrícula.");
        }
    }

    // MÉTODOS DE VISUALES

    // Muestro solo las llaves (Matrículas)
    public void visualizaMatriculas() {
        System.out.println("LISTA DE MATRÍCULAS");
        for (String m : listaCoches.keySet()) {
            System.out.println(m);
        }
    }

    // Muestro solo los valores (Coches)
    public void visualizaCoches() {
        System.out.println("LISTA DE COCHES");
        for (Coche c : listaCoches.values()) {
            System.out.println(c.toString());
        }
    }

    // Muestro la pareja completa (Clave = Valor)
    public void visualizaTaller() {
        System.out.println("ESTADO COMPLETO DEL TALLER");
        for (Map.Entry<String, Coche> entradaMapa : listaCoches.entrySet()) {
            System.out.println("Matrícula: " + entradaMapa.getKey() + " -> " + entradaMapa.getValue().toString());
        }
    }


}//CLASE TALLER
