module es.frojas.jfx.primer_practicaj_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.frojas.jfx.primer_practicaj_fx to javafx.fxml;
    exports es.frojas.jfx.primer_practicaj_fx;
}