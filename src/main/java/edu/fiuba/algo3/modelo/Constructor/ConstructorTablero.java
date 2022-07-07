package edu.fiuba.algo3.modelo.Constructor;

import edu.fiuba.algo3.modelo.Mapa.*;
import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;

import java.util.Random;

public class ConstructorTablero implements IConstructor {

    private Esquina[][] mapa;
    private int n;
    private Random random;
    public ConstructorTablero() {
    }
    public Esquina[][] getMapa() {
        return this.mapa;
    }

    public void crearConTamanio(int n) {
        this.n = n;
        this.mapa = new Esquina[n][n];
        this.random = new Random(System.currentTimeMillis());
        this.iniciarTablero();
    }

    private void iniciarTablero(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mapa[i][j] = new EsquinaNormie(i, j);
            }
        }
        int randomInt = random.nextInt(n);
        mapa[randomInt][n - 1] = new EsquinaDestino(randomInt, n - 1);
        this.crearCalles();
    }

    private ISorpresa crearSorpresa() {
        float random = this.random.nextFloat();
        float tope0 = 0.125f;
        float tope1 = 2 * tope0 / 3;
        float tope2 = tope0 / 3;
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
        float tope2 = tope0 / 3;

        return random > tope0 ? new ObstaculoNulo() :
                random > tope1 ? new Piquete() :
                        random > tope2 ? new Pozo() :
                                new ControlPolicial();
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

    private void crearCalles() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Esquina actual = mapa[i][j];
                if (j + 1 < n) {
                    Esquina abajo = mapa[i][j + 1];
                    this.unirEsquinasVerticalmente(actual, abajo);
                }
                if (i + 1 < n) {
                    Esquina derecha = mapa[i + 1][j];
                    this.unirEsquinasHorizontalmente(actual, derecha);
                }
            }
        }
    }

    @Override
    public Esquina getResultado() {
        return mapa[random.nextInt(n)][0];
    }
}
