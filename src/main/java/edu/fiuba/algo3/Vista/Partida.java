package edu.fiuba.algo3.Vista;
//modelo
import edu.fiuba.algo3.modelo.Constructor.ConstructorJuego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.*;
import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;
//javafx
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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

//herramientas de java
import java.util.ArrayList;

public class Partida extends Application {
    //pasar a mayusculas que son constantes
    private final int altoTablero = 25;
    private final int anchoTablero = 25;
    private final int cantCuadras = 10;
    private final int margenIzq = 25;
    private final int margenInf = 25;
    // Acomodar para cada uno xd
    private final String rutaAuto = "file:/home/rueba/code/tp2_gps/src/main/java/edu/fiuba/algo3/Vista/res/auto.png";
    private final String rutaPiquete = "file:/home/rueba/code/tp2_gps/src/main/java/edu/fiuba/algo3/Vista/res/piquete.png";
    private final String rutaControlPolicial = "file:/home/rueba/code/tp2_gps/src/main/java/edu/fiuba/algo3/Vista/res/controlpolicial.png";
    private final int tamCuadra = 50;
    private final int anchoCalle = 15;
    private String vehiculo;
    private String nick;

    public Partida(String nick, String vehiculo) {
        this.nick = nick;
        this.vehiculo = vehiculo;
    }

    public void start(Stage stage){
        ConstructorJuego cons = new ConstructorJuego();
        cons.crearJuego(cantCuadras, nick, vehiculo); //esto deberia recibirlo como parametro, despues hay que ver cuando se le pasaria esto
        Jugador jugador = cons.getResultado();
        Esquina[][] mapa = cons.getTablero();

        Group elementos = procesarTablero(mapa, cantCuadras);

        /*por alguna razon aca hacia lo siguente:
        Group grupo = procesarTablero(mapa, cantCuadras);
        Group elementos = new Group(grupo);
        */

        //capaz hay cierta persistencia y java no trabaja con copias como python, en ese caso se podria hacer que no devuelva nada y queda un poquito mas bonito
        elementos = agregarTablaMovimientos(jugador, elementos);

        //el texto lo agrego fuera de agregarTablaMovimientos porque hay que ir actualizando movimientosText
        Text movimientosText = new Text(730, 620, Integer.toString(jugador.getMovimientos()));
        movimientosText.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        movimientosText.setFill(Color.WHITE);
        elementos.getChildren().add(movimientosText);
        ImageView imagenVehiculo = setImagenInicialVehiculo(jugador, rutaAuto);


        //logica de teclas para moverse
        Pane pane = new Pane();
        pane.getChildren().add(imagenVehiculo);
        actualizarPosicion(jugador, imagenVehiculo);
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

        movimientosText.setText(Integer.toString(jugador.getMovimientos()));
        elementos.getChildren().add(pane);

        //hasta elementos.add(bar) ver si se puede mejorar, capaz haciendo un metodo.
        //y hacer que cada opcion haga lo que dice
        // -rive
        Menu opciones = new Menu("opciones");
        MenuItem opcion1 = new MenuItem("opcion1");
        opciones.getItems().add(opcion1);

        Menu uwu = new Menu("uwu");

        Menu sonido = new Menu("sonido");
        CheckMenuItem musica = new CheckMenuItem("Musica");
        CheckMenuItem sfx = new CheckMenuItem("Efectos especiales");
        sonido.getItems().addAll(musica,sfx);

        Menu ayuda = new Menu("ayuda");

        MenuBar bar = new MenuBar(opciones,uwu,sonido,ayuda);

        elementos.getChildren().add(bar);

        Scene scene = new Scene(elementos, altoTablero*30 + margenIzq, altoTablero*30 + margenInf);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("GPS - escape from Torcuato");
        pane.requestFocus();

    }

    

    private Group procesarTablero(Esquina[][] mapa, int cantCuadras){
        //crea el tablero y todo el fondo y lo devuelve en un grupo

        
        //no se porque llamamos "Esquina" a la esquina cuando enrealidad es una interseccion, la cual esta compuesta por 4 esquinas
        
        Group grupo = new Group();

        Color colorTablero = Color.rgb(71, 9, 124, 1);
        Rectangle fondo = new Rectangle(0,0, altoTablero*90, anchoTablero*90);
        fondo.setFill(colorTablero);
        grupo.getChildren().add(fondo);
        
        Rectangle calles = new Rectangle(margenIzq, margenInf, (tamCuadra+anchoCalle)*cantCuadras, (tamCuadra+anchoCalle)*cantCuadras);
        calles.setFill(Color.GRAY);
        grupo.getChildren().add(calles);

        //este forfor imprime las cuadras, cada cuadra empieza en la posicion indicada por la esquina y va para abajo a la derecha
        //tambien guarda las calles horizontales en un array con su posicion y tamaño y lo mismo con las verticales
        for(int i = 0; i < cantCuadras; i++) {
            for(int j = 0; j < cantCuadras; j++) {
                Esquina esq = mapa[i][j];

                int posX = esq.getX()*(tamCuadra+anchoCalle) + anchoCalle + margenIzq;
                int posY = (esq.getY()*(tamCuadra+anchoCalle)) + anchoCalle + margenInf;

                //cada esquina imprime la cuadra de abajo a la derecha
                Rectangle manzana = new Rectangle(posX,posY, tamCuadra ,tamCuadra);
                manzana.setFill(Color.PINK);
                grupo.getChildren().add(manzana);

                if (esq.esDestino()) {
                    Circle destino = new Circle();
                    destino.setStroke(Color.GREEN);
                    destino.setFill(Color.TRANSPARENT);
                    destino.setRadius(10);
                    destino.setCenterX(posX);
                    destino.setCenterY(posY);
                    grupo.getChildren().add(destino);
                }

                grupo = agregarElementosEste(grupo, esq); //ahora mismo solo les cambia una linea, deberia sacar las 47 que se quedan igual y solo pasarles la posicion acorde a ambas
                grupo = agregarElementosSur(grupo, esq);
            }
        }
        return grupo;
    }


    private Group agregarElementos(Group grupo, Esquina esq, int posX, int posY, Calle calle){
        Color colorNulo = new Color(1,1,1,0); //color que usamos para las sorpresas y obstaculos nulos

        if (calle == null) return grupo;
        ISorpresa sorpresa = calle.getSorpresa();
        
        Circle sorpresaPrinteada = new Circle(posX, posY , 5);
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
            sorpresaPrinteada.setFill(colorNulo);
        }
        grupo.getChildren().add(sorpresaPrinteada);



        IObstaculo obstaculo = calle.getObstaculo();
        Rectangle obstaculoPrinteado = new Rectangle(posX + 5, posY, 5, 5);
        Class claseObstaculo = obstaculo.getClass();
        ImageView obstaculoNuevo = new ImageView();

        if (claseObstaculo.equals(ControlPolicial.class)) {
            Image control = new Image(rutaControlPolicial);
            obstaculoNuevo.setImage(control);

            obstaculoPrinteado.setFill(Color.BLUE);
        }
        if (claseObstaculo.equals(Pozo.class)) {
            obstaculoPrinteado.setFill(Color.RED);
        }
        if (claseObstaculo.equals(Piquete.class)) {
            Image piquete = new Image(rutaPiquete);
            obstaculoNuevo.setImage(piquete);

            obstaculoPrinteado.setFill(Color.BROWN);
        }
        if (claseObstaculo.equals(ObstaculoNulo.class)) {
            obstaculoPrinteado.setFill(colorNulo);
        }
        grupo.getChildren().add(obstaculoPrinteado);

        obstaculoNuevo.setX(posX);
        obstaculoNuevo.setY(posY);

        obstaculoNuevo.setFitHeight(25);
        obstaculoNuevo.setPreserveRatio(true);

        grupo.getChildren().add(obstaculoNuevo);

        return grupo;
    }


    private Group agregarElementosEste(Group grupo, Esquina esq) {



        Calle calle = esq.getEste();
        int posX = (esq.getX()*(tamCuadra+anchoCalle)) + margenInf + (anchoCalle/2) + (tamCuadra/2);
        int posY = (esq.getY()*(tamCuadra+anchoCalle)) + margenIzq + (anchoCalle/2);

        return agregarElementos(grupo, esq, posX, posY, calle);

    }

    private Group agregarElementosSur(Group grupo, Esquina esq) {
        Calle calle = esq.getSur();
        int posX = (esq.getX()*(tamCuadra+anchoCalle)) + margenIzq+ (anchoCalle/2);
        int posY = (esq.getY()*(tamCuadra+anchoCalle)) + margenInf+ (anchoCalle/2) + (tamCuadra/2);

        return agregarElementos(grupo, esq, posX, posY, calle);
    }

    private ImageView setImagenInicialVehiculo(Jugador jugador, String rutaVehiculo){
        Image imagen = new Image(rutaVehiculo);
        ImageView imagenVehiculo = new ImageView();
        imagenVehiculo.setImage(imagen);
        imagenVehiculo.setX((jugador.getX()*(tamCuadra+anchoCalle))+margenIzq );
        imagenVehiculo.setY((jugador.getY()*(tamCuadra + anchoCalle)) + margenInf  );
        imagenVehiculo.setFitHeight(15);

        imagenVehiculo.setPreserveRatio(true);

        return imagenVehiculo;

    }


    private Group agregarTablaMovimientos(Jugador jugador, Group elementos){
        int movimientos = jugador.getMovimientos();
        Rectangle movimientosRect = new Rectangle(715, 600, 50, 50);
        movimientosRect.setFill(Color.rgb(71, 9, 124, 1));
        movimientosRect.setStroke(Color.rgb(11, 32, 142, 1));
        movimientosRect.setStrokeWidth(5);
        elementos.getChildren().add(movimientosRect);

        return elementos;
    }

    public void actualizarPosicion(Jugador jugador, ImageView imagenVehiculo) {
        //Si queres saber porque esta invertido volve a Algebra del CBC (nosotros tampoco sabemos porque).
        imagenVehiculo.setX((jugador.getX()*(tamCuadra + anchoCalle))+margenIzq );
        imagenVehiculo.setY((jugador.getY()*(tamCuadra + anchoCalle)) + margenInf );

    }

    public static void main(String[] args) {
        launch();
    }


}