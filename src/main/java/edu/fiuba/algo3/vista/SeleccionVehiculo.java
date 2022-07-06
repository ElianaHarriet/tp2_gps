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


public class SeleccionVehiculo extends Pantalla {

    private final int anchoVentana = 1005;
    private final int altoVentana = 525;
    private final int anchoBoton = 110;
    private final int altoBoton = 50;
    private final String pathTitulo = "file:src/main/java/edu/fiuba/algo3/vista/media/img/seleccionVehiculos.jpeg";
    private final Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
    private final int yBoton = 450;
    private RankingManager rankingManager;
    public SeleccionVehiculo(RankingManager rankingManager) {
        this.rankingManager = rankingManager;
    }

    @Override
    public void start(Stage stage) {
        Group elementos = new Group();
        Pane panel = new Pane();
        elementos.getChildren().add(panel);

        ImageView titulo = crearImageView(pathTitulo, 0, 0, anchoVentana);
        panel.getChildren().add(titulo);

//        Button botonAuto = crearButton("Auto", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 2, 450, "#a55d31", fuenteBoton);
        Button botonAuto = (new BotonVehiculo(stage, "auto", rankingManager)).getBoton();
        disenarBoton(botonAuto, "Auto", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 2, yBoton, "#a55d31", fuenteBoton);
        elementos.getChildren().add(botonAuto);
//        botonAuto.setOnAction(e -> {
//            iniciarPartida(stage, "auto");
//        });

//        Button botonMoto = crearButton("Moto", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 9, 450, "#b2793c", fuenteBoton);
        Button botonMoto = (new BotonVehiculo(stage, "moto", rankingManager)).getBoton();
        disenarBoton(botonMoto, "Moto", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 9, yBoton, "#b2793c", fuenteBoton);
        elementos.getChildren().add(botonMoto);
//        botonMoto.setOnAction(e -> {
//            iniciarPartida(stage, "moto");
//        });

//        Button botonCamioneta = crearButton("4x4", anchoBoton, altoBoton, 8 * (anchoVentana - anchoBoton) / 9, 450, "#a14836", fuenteBoton);
        Button botonCamioneta = (new BotonVehiculo(stage, "moto", rankingManager)).getBoton();
        disenarBoton(botonCamioneta, "4x4", anchoBoton, altoBoton, 8 * (anchoVentana - anchoBoton) / 9, yBoton, "#a14836", fuenteBoton);
        elementos.getChildren().add(botonCamioneta);
//        botonCamioneta.setOnAction(e -> {
//            iniciarPartida(stage, "camioneta");
//        });

//        Button botonVolver = crearButton("\uD83E\uDC78", anchoBoton / 3, altoBoton / 3, 0, 0, "#a67f5a", fuenteBoton);
        Button botonVolver = (new BotonPantalla(stage, new Inicio())).getBoton();
        disenarBoton(botonVolver, "\uD83E\uDC78", anchoBoton / 3, altoBoton / 3, 0, 0, "#a67f5a", fuenteBoton);
        elementos.getChildren().add(botonVolver);
//        botonVolver.setOnAction(e -> {
//            stage.close();
//            Inicio inicio = new Inicio();
//            inicio.start(stage);
//        });

        Scene scene = new Scene(elementos, anchoVentana, altoVentana);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
