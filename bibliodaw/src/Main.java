import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Biblioteca biblio = new Biblioteca("Bib001", "BMS Jado", "Paseo Altamira 23", " info@biblio.es", "2456-6564-45");

        Libro l1 = new Libro("La comunidad del anillo", "JRB Talkien", "ISBN123", "23-7-196");
        Libro l2 = new Libro("Harry Potter y la Piedra Filosofal", "J.K.Rowling", "ISBN4563", "23-12-1991");
        Libro l3 = new Libro("Harry Potter y la Camara de los secretos", "J.K.Rowling", "ISBN123", "23-12-1991");
        Libro l4 = new Libro("Harry Potter y el Prisionero de Azcaban", "J.K.Rowling", "ISBN123", "23-12-1991");
        Libro l5 = new Libro("Harry Potter y el Caliz de Fuego", "J.K.Rowling", "ISBN123", "23-12-1991");
        Libro l6 = new Libro("Harry Potter y La orden del Fenix",  "J.K.Rowling", "ISBN123", "23-12-1991");
        Libro l7 = new Libro("Harry Potter y el Misterio del  Principe",  "J.K.Rowling", "ISBN123", "23-12-1991");
        Libro l8 = new Libro("Harry Potter y las Reliquias de la Muerte Parte 1", "J.K.Rowling", "ISBN123", "23-12-1991");
        Libro l9 = new Libro("Harry Potter y las Reliquias de la Muerte parte 2", "J.K.Rowling", "ISBN123", "23-12-1991");



        boolean estado = biblio.insertarLibro(l1);
        if (estado == true) {
            System.out.println("Libro insertado correctamente");
        }else{
            System.out.println("Libro insertado incorrecto");
        }

        estado = biblio.insertarLibro(l1);
        estado = biblio.insertarLibro(l2);
        estado = biblio.insertarLibro(l3);
        estado = biblio.insertarLibro(l4);
        estado = biblio.insertarLibro(l5);
        estado = biblio.eliminarLibro(l6);
        estado = biblio.eliminarLibro(l7);
        estado = biblio.eliminarLibro(l8);
        estado = biblio.eliminarLibro(l9);


        /*Insertar un libro*/
        Scanner sc = new Scanner(System.in);
        String titulo ="", autor = "", ISBN = "", fechaPublicacion ="";


    } // void
}//main
