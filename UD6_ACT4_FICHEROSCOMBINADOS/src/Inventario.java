import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Inventario {

        //defino las rutas primero, por temas de orden.

        private static final String PATH = ".\\src\\resources\\";
        private static final String FILE_CSV = "productos.csv";
        private static final String FILE_DAT = "almacen.dat";

        //Creo la lista fuera del main para que sea màs "global"

        private static LinkedList<Producto> listaProductos = new LinkedList<Producto>();

    public static void main(String[] args) {
        cargarDatosCSV();
        cargarDatosBinarios();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    eliminarProductos(sc);
                    break;
                case 3:
                    guardarySalir();
                    System.out.println("Saliendo del programa MERCADAW");
                    break;
                default:
                    System.out.println("Opcion no válida");
            }

            }while (opcion != 3);

    } //CIERRE VOID MAIN

        private static void cargarDatosCSV() {

            //aqui intentare abrir el archivo con la ruta que estableci previamente

            try (FileReader fr = new FileReader(PATH + FILE_CSV);
                BufferedReader br = new BufferedReader(fr)){

                String linea;
                //USO UN WHILE PARA DECIR "MIENTRAS HAYAN LINEAS EN EL CSV...HAZ...LO SIGUIENTE"
                while ((linea = br.readLine()) != null){
                    if (!linea.trim().isEmpty()){  //si la linea no està vacia entonces....

                        //TROCEO EL CSV EN PARTES POR CADA PUNTO Y COMA
                        String[] partes = linea.split(";");

                        //aqui convierto cada "parte" en una variable del tipo que tengo en la clase producto.

                        String ref = partes[0].trim();
                        String desc = partes[1].trim();
                        String tipo = partes[2].trim();
                        int cant = Integer.parseInt(partes[3].trim());
                        double prec = Double.parseDouble(partes[4].trim());
                        int descue = (int) Double.parseDouble(partes[5].trim());
                        int iva = Integer.parseInt(partes[6].trim());
                        boolean dto = Boolean.parseBoolean(partes[7].trim());


                        //y ahora si que lo tengo en partes y "definido en tipos de variables" pues ya creo el objeto.
                        //que es cada objeto producto como tal.


                        Producto p = new Producto(ref, desc, tipo, cant, prec, descue, iva, dto);
                        listaProductos.add(p);

                    }
                }
                System.out.println("Productos del CSV cargados correctamente" + listaProductos.size());
                }catch (IOException | NumberFormatException e){
                e.printStackTrace();
            }//CIERRE CATCH


        }//CIERRE CARGAR DATOS CSV METODO

        private static void cargarDatosBinarios () {
            File fichero  = new File(FILE_DAT);

            //primero verifico si existe, porque como yo hago el proyecto de cero, la primera vez no va a existir.
            if (!fichero.exists()){
                System.out.println("No se encontro el fichero " + FILE_DAT);
                return;
            }//cierre del if

            //Si en cambio el archivo existe, entonces abro el bucle especial para objetos
            //uso try with resources para que se cierre automaticamente
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {

                //leo la coleccion y hago un casting para avisarle a java que lo que viene en este bucle son objetos
                LinkedList<Producto> listaAuxiliar = (LinkedList<Producto>) ois.readObject();

                //fusiono los productos nuevos añadiendolos a la lista global
                listaProductos.addAll(listaAuxiliar);
                System.out.println("Lista de productos Binarios cargados correctamente" + listaProductos.size());


            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }


        }//CIERRE CARGAR DATOS BINARIOS METODO

        //hago un metodo para el menu

        private static void mostrarMenu() {
            System.out.println("\n MENÚ MERCADAW");
            System.out.print("Elige una de las siguientes opciones: ");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Eliminar producto por referencia");
            System.out.println("3. Guardar y Salir");

        }//CIERRE DEL METODO DEL MENU

        private static void mostrarProductos() {
            // Si la lista ESTÁ vacía...
            if (listaProductos.isEmpty()) {
                System.out.println("\n[Aviso] El inventario no contiene productos actualmente.");
            } else {
                System.out.println("\n--- LISTADO DE STOCK ---");

                // ImpriMO una cabecera PARA MAS ORDEN para saber qué es cada columna

                System.out.println("REF\tDESC.\tTIPO\tSTOCK\tPRECIO");

                for (Producto p : listaProductos) {

                    System.out.println(
                            p.getReferencia() + "\t" +
                                    p.getDescripcion() + "\t" +
                                    p.getTipo() + "\t" +
                                    p.getCantidad() + "\t" +
                                    p.getPrecio() + "€"
                    );
                }
                System.out.println(""); // Espacio final para que "respire" el menú
            }
        }//CIERRE METODO MOSTRAR PRODUCTOS

        private static void eliminarProductos(Scanner sc) {

        //VERIFICO SI TENGO ALGO QUE BORRAR
            if (listaProductos.isEmpty()) {
                System.out.println("\n[Error] El inventario está vacío. No hay productos para eliminar.");
                return;
            }
        //PIDO EL ID UNICO QUE CREA EL USUARIO DESDE EL PRINCIPIO
            System.out.println("\n DAR DE BAJA UN PRODUCTO ");
            System.out.print("> Introduzca la referencia del artículo a eliminar: ");
            String refObjetivo = sc.nextLine().trim();

        //USO UN BOOLEAN PARA SABER SI ENCONTRÉ EL PRODUCTO POR REFERENCIA
            boolean encontrado = false;

            for (int i = 0; i < listaProductos.size(); i++) {
                // Uso equalsIgnoreCase para que no importe si el usuario tonto escribe "REF001" o "ref001"
                if (listaProductos.get(i).getReferencia().equalsIgnoreCase(refObjetivo)) {

                    // Guardo la descripcion antes de borrarla para dar un mensaje personalizado

                    String descBorrada = listaProductos.get(i).getDescripcion();
                    listaProductos.remove(i);
                    System.out.println("\n[Éxito] El producto '" + descBorrada + "' ha sido eliminado.");

                    encontrado = true;

                    break; // Detengo el bucle
                }//CIERRE DEL IF
            }//CIERRE DEL FOR

        }//CIERRE METODO ELIMINAR PRODUCTOS

        private static void guardarySalir() {
            File fichero = new File(PATH + FILE_DAT);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {

                //ESCRIBO LA LISTA ENTERA DE OBJETOS
                oos.writeObject(listaProductos);
                System.out.println("\n[SISTEMA] Datos sincronizados en almacen.dat correctamente.");
                System.out.println("Cerrando la conexión con los archivos de MercaDaw...");

            } catch (IOException e) {
                // Si el disco falla o no hay permisos, muestro el rastro del error
                System.out.println("\n[CRÍTICO] No se pudieron guardar los cambios.");
                e.printStackTrace();
            }

        }//CIERRE DE METODO GUARDAR Y SALIR


}//CIERRE CLASE INVENTARIO