package edu.fiuba.algo3.Vista;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Inicio extends Application {

    private final int anchoVentana = 1050;
    private final int altoVentana = 525;
    private final int anchoBoton = 100;
    private final int altoBoton = 60;
    private final String pathTitulo = "file:/home/rueba/code/tp2_gps/src/main/java/edu/fiuba/algo3/Vista/res/361DAEB8-EFF2-4BA1-BC46-58F6663DA56A.jpeg";

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

        Button botonJugar = new Button("Jugar");
        botonJugar.setPrefSize(anchoBoton, altoBoton);
        botonJugar.setStyle("-fx-background-color: #6a815c;");
        botonJugar.setFont(Font.font("Impact", FontWeight.BOLD, 17));
        elementos.getChildren().add(botonJugar);
        botonJugar.setLayoutX((anchoVentana - anchoBoton) / 2);
        botonJugar.setLayoutY(300);
        botonJugar.setOnAction(e -> {
            //abrir menu partida
            stage.close();
            Partida partida = new Partida();
            partida.start(new Stage());
        });

        Button botonRanking = new Button("Ranking");
        botonRanking.setPrefSize(anchoBoton, altoBoton);
        botonRanking.setStyle("-fx-background-color: #6a815c;");
        botonRanking.setFont(Font.font("Impact", FontWeight.BOLD, 17));
        elementos.getChildren().add(botonRanking);
        botonRanking.setLayoutX((anchoVentana - anchoBoton) / 3);
        botonRanking.setLayoutY(300);
        botonRanking.setOnAction(e -> {
            //abrir ranking
//            titulo.setText("Ranking xd");
        });

        Button botonAyuda = new Button("Ayuda");
        botonAyuda.setPrefSize(anchoBoton, altoBoton);
        botonAyuda.setStyle("-fx-background-color: #6a815c;");
        botonAyuda.setFont(Font.font("Impact", FontWeight.BOLD, 17));
        elementos.getChildren().add(botonAyuda);
        botonAyuda.setLayoutX(2 * (anchoVentana - anchoBoton) / 3);
        botonAyuda.setLayoutY(300);
        botonAyuda.setOnAction(e -> {
            //abrir ayuda
//            titulo.setText("Ayuda xd");
        });

        Scene scene = new Scene(elementos, anchoVentana, altoVentana);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
