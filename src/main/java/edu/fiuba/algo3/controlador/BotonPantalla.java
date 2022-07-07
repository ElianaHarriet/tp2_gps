package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.Inicio;
import edu.fiuba.algo3.Vista.Pantalla;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonPantalla {
    private Button boton;

    public BotonPantalla(Stage stage, Pantalla pantalla) {
        boton = new Button();
        boton.setOnAction(e -> {
            stage.close();
            pantalla.start(stage);
        });
    }

    public BotonPantalla(Stage stage, Inicio pantalla) {
        boton = new Button();
        boton.setOnAction(e -> {
            stage.close();
            pantalla.start(stage);
        });
    }

    public Button getBoton() {
        return boton;
    }
}
