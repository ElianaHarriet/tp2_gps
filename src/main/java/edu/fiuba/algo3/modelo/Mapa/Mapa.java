package edu.fiuba.algo3.modelo.Mapa;


import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;

import java.util.Random;

public class Mapa {

    private final Esquina[][] mapa;
    private final int ancho;
    private final int alto;
    private final Random random;

    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        mapa = new Esquina[alto][ancho];
        this.random = new Random(System.currentTimeMillis());
        this.iniciarMapa();
    }

    private void iniciarMapa() {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                mapa[i][j] = new Esquina(false);
            }
        }
        mapa[random.nextInt(0, alto)][ancho - 1] = new Esquina(true);
        this.crearCalles();
    }

    private void crearCalles() {
        for (int i = 0; i < alto - 1; i++) {
            for (int j = 0; j < ancho - 1; j++) {
                Esquina actual = mapa[i][j];
                Esquina derecha = mapa[i][j + 1];
                Esquina abajo = mapa[i + 1][j];

                ISorpresa sorpresa1 = this.crearSorpresa();
                IObstaculo obstaculo1 = null; // hacer esto
                Calle calle1 = new Calle(actual, derecha, sorpresa1, obstaculo1);
                actual.setAdyDerecha(calle1);
                derecha.setAdyIzquierda(calle1);

                ISorpresa sorpresa2 = this.crearSorpresa();
                IObstaculo obstaculo2 = null; // hacer esto
                Calle calle2 = new Calle(actual, abajo, sorpresa2, obstaculo2);
                actual.setAdyInferior(calle2);
                abajo.setAdySuperior(calle2);
            }
        }
    }

    private ISorpresa crearSorpresa() {
        float random = this.random.nextFloat();
        float tope0 = 1 / 4f;
        float tope1 = 1 / 6f;
        float tope2 = 1 / 12f;  //porque pintó
        // (proba de encontrar una sorpresa no neutra = 0.125)
        // SorpresaFavorable, SorpresaDesfavorable y SorpresaCambioVehiculo son equiprobables

        return random > tope0 ? new SorpresaNeutra() :
               random > tope1 ? new SorpresaFavorable() :
               random > tope2 ? new SorpresaDesfavorable() :
                                new SorpresaCambioVehiculo();

    }

    private IObstaculo crearObstaculo() {
        float random = this.random.nextFloat();
        float tope0 = 1 / 4f;
        float tope1 = 1 / 6f;
        float tope2 = 1 / 12f;  //idem sorpresa

        return random > tope0 ? new ObstaculoNulo() :
               random > tope1 ? new Piquete() :
               random > tope2 ? new Pozo() :
                                new ControlPolicial(/*hacer esto*/);

    }


    public Esquina posicionInicio() {
        return mapa[random.nextInt(0, alto)][0];
    }



}
