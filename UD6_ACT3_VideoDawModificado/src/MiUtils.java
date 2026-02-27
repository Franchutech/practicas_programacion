import java.util.Scanner;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class MiUtils {
    //Generacion aleatoria de letras en mayusculas
    public static char generarLetraAleatoria(){
        char c = (char) Math.max(65, (int)((Math.random() * 90) + 1));
        return c;
    }

    public static int generarEnteroAleatorio(int max){
        int resultado = (int)((Math.random() * max) + 1);
        return resultado;
    }

    public static double leerDecimal(String mensaje){
        System.out.print(mensaje);
        Scanner sc = new Scanner(System.in);
        double numero = sc.nextDouble();
        sc.close();
        return numero;
    }

    public static boolean comprobarPatron(String patron, String texto){
        boolean resultado = false;
        resultado = texto.matches(patron);
        return resultado;
    }

    public static String menuConsola(String[] menu){
        System.out.println("Por favor, escoja una de las opciones:");
        for(int i = 0; i < menu.length; i++){
            System.out.println(menu[i]);
        }
        Scanner sc = new Scanner(System.in);
        String opcion = sc.nextLine();
        sc.close();
        return opcion;
    }

    public static void imprimir(String mensaje){
        System.out.println(mensaje);
    }

    public static String leerTextoPantalla(String mensaje){
        Scanner reader = new Scanner(System.in);
        System.out.println(mensaje);
        String valor = reader.nextLine();
        return valor;
    }

    //COMPROBAR REPETIDAMENTE QUE UN PATRON SE REPITE.

    public static String comprobarPatronRepetidamente(String patron, String mensaje){
        boolean isOk = false;
        String texto;
        do {
            texto = MiUtils.leerTextoPantalla(mensaje);
            isOk = MiUtils.comprobarPatron(patron, texto);
            if(!isOk){
                MiUtils.imprimir("El formato es incorrecto");
            }
        } while (!isOk);
        return texto;
    }

    //COMPROBAR SI UNA FECHA ES MAYOR QUE OTRA EN CUANTOS AÑOS. (METODO NUEVO MIO)

    public static boolean minimoEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) return false;
        // Segundos que equivalen a 18 años
        long SEGUNDOS_18_ANIOS = 31557600L * 18;
        // Zona horaria del sistema
        ZoneId zoneId = ZoneId.systemDefault();
        // Pasar la fecha de nacimiento a epoch seconds (a medianoche)
        long nacimientoEpoch = fechaNacimiento.atStartOfDay(zoneId).toEpochSecond();
        // Epoch seconds actuales
        long ahoraEpoch = LocalDateTime.now().atZone(zoneId).toEpochSecond();
        // Diferencia entre ambas fechas
        long diferencia = ahoraEpoch - nacimientoEpoch;
        return diferencia >= SEGUNDOS_18_ANIOS;
    }



}//MAIN CLASS MIUTILS
