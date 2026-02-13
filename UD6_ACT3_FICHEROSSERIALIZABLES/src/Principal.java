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
        menuPrincipal();

    }//VOID MAIN

        private static void menuPrincipal(){
            int opcion = 0;
            do{
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
                        case 5: System.out.println("Saliendo de la Biblioteca"); break;
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
                System.out.println("Titulo: ");
                titulo = lector.nextLine();
                if (!titulo.trim().isEmpty())break;
                else System.out.println("El titulo no puede estar vacio");
            }//CIERRE WHILE TITULO

            //VALIDO EL AUTOR

            String autor;
            while (true){
                System.out.println("Autor: ");
                autor = lector.nextLine();
                if (!autor.trim().isEmpty())break;
                else System.out.println("El autor no puede estar vacio");

            }//CIERRE WHILE AUTOR

            //VALIDAR LA FECHA

            System.out.println("Fecha de publicacion (AAAA-MM-DD): ");
            LocalDate fechaPublicacion = LocalDate.parse(lector.nextLine());

            biblioteca.add(new Libro(fechaPublicacion, titulo, ISBN, autor));
            System.out.println("Libro creado exitosamente");

        }catch (Exception e){
            System.out.println("Error al crear libro, verifique toda la información.");
        }
    }//CIERRE METODO CREAR LIBRO


}//MAIN





