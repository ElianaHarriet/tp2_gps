package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonPantalla;
import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static edu.fiuba.algo3.vista.ElementManager.*;

public class Ayuda extends Pantalla {

    private final int anchoVentana = 1050;
    private final int altoVentana = 525;
    private final int anchoBoton = 35;
    private final int altoBoton = 20;
    private final String pathFondo = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/finDePartida.jpg";
    private final String colorTexto = "#f2d8a5";
    private final String colorBoton = "#57633c";

    @Override
    public void start(Stage stage) {
        Group elementos = new Group();
        Pane panel = new Pane();
        elementos.getChildren().add(panel);

        ImageView titulo = crearImageView(pathFondo, 0, 0, anchoVentana);
        panel.getChildren().add(titulo);

        String txt = "Estás en la ciudad de Lanús, tu objetivo es escapar en la menor cantidad de movimientos posibles porque es de noche y en dentro de poco ya no se va a poder ver nada (explotó un generador y ya no hay luz en las calles). Para ello tenes la opción de elegir una moto, un auto o una 4x4 algo oxidada. Cada uno tiene sus pro y sus contras, pero es algo que vas a conocer durante la marcha porque no hay tiempo para que te cuente, te tenés que ir muy rápido.\n" +
                "Preparate para afrontar problemas usuales del conurbano, pozos, controles policiales o piquetes, no queremos daños colaterales por lo que estos últimos sólo son atravesables por las motos.\n" +
                "También habrá sorpresas, podes verte favorecido por alguna resta mágica a los movimientos que hiciste hasta el momento (ese mecánico al que le llevamos los vehículos hizo cosas raras), o desfavorecido al obtener una suma en los movimientos (podes tomarlo como que fuiste a cargar nafta y hubo un aumento nada sorpresivo en estos días). La última sorpresa es que te roben el vehículo, entonces te daremos lo primero que tengamos a mano para que puedas seguir tu camino. Como toda sorpresa no vas a saber qué es lo que te espera hasta que te toque.";
        Font fuente = Font.font("Impact", FontWeight.BOLD, 30);
        Text texto = crearText(txt, anchoVentana / 2 - 305, 120, fuente, colorTexto, Color.BLACK, TextAlignment.RIGHT);
        panel.getChildren().add(texto);

        Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
        Button botonVolver = (new BotonPantalla(stage, new Inicio())).getBoton();
        disenarBoton(botonVolver, "\uD83E\uDC78", anchoBoton, altoBoton, 0, 0, colorBoton, fuenteBoton);
        elementos.getChildren().add(botonVolver);

        Scene scene = new Scene(elementos, anchoVentana, altoVentana);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
