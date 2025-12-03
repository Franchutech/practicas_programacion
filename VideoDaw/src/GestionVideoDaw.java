import java.util.Scanner;

public class GestionVideoDaw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //COMPROBACION DEL DNI

        String dniComprobado = MiUtils.comprobarPatronRepetidamente("[0-9]{8}[a-zA-Z]{1}",
                "Introduzca su DNI");

        //COMPROBACION DEL NUMSOCIO

        String numSocioComprobado = MiUtils.comprobarPatronRepetidamente("[a-zA-Z]{1}[-]{1}[0-9]{4}",
                "Introduzca un numero de socio");

        //COMPROBACION DEL NOMBRE DEL CLIENTE

        System.out.println("Introduzca el nombre del Cliente: ");
        String nombre = sc.nextLine();  //entrada del usuario tonto

                boolean nombreComprobado = false;
        do {
            //Leer la entrada del usuario tontoo
            nombre = sc.nextLine();

            //llamo el metodo y guardo el resultado en booleano
            boolean validacionExitosa = Cliente.validacionNombre(nombre);

            if  (!validacionExitosa) {
                System.out.println("Introduzca el titular valido");

            }else {
                System.out.println("Nombre del titular registrado: " + nombre);
                nombreComprobado = true;
            }

        }while(!nombreComprobado);


        //para prueba git










    /*La clase GestionVideoDaw pedirá los datos necesarios para realizar las gestiones y mostrará el
menú principal para permitir actuar sobre el video club. Tras cada acción se volverá a mostrar el
menú.
1. Crear y registrar VideoClub en la franquicia.
2. Registrar película en videoclub.
3. Crear y registrar cliente en videoclub.
4. Alquilar película.
5. Devolver película.
6. Dar de baja cliente.
7. Dar de baja película.
8. Salir. Termina el programa. */


    } //STATIC VOID MAIN

} //CLASS GESTION VIDEO DAW
