package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controlador.BotonPantalla;
import edu.fiuba.algo3.controlador.Controlador;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Optional;

import static edu.fiuba.algo3.Vista.ElementManager.crearImageView;
import static edu.fiuba.algo3.Vista.ElementManager.disenarBoton;

public class SeleccionModoDeJuego extends Pantalla {

    private final int anchoVentana = 1050;
    private final int altoVentana = 525;
    private final int ANCHOBOTON = 110;
    private final int ALTOBOTON = 50;
    private final Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);

    private final int yBoton = 450;
    private final String pathFondo = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Fondos/SeleccionModo.jpeg";

    private final Controlador CONTROLADOR;
    public SeleccionModoDeJuego(Controlador controlador) {
        this.CONTROLADOR = controlador;
    }

    @Override
    public void start(Stage stage) {
        Group elementos = new Group();
        Pane panel = new Pane();
        elementos.getChildren().add(panel);

        ImageView titulo = crearImageView(pathFondo, 0, 0, anchoVentana);
        panel.getChildren().add(titulo);

        Button botonVolver = (new BotonPantalla(stage, new Inicio())).getBoton();
        disenarBoton(botonVolver, "\uD83E\uDC78", ANCHOBOTON / 3, ALTOBOTON / 3, 0, 0, "#d6b77a", fuenteBoton);
        elementos.getChildren().add(botonVolver);

        //boton singleplayer
        Button botonSingleplayer = new Button();
        disenarBoton(botonSingleplayer, "Jugar solo", ANCHOBOTON, ALTOBOTON, (anchoVentana - ANCHOBOTON) / 9 + 10, yBoton, "#b02733", fuenteBoton);
        elementos.getChildren().add(botonSingleplayer);

        botonSingleplayer.setOnAction(e -> {
            Pantalla pantallaSelecion = new SeleccionVehiculo(CONTROLADOR, 1);
            stage.close();
            pantallaSelecion.start(stage);
        });



        //boton multiplayer
        Button botonMultiplayer = new Button();
        disenarBoton(botonMultiplayer, "Multijugador", (int)(ANCHOBOTON * 1.75), ALTOBOTON, (int)(25 * (anchoVentana - ANCHOBOTON * 1.75) / 36) + 10, yBoton, "#b02e27", fuenteBoton);
        elementos.getChildren().add(botonMultiplayer);

        botonMultiplayer.setOnAction(e -> {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setHeaderText(null);
            alert1.setTitle("Info");
            alert1.setContentText("MODO JUEGOS DEL HAMBRE: Sólo uno podrá salir");
            alert1.showAndWait();

            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setHeaderText(null);
            alert2.setTitle("Confirmacion");
            alert2.setContentText("No hay vuelta atrás, ¿confirmamos la operación?");
            if (alert2.showAndWait().get() == ButtonType.OK) {
                TextInputDialog dialog = new TextInputDialog("2");
                dialog.setHeaderText("Ingrese la cantidad de desafortunados que deben escapar de Lanús");
                Optional<String> input = dialog.showAndWait();
                String cantJugadoresString = input.map(Objects::toString).orElse("");
                if (!validarCantJugadores(cantJugadoresString)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Ingrese algo válido");
                    alert.showAndWait();
                } else {
                    int cantJugadores = Integer.parseInt(cantJugadoresString);

                    Pantalla pantallaSelecion = new SeleccionVehiculo(CONTROLADOR, cantJugadores);
                    stage.close();
                    pantallaSelecion.start(stage);
                }
            }
        });


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
