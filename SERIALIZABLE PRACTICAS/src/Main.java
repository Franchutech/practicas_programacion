import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;



public class Main {
    public static void main(String[] args) {

        final String path = "./src/resources/";
        final String fileName = "alumnos.dat";
        boolean fileMode = false;

    Alumno pp = new Alumno("Pepe", "Blanco","pepe@pepe.com",18);

    pp.calificar("Programacion", 5);
    pp.calificar("BBDD", 6);
    pp.calificar("Lenguaje de Marcas", 7);
    pp.calificar("Sistemas Informaticos", 9);
    pp.calificar("Ingles",4);


    FileOutputStream file;
    ObjectOutputStream buffer;


    try{
        file = new FileOutputStream(path+fileName, fileMode);
        buffer = new ObjectOutputStream(file);
    }catch (IOException e) {
        System.out.println("Error al escribir el archivo: " + e.getMessage());
        return;
    }


    //ESCRITURA DEL FICHERO

        try{
            buffer.writeObject(pp);
            System.out.println("Archivo guardado correctamente");
        }catch (IOException e){
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        try{
            file.close();
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar el archivo: " + e.getMessage());
        }

    }//VOIN MAIN

}//MAIN