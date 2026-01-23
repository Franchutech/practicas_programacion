import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //creo el objeto AGENDA
        Agenda miAgenda = new Agenda();

        //El usuario debe tener oportunidad de elegir en el MENU.
        Scanner entrada = new Scanner(System.in);




        do {
            switch (entrada.next()) {
                case "1":
                    miAgenda.addContacto();
                    break;
                case "2":


            }
        } while ();
    }

    }//VOID MAIN
}//MAIN