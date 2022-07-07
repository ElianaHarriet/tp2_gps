package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controlador.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

import static edu.fiuba.algo3.Vista.ElementManager.*;

/*
 * Falta:
 * Catch errores para que no salgan en la terminal
 * Revisar codigo por las dudas
 * Ejecutable
 * Informe + muchos demasiados de diagramas
 * Leer consigna del tp por las dudas
 * Resolver problemas de build para integrar con master
 */

public class Inicio extends Application {
    private final int anchoVentana = 1050;
    private final int altoVentana = 525;
    private final int anchoBoton = 100;
    private final int altoBoton = 60;
    private final String colorBoton = "#57643f";
    private final int yBoton = 300;
    private final Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
    private final String pathTitulo = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Fondos/inicio.jpeg";
    private final Controlador controlador = new Controlador();
    static private MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Group elementos = new Group();
        Pane panel = new Pane();
        elementos.getChildren().add(panel);

        String musicFile = "src/main/java/edu/fiuba/algo3/Vista/media/audio/General/menuSong.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        this.mediaPlayer = new MediaPlayer(sound);
        this.mediaPlayer.setAutoPlay(true);
        this.mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        this.mediaPlayer.setVolume(0.6);
        this.mediaPlayer.play();

        //setear ventana inicial
        ImageView titulo = crearImageView(pathTitulo, 0, 0, anchoVentana);
        panel.getChildren().add(titulo);

        //boton jugar
        Button botonJugar = (new BotonPantalla(stage, new SeleccionModoDeJuego(controlador))).getBoton();
        disenarBoton(botonJugar, "Jugar", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 2, yBoton, colorBoton, fuenteBoton);
        elementos.getChildren().add(botonJugar);

        Button botonRanking = (new BotonPantalla(stage, new Ranking(this.controlador))).getBoton();
        disenarBoton(botonRanking, "Ranking", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 3, yBoton, colorBoton, fuenteBoton);
        elementos.getChildren().add(botonRanking);

        Button botonAyuda = (new BotonPantalla(stage, new Ayuda())).getBoton();
        disenarBoton(botonAyuda, "Ayuda", anchoBoton, altoBoton, 2 * (anchoVentana - anchoBoton) / 3, yBoton, colorBoton, fuenteBoton);
        elementos.getChildren().add(botonAyuda);

        Scene scene = new Scene(elementos, anchoVentana, altoVentana);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();



    }
}