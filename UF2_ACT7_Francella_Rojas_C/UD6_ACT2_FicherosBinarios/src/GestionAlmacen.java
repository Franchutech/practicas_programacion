import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionAlmacen {
    // uso Arraylist
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static final String ARCHIVO = "Almacen.dat"; // Nombre del fichero binario
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargarFichero();
        menuPrincipal();
    }

    private static void cargarFichero() {
        File fichero = new File(ARCHIVO);
        if (fichero.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                // Se deben leer los datos como ficheros binarios
                listaProductos = (ArrayList<Producto>) ois.readObject();
                System.out.println("Datos cargados correctamente desde " + ARCHIVO);
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("Error al cargar el fichero: " + e.getMessage());
            }
        } else {
            System.out.println("No existe el fichero " + ARCHIVO + ". Se iniciará un almacén vacío.");
        }
    }

    private static void menuPrincipal() {
        int opcion = 0;
        do {

            System.out.println("\n--- MENÚ ALMACÉN ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Mostrar productos existentes");
            System.out.println("3. Eliminar producto por código");
            System.out.println("4. Guardar productos en el fichero");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1: crearProducto(); break;
                    case 2: mostrarProductos(); break;
                    case 3: eliminarProducto(); break;
                    case 4: guardarEnFichero(); break;
                    case 5: System.out.println("Saliendo..."); break;
                    default: System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }
        } while (opcion != 5);
    }


    private static void crearProducto() {
        try {

            System.out.print("Código: ");
            int cod = Integer.parseInt(sc.nextLine());
            System.out.print("Nombre: ");
            String nom = sc.nextLine();
            System.out.print("Cantidad: ");
            int cant = Integer.parseInt(sc.nextLine());
            System.out.print("Precio: ");
            double prec = Double.parseDouble(sc.nextLine());

            listaProductos.add(new Producto(cod, nom, cant, prec));
            System.out.println("Producto añadido temporalmente.");
        } catch (NumberFormatException e) {
            System.out.println("Dato incorrecto. No se pudo crear el producto.");
        }
    }

    private static void mostrarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : listaProductos) {
                System.out.println(p);
            }
        }
    }

    private static void eliminarProducto() {
        System.out.print("Código a eliminar: ");
        try {
            int cod = Integer.parseInt(sc.nextLine());

            boolean eliminado = listaProductos.removeIf(p -> p.getCodigo() == cod);
            if (eliminado) System.out.println("Producto borrado.");
            else System.out.println("No se encontró el código.");
        } catch (Exception e) {
            System.out.println("Error en el borrado.");
        }
    }

    private static void guardarEnFichero() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(listaProductos);
            System.out.println("Cambios guardados en " + ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}