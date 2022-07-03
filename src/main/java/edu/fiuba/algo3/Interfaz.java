package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Constructor.ConstructorJuego;
import edu.fiuba.algo3.modelo.Constructor.ConstructorTablero;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.*;
import edu.fiuba.algo3.modelo.Obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.*;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        cons.crearJuego(cantCuadras - 1, "->BUCHGOD<-", "auto");
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

                grupo.add((Node)(calles));
                grupo.add((Node)(manzana));

                Calle calle = esq.getEste();
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
                        if (claseDeSorpresa.getName().equals("sorpresaFavorable")) {
                            sorpresaPrinteada.setFill(Color.GREEN);
                        }
                        if (claseDeSorpresa.getName().equals("sorpresaDesfavorable")) {
                            sorpresaPrinteada.setFill(Color.RED);
                        }
                        if (claseDeSorpresa.getName().equals("SorpresaCambioVehiculo")) {
                            sorpresaPrinteada.setFill(Color.BLUE);
                        }
                        if(claseDeSorpresa.getName().equals("SorpresaNula")){
                            Color colorNulo = new Color(1,1,1, 0);
                            sorpresaPrinteada.setFill(colorNulo);
                        }
                        grupo.add(sorpresaPrinteada);

                        IObstaculo obstaculo = callea.getObstaculo();
                        Rectangle obstaculoPrinteado = new Rectangle((esq.getX() * 65) + margenIzq + 25, (esq.getY() * 65) + margenInf + 25, 5, 5);

                        Class claseObstaculo = obstaculo.getClass();

                        //Color color = Color.rgb(71, 9, 124, 1); //el ultimo parametro es transparencia :D
                        if (claseObstaculo.getName().equals("control")) {
                            sorpresaPrinteada.setFill(Color.BLUE);
                        }
                        if (claseObstaculo.getName().equals("pozo")) {
                            sorpresaPrinteada.setFill(Color.RED);
                        }
                        if (claseObstaculo.getName().equals("piquete")) {
                            sorpresaPrinteada.setFill(Color.BROWN);
                        }
                        if (claseObstaculo.getName().equals("nulo")) {
                            Color colorNulo = new Color(1,1,1,0);
                            sorpresaPrinteada.setFill(colorNulo);
                        }

                        grupo.add(obstaculoPrinteado);

                    }
                }
            }
        }



        int xJugador = jugador.getX();
        int yJugador = jugador.getY();
        Rectangle autoXD = new Rectangle((yJugador*65) + margenIzq + 50,(xJugador*65) + margenInf + 50,15 , 15);
        autoXD.setFill(Color.RED);
        grupo.add((Node)(autoXD));

//        public Group(Collection<Node> var1);
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





        Button arriba = new Button("\uD83E\uDC79");
        arriba.setLayoutX(100);
        arriba.setLayoutY(700);
        arriba.setOnAction(e -> {
            jugador.moverseHacia(new Arriba());
            int x = jugador.getX();
            int y = jugador.getY();
            autoXD.setX((y*65) + margenIzq + 50);
            autoXD.setY((x*65) + margenInf + 50);
            movimientosText.setText(Integer.toString(jugador.getMovimientos()));
        });
        elementos.getChildren().add(arriba);

        Button abajo = new Button("\uD83E\uDC7B");
        abajo.setLayoutX(100);
        abajo.setLayoutY(730);
        abajo.setOnAction(e -> {
            jugador.moverseHacia(new Abajo());
            int x = jugador.getX();
            int y = jugador.getY();
            autoXD.setX((y*65) + margenIzq + 50);
            autoXD.setY((x*65) + margenInf + 50);
            movimientosText.setText(Integer.toString(jugador.getMovimientos()));
        });
        elementos.getChildren().add(abajo);

        Button derecha = new Button("\uD83E\uDC7A");
        derecha.setLayoutX(130);
        derecha.setLayoutY(715);
        derecha.setOnAction(e -> {
            jugador.moverseHacia(new Derecha());
            int x = jugador.getX();
            int y = jugador.getY();
            autoXD.setX((y*65) + margenIzq + 50);
            autoXD.setY((x*65) + margenInf + 50);
            movimientosText.setText(Integer.toString(jugador.getMovimientos()));
        });
        elementos.getChildren().add(derecha);

        Button izquierda = new Button("\uD83E\uDC78");
        izquierda.setLayoutX(70);
        izquierda.setLayoutY(715);
        izquierda.setOnAction(e -> {
            jugador.moverseHacia(new Izquierda());
            int x = jugador.getX();
            int y = jugador.getY();
            autoXD.setX((y*65) + margenIzq + 50);
            autoXD.setY((x*65) + margenInf + 50);
            movimientosText.setText(Integer.toString(jugador.getMovimientos()));
        });
        elementos.getChildren().add(izquierda);

        Scene scene = new Scene(elementos, altoTablero*30 + margenIzq, altoTablero*30 + margenInf);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("GPS - The Game");
//        stage.close();
    }

    public static void main(String[] args) {
        launch();
    }

}
