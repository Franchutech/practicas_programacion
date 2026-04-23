package es.frojas.jfx.apppersonasfx.model;

//DEVUELVE OBJETOS DEL TIPO PERSONABUILDER

public class PersonaBuilder {

        //ATRIBUTOS

    private String dni;
    private String name;
    private String surname;
    private String email;
    private int age;
    private String phone;


    //GETTERS

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    //METODO

    public PersonaBuilder dni(String dni) {
        this.dni = dni;
        return this;
    }
    public PersonaBuilder name(String name) {
        this.name = name;
        return this;
    }
    public PersonaBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonaBuilder email(String email) {
        this.email = email;
        return this;
    }
    public PersonaBuilder age(int age) {
        this.age = age;
        return this;
    }
    public PersonaBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }
    public Persona build() {
        return new Persona(dni, name, surname, email, age, phone);
    }

    //CONSTRUCTOR POR DEFECTO
    public PersonaBuilder() {
    }

}//CIERRE PERSONABUILDER
