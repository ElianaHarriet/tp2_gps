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

import java.lang.reflect.Array;

import static edu.fiuba.algo3.Vista.ElementManager.*;


public class Ranking extends Application {

    private final int anchoVentana = 1050;
    private final int altoVentana = 525;
    private final int anchoBoton = 35;
    private final int altoBoton = 20;
    private final String pathFondo = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/finDePartida.jpg";
    private final String colorTexto = "#f2d8a5";
    private final String colorBoton = "#57633c";
    private RankingManager rankingManager;

    public Ranking(RankingManager rankingManager) {
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

        Font fuenteTitulo = Font.font("Impact", FontWeight.BOLD, 55);
        Text ranking = crearText("✩ Top 10 ✩", anchoVentana / 2 - 150, 60, fuenteTitulo, "#f2d8a5", Color.BLACK, TextAlignment.CENTER);
        panel.getChildren().add(ranking);


        String txt = rankingManager.obtenerRanking();
        int contadorLineas = 0;
        for (int i = 0; i < txt.length(); i++) {
            char caracterActual = txt.charAt(i);
            if(contadorLineas == 10) {
                txt = txt.substring(0,i);
                break;
            }
            if(caracterActual == '\n'){
                contadorLineas++;
            }
        }
        Font fuenteRanking = Font.font("Impact", FontWeight.BOLD, 30);
        Text texto = crearText(txt, anchoVentana / 2 - 305, 120, fuenteRanking, colorTexto, Color.BLACK, TextAlignment.RIGHT);
        panel.getChildren().add(texto);

        Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
        Button botonVolver = crearButton("\uD83E\uDC78", anchoBoton, altoBoton, 0, 0, colorBoton, fuenteBoton);
        elementos.getChildren().add(botonVolver);
        botonVolver.setOnAction(e -> {
            stage.close();
            Inicio inicio = new Inicio();
            inicio.start(stage);
        });

        Scene scene = new Scene(elementos, anchoVentana, altoVentana);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
