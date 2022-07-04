package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Optional;


public class SeleccionVehiculo extends Application {
    // ELIMINAR CODIGO REPETIDO

    private final int anchoVentana = 1005;
    private final int altoVentana = 525;
    private final int anchoBoton = 110;
    private final int altoBoton = 50;
    private final String pathTitulo = "file:/home/rueba/code/tp2_gps/src/main/java/edu/fiuba/algo3/Vista/res/seleccionVehiculos.jpeg";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Group elementos = new Group();
        Pane panel = new Pane();
        elementos.getChildren().add(panel);

        Image img = new Image(pathTitulo);
        ImageView titulo = new ImageView();
        titulo.setImage(img);
        titulo.setX(0);
        titulo.setY(0);
        titulo.setFitWidth(anchoVentana);
        titulo.setPreserveRatio(true);
        panel.getChildren().add(titulo);

        Button botonAuto = new Button("Auto");
        botonAuto.setPrefSize(anchoBoton, altoBoton);
        botonAuto.setStyle("-fx-background-color: #a55d31;");
        botonAuto.setFont(Font.font("Impact", FontWeight.BOLD, 17));
        elementos.getChildren().add(botonAuto);
        botonAuto.setLayoutX((anchoVentana - anchoBoton) / 2);
        botonAuto.setLayoutY(450);
        botonAuto.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog("ElBrian");
            dialog.setHeaderText("Ingrese un nick (entre 3 y 10 caracteres)");
            Optional<String> input = dialog.showAndWait();
            String nombre = input.map(Objects::toString).orElse("");
            if ((nombre.length() >= 3 && nombre.length() <= 10)) {
                botonAuto.setText(nombre);
                IVehiculo auto = new Auto();
                stage.close();
                Partida partida = new Partida(nombre, "auto");
                partida.start(stage);
            }
        });

        Button botonMoto = new Button("Moto");
        botonMoto.setPrefSize(anchoBoton, altoBoton);
        botonMoto.setStyle("-fx-background-color: #b2793c;");
        botonMoto.setFont(Font.font("Impact", FontWeight.BOLD, 17));
        elementos.getChildren().add(botonMoto);
        botonMoto.setLayoutX((anchoVentana - anchoBoton) / 9);
        botonMoto.setLayoutY(450);
        botonMoto.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog("ElBrian");
            dialog.setHeaderText("Ingrese un nick (entre 3 y 10 caracteres)");
            Optional<String> input = dialog.showAndWait();
            String nombre = input.map(Objects::toString).orElse("");
            if ((nombre.length() >= 3 && nombre.length() <= 10)) {
                botonAuto.setText(nombre);
                IVehiculo moto = new Moto();
                stage.close();
                Partida partida = new Partida(nombre, "moto");
                partida.start(stage);
            }
        });

        Button botonCamioneta = new Button("4x4");
        botonCamioneta.setPrefSize(anchoBoton, altoBoton);
        botonCamioneta.setStyle("-fx-background-color: #a14836;");
        botonCamioneta.setFont(Font.font("Impact", FontWeight.BOLD, 17));
        elementos.getChildren().add(botonCamioneta);
        botonCamioneta.setLayoutX(8 * (anchoVentana - anchoBoton) / 9);
        botonCamioneta.setLayoutY(450);
        botonCamioneta.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog("ElBrian");
            dialog.setHeaderText("Ingrese un nick (entre 3 y 10 caracteres)");
            Optional<String> input = dialog.showAndWait();
            String nombre = input.map(Objects::toString).orElse("");
            if ((nombre.length() >= 3 && nombre.length() <= 10)) {
                botonAuto.setText(nombre);
                stage.close();
                Partida partida = new Partida(nombre, "camioneta");
                partida.start(stage);
            }
        });

        Button botonVolver = new Button("\uD83E\uDC78");
        botonVolver.setPrefSize(anchoBoton / 3, altoBoton / 3);
        botonVolver.setStyle("-fx-background-color: #a67f5a;");
        botonVolver.setFont(Font.font("Impact", FontWeight.BOLD, 17));
        elementos.getChildren().add(botonVolver);
        botonVolver.setLayoutX(0);
        botonVolver.setLayoutY(0);
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
