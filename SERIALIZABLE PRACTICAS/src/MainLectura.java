import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainLectura {
    public static void main(String[] args) {

        final String path = "./src/resources/";
        final String fileName = "alumnos.dat";
        boolean fileMode = false;

        try(FileInputStream file = new FileInputStream(path+fileName);
            ObjectInputStream reader = new ObjectInputStream(file)){
            Object obj = reader.readObject();
            if(obj instanceof Alumno){
                Alumno a= (Alumno)obj;
                System.out.println(a);
                for(Calificacion c: a.getCalificaciones()){
                    System.out.println(c);
                }
            }

        }catch(IOException | ClassNotFoundException e){

            System.out.println("Error al abrir archivo" +e.getMessage());
        }
    }
}
