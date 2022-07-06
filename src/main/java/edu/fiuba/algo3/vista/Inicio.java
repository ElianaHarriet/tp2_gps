package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.stage.Stage;
import static edu.fiuba.algo3.vista.ElementManager.*;


public class Inicio extends Pantalla {
    private final int anchoVentana = 1050;
    private final int altoVentana = 525;
    private final int anchoBoton = 100;
    private final int altoBoton = 60;
    private final String colorBoton = "#57643f";
    private final int yBoton = 300;
    private final Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
    private final String pathTitulo = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/inicio.jpeg";


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Group elementos = new Group();
        Pane panel = new Pane();
        elementos.getChildren().add(panel);

        //setear ventana inicial
        ImageView titulo = crearImageView(pathTitulo, 0, 0, anchoVentana);
        panel.getChildren().add(titulo);

        //boton jugar
        Button botonJugar = (new BotonPantalla(stage, new SeleccionVehiculo(rankingManager))).getBoton();
        disenarBoton(botonJugar, "Jugar", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 2, yBoton, colorBoton, fuenteBoton);
        elementos.getChildren().add(botonJugar);

        Button botonRanking = (new BotonPantalla(stage, new Ranking(rankingManager))).getBoton();
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
