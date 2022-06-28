package edu.fiuba.algo3;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.modelo.Constructor.ConstructorJuego;
import edu.fiuba.algo3.modelo.Constructor.ConstructorTablero;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.*;
import edu.fiuba.algo3.modelo.Mapa.EsquinaNormie;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
/*
* Este archivo tiene que ir en la carpeta Vista.
* Interfaz debe ser una clase que tenga metodos para poder mostrarse
* y acutalizarse que son llamados desde el Main principal que esta en
* edu.fiuba.algo3.
* */

public class Interfaz extends Application {
    @Override
    public void start(Stage stage) {
        String javaVersion = SystemInfo.javaVersion();
        String javafxVersion = SystemInfo.javafxVersion();
        int altoTablero = 25;
        int anchoTablero = 25;
        int cantCuadras = 10;
        int margenIzq = 25;
        int margenInf = 25;
//        Auto auto = new Auto();
        ConstructorJuego cons = new ConstructorJuego();
        cons.crearJuego(cantCuadras, "->BUCHGOD<-", "auto");
        Jugador jugador = cons.getResultado();
//        Jugador jugador = new Jugador(new EsquinaNormie(0, 5), "->ESSAYAGOD<-", auto);
        Rectangle fondo = new Rectangle(margenIzq,margenInf, altoTablero*80, anchoTablero*80);
        Color color = Color.rgb(71, 9, 124, 1); //el ultimo parametro es transparencia :D
        fondo.setFill(color);
        Group group = new Group(fondo);

        ////////////
        ConstructorJuego constructor = new ConstructorJuego();
        ConstructorTablero cTablero = constructor.getcTablero();
        cTablero.crearConTamanio(10);
        Esquina[][] mapa = cTablero.getMapa();
        ///////////


//        public Group(Collection<Node> var1);
        Collection<Node> grupo = new ArrayList<Node>();
        Collection<Node> esquinas = new ArrayList<Node>();
        for(int i = 0; i < cantCuadras; i++) {
            for(int j = 0; j < cantCuadras; j++){
                //grupo.add((Node)(new Rectangle((i*65) + margenIzq,(j*65) + margenInf,50 , 50)));
                Esquina esq = mapa[i][j];
                //las esquinass estan imprimiendo las cuadras, feo, pero por ahora sirve
                Rectangle calles = new Rectangle((esq.getX()*65) + margenIzq,(esq.getY()*65) + margenInf,70 , 70);
                Rectangle manzana = new Rectangle((esq.getX()*65) + margenIzq,(esq.getY()*65) + margenInf,50 , 50);
                calles.setFill(Color.GRAY);
                manzana.setFill(Color.PINK);

                Calle calle = esq.getNorte();



                grupo.add((Node)(calles));
                grupo.add((Node)(manzana));
            }
        }



        int xJugador = jugador.getX();
        int yJugador = jugador.getY();
        Rectangle autoXD = new Rectangle((yJugador*65) + margenIzq + 50,(xJugador*65) + margenInf + 50,15 , 15);
        autoXD.setFill(Color.RED);
        grupo.add((Node)(autoXD));

//        public Group(Collection<Node> var1);
        Group elementos = new Group(grupo);

        Button arriba = new Button("Arriba");
        arriba.setLayoutX(100);
        arriba.setLayoutY(700);
        arriba.setOnAction(e -> {
            jugador.moverseHacia(new Arriba());
        });
        elementos.getChildren().add(arriba);
        Scene scene = new Scene(elementos, altoTablero*30 + margenIzq, altoTablero*30 + margenInf);


        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }





    public static void main(String[] args) {
        launch();
    }

}
