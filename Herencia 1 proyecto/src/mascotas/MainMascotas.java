package mascotas;

/* prueba del sistema de mascotas */
public class MainMascotas {

    public static void main(String[] args){

        Inventario inv = new Inventario(10);

        inv.insertar(new Perro("Boby",3,"OK","2021","Pastor"));
        inv.insertar(new Gato("Misu",2,"OK","2022","Negro"));
        inv.insertar(new Loro("Paco",4,"OK","2020","Fino",true,"Brasil"));
        inv.insertar(new Canario("Sol",1,"OK","2023","Corto",true,"Amarillo"));

        inv.mostrarTodos();
    }
}
