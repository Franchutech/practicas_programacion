public class Coche {

    //Defino los atributos

    private String color;
    private String marca;

    //HAGO EL CONSTRUCTOR PARA ESOS ATRIBUTOS

    public Coche(String color, String marca) {
        setColor(color);
        setMarca(marca);
    }

    //VALIDACION DE DATOS
    public boolean validarColor (String color){
    return color.matches("^[A-Z][a-zA-Z]*$");
    } //VALIDACION1
    public boolean validarMarca (String marca){
        return marca.matches("^[A-Z][a-zA-Z]*$");
    }//VALIDACION2

    //SETTERS

    public void setColor(String color) {
        if (validarColor(color)) {
            this.color = color;
        }else  {
            System.out.println("color invalido");
        }
    }//SETTER1
    //REVISION PARA GITHUB

    public void setMarca(String marca) {
        if (validarMarca(marca)) {
            this.marca = marca;
        }else   {
            System.out.println("marca invalido");
        }
    }//SETTER2

    //GETTERS

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Coche [color=" + color + ", marca=" + marca + "]";
    }


}//CLASE COCHE

