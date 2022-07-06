package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Pantalla;
import edu.fiuba.algo3.vista.Partida;
import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Optional;

public class BotonVehiculo {

    private Button boton;

    public BotonVehiculo(Stage stage, String vehiculo, RankingManager rankingManager) {
        boton = new Button();
        boton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog("ElBrian");
            dialog.setHeaderText("Ingrese un nick (entre 5 y 15 caracteres)");
            Optional<String> input = dialog.showAndWait();
            String nombre = input.map(Objects::toString).orElse("");
            if ((nombre.length() >= 4 && nombre.length() <= 15)) {
                stage.close();
                Partida partida = new Partida(nombre, vehiculo, rankingManager);
                partida.start(stage);
            }
        });
    }

    public Button getBoton() {
        return boton;
    }
}
