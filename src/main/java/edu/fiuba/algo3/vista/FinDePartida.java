package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonPantalla;
import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import static edu.fiuba.algo3.vista.ElementManager.*;


public class FinDePartida extends Application {

    private final int anchoVentana = 1050;
    private final int altoVentana = 525;
    private final int anchoBoton = 35;
    private final int altoBoton = 20;
    private final String pathFondo = "file:/src/main/java/edu/fiuba/algo3/vista/media/img/finDePartida.jpg";
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
                     movimientos < 35 ? "Lograste escapar" + nick + ",\n" + "lo hiciste después de\n" + movimientos + " movimientos" :
                                        "Casi no salís " + nick + "!\n" + "Has escapado en\n" + movimientos + " movimientos";
        Font fuenteTexto = Font.font("Impact", FontWeight.EXTRA_BOLD, 50);
        Text texto = crearText(txt, anchoVentana / 2 - 305, (int)(altoVentana / 2.5), fuenteTexto, "#efbb7c", Color.BLACK, TextAlignment.CENTER);
        panel.getChildren().add(texto);

        Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
        Button botonVolver = (new BotonPantalla(stage, new Inicio())).getBoton();
        disenarBoton(botonVolver, "\uD83E\uDC78", anchoBoton, altoBoton, 0, 0, "#57633c", fuenteBoton);
        elementos.getChildren().add(botonVolver);

        Button botonRanking = (new BotonPantalla(stage, new Ranking(rankingManager))).getBoton();
        disenarBoton(botonRanking, "Ranking", anchoBoton * 3, altoBoton, anchoVentana - anchoBoton * 3, 0, "#57633c", fuenteBoton);
        elementos.getChildren().add(botonRanking);

        Scene scene = new Scene(elementos, anchoVentana, altoVentana);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
