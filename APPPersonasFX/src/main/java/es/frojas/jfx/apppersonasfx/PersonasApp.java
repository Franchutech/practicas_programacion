package es.frojas.jfx.apppersonasfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonasApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PersonasApp.class.getResource("persona-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 640);
        stage.setTitle("App administración de Personas");
        stage.setScene(scene);
        stage.setResizable(false);//CON ESTO EL TAMAÑO DE LA VENTANA NO SE PUEDE CAMBIAR
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}