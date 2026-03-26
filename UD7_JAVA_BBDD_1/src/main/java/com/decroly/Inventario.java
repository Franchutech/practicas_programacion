package com.decroly;


import java.util.List;
import java.util.Scanner;


public class Inventario {
    public static void main(String[] args) {

        System.out.println("Iniciando sistema MercaDaw...");

        java.sql.Connection conn = SQLDataBaseManager.getConnection();

        if (conn != null) {
            System.out.println("Conexión a la base de datos de MercaDaw establecida correctamente...");
            Scanner input = new Scanner(System.in);

            int opcion;
            SQLAccessProducts acceso = new SQLAccessProducts();
            //LO DECLARO FUERA PARA USARLO EN TODAS LAS CLASES

            do {
            opcion = mostrarMenu(input);
            switch (opcion) {
                case 1:
                    System.out.println("MOSTRANDO TODOS LOS PRODUCTOS DEL INVENTARIO");
                    //LLAMO EL INSTANCIADO
                    List<Producto> productos = acceso.getProducto();
                    //3.FOR-EACH-RECORRIDO
                    for (Producto p: productos) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.println("BUSCAR PRODUCTO POR REFERENCIA");
                    System.out.println("Introduce el número de referencia (formato REF000)");
                    String ref = input.nextLine().trim();
                    //LLAMO EL INSTANCIADO
                    Producto encontrado = acceso.getProductsbyreference(ref);
                    if (encontrado != null) {
                        System.out.println("PRODUCTO ENCONTRADO");
                        System.out.println(encontrado);//llama al to string
                    }else {
                        System.out.println("No existe ningun producto con la referencia:" + ref);
                    }
                    break;
                case 3:
                    System.out.println("BUSCAR PRODUCTO POR TIPO");
                    System.out.println("Introduce el numero del Tipo (número del 1 al 9)");
                    int tipo = input.nextInt();
                    List<Producto>productosporTipo = acceso.getProductsbyTipo(tipo);
                    if (!productosporTipo.isEmpty()) {
                        System.out.println("PRODUCTO POR TIPO ENCONTRADO");
                        for (Producto p: productosporTipo) {
                            System.out.println(p);
                        }
                    }else {
                        System.out.println("No existe ningun producto con la Tipo:" + tipo);
                    }
                    break;
                case 4:
                    System.out.println("BUSCAR PRODUCTO POR CANTIDAD");
                    System.out.println("Introduzca la cantidad de inventario que desea buscar (sin comas ni puntos): ");
                    int stockLimite = input.nextInt();
                    List<Producto>listaPorCantidad = acceso.getProductsbyCantidad(stockLimite);
                    if (!listaPorCantidad.isEmpty()) {
                        System.out.println("PRODUCTO POR CANTIDAD ENCONTRADO");
                        for (Producto p: listaPorCantidad) {
                            System.out.println(p);
                        }
                    }else {
                        System.out.println("No hay en inventario ningún producto con esa Cantidad: " +
                                stockLimite);
                    }
                    break;
                case 5:
                    System.out.println("INSERTAR UN NUEVO PRODUCTO (No se permiten referencias repetidas)");
                    System.out.println("Introduce la referencia del nuevo producto (formato REF000)");
                    String nuevaReferencia = input.nextLine().trim();

                    Producto productoExistente = acceso.getProductsbyreference(nuevaReferencia);
                    if (productoExistente != null) {
                        System.out.println("ERROR: La referencia: " + nuevaReferencia +
                                " ya existe en la base de datos");
                        System.out.println("No es permitido insertar un producto ya existente, pruebe con otra referencia");
                    }else {
                        System.out.println("La Referencia introducida se encuentra disponible para su uso.");

                        try{
                            System.out.println("Introduzca el nombre del producto: ");
                            String nuevoNom = input.nextLine().trim();
                            System.out.println("Introduzca la descripcion del producto: ");
                            String nuevoDescripcion = input.nextLine().trim();
                            System.out.println("Introduzca el tipo de producto: ");
                            int nuevoTipo = input.nextInt();
                            System.out.println("Introduzca la cantidad del producto: ");
                            int nuevoCantidad = input.nextInt();
                            System.out.println("Introduzca el precio del producto: ");
                            double nuevoPrecio = input.nextDouble();
                            System.out.println("Introduzca el descuento del producto: ");
                            int nuevoDesc = input.nextInt();
                            System.out.println("Introduzca el impuesto del producto: ");
                            int nuevoImpuesto = input.nextInt();
                            System.out.println("¿Aplica descuento? (1=SÍ / 0=NO): ");
                            int opcDto = input.nextInt();
                            boolean aplica = (opcDto == 1);
                            input.nextLine();

                        //Con esa informacioon armo el objeto nuevo

                        Producto nuevo = new Producto(0, nuevaReferencia, nuevoNom, nuevoDescripcion, nuevoTipo,
                                nuevoCantidad, nuevoPrecio, nuevoDesc, nuevoImpuesto, aplica);

                        int resultado = acceso.insertarProductos(nuevo);
                        if (resultado > 0){
                            System.out.println("PRODUCTO INSERTADO CON ÈXITO EN LA BBDD");
                        }else {
                            System.out.println("PRODUCTO NO HA PODIDO INSERTARSE EN LA BBDD");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("ERROR: Formato de número no válido (revisa puntos y comas).");
                        input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Error inesperado: " + e.getMessage());
                        input.nextLine();
        }
    }//CIERRE DEL ELSE

                    break;
                case 6:
                    System.out.println("ELIMINAR PRODUCTO POR REFERENCIA");
                    System.out.println("Introduzca la referencia del producto que desea eliminar: (formato REF000) ");
                    String eliminarReferencia = input.nextLine().trim();
                    Producto eliminarProducto =  acceso.getProductsbyreference(eliminarReferencia);
                    if (eliminarProducto == null) {
                        System.out.println("ERROR: La referencia " + eliminarReferencia + " no existe.");
                    } else {
                        System.out.println("La referencia " + eliminarReferencia + " existe.");
                        System.out.print("¿Estás seguro? (1=SÍ / 0=NO): ");
                        int confirmacion = input.nextInt();
                        input.nextLine();

                        if (confirmacion == 1) {
                            int resultado = acceso.eliminarProductos(eliminarProducto);
                            if (resultado > 0) {
                                System.out.println("Producto eliminado de manera exitosa");
                            } else {
                                System.out.println("ERROR: No se pudo eliminar el producto");
                            }
                        }
                        else if (confirmacion == 0) {
                            System.out.println("Operación cancelada por el usuario");
                        }
                        else {
                            System.out.println("La confirmación: " + confirmacion + " no es una opción válida");
                        }
                    }
                    break;
                case 7:
                    System.out.println("ACTUALIZAR PRODUCTO");
                    System.out.println("Introduzca la referencia del producto que desea actualizar: (formato REF000) ");
                    String refEdit = input.nextLine().trim();

                    Producto pEncontrado =  acceso.getProductsbyreference(refEdit);

                    if (pEncontrado == null) {
                        System.out.println("ERROR: La referencia " + refEdit + " no existe.");
                    }else {
                        System.out.println("Editando la referencia: " + pEncontrado.getNombre() + " a continuación" +
                                " se le solicitarán los datos");

                        try {
                            System.out.print("Nueva Descripción: ");
                            String nDesc = input.nextLine().trim();

                            System.out.print("Nueva Cantidad: ");
                            int nCant = input.nextInt();

                            System.out.print("Nuevo Precio (usa punto para decimales): ");
                            double nPrecio = input.nextDouble();

                            System.out.print("Nuevo Descuento (entero): ");
                            int nDto = input.nextInt();

                            System.out.print("¿Aplica descuento? (1=SÍ / 0=NO): ");
                            int opc = input.nextInt();
                            boolean nAplica = (opc == 1);
                            input.nextLine();

                            int filas = acceso.actualizarProductos(refEdit, nDesc, nCant, nPrecio, nDto, nAplica);

                            if (filas > 0) {
                                System.out.println("¡Producto actualizado con éxito!");
                            } else {
                                System.out.println("No se pudieron guardar los cambios.");
                            }

                        } catch (Exception e) {
                            System.out.println("ERROR: Datos introducidos no válidos.");
                            input.nextLine();
                        }
                    }
                    break;
                case 8:
                    System.out.println("\n--- REGISTRAR NUEVO TIPO DE PRODUCTO ---");
                    System.out.print("Introduce el nombre de la nueva categoría (ej: Lácteos, Limpieza...): ");
                    String nombreNuevoTipo = input.nextLine().trim();

                    if (nombreNuevoTipo.isEmpty()) {
                        System.out.println("El nombre del tipo no puede estar vacío.");
                    } else {
                        int resultado = acceso.insertarNuevoTipo(nombreNuevoTipo);

                        if (resultado > 0) {
                            System.out.println("Nueva categoría '" + nombreNuevoTipo + "' añadida con éxito.");
                            System.out.println("Ahora ya puedes usar este tipo al insertar productos (Caso 5).");
                        } else {
                            System.out.println("No se pudo registrar la nueva categoría.");
                        }
                    }
                    break;
                case 9:
                    System.out.println("SALIENDO DE MERCADAW...");
                    break;
                    default:
                    System.out.println("Opción no válida. Por favor, elige entre 1 y 9.");
                break;
            }
        }while (opcion!=9);

    }else {
        System.out.println("ERROR: No se puede conectar a la base de datos");
    }

    }// CIERRE VOID MAIN


    //METODO PARA EL MENU

    public static int mostrarMenu(Scanner input) {
        System.out.println("\n BIENVENIDO A MERCADAW");
        System.out.println("\n  MENÚ PRINCIPAL");
        System.out.println("1. Mostrar todos los productos en el inventario");
        System.out.println("2. Buscar producto por referencia");
        System.out.println("3. Buscar producto por tipo");
        System.out.println("4. Buscar producto por cantidad");
        System.out.println("5. Insertar un nuevo producto"); //(no permitir referencias repetidas)
        System.out.println("6. Eliminar producto por referencia");  //referencia no valida
        System.out.println("7. Actualizar producto"); //(descripción, cantidad, precio, descuento, AplicarDto).
        System.out.println("8. Insertar un nuevo tipo de producto ");
        System.out.print("9. Salir.");

        String entrada = input.nextLine().trim();
        while (!entrada.matches("[1-9]")) {
            System.out.print("Opción no válida. Ingrese 1-9: ");
            entrada = input.nextLine().trim();
        }

        return Integer.parseInt(entrada);
    }


}//CIERRE INVENTARIO
