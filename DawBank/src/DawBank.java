import javax.sound.midi.MidiUnavailableException;
import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

public class DawBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ibanComprobado = MiUtils.comprobarPatronRepetidamente("[a-zA-Z]{2}[0-9]{22}",
                "Introduzca el IBAN");

        String titularComprobado;

        System.out.print("Introduzca el titular: ");

        boolean titularComprobadoValido = false;
        do {
            titularComprobado = sc.nextLine();
            titularComprobadoValido = CuentaBancaria.validacionTitular(titularComprobado);

            if  (titularComprobadoValido == false) {
                System.out.println("Introduzca el titular valido");

            }else {
                System.out.println("Nombre del titular registrado: " + titularComprobado);
            }

        }while(!titularComprobadoValido);


    } //void
} //clase