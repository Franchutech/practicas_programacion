package actividad7;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("UF2_Actividad 7");
        instrucciones(); //este seria mi método.

        String letra = "";
        Scanner lector = new Scanner(System.in);

        while (!letra.equals("S")) {


            System.out.println("Elija una letra L, P, o T, para jugar:");
            letra = lector.nextLine().toUpperCase();

            //aqui quiero condicionar al usuario, a que no meta otra letra distinta

            while (!"LPTS".contains(letra)) {
                System.out.println("Entrada inválida. Solo se admite L, P, T o S. Intente de nuevo:");
                letra = lector.nextLine().toUpperCase(); // dudo de esto p (si sirve, no tocar jaja)/
            }// while

            if (letra.equals("S")) {
                System.out.println("Has salido del juego. ¡Gracias por jugar!");
                break;
            }

            //convierto el String del usuario en un chart, para poder compararlo con el char de la PC.
            char jugador = letra.charAt(0);

            char jugadaPC = jugadaOrdenador();
            System.out.println("La jugada del ordenador fue: " + jugadaPC);
            System.out.println(elegirGanador(jugador, jugadaPC));

        }
    }//main
        //metodo para instrucciones:
        public static void instrucciones() {
            System.out.println("En el juego Piedra, Papel o Tijera:");
            System.out.println(" - La piedra vence a la tijera.");
            System.out.println(" - La tijera vence al papel.");
            System.out.println(" - El papel vence a la piedra.");
            System.out.println("Para salir, pulse S.");
        }

        // metodo para jugada de ordenador
        public static char jugadaOrdenador(){
            char[] opciones = {'P', 'L', 'T'};
            int numero = (int)(Math.random() * 3);
            return opciones[numero];

        }//clase_jugadaordenador

        //metodo para decidir quien gana
        public static String elegirGanador(char jugador, char jugada){
        if (jugador == jugada){
            return "Empate";
        }else if ((jugador =='P' && jugada =='T') ||
                 (jugador=='T' && jugada =='L') ||
                 (jugador =='L' && jugada =='P')){
            return "Haz Ganado";
        }else{
            return "Gana el ordenador";
        }
        }// clase elegirGanador.

    }//class main

/* Aqui es donde viene la explicacion de a que no tengo idea de que hice. jajaja
1. Declare un metodo con las instrucciones, eso lo primero. porque por alguna extraña razón
pensé, que ocupaba metodos (para estar trayendo las instrucciones una y otra vez.
2. Seguido de eso hice otro metodo para hacer la jugada del ordenador.
3. y mas adelante hice el de como decidir quien gana.
4. Arriba hale las instrucciones del metodo.
5. Luego puse el while, que hace la repetición del juego una y otra vez. y lo finalice con un if, para el caso de que
el usuario toque la S, y tenga que salir.
6. Pedi las entradas al usuario, (su partida pues)
7. Luego hice un while para "restringir al usuario" y que no pueda meter otras letras.
8. paso a Char tanto la entrada del usuario, como la jugada del metodo que hice para el ordenador, (pues para poder
compararlos entre ellos y poder saber quien gana).
9. Lío total, pero funciona. jajaja


 */




