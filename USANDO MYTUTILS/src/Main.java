import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edad = MyUtilspractica.leerEntero(sc, 1."Introduzca su edad");
        System.out.print("Edad introducida con Éxito");

        if (edad < 18) {
            System.out.print("La edad ingresada corresponde a un mayor de edad");


        }

        String nombreUsuario = sc.nextLine();

        if (MyUtilspractica.esNombreValido(nombreUsuario)) {
            System.out.println("✅ El nombre es correcto: " + nombreUsuario);
        } else {
            System.out.println("❌ El nombre no es válido.");
        }

        String telefonoValido = sc.nextLine();
        if (MyUtilspractica.esTelefonoValido(telefonoValido)) {
            System.out.println("El telefono es correcto: " + telefonoValido);
        } else {
            System.out.println("El numero de telefono no cumple con el formato requerido");
        }


        String emailUsuario = sc.nextLine();
    if (MyUtilspractica.esEmailValido(emailUsuario)) {
        System.out.println("El email es correcto: " + emailUsuario);
    }else {
        System.out.println("El email no es valido");
    }






    }
}