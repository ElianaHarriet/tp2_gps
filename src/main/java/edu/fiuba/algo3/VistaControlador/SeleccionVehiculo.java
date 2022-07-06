package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Objects;
import java.util.Optional;
import static edu.fiuba.algo3.Vista.ElementManager.*;


public class SeleccionVehiculo extends Application {
    private final int anchoVentana = 1005;
    private final int altoVentana = 525;
    private final int anchoBoton = 110;
    private final int altoBoton = 50;
    private final String pathTitulo = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/seleccionVehiculos.jpeg";
    private final Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
    private RankingManager rankingManager;
    public SeleccionVehiculo(RankingManager rankingManager) {
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

        ImageView titulo = crearImageView(pathTitulo, 0, 0, anchoVentana);
        panel.getChildren().add(titulo);

        Button botonAuto = crearButton("Auto", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 2, 450, "#a55d31", fuenteBoton);
        elementos.getChildren().add(botonAuto);
        botonAuto.setOnAction(e -> {
            iniciarPartida(stage, "auto");
        });

        Button botonMoto = crearButton("Moto", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 9, 450, "#b2793c", fuenteBoton);
        elementos.getChildren().add(botonMoto);
        botonMoto.setOnAction(e -> {
            iniciarPartida(stage, "moto");
        });
        
        Button botonCamioneta = crearButton("4x4", anchoBoton, altoBoton, 8 * (anchoVentana - anchoBoton) / 9, 450, "#a14836", fuenteBoton);
        elementos.getChildren().add(botonCamioneta);
        botonCamioneta.setOnAction(e -> {
            iniciarPartida(stage, "camioneta");
        });

        Button botonVolver = crearButton("\uD83E\uDC78", anchoBoton / 3, altoBoton / 3, 0, 0, "#a67f5a", fuenteBoton);
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

    private void iniciarPartida(Stage stage, String vehiculo) {
        TextInputDialog dialog = new TextInputDialog("ElBrian");
        dialog.setHeaderText("Ingrese un nick (entre 5 y 15 caracteres)");
        Optional<String> input = dialog.showAndWait();
        String nombre = input.map(Objects::toString).orElse("");
        if ((nombre.length() >= 4 && nombre.length() <= 15)) {
            stage.close();
            Partida partida = new Partida(nombre, vehiculo, rankingManager);
            partida.start(stage);
        }
    }
}
