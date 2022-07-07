package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controlador.BotonPantalla;
import edu.fiuba.algo3.controlador.Controlador;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.security.auth.callback.TextInputCallback;
import java.util.Objects;
import java.util.Optional;

import static edu.fiuba.algo3.Vista.ElementManager.disenarBoton;

public class SeleccionModoDeJuego extends Pantalla {

    private final int anchoVentana = 1005;
    private final int altoVentana = 525;
    private final int ANCHOBOTON = 350;
    private final int ALTOBOTON = 75;
    private final Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
    private final int yBOTONSINGLE = 250;
    private final int yBOTONMULTI = 650;

    private final Controlador CONTROLADOR;
    public SeleccionModoDeJuego(Controlador controlador) {
        this.CONTROLADOR = controlador;
    }

    @Override
    public void start(Stage stage) {
        Group elementos = new Group();
        Pane panel = new Pane();
        elementos.getChildren().add(panel);

        int cantJugadores = 1;

        //boton singleplayer
        Button botonSingleplayer = new Button();
        disenarBoton(botonSingleplayer, "Jugar solo", ANCHOBOTON, ALTOBOTON, (anchoVentana - ANCHOBOTON) / 2, yBOTONSINGLE, "#550000", fuenteBoton);
        elementos.getChildren().add(botonSingleplayer);

        //boton multiplayer
        Button botonMultiplayer = new Button();
        disenarBoton(botonMultiplayer, "Multijugador", ANCHOBOTON, ALTOBOTON, (anchoVentana - ANCHOBOTON) / 2, yBOTONMULTI, "#550000", fuenteBoton);
        elementos.getChildren().add(botonMultiplayer);

        botonMultiplayer.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog("2");
            dialog.setHeaderText("Ingrese la cantidad de desafortunados que deben escapar de Lanus");
            Optional<String> input = dialog.showAndWait();
            String cantJugadoresString = input.map(Objects::toString).orElse("");
            if (!validarCantJugadores(cantJugadoresString)) {
                //printear dialogo que diga "dale flaco te pedi un numero no es tan dificil"
                //continue
            }

            cantJugadores = Integer.parseInt(cantJugadoresString);


        });

        for (int i = 0; i < cantJugadores; i++) {
            Pantalla pantallaSelecion = SeleccionVehiculo(CONTROLADOR);
            stage.close();
            pantallaSelecion.start(stage);
        }

        //////////////////////////////////
        Partida partida = new Partida(CONTROLADOR, nick, vehiculo);
        /////////////////////////////////
        partida.start(stage);

        Scene scene = new Scene(elementos, anchoVentana, altoVentana);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    public boolean validarCantJugadores(String cantJugadoresString) {
        try {
            int cantJugadores = Integer.parseInt(cantJugadoresString);
            if (cantJugadores < 1) {
                return false;}
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
