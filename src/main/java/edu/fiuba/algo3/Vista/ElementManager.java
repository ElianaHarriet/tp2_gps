package edu.fiuba.algo3.Vista;

import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ElementManager {

    public static ImageView crearImageView(String path, int x, int y, int ancho) {
        Image img = new Image(path);
        ImageView imgView = new ImageView(img);
        imgView.setX(x);
        imgView.setY(y);
        imgView.setFitWidth(ancho);
        imgView.setPreserveRatio(true);
        return imgView;
    }

    public static Button crearButton(String txt, int anchoBoton, int altoBoton, int x, int y, String color, Font font) {
        Button boton = new Button(txt);
        boton.setPrefSize(anchoBoton, altoBoton);
        boton.setStyle("-fx-background-color: " + color + ";");
        boton.setFont(font);
        boton.setLayoutX(x);
        boton.setLayoutY(y);
        return boton;
    }

    public static Text crearText(String txt, int x, int y, Font font, String color, Color borde, TextAlignment alineacion) {
        Text text = new Text(txt);
        text.setX(x);
        text.setY(y);
        text.setFont(font);
        text.setStyle("-fx-fill: " + color + ";");
        text.setStroke(borde);
        text.setTextAlignment(alineacion);
        return text;
    }
}
