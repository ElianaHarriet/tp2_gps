package edu.fiuba.algo3.VistaControlador;

import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static edu.fiuba.algo3.Vista.ElementManager.*;


public class Inicio extends Application {

    private final int anchoVentana = 1050;
    private final int altoVentana = 525;
    private final int anchoBoton = 100;
    private final int altoBoton = 60;
    private final String colorBoton = "#57643f";
    private final Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
    private final String pathTitulo = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/inicio.jpeg";
    private RankingManager rankingManager = new RankingManager("src/main/java/edu/fiuba/algo3/modelo/Ranking/ranking.json");
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
        Button botonJugar = crearButton("Jugar", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 2, 300, colorBoton, fuenteBoton);
        elementos.getChildren().add(botonJugar);
        botonJugar.setOnAction(e -> {
            stage.close();
            SeleccionVehiculo pantallaSeleccion = new SeleccionVehiculo(rankingManager);
            pantallaSeleccion.start(stage);
        });

        Button botonRanking = crearButton("Ranking", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 3, 300, colorBoton, fuenteBoton);
        elementos.getChildren().add(botonRanking);
        botonRanking.setOnAction(e -> {
            stage.close();
            Ranking pantallaRanking = new Ranking(rankingManager);
            pantallaRanking.start(stage);
        });

        Button botonAyuda = crearButton("Ayuda", anchoBoton, altoBoton, 2 * (anchoVentana - anchoBoton) / 3, 300, colorBoton, fuenteBoton);
        elementos.getChildren().add(botonAyuda);
        botonAyuda.setOnAction(e -> {
            //abrir ayuda
//            titulo.setText("Ayuda xd");
            /*


             */
        });


        Scene scene = new Scene(elementos, anchoVentana, altoVentana);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
