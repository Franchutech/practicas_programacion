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
    }




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
    }


}//CIERRE PERSONAS CONTROLLER


