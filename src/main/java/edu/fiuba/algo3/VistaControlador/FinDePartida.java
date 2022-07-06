package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static edu.fiuba.algo3.Vista.ElementManager.*;


public class FinDePartida extends Application {
    private final int anchoVentana = 1050;
    private final int altoVentana = 525;
    private final int anchoBoton = 35;
    private final int altoBoton = 20;
    private final String pathFondo = "file:/src/main/java/edu/fiuba/algo3/Vista/media/img/finDePartida.jpg";
    private String nick;
    private int movimientos;
    private RankingManager rankingManager;

    public FinDePartida(String nick, int movimientos, RankingManager rankingManager) {
        this.nick = nick;
        this.movimientos = movimientos;
        this.rankingManager = rankingManager;
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Group elementos = new Group();
        Pane panel = new Pane();
        elementos.getChildren().add(panel);

        ImageView titulo = crearImageView(pathFondo, 0, 0, anchoVentana);
        panel.getChildren().add(titulo);

        String txt = movimientos < 15 ? "Felicidades " + nick + "!\n" + "Has escapado en tan solo\n" + movimientos + " movimientos" :
                     movimientos < 25 ? "Lo conseguiste " + nick + "!\n" + "Has escapado en\n" + movimientos + " movimientos" :
                     movimientos < 35 ? "Lograste escapar " + nick + "!\n" + "Lo hiciste en\n" + movimientos + " movimientos" :
                                        "Casi no salís " + nick + "!\n" + "Has escapado en\n" + movimientos + " movimientos";
        Font fuente = Font.font("Impact", FontWeight.EXTRA_BOLD, 50);
        Text texto = crearText(txt, anchoVentana / 2 - 305, (int)(altoVentana / 2.5), fuente, "#efbb7c", Color.BLACK, TextAlignment.CENTER);
        panel.getChildren().add(texto);

        Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
        Button botonVolver = crearButton("\uD83E\uDC78", anchoBoton, altoBoton, 0, 0, "#57633c", fuenteBoton);
        elementos.getChildren().add(botonVolver);
        botonVolver.setOnAction(e -> {
            stage.close();
            Inicio inicio = new Inicio();
            inicio.start(stage);
        });

        Button botonRanking = crearButton("Ranking", anchoBoton * 3, altoBoton, anchoVentana - anchoBoton * 3, 0, "#57633c", fuenteBoton);
        elementos.getChildren().add(botonRanking);
        botonRanking.setOnAction(e -> {
            stage.close();
            Ranking pantallaRanking = new Ranking(rankingManager);
            pantallaRanking.start(stage);
        });


        Scene scene = new Scene(elementos, anchoVentana, altoVentana);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
