import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Biblioteca biblio = new Biblioteca("Bib001","BMS Jado",
                "Pase de Altamira 23","info@bmsjado.es","942-20-23-25");

        Libro l1 = new Libro("La comunidad del anillo", "JRR Tolkien",
                "ISBN123","23-7-1942");
        Libro l2 = new Libro("Las dos torres", "JRR Tolkien",
                "ISBN456","23-7-1944");
        Libro l3 = new Libro("El retorno del Rey", "JRR Tolkien",
                "ISBN789","23-7-1946");
        Libro l4 = new Libro("Juegos de tronos", "GRR Martin",
                "ISBN333","23-7-1992");
        Libro l5 = new Libro("Choque de reyes", "GRR Martin",
                "ISBN333","23-7-1992");
        Libro l6 = new Libro("Tormenta de espadas", "GRR Martin",
                "ISBN333","23-7-1992");
        Libro l7 = new Libro("Festin de cuervos", "GRR Martin",
                "ISBN333","23-7-1992");
        Libro l8 = new Libro("Danza de dragones", "GRR Martin",
                "ISBN334","23-7-2011");
        Libro l9 = new Libro("El nombre del viento", "Patrick Rothfus",
                "ISBN335","23-7-2006");
        Libro l10 = new Libro("El temor de un hombre sabio", "Patrick Rothfus",
                "ISBN335","23-7-2011");

        boolean estado = biblio.insertarLibro(l1);
        if(estado){
            System.out.println("Libro insertado exitosamente");
        }else{
            System.out.println("Libro no insertado exitosamente");
        }

        estado = biblio.insertarLibro(l2);
        estado = biblio.insertarLibro(l3);
        estado = biblio.insertarLibro(l4);
        estado = biblio.insertarLibro(l5);
        estado = biblio.insertarLibro(l6);
        estado = biblio.insertarLibro(l7);
        estado = biblio.insertarLibro(l8);
        estado = biblio.insertarLibro(l9);
        estado = biblio.insertarLibro(l10);


        /*
        Insertar un libro por teclado
         */
        Scanner sc = new Scanner(System.in);
        String titulo = "", autor = "", ISBN = "", fechaPublicacion = "";

        System.out.print("Ingrese el titulo del libro: ");
        titulo = sc.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        autor = sc.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        ISBN = sc.nextLine();
        System.out.print("Ingrese el fecha de publicacion del libro: ");
        fechaPublicacion = sc.nextLine();

        Libro lTeclado = new Libro(titulo, autor, ISBN, fechaPublicacion);
        biblio.insertarLibro(lTeclado);

        System.out.println(biblio.infoBiblioteca());

        System.out.println(biblio.infoLibros());

        boolean isElimnado = biblio.eliminarLibro(l2);

        if(isElimnado){
            System.out.println("Libro eliminado exitosamente");
        }

        l1.setnPaginas(537);
        l3.setnPaginas(645);

        System.out.println(biblio.infoLibros());

        sc =  new Scanner(System.in);
        System.out.print("Ingrese el ISBN del libro que quiere eliminar: ");
        String isbnEliminar = sc.nextLine();

        Libro lEliminar = biblio.getLibroByISBN(isbnEliminar);
        biblio.eliminarLibro(lEliminar);

        System.out.println(Biblioteca.getContadorTotal());

    } //void main
} //main
