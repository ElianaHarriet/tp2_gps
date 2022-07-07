package edu.fiuba.algo3;


//import edu.fiuba.algo3.modelo.Esquina;
//import javafx.application.Application;
//import javafx.scene.*;
//import javafx.scene.image.ImageView;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.scene.image.Image;
//import edu.fiuba.algo3.modelo.Jugador.Jugador;
///*
//*
//*   PARA HACER
//*   - ordenar los imports
//*   - ver como conectar las posiciones de aca con las del mapa y la logica interna
//*   - para mover el wachin hay una funcion translate, todavia no la probe
//*   - modularizar bien
//*
//*
//public class Main extends Application {
//    @Override
//    public void start(Stage stage) {
//        Pane pane = new Pane();
//
//        stage.setScene(new Scene(pane, 640, 480));
//        stage.setTitle("GPS");
//
//
//        for (int i = 0; i < 20; i++) {
//            Rectangle cuadra = new Rectangle(10 + i*35,10,30,30);
//            pane.getChildren().add(cuadra);
//            for (int j = 0; j < 20; j++) {
//                Rectangle cuadra2 = new Rectangle(10 + i*35,10 + j*35,30,30);
//                pane.getChildren().add(cuadra2);
//            }
//        }
//
//        Jugador jugador = new Jugador(new Esquina(false), "Ben10");
//        int xJugador = 40;
//        int yJugador = 285;
//        //ImageView auto = new ImageView(new Image(getClass().getResourceAsStream("/res/auto.png")));
//        //auto.setX(xJugador);
//        //auto.setY(yJugador);
//        //auto.setFitWidth(5);
//        //pane.getChildren().add(auto);
//        stage.show();
//
//    }