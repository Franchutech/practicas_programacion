package es.frojas.jfx.apppersonasfx.model;

public class Persona {

    //ATRIBUTOS

    private String dni;
    private String name;
    private String surname;
    private String email;
    private int age;
    private String phone;

    //CONSTRUCTOR LLENO

    public Persona(String dni, String name, String surname, String email, int age, String phone) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    //NUEVO CONSTRUCTOR PARA EL USO DE BUILDER

    public Persona(PersonaBuilder builder) {
        this.dni = builder.getDni();
        this.name = builder.getName();
        this.surname = builder.getSurname();
        this.email = builder.getEmail();
        this.age = builder.getAge();
        this.phone = builder.getPhone();
    }

    //CONSTRUCTOR VACIO
    public Persona() {
    }

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


    //SETTER


    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }

    //ESTO ES PARA LLAMAR A LA CLASE PERSONABUILDER  Y PODER USARLA EN EL CONSTRUCTOR

    public static PersonaBuilder builder() {
        return new PersonaBuilder();
    }



}//CIERRE CLASE PERSONA
