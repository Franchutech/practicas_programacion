module es.frojas.jfx.apppersonasfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens es.frojas.jfx.apppersonasfx to javafx.fxml;
    exports es.frojas.jfx.apppersonasfx;
}