import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

    public class Inventario {

        //defino las rutas primero, por temas de orden.

        private static final String PATH = ".\\src\\resources\\";
        private static final String FILE_CSV = "productos.csv";
        private static final String FILE_DAT = "almacen.dat";

        //Creo la lista fuera del main para que sea màs "global"

        private static LinkedList<Producto> listaProductos = new LinkedList<Producto>();

    public static void main(String[] args) {
        cargarDatosCSV();

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
                        int descue = Integer.parseInt(partes[5].trim());
                        int iva = Integer.parseInt(partes[6].trim());
                        boolean dto = Boolean.parseBoolean(partes[7].trim());


                        //y ahora si que lo tengo en partes y "definido en tipos de variables" pues ya creo el objeto.
                        //que es cada producto como tal.


                        Producto p = new Producto(ref, desc, tipo, cant, prec, descue, iva, dto);
                        listaProductos.add(p);

                    }
                }
                System.out.println("Productos del CSV cargados correctamente" + listaProductos.size());
                }catch (IOException | NumberFormatException e){
                e.printStackTrace();
            }//CIERRE CATCH


        }//CIERRE CARGAR DATOS CSV METODO




}//CIERRE CLASE INVENTARIO