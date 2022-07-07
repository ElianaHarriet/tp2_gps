package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.TeFaltaCalleError;
import edu.fiuba.algo3.TeFaltaCarroError;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.*;
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

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

import static edu.fiuba.algo3.Vista.ElementManager.crearImageView;

public class Partida extends Application {
    private final int altoTablero = 25;
    private final int anchoTablero = 25;
    private final int cantCuadras = 10;
    private final int margenIzq = 25;
    private final int margenInf = 25;

    private final String rutaAuto = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Vehiculos/auto.png";
    private final String rutaMoto = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Vehiculos/moto.png";
    private final String rutaCamioneta = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Vehiculos/camioneta.png";
    private final String rutaPiquete = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Mapa/piquete.png";
    private final String rutaControlPolicial = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Mapa/controlpolicial.png";
    private final String rutaPozo = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Mapa/pozo.png";
    private final String rutaSorpresa = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Mapa/sorpresa.png";
    private final String rutaMeta = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Mapa/meta.png";
    private final String rutaFondo = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Fondos/fondoPartida.jpg";
    private final int tamCuadra = 50;
    private final int anchoCalle = 15;

    private Shape fog;
    private Controlador controlador;

    public Partida(Controlador controlador) {
        this.controlador = controlador;
    }

    public void start(Stage stage){
        Esquina[][] mapa = controlador.getMapa();
        AtomicReference<Jugador> jugador = new AtomicReference<>(controlador.getJugadorActual());

        Group elementos = procesarTablero(mapa, cantCuadras);

        String strMovimientos = Integer.toString(jugador.get().getMovimientos());
        String cero = jugador.get().getMovimientos() < 10 ? "0" : "";
        Text movimientosText = new Text(575, 773, cero + strMovimientos);
        movimientosText.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        movimientosText.setFill(Color.WHITE);
        elementos.getChildren().add(movimientosText);

        Text nickJugador = new Text(120, 745, jugador.get().getNick());
        nickJugador.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        nickJugador.setFill(Color.WHITE);
        elementos.getChildren().add(nickJugador);

        ImageView imagenVehiculo = setImagenVehiculo(jugador.get());

        Pane pane = new Pane();
        pane.getChildren().add(imagenVehiculo);
        actualizarImagen(jugador.get(), imagenVehiculo);
        fog = crearFog(jugador.get());
        pane.getChildren().add(fog);

        this.controlador.setAudioMediaPlayer("src/main/java/edu/fiuba/algo3/Vista/media/audio/General/soundtrackPartida.mp3");

        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                try {
                    Calle calleAtravesada = controlador.moverJugadorHacia("arriba");
                    postMovimiento(stage, jugador, nickJugador, calleAtravesada);
                } catch (TeFaltaCalleError teFaltaCalleError) {
                    cartelTeFaltaCalle();
                }
            }
            if (e.getCode() == KeyCode.DOWN) {
                try {
                    Calle calleAtravesada = controlador.moverJugadorHacia("abajo");
                    postMovimiento(stage, jugador, nickJugador, calleAtravesada);
                } catch (TeFaltaCalleError teFaltaCalleError) {
                    cartelTeFaltaCalle();
                }
            }
            if (e.getCode() == KeyCode.RIGHT) {
                try {
                    Calle calleAtravesada = controlador.moverJugadorHacia("derecha");
                    postMovimiento(stage, jugador, nickJugador, calleAtravesada);
                } catch (TeFaltaCalleError teFaltaCalleError) {
                    cartelTeFaltaCalle();
                }
            }
            if (e.getCode() == KeyCode.LEFT) {
                try {
                    Calle calleAtravesada = controlador.moverJugadorHacia("izquierda");
                    postMovimiento(stage, jugador, nickJugador, calleAtravesada);
                } catch (TeFaltaCalleError teFaltaCalleError) {
                    cartelTeFaltaCalle();
                }
            }
            pane.getChildren().remove(fog);
            this.actualizarFog(jugador.get());
            pane.getChildren().add(fog);
            actualizarImagen(jugador.get(), imagenVehiculo);
            movimientosText.setText(Integer.toString(jugador.get().getMovimientos()));
        });
        movimientosText.setText(Integer.toString(jugador.get().getMovimientos()));
        elementos.getChildren().add(pane);

        Menu sonido = new Menu("sonido");
        CheckMenuItem musica = new CheckMenuItem("Musica");
        musica.setOnAction(e -> {
            if (!musica.isSelected()) {
                this.controlador.pausarMediaPlayer();
            }
            else {
                this.controlador.resumirMediaPlayer();
            }
        });
        musica.setSelected(true);

        sonido.getItems().addAll(musica);

        Menu ayuda = new Menu("ayuda");
        ayuda.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("    MOVIMIENTOS\n" +
                    "← : moverse hacia la izquierda\n" +
                    "→: moverse hacia la derecha\n" +
                    "↓: moverse hacia abajo\n" +
                    "↑: moverse hacia arriba\n" +
                    "œæ€®†¥øπå∫∂ƒ™¶§~Ω∑©√ßµ");

            alert.showAndWait();
        });
        MenuItem porFavor = new MenuItem("por favor");
        ayuda.getItems().add(porFavor);

        MenuBar barra = new MenuBar(sonido,ayuda);
        elementos.getChildren().add(barra);

        Scene scene = new Scene(elementos, altoTablero*30 + margenIzq, altoTablero*30 + margenInf);

        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("GPS - Escape from Lanús");
        pane.requestFocus();
    }
    
    private void postMovimiento(Stage stage, AtomicReference<Jugador> jugador, Text nickJugador, Calle calleAtravesada) {
        this.controlador.reproducirEfectoDeSonido(calleAtravesada);
        chequearSiTermino(stage, jugador, nickJugador);
        jugador.set(controlador.getJugadorActual());
        nickJugador.setText(jugador.get().getNick());
    }

    private void chequearSiTermino(Stage stage, AtomicReference<Jugador> jugador, Text nickJugador) {
        if (controlador.terminoElJuego()){
            stage.close();
            FinDePartida fin = new FinDePartida(controlador.getNick(), controlador);
            fin.start(stage);
            jugador.set(controlador.getJugadorActual());
            nickJugador.setText(jugador.get().getNick());
        }
    }

    private void cartelTeFaltaCalle() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Fin de la calle");
        alert.setContentText("Esa calle está cortada, no podes pasar");
        alert.showAndWait();
    }

    private void actualizarFog(Jugador jugador){
        fog = crearFog(jugador);
    }

    private Group procesarTablero(Esquina[][] mapa, int cantCuadras){
        //crea el tablero y todo el fondo y lo devuelve en un grupo
        Group grupo = new Group();

        ImageView fondoPartida = crearImageView(rutaFondo, 0, 0, 777);
        grupo.getChildren().add(fondoPartida);

        Rectangle calles = new Rectangle(margenIzq, margenInf, (tamCuadra+anchoCalle)*cantCuadras, (tamCuadra+anchoCalle)*cantCuadras);
        calles.setFill(Color.GRAY);
        grupo.getChildren().add(calles);

        //este for imprime las cuadras, cada cuadra empieza en la posicion indicada por la esquina y va para abajo a la derecha
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
                    Image imgFin = new Image(rutaMeta);
                    ImageView imgFinView = new ImageView(imgFin);
                    imgFinView.setFitWidth(80);
                    imgFinView.setPreserveRatio(true);
                    imgFinView.setX(posX - 40);
                    imgFinView.setY(posY - 15);
                    grupo.getChildren().add(imgFinView);
                }

                grupo = agregarElementosEste(grupo, esq);
                grupo = agregarElementosSur(grupo, esq);
            }
        }
        return grupo;
    }


    private Group agregarElementos(Group grupo, Esquina esq, int posX, int posY, Calle calle){

        if (calle == null) return grupo;
        ISorpresa sorpresa = calle.getSorpresa();

        Class claseDeSorpresa = sorpresa.getClass();
        ImageView sorpresaNueva = new ImageView();
        Image sorpresaImg = new Image(rutaSorpresa);

        if (claseDeSorpresa.equals(SorpresaFavorable.class)) {
            sorpresaNueva.setImage(sorpresaImg);
        }
        if (claseDeSorpresa.equals(SorpresaDesfavorable.class)) {
            sorpresaNueva.setImage(sorpresaImg);
        }
        if (claseDeSorpresa.equals(SorpresaCambioVehiculo.class)) {
            sorpresaNueva.setImage(sorpresaImg);
        }

        sorpresaNueva.setX(posX - 2);
        sorpresaNueva.setY(posY - 2);

        sorpresaNueva.setFitHeight(25);
        sorpresaNueva.setPreserveRatio(true);

        grupo.getChildren().add(sorpresaNueva);



        IObstaculo obstaculo = calle.getObstaculo();
        Class claseObstaculo = obstaculo.getClass();
        ImageView obstaculoNuevo = new ImageView();

        if (claseObstaculo.equals(ControlPolicial.class)) {
            Image control = new Image(rutaControlPolicial);
            obstaculoNuevo.setImage(control);
        }
        if (claseObstaculo.equals(Pozo.class)) {
            Image pozo = new Image(rutaPozo);
            obstaculoNuevo.setImage(pozo);
        }
        if (claseObstaculo.equals(Piquete.class)) {
            Image piquete = new Image(rutaPiquete);
            obstaculoNuevo.setImage(piquete);
        }

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

    private Shape crearFog(Jugador jugador){
        Rectangle rectangulo = new Rectangle(margenIzq,margenInf, altoTablero*25 + margenInf,altoTablero*25 + margenInf);
        Circle circulo = new Circle((jugador.getX()*(tamCuadra+anchoCalle))+margenIzq ,(jugador.getY()*(tamCuadra + anchoCalle)) + margenInf, 2*(tamCuadra + anchoCalle ));
        Shape fog = Shape.subtract(rectangulo, circulo);

        return fog;
    }


    public static void main(String[] args) {
        launch();
    }
}
