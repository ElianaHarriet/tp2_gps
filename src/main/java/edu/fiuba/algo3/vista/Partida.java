package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.TeFaltaCarroError;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.*;
import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import edu.fiuba.algo3.modelo.Sorpresas.*;
import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Vehiculos.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Partida extends Application implements IVista {
        //pasar a mayusculas que son constantes
    private final int altoTablero = 25;
    private final int anchoTablero = 25;
    private final int cantCuadras = 10;
    private final int margenIzq = 25;
    private final int margenInf = 25;

    private final String rutaAuto = "file:src/main/java/edu/fiuba/algo3/vista/media/img/auto.png";
    private final String rutaMoto = "file:src/main/java/edu/fiuba/algo3/vista/media/omg/moto.png";
    private final String rutaCamioneta = "file:src/main/java/edu/fiuba/algo3/vista/media/img/camioneta.png";
    private final String rutaPiquete = "file:src/main/java/edu/fiuba/algo3/vista/media/img/piquete.png";
    private final String rutaControlPolicial = "file:src/main/java/edu/fiuba/algo3/vista/media/img/controlpolicial.png";
    private final int tamCuadra = 50;
    private final int anchoCalle = 15;

    private RankingManager rankingManager;
    private Shape fog;
    private Controlador controlador;

    Stage stage;
    public Partida(String nombre,String vehiculo) {
        this.controlador = new Controlador();
        controlador.iniciarPartidaCon(nombre, vehiculo);

    }

    public void start(Stage stage){
        this.stage = stage;
        Esquina[][] mapa = controlador.getMapa();
        Jugador jugador = controlador.getJugador();

        Group elementos = procesarTablero(mapa, cantCuadras);

        //capaz hay cierta persistencia y java no trabaja con copias como python, en ese caso se podria hacer que no devuelva nada y queda un poquito mas bonito
        elementos = agregarTablaMovimientos(jugador, elementos);

        //el texto lo agrego fuera de agregarTablaMovimientos porque hay que ir actualizando movimientosText
        Text movimientosText = new Text(730, 620, Integer.toString(jugador.getMovimientos()));
        movimientosText.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        movimientosText.setFill(Color.WHITE);


        elementos.getChildren().add(movimientosText);
        ImageView imagenVehiculo = setImagenVehiculo(jugador);

        Pane pane = new Pane();
        pane.getChildren().add(imagenVehiculo);
        actualizarImagen(jugador, imagenVehiculo);
        fog = crearFog(jugador);
        pane.getChildren().add(fog);

        //String musicFile = "src/main/java/edu/fiuba/algo3/Vista/media/audio/piqueteSound.mp3";
        //Media sound = new Media(new File(musicFile).toURI().toString());
        //MediaPlayer mediaPlayer = new MediaPlayer(sound);
        //mediaPlayer.play();


        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                controlador.moverJugadorHacia(new Arriba());
            }
            if (e.getCode() == KeyCode.DOWN) {
                controlador.moverJugadorHacia(new Abajo());
            }
            if (e.getCode() == KeyCode.RIGHT) {
                controlador.moverJugadorHacia(new Derecha());
            }
            if (e.getCode() == KeyCode.LEFT) {
                controlador.moverJugadorHacia(new Izquierda());
            }

            pane.getChildren().remove(fog);
            this.actualizarFog(jugador);
            pane.getChildren().add(fog);
            actualizarImagen(jugador, imagenVehiculo);
            movimientosText.setText(Integer.toString(jugador.getMovimientos()));


        });
        movimientosText.setText(Integer.toString(jugador.getMovimientos()));
        elementos.getChildren().add(pane);

        Menu opciones = new Menu("opciones");
        MenuItem opcion1 = new MenuItem("opcion1");
        opciones.getItems().add(opcion1);
        Menu uwu = new Menu("uwu");

        Menu sonido = new Menu("sonido");
        CheckMenuItem musica = new CheckMenuItem("Musica");
        CheckMenuItem efectos = new CheckMenuItem("Efectos");
        sonido.getItems().addAll(musica,efectos);

        Menu ayuda = new Menu("ayuda");
        MenuItem porFavor = new MenuItem("por favor");

        ayuda.getItems().add(porFavor);

        MenuBar bar = new MenuBar(opciones,uwu,sonido,ayuda);


        elementos.getChildren().add(bar);


        Scene scene = new Scene(elementos, altoTablero*30 + margenIzq, altoTablero*30 + margenInf);

        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("GPS - Escape from Lanús");
        pane.requestFocus();

    }
    @Override
    public void terminarJuego() {
        rankingManager.guardarNuevaPuntuacion(controlador.getNick(), controlador.getMovimientosJugador());
        stage.close();
        FinDePartida fin = new FinDePartida(controlador.getNick(), controlador.getMovimientosJugador(), rankingManager);
        fin.start(stage);
    }

    private void actualizarFog(Jugador jugador){
        fog = crearFog(jugador);
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

    private ImageView setImagenVehiculo(Jugador jugador){
        String rutaVehiculo;
        Class claseVehiculo = jugador.getVehiculo().getClass();
        if (claseVehiculo.equals(Auto.class)) rutaVehiculo = rutaAuto;
        else if (claseVehiculo.equals(Moto.class)) rutaVehiculo = rutaMoto;
        else if (claseVehiculo.equals(Camioneta.class)) rutaVehiculo = rutaCamioneta;
        else throw new TeFaltaCarroError();

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

    public void actualizarImagen(Jugador jugador, ImageView imagenVehiculo) {
        imagenVehiculo.setX((jugador.getX()*(tamCuadra + anchoCalle)) + margenIzq );
        imagenVehiculo.setY((jugador.getY()*(tamCuadra + anchoCalle)) + margenInf );


        String rutaVehiculo;
        Class claseVehiculo = jugador.getVehiculo().getClass();
        if (claseVehiculo.equals(Auto.class)) rutaVehiculo = rutaAuto;
        else if (claseVehiculo.equals(Moto.class)) rutaVehiculo = rutaMoto;
        else if (claseVehiculo.equals(Camioneta.class)) rutaVehiculo = rutaCamioneta;
        else throw new TeFaltaCarroError();

        Image imagen = new Image(rutaVehiculo);
        imagenVehiculo.setImage(imagen);

    }

    private void actualizarVista(Pane pane,Shape anterior, Jugador judador){
        pane.getChildren().remove(anterior);
        Shape nueva = crearFog(judador);
        pane.getChildren().add(nueva);
    }
    private Shape crearFog(Jugador jugador){
        Rectangle rectangulo = new Rectangle(margenIzq,margenInf, altoTablero*25 + margenInf,altoTablero*25 + margenInf); // ELTAMAÑO DE LA PANTALLA ???? (altotablero*30 + margenizq)
        Circle circulo = new Circle((jugador.getX()*(tamCuadra+anchoCalle))+margenIzq ,(jugador.getY()*(tamCuadra + anchoCalle)) + margenInf, 2*(tamCuadra + anchoCalle ));
        Shape fog = Shape.subtract(rectangulo, circulo);

        return fog;
    }


    public static void main(String[] args) {
        launch();
    }
}
