package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;

import java.util.Random;

public class Mapa {

    private final Esquina[][] mapa;
    private final int tam;
    private final Random random;

    public Mapa(int tam) {
        this.tam = tam;
        mapa = new Esquina[tam][tam];
        this.random = new Random(System.currentTimeMillis());
        this.iniciarMapa();
    }

    private void iniciarMapa() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                mapa[i][j] = new Esquina(false);
            }
        }
        mapa[random.nextInt(0, tam)][tam - 1] = new Esquina(true);
        this.crearCalles();
    }

    private void crearCalles() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                Esquina actual = mapa[i][j];
                if (j + 1 < tam) {
                    Esquina derecha = mapa[i][j + 1];
                    this.unirEsquinasHorizontalmente(actual, derecha);
                }
                if (i + 1 < tam) {
                    Esquina abajo = mapa[i + 1][j];
                    this.unirEsquinasVerticalmente(actual, abajo);
                }
            }
        }

//        for (int i = 0; i < tam - 1; i++) {
//            // uniendo la ult fila
//            Esquina actual = mapa[tam - 1][i];
//            Esquina derecha = mapa[tam - 1][i + 1];
//            this.unirEsquinasHorizontalmente(actual, derecha);
//
//            // uniendo la ult columna
//            actual = mapa[i][tam - 1];
//            Esquina abajo = mapa[i + 1][tam - 1];
//            this.unirEsquinasVerticalmente(actual, abajo);
//        }
    }

    private void unirEsquinasVerticalmente(Esquina superior, Esquina inferior) {
        ISorpresa sorpresa = this.crearSorpresa();
        IObstaculo obstaculo = this.crearObstaculo();
        Calle calle = new Calle(superior, inferior, sorpresa, obstaculo);
        superior.setAdyInferior(calle);
        inferior.setAdySuperior(calle);
    }

    private void unirEsquinasHorizontalmente(Esquina izquierda, Esquina derecha) {
        ISorpresa sorpresa = this.crearSorpresa();
        IObstaculo obstaculo = this.crearObstaculo();
        Calle calle = new Calle(izquierda, derecha, sorpresa, obstaculo);
        izquierda.setAdyDerecha(calle);
        derecha.setAdyIzquierda(calle);
    }

    private ISorpresa crearSorpresa() {
        float random = this.random.nextFloat();
        float tope0 = 0.125f;
        float tope1 = 2 * tope0 / 3;
        float tope2 = tope0 / 3;  //porque pintó
        // (proba de encontrar una sorpresa no neutra = 0.125)
        // SorpresaFavorable, SorpresaDesfavorable y SorpresaCambioVehiculo son equiprobables

        return random > tope0 ? new SorpresaNeutra() :
               random > tope1 ? new SorpresaFavorable() :
               random > tope2 ? new SorpresaDesfavorable() :
                                new SorpresaCambioVehiculo();

    }

    private IObstaculo crearObstaculo() {
        float random = this.random.nextFloat();
        float tope0 = 0.125f;
        float tope1 = 2 * tope0 / 3;
        float tope2 = tope0 / 3;  //porque pintó

        return random > tope0 ? new ObstaculoNulo() :
               random > tope1 ? new Piquete() :
               random > tope2 ? new Pozo() :
                                new ControlPolicial();

    }
    public Esquina posicionInicio() {
        return mapa[random.nextInt(0, tam)][0];
    }
}
