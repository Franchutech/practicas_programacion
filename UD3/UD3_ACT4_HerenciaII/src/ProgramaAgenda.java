
public class ProgramaAgenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.anadirContacto(new ContactoPersona("Ana", "123456", "01/01/2000"));
        agenda.anadirContacto(new ContactoEmpresa("Decroly", "987654", "www.decroly.com"));

        agenda.listarContactos();

        System.out.println("Existe Ana: " + agenda.existeContacto("Ana"));
        agenda.eliminarContacto("Ana");
        agenda.listarContactos();
    }
}