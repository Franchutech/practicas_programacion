import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    //DECLARO LA VARIABLE LIST POR SI MAS ADELANTE QUIERO CAMBIAR A ARRAYLIST ETC

    private static List<Libro> biblioteca = new LinkedList<>();

    //INICIO EL ESCANNER

    private static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatos();
        menuPrincipal();

    }//VOID MAIN

        private static void menuPrincipal(){
            int opcion = 0;
            do{
                System.out.println("\n Selecciona una opcion del menú :\n");
                System.out.println("\n--- MENU BIBLIOTECA ---");
                System.out.println("1. Crear Libro");
                System.out.println("2. Mostrar Libro");
                System.out.println("3. Eliminar Libro");
                System.out.println("4. Guardar Libro en el Fichero");
                System.out.println("5. Guardar y Salir");

                try {
                    opcion = Integer.parseInt(lector.nextLine());
                    switch(opcion){
                        case 1: crearLibro(); break;
                        case 2: mostrarLibro(); break;
                        case 3: eliminarLibro(); break;
                        case 4: guardarLibro(); break;
                        case 5: guardarLibro();
                            System.out.println("Saliendo de la Biblioteca");
                            break;
                        default: System.out.println("Opción no válida");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor introduce un número válido");
                }
            } while (opcion != 5);
        }//CIERRE MENU PRINCIPAL

    //CLASE CREAR LIBRO CON ISBN UNICO

    private static void crearLibro(){
        try{
            //PIDO TODO LO NECESARIO POR SCANNER Y VALIDO CADA DATO ANTES DE ACEPTARLO

            //VALIDO EL ISBN
            String ISBN;
            while(true){
                System.out.println("Introduce el ISBN (exactamente 13 números: ");
                ISBN = lector.nextLine();

                //Compruebo formato y si es ùnico
                if(ISBN.matches("[0-9]{13}")){
                    boolean existe = false;
                    for (Libro l : biblioteca){
                        if (l.getISBN().equals(ISBN)){
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) break;
                    else  System.out.println("ISBN introducido ya existe en la Biblioteca");

                }else {
                    System.out.println("Formato de ISBN invalido");
                }
            }//CIERRE WHILE ISBN

            //VALIDO EL TITULO
            String titulo;
            while (true){
                System.out.println("Titulo (De 3 a 100 caracteres): ");
                titulo = lector.nextLine();
                if (titulo.length() >= 3 && titulo.length() <= 100) {
                    break;
                }
                else System.out.println("El titulo debe tener entre 3 y 100 caracteres");
            }//CIERRE WHILE TITULO

            //VALIDO EL AUTOR

            String autor;
            while (true) {
                System.out.println("Autor (3-50 caracteres): ");
                autor = lector.nextLine().trim();
                if (autor.length() >= 3 && autor.length() <= 50) {
                    //Valido que no contenga números o símbolos raros
                    if (autor.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                        break;
                    } else {
                        System.out.println("Error: El nombre del autor solo debe contener letras.");
                    }
                } else {
                    System.out.println("Error: El nombre debe tener entre 3 y 50 caracteres.");
                }
            }//CIERRE WHILE AUTOR

            //VALIDAR LA FECHA

            System.out.println("Fecha de publicacion (AAAA-MM-DD): ");
            LocalDate fechaPublicacion = LocalDate.parse(lector.nextLine());

            biblioteca.add(new Libro(fechaPublicacion, titulo, ISBN, autor));
            System.out.println("Libro creado exitosamente");

        }catch (Exception e){
            System.out.println("Error al crear libro, verifique toda la información.");
        }
    }//CIERRO METODO CREAR LIBRO


    public static void mostrarLibro(){

        //Compruebo si la biblioteca esta vacia.
        if(biblioteca.isEmpty()){
            System.out.println("No se encontro el libro");
            return;
        }
        System.out.println("LISTADO DE LIBROS EXISTENTES");

        //lo recorro y muestro el listado
        for(Libro l : biblioteca){
            System.out.println(l.toString());
        }

    }// CIERRO METODO MOSTRAR LIBRO

    public static void eliminarLibro(){
        System.out.println("Introduzca el ISBN del libro que desea eliminar: ");
        String  isbnBuscar = lector.nextLine();

        if (!isbnBuscar.matches("[0-9]{13}")) {
            System.out.println("Error: El formato del ISBN no es válido (deben ser 13 números).");
            return; //SALGO DEL METODO Y REGRESO PORQUE NO COINCIDE
        }
        boolean eliminado = biblioteca.removeIf(l -> l.getISBN().equals(isbnBuscar));
        if (eliminado) {
            System.out.println("Libro eliminado exitosamente");
        }else  {
            System.out.println("No se encontró ningun libro con ese ISBN para eliminar");
        }

    }//CIERRO EL METODO DE ELIMINAR LIBRO

    public static void guardarLibro(){
        //aqui mientras try maneja cualquier excepcion
        //inicio el bloque y le digo al oos, que traduzca todo
        //para el archivo fileoutputstream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Biblioteca.dat"))){

            //aqui le digo al oos que meta todo por el embudo
            //dentor de el archivo biblioteca
            oos.writeObject(biblioteca);

            System.out.println("Libro guardado exitosamente en el fichero Biblioteca");

        }
        catch (IOException e){
            System.out.println("Error al guardar libro en el fichero: " + e.getMessage());
        }

    }//CIERRO EL METODO DE GUARDAR LIBRO

    public static void cargarDatos(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Biblioteca.dat"))){

            biblioteca = (List<Libro>) ois.readObject();
            System.out.println("Datos cargados correctamente desde el fichero Biblioteca");


        }catch (FileNotFoundException e){
            System.out.println("No hay datos previos. Iniciando biblioteca vacía.");
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Error al cargar datos de la Biblioteca: " + e.getMessage());
        }
    }//CIERRO METODO DE CARGAR DATOS


}//MAIN





