package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.Pantalla;
import edu.fiuba.algo3.Vista.Partida;
import edu.fiuba.algo3.Vista.SeleccionVehiculo;
import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Optional;

public class BotonVehiculo {

    private Button boton;

    public BotonVehiculo(Stage stage, String vehiculo, Controlador controlador, int cantJugadores) {
        boton = new Button();
        boton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog("Chayanne");
            dialog.setHeaderText("Ingrese un nick (entre 5 y 15 caracteres)");
            Optional<String> input = dialog.showAndWait();
            String nick = input.map(Objects::toString).orElse("");
            if ((nick.length() >= 4 && nick.length() <= 15)) {
                //NO SE TIENE QUE CREAR LA PARTIDA ACA Y PARA CAMBIAR ESO
                //HAY QUE CAMBIAR MUCHAS COSAS AAAAAAAAAA


                //Aca el controlador recibe un nick para el jugador actual
                //controlador.crearJugador(nick, vehiculo);

//                Partida partida = new Partida(controlador, nick, vehiculo);
//
//                partida.start(stage);
                controlador.agregarJugador(nick, vehiculo);
                stage.close();
                if (cantJugadores == 1) {
                    controlador.iniciarPartida();
                    Partida partida = new Partida(controlador);
                    partida.start(stage);
                } else {
                    Pantalla pantallaSelecion = new SeleccionVehiculo(controlador, cantJugadores - 1);
                    pantallaSelecion.start(stage);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El nick debe tener entre 5 y 15 caracteres");
                alert.showAndWait();
            }
        });
    }

    public Button getBoton() {
        return boton;
    }
}
