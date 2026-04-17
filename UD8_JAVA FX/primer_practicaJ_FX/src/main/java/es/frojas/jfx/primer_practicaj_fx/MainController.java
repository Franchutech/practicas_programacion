package es.frojas.jfx.primer_practicaj_fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Mi primer proyecto Java FX");
    }
}