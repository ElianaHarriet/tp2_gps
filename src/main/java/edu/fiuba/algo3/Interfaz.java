package edu.fiuba.algo3;

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

    @Override
    public void start(Stage stage) {
//me voy a hacer kung fu ahi vuelvo -no
        ConstructorJuego cons = new ConstructorJuego();
        cons.crearJuego(cantCuadras, "->BUCHGOD<-", "auto");
        Jugador jugador = cons.getResultado();
        Esquina[][] mapa = cons.getTablero();
//      Jugador jugador = new Jugador(new EsquinaNormie(0, 5), "->ESSAYAGOD<-", auto);
//        public Group(Collection<Node> var1);
        //IMPRIMIR TABLERO

        Group tablero = this.procesarTablero(mapa, cantCuadras);


        int xJugador = jugador.getX();
        int yJugador = jugador.getY();
        Rectangle autoXD = new Rectangle((yJugador*65) + margenIzq + 50,(xJugador*65) + margenInf + 50,15 , 15);
        autoXD.setFill(Color.RED);


//        public Group(Collection<Node> var1);
        Group grupo = procesarTablero(mapa, cantCuadras);
        tablero.getChildren().add((Node)(autoXD));

        Group elementos = new Group(grupo);
        elementos.getChildren().add(autoXD);

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





        //creating the image object
        //File foto = new File("src/main/java/edu/fiuba/algo3/ejercicio-triangulos.png");
        //InputStream stream = new FileInputStream(foto);
       // Image image = new Image(stream);
        //Creating the image view
       // ImageView imageView = new ImageView();
        //Setting image to the image view
       // imageView.setImage(image);
        //Setting the image view parameters
       /* imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(575);
        imageView.setPreserveRatio(true);
        //Setting the Scene object
        Group root = new Group(imageView);
        elementos.getChildren().add(root);*/

        Scene scene = new Scene(elementos, altoTablero*30 + margenIzq, altoTablero*30 + margenInf);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("GPS - escape from Torcuato");


//logica de botones que no vamos a usar, rehacer con flechitas
        //event listener??
        KeyEvent event = new KeyEvent();
                @Override
                public void handle(KeyEvent event) {
                        controlador.teclaPresionada(jugador, event);
            }

        controlador.moverseHacia(event.getCode());


        //vista
        int x = jugador.getX();
        int y = jugador.getY();
        autoXD.setX((y*65) + margenIzq + 50);
        autoXD.setY((x*65) + margenInf + 50);
        movimientosText.setText(Integer.toString(jugador.getMovimientos()));
        //vista

//      stage.close();
    }


    @Override
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
    }


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
                Rectangle manzana = new Rectangle((esq.getX()*65) + margenIzq,(esq.getY()*65) + margenInf, tamCuadra ,tamCuadra);
               // calles.setFill(Color.GRAY);
                manzana.setFill(Color.PINK);

               // grupo.getChildren().add((Node)(calles));
                grupo.getChildren().add((manzana)
                ArrayList<Calle> calless = new ArrayList<>();
                calless.add(esq.getNorte());
                calless.add(esq.getSur());

                calless.add(esq.getEste());
                calless.add(esq.getOeste());


                for(Calle callea : calless) {
                    if (callea != null) {
                        ISorpresa sorpresa = callea.getSorpresa();

                        Circle sorpresaPrinteada = new Circle((esq.getX() * 65) + margenIzq + 35, (esq.getY() * 65) + margenInf + 35, 5);
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

                        IObstaculo obstaculo = callea.getObstaculo();
                        Rectangle obstaculoPrinteado = new Rectangle((esq.getX() * 65) + margenIzq + 25, (esq.getY() * 65) + margenInf + 25, 5, 5);

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
