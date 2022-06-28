package edu.fiuba.algo3;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.EsquinaNormie;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/*
* Este archivo tiene que ir en la carpeta Vista.
* Interfaz debe ser una clase que tenga metodos para poder mostrarse
* y acutalizarse que son llamados desde el Main principal que esta en
* edu.fiuba.algo3.
* */

public class Interfaz extends Application {
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        Auto auto = new Auto();

        Jugador jugador = new Jugador(new EsquinaNormie(), "ESSAYAGOD???", auto);
        var label = new Label("Hello, " + jugador.getNick() + ", running on Java " /* + auto.getNombre()  */ + ".");

        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
