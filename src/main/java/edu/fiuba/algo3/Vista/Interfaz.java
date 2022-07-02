package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Constructor.ConstructorJuego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.*;
import edu.fiuba.algo3.modelo.Obstaculos.*;

import edu.fiuba.algo3.modelo.Sorpresas.*;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


// para imagenes
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.EventListener;


/*
* Este archivo tiene que ir en la carpeta Vista.
* Interfaz debe llamarse partida
* edu.fiuba.algo3.
* */

public class Interfaz extends Application {

    private int altoTablero = 25;
    private int anchoTablero = 25;
    private int cantCuadras = 10;
    private int margenIzq = 25;
    private int margenInf = 25;

    private String rutaAuto = "file:C:\\home\\joaco\\1cuatri#actual\\algoritmos 3\\tp2_gps\\src\\main\\java\\edu\\fiuba\\algo3\\res\\auto.png";

    @Override
    public void start(Stage stage) {
        ConstructorJuego cons = new ConstructorJuego();
        cons.crearJuego(cantCuadras, "->BUCHGOD<-", "auto");
        Jugador jugador = cons.getResultado();
        Esquina[][] mapa = cons.getTablero();

        //IMPRIMIR TABLERO

        //MOSTRAR IMAGEN VEHICULO
        Image imagen = new Image(rutaAuto);
        ImageView imagenVehiculo = new ImageView();

        imagenVehiculo.setImage(imagen);
        imagenVehiculo.setX(jugador.getX());
        imagenVehiculo.setY(jugador.getY());
        imagenVehiculo.setFitHeight(15);
        imagenVehiculo.setPreserveRatio(true);


        Group grupo = procesarTablero(mapa, cantCuadras);

        Group elementos = new Group(grupo);

        int movimientos = jugador.getMovimientos();
        Rectangle movimientosRect = new Rectangle(715, 600, 50, 50);
        movimientosRect.setFill(Color.rgb(71, 9, 124, 1));
        movimientosRect.setStroke(Color.rgb(11, 32, 142, 1));
        movimientosRect.setStrokeWidth(5);
        Text movimientosText = new Text(730, 620, Integer.toString(movimientos));
        movimientosText.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        movimientosText.setFill(Color.WHITE);
//        movimientosRect.
        elementos.getChildren().add(movimientosRect);
        elementos.getChildren().add(movimientosText);



        Pane pane = new Pane();

        pane.getChildren().add(imagenVehiculo);



        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                jugador.moverseHacia(new Arriba());
                actualizarPosicion(jugador, imagenVehiculo);

                movimientosText.setText(Integer.toString(jugador.getMovimientos()));

            }
            if (e.getCode() == KeyCode.DOWN) {
                jugador.moverseHacia(new Abajo());
                actualizarPosicion(jugador, imagenVehiculo);

                movimientosText.setText(Integer.toString(jugador.getMovimientos()));
            }
            if (e.getCode() == KeyCode.RIGHT) {
                jugador.moverseHacia(new Derecha());
                actualizarPosicion(jugador, imagenVehiculo);

                movimientosText.setText(Integer.toString(jugador.getMovimientos()));
            }
            if (e.getCode() == KeyCode.LEFT) {
                jugador.moverseHacia(new Izquierda());
                actualizarPosicion(jugador, imagenVehiculo);

                movimientosText.setText(Integer.toString(jugador.getMovimientos()));
            }
        });


//logica de botones que no vamos a usar, rehacer con flechitas
        //event listener??
        /*KeyEvent event = new KeyEvent();
                @Override
                public void handle(KeyEvent event) {
                        controlador.teclaPresionada(jugador, event);
            }

        controlador.moverseHacia(event.getCode());*/


        //vista

        movimientosText.setText(Integer.toString(jugador.getMovimientos()));
        //vista
        elementos.getChildren().add(pane);

        Scene scene = new Scene(elementos, altoTablero*30 + margenIzq, altoTablero*30 + margenInf);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("GPS - escape from Torcuato");
        pane.requestFocus();
//      stage.close();
    }

    public void actualizarPosicion(Jugador jugador, ImageView imagenVehiculo) {
        int x = jugador.getX();
        int y = jugador.getY();
        imagenVehiculo.setX((y*65) + margenIzq + 50);
        imagenVehiculo.setY((x*65) + margenInf + 50);

    }
   /* @Override
    public void handle(KeyEvent event, Jugador jugador, Rectangle autoXD) {
        if (event.getCode() == KeyCode.UP) {
            controlador.moverseHacia(jugador, new Arriba());

        }
        if (event.getCode() == KeyCode.DOWN) {
            controlador.moverseHacia(jugador, new Abajo());

        }
        if (event.getCode() == KeyCode.RIGHT) {
            controlador.moverseHacia(jugador, new Derecha());

        }
        if (event.getCode() == KeyCode.LEFT) {
            controlador.moverseHacia(jugador, new Izquierda());

        }
    }*/


    private Group procesarTablero(Esquina[][] mapa, int cantCuadras){
        int tamCuadra = 50;
        int anchoCalle = 15;

        Rectangle fondo = new Rectangle(0,0, altoTablero*80, anchoTablero*80);
        Color color = Color.rgb(71, 9, 124, 1); //el ultimo parametro es transparencia :D
        fondo.setFill(color);
        Rectangle calles = new Rectangle(margenIzq, margenInf, (tamCuadra+anchoCalle)*cantCuadras, (tamCuadra+anchoCalle)*cantCuadras);
        calles.setFill(Color.GRAY);


        Group grupo = new Group(fondo, calles);

        //recorrido vertical
        for(int i = 0; i < cantCuadras; i++) {
            for(int j = 0; j < cantCuadras; j++){

                Esquina esq = mapa[i][j];
                //las esquinass estan imprimiendo las cuadras, feo, pero por ahora sirve
                Rectangle manzana = new Rectangle((esq.getX()*(tamCuadra+anchoCalle)) + margenIzq,(esq.getY()*(tamCuadra+anchoCalle)) + margenInf, tamCuadra ,tamCuadra);
               // calles.setFill(Color.GRAY);
                manzana.setFill(Color.PINK);

               // grupo.getChildren().add((Node)(calles));
                grupo.getChildren().add(manzana);
                ArrayList<Calle> callesVerticales = new ArrayList<>();
                ArrayList<Calle> callesHorizontales = new ArrayList<>();

                callesVerticales.add(esq.getNorte());
                callesVerticales.add(esq.getSur());

                callesHorizontales.add(esq.getEste());
                callesHorizontales.add(esq.getOeste());


                for(Calle callei : callesVerticales) {
                    if (callei != null) {
                        ISorpresa sorpresa = callei.getSorpresa();

                        Circle sorpresaPrinteada = new Circle((esq.getX() * (tamCuadra+anchoCalle)) + margenIzq + tamCuadra+(anchoCalle/2), (esq.getY() * (tamCuadra+anchoCalle)) + margenInf + tamCuadra/2, 5);
                        Class claseDeSorpresa = sorpresa.getClass();

                        if (claseDeSorpresa.equals(SorpresaFavorable.class)) {
                            sorpresaPrinteada.setFill(Color.GREEN);
                        }
                        if (claseDeSorpresa.equals(SorpresaDesfavorable.class)) {
                            sorpresaPrinteada.setFill(Color.RED);
                        }
                        if (claseDeSorpresa.equals(SorpresaCambioVehiculo.class)) {
                            sorpresaPrinteada.setFill(Color.BLUE);
                        }
                        if(claseDeSorpresa.equals(SorpresaNeutra.class)){
                            Color colorNulo = new Color(1,1,1, 0);
                            sorpresaPrinteada.setFill(colorNulo);
                        }
                        grupo.getChildren().add(sorpresaPrinteada);

                        IObstaculo obstaculo = callei.getObstaculo();
                        Rectangle obstaculoPrinteado = new Rectangle((esq.getX() * (tamCuadra+anchoCalle)) + margenIzq + tamCuadra+(anchoCalle/2), (esq.getY() * (tamCuadra+anchoCalle)) + margenInf + tamCuadra/2+5, 5, 5);

                        Class claseObstaculo = obstaculo.getClass();

                        //Color color = Color.rgb(71, 9, 124, 1); //el ultimo parametro es transparencia :D
                        if (claseObstaculo.equals(ControlPolicial.class)) {

                            obstaculoPrinteado.setFill(Color.BLUE);
                        }
                        if (claseObstaculo.equals(Pozo.class)) {
                            obstaculoPrinteado.setFill(Color.RED);
                        }
                        if (claseObstaculo.equals(Piquete.class)) {
                            obstaculoPrinteado.setFill(Color.BROWN);
                        }
                        if (claseObstaculo.equals(ObstaculoNulo.class)) {
                            Color colorNulo = new Color(1,1,1,0);
                            obstaculoPrinteado.setFill(colorNulo);
                        }

                        grupo.getChildren().add(obstaculoPrinteado);


                    }
                }

                for(Calle callej : callesHorizontales) {
                    if (callej != null) {
                        ISorpresa sorpresa = callej.getSorpresa();


                        Circle sorpresaPrinteada = new Circle((esq.getY() * (tamCuadra+anchoCalle)) + margenInf + tamCuadra/2, (esq.getX() * (tamCuadra+anchoCalle)) + margenIzq + tamCuadra+(anchoCalle/2), 5);

                        Class claseDeSorpresa = sorpresa.getClass();

                        if (claseDeSorpresa.equals(SorpresaFavorable.class)) {
                            sorpresaPrinteada.setFill(Color.GREEN);
                        }
                        if (claseDeSorpresa.equals(SorpresaDesfavorable.class)) {
                            sorpresaPrinteada.setFill(Color.RED);
                        }
                        if (claseDeSorpresa.equals(SorpresaCambioVehiculo.class)) {
                            sorpresaPrinteada.setFill(Color.BLUE);
                        }
                        if(claseDeSorpresa.equals(SorpresaNeutra.class)){
                            Color colorNulo = new Color(1,1,1, 0);
                            sorpresaPrinteada.setFill(colorNulo);
                        }
                        grupo.getChildren().add(sorpresaPrinteada);

                        IObstaculo obstaculo = callej.getObstaculo();
                        Rectangle obstaculoPrinteado = new Rectangle((esq.getY() * (tamCuadra+anchoCalle)) + margenInf + tamCuadra/2+5, (esq.getX() * (tamCuadra+anchoCalle)) + margenIzq + tamCuadra+(anchoCalle/2), 5, 5);

                        Class claseObstaculo = obstaculo.getClass();

                        //Color color = Color.rgb(71, 9, 124, 1); //el ultimo parametro es transparencia :D
                        if (claseObstaculo.equals(ControlPolicial.class)) {

                            obstaculoPrinteado.setFill(Color.BLUE);
                        }
                        if (claseObstaculo.equals(Pozo.class)) {
                            obstaculoPrinteado.setFill(Color.RED);
                        }
                        if (claseObstaculo.equals(Piquete.class)) {
                            obstaculoPrinteado.setFill(Color.BROWN);
                        }
                        if (claseObstaculo.equals(ObstaculoNulo.class)) {
                            Color colorNulo = new Color(1,1,1,0);
                            obstaculoPrinteado.setFill(colorNulo);
                        }

                        grupo.getChildren().add(obstaculoPrinteado);


                    }
                }

            }
        }
        return grupo;
    }


    public static void main(String[] args) {
        launch();
    }

}
