package es.frojas.jfx.apppersonasfx;

import es.frojas.jfx.apppersonasfx.model.Persona;
import es.frojas.jfx.apppersonasfx.model.SQLAccessPersona;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonasController implements Initializable {
    private Persona pp;

    //OBSERVER REVISA CAMBIOS EN LA LSITA Y ACTUALIZA LA INTERFAZ
    private ObservableList<Persona> personas =  FXCollections.observableArrayList();

    @FXML
    private AnchorPane mainView;

    @FXML
    private AnchorPane formView;

    @FXML
    private AnchorPane listView;


    //CAMPOS DE TEXTO DEL FORMULARIO
    @FXML
    private TextField dnitextf;

    @FXML
    private TextField nombretextf;

    @FXML
    private TextField apellidotextf;

    @FXML
    private TextField emailtextf;

    @FXML
    private TextField edadtextf;

    @FXML
    private TextField telefonotextf;



    //CODIGO QUE NECESITAMOS QUE SE EJECUTE DE PRIMERO VA EN ESTE METODO INITIALIZE
    @Override
    public void initialize(URL location, ResourceBundle resources){
        this.mainView.setVisible(true);
        this.formView.setVisible(false);
        this.clearFieldText();

        //INSERTAR LOS LISTENERS A LAS PROPIEDADES DE FOCUS

        this.dnitextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(dnitextf.getText())){
                    this.dnitextf.setText("");
                    this.dnitextf.setPromptText("Ingresar el DNI en formato correcto");
                }
            }
        });

        this.nombretextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(nombretextf.getText())){
                    this.nombretextf.setText("");
                    this.nombretextf.setPromptText("Ingresar el nombre en formato correcto");
                }
            }
        });

        this.apellidotextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(apellidotextf.getText())){
                    this.apellidotextf.setText("");
                    this.apellidotextf.setPromptText("Ingrese un apellido válido");
                }
            }
        });
        this.emailtextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(emailtextf.getText())){
                    this.emailtextf.setText("");
                    this.emailtextf.setPromptText("Ingrese un email en el formato correcto");
                }
            }
        });
        this.edadtextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(edadtextf.getText())){
                    this.edadtextf.setText("");
                    this.edadtextf.setPromptText("Ingrese un edad en formato correcto");
                }
            }
        });

        this.telefonotextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(telefonotextf.getText())){
                    this.telefonotextf.setText("");
                    this.telefonotextf.setPromptText("Ingrese un telefono en formato correcto");
                }
            }
        });


    }//CIERRE CLASE INITIALIZE




    @FXML
    public void onInsertarButtonAction(ActionEvent actionEvent){
        this.mainView.setVisible(false);
        this.formView.setVisible(true);
}

    @FXML
    public void onBuscarButtonAction(ActionEvent actionEvent){

    }

    @FXML
    public void onVerButtonAction(ActionEvent actionEvent){
        this.mainView.setVisible(false);
        this.listView.setVisible(true);

    }

    @FXML
    public void onSalirButtonAction(ActionEvent actionEvent){
        Platform.exit();
    }

    @FXML
    public void onGuardarButttonClick(ActionEvent actionEvent){
        //GUARDAR EN EL FORMULARIO, INSERTAR EN EL SQL
        this.pp = Persona.builder()
                        .dni(this.dnitextf.getText())
                        .name(this.nombretextf.getText())
                        .surname(this.apellidotextf.getText())
                        .email(this.emailtextf.getText())
                        .age(Integer.parseInt(this.edadtextf.getText()))
                        .phone(this.telefonotextf.getText())
                        .build();

        if(SQLAccessPersona.createPersona(pp)){
            this.clearFieldText();
        }

    }

    @FXML
    public void onCancelarButtonClick(ActionEvent actionEvent){
        this.formView.setVisible(false);
        this.mainView.setVisible(true);

        this.clearFieldText();
    }

    private void clearFieldText(){
        this.dnitextf.clear();
        this.nombretextf.clear();
        this.apellidotextf.clear();
        this.edadtextf.clear();
        this.telefonotextf.clear();
        this.emailtextf.clear();

        this.dnitextf.setPromptText("Ingresse un DNI 12345678");
        this.nombretextf.setPromptText("Ingrese un nombre");
        this.apellidotextf.setPromptText("Ingrese un apellido");
        this.edadtextf.setPromptText("Ingrese una edad");
        this.telefonotextf.setPromptText("Ingrese un telefono");
        this.emailtextf.setPromptText("Ingrese un email xxxx@xxxx.com");
    }

    private boolean validation(String dni){
        return dni.matches("[1-9]{1,3}");
    }

    private boolean validationEmail(String email) {
    return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
}

private boolean validationPhone(String telefono) {
    return telefono.matches("[0-9]{9}");
}

private boolean validationNombre(String nombre) {
    // Acepta letras mayúsculas, minúsculas, tildes, ñ y espacios.
    return nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
}

private boolean validationApellido(String apellido) {
    return apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
}
private boolean validationEdad(String edad) {
    // Comprueba que solo haya números y que tenga entre 1 y 3 dígitos
    return edad != null && edad.trim().matches("[0-9]{1,3}");
}




}//CIERRE PERSONAS CONTROLLER


