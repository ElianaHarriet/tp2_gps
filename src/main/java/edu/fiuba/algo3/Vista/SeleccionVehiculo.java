package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controlador.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.stage.Stage;
import static edu.fiuba.algo3.Vista.ElementManager.*;


public class SeleccionVehiculo extends Pantalla {

    private final int anchoVentana = 1050;
    private final int altoVentana = 525;
    private final int anchoBoton = 110;
    private final int altoBoton = 50;
    private final String pathTitulo = "file:src/main/java/edu/fiuba/algo3/Vista/media/img/Fondos/seleccionVehiculos.jpeg";
    private final Font fuenteBoton = Font.font("Impact", FontWeight.BOLD, 17);
    private final int yBoton = 450;
    private final int cantJugadores;
    private Controlador controlador;
    public SeleccionVehiculo(Controlador controlador, int cantJugadores) {
        this.controlador = controlador;
        this.cantJugadores = cantJugadores;
    }

    @Override
    public void start(Stage stage) {
        Group elementos = new Group();
        Pane panel = new Pane();
        elementos.getChildren().add(panel);

        ImageView titulo = crearImageView(pathTitulo, 0, 0, anchoVentana);
        panel.getChildren().add(titulo);

        Button botonAuto = (new BotonVehiculo(stage, "auto", controlador, cantJugadores)).getBoton();
        disenarBoton(botonAuto, "Auto", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 2, yBoton, "#a55d31", fuenteBoton);
        elementos.getChildren().add(botonAuto);

        Button botonMoto = (new BotonVehiculo(stage, "moto", controlador, cantJugadores)).getBoton();
        disenarBoton(botonMoto, "Moto", anchoBoton, altoBoton, (anchoVentana - anchoBoton) / 9, yBoton, "#b2793c", fuenteBoton);
        elementos.getChildren().add(botonMoto);

        Button botonCamioneta = (new BotonVehiculo(stage, "camioneta", controlador, cantJugadores)).getBoton();
        disenarBoton(botonCamioneta, "4x4", anchoBoton, altoBoton, 8 * (anchoVentana - anchoBoton) / 9, yBoton, "#a14836", fuenteBoton);
        elementos.getChildren().add(botonCamioneta);

        Button botonVolver = (new BotonPantalla(stage, new Inicio())).getBoton();
        disenarBoton(botonVolver, "\uD83E\uDC78", anchoBoton / 3, altoBoton / 3, 0, 0, "#a67f5a", fuenteBoton);
        elementos.getChildren().add(botonVolver);

        Scene scene = new Scene(elementos, anchoVentana, altoVentana);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
