package es.frojas.jfx.apppersonasfx;

import es.frojas.jfx.apppersonasfx.model.Persona;
import es.frojas.jfx.apppersonasfx.model.SQLAccessPersona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PersonasController {
    private Persona pp;

    //OBSERVER REVISA CAMBIOS EN LA LSITA Y ACTUALIZA LA INTERFAZ
    private ObservableList<Persona> personas =  FXCollections.observableArrayList();


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}