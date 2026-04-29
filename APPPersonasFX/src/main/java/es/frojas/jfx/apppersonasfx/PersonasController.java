package es.frojas.jfx.apppersonasfx;

import es.frojas.jfx.apppersonasfx.model.Persona;
import es.frojas.jfx.apppersonasfx.model.SQLAccessPersona;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonasController implements Initializable {
    private Persona pp;

    //OBSERVER REVISA CAMBIOS EN LA LSITA Y ACTUALIZA LA INTERFAZ
    private ObservableList<Persona> personas =  FXCollections.observableArrayList();

    //VARIABLES PARA PONER EL BOTON ENABLE
    boolean isDniValido = false, isNombreValido = false, isApellidosValido = false,
            isEmailValido = false, isTelefonoValido = false, isEdadValido = false;

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

    @FXML
    private Button guardarformButton;

    @FXML
    private ListView<Persona> personaslistView;



    //CODIGO QUE NECESITAMOS QUE SE EJECUTE DE PRIMERO VA EN ESTE METODO INITIALIZE
    @Override
    public void initialize(URL location, ResourceBundle resources){
        this.selectPanelVisible(0);
        this.clearFieldText();

        //INSERTAR LOS LISTENERS A LAS PROPIEDADES DE FOCUS

        this.dnitextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(dnitextf.getText())){
                    this.dnitextf.setText("");
                    this.dnitextf.setPromptText("Ingresar el DNI en formato correcto");
                    this.isDniValido = true;
                }
                else {
                    this.isDniValido = false;
                    this.guardarformButton.setDisable(this.isValidoFormulario());
                }
            }
        });

        this.nombretextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(nombretextf.getText())){
                    this.nombretextf.setText("");
                    this.nombretextf.setPromptText("Ingresar el nombre en formato correcto");
                    this.isNombreValido = true;
                }
                else {
                    this.isNombreValido = false;
                    this.guardarformButton.setDisable(this.isValidoFormulario());
                }
            }
        });

        this.apellidotextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(apellidotextf.getText())){
                    this.apellidotextf.setText("");
                    this.apellidotextf.setPromptText("Ingrese un apellido válido");
                    this.isApellidosValido = true;
                }
                else {
                    this.isApellidosValido = false;
                    this.guardarformButton.setDisable(this.isValidoFormulario());
                }
            }
        });
        this.emailtextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(emailtextf.getText())){
                    this.emailtextf.setText("");
                    this.emailtextf.setPromptText("Ingrese un email en el formato correcto");
                    this.isEmailValido = true;
                }
                else {
                    this.isEmailValido = false;
                    this.guardarformButton.setDisable(this.isValidoFormulario());
                }
            }
        });
        this.edadtextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(edadtextf.getText())){
                    this.edadtextf.setText("");
                    this.edadtextf.setPromptText("Ingrese un edad en formato correcto");
                    this.isEdadValido = true;
                }
                else {
                    this.isEdadValido = false;
                    this.guardarformButton.setDisable(this.isValidoFormulario());
                }
            }
        });

        this.telefonotextf.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(this.validation(telefonotextf.getText())){
                    this.telefonotextf.setText("");
                    this.telefonotextf.setPromptText("Ingrese un telefono en formato correcto");
                    this.isTelefonoValido = true;
                }
                else {
                    this.isTelefonoValido = false;
                    this.guardarformButton.setDisable(this.isValidoFormulario());
                }
            }
        });


    }//CIERRE CLASE INITIALIZE




    @FXML
    public void onInsertarButtonAction(ActionEvent actionEvent){
        this.selectPanelVisible(1);
}

    @FXML
    public void onBuscarButtonAction(ActionEvent actionEvent){

    }

    @FXML
    public void onVerButtonAction(ActionEvent actionEvent){
        this.selectPanelVisible(2);

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
        this.selectPanelVisible(0);

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
public boolean isValidoFormulario(){
        return (isDniValido && isNombreValido && isApellidosValido && isEmailValido &&
                isEdadValido && isTelefonoValido);
}

//PARA SELECCIONAR EL PANEL VISIBLE

    private void selectPanelVisible(int panel){
        switch (panel){
            case 0: //PRINCIPAL
                this.mainView.setVisible(true);
                this.listView.setVisible(false);
                this.formView.setVisible(false);
                break;
            case 1:
                this.mainView.setVisible(false);
                this.listView.setVisible(false);
                this.formView.setVisible(true);
                break;
            case 2:
                this.mainView.setVisible(false);
                this.listView.setVisible(true);
                this.formView.setVisible(false);
                break;
            case 3:
                this.mainView.setVisible(false);
                this.listView.setVisible(false);
                this.formView.setVisible(false);
                break;
            default:
                this.mainView.setVisible(true);
                this.listView.setVisible(false);
                this.formView.setVisible(false);
                break;
        }
    }


//EVENTOS BOTONES LIST VIEW

    public void onEditarListViewButton(ActionEvent actionEvent){

    }
    public void onEliminarListViewButton(ActionEvent actionEvent) {
    }

    public void onCancelListViewButton(ActionEvent actionEvent) {
        this.listView.setVisible(false);
        this.mainView.setVisible(true);
    }

}//CIERRE PERSONAS CONTROLLER


