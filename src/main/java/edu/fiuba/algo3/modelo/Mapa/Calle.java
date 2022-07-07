package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.ISorpresa;

public class Calle {

    private final Esquina esquina1;
    private final Esquina esquina2;

    private final ISorpresa sorpresa;
    private final IObstaculo obstaculo;

    public Calle(Esquina esquina1, Esquina esquina2, ISorpresa sorpresa, IObstaculo obstaculo) {
        this.esquina1 = esquina1;
        this.esquina2 = esquina2;
        this.sorpresa = sorpresa;
        this.obstaculo = obstaculo;
    }

    public void moverse(Esquina esquina, Jugador jugador) {
        Esquina prox = esquina.equals(this.esquina1) ? this.esquina2 : this.esquina1;
        jugador.actualizarEstado(prox, this.sorpresa, this.obstaculo);
    }

    public ISorpresa getSorpresa(){
        return this.sorpresa;
    }

    public IObstaculo getObstaculo(){
        return this.obstaculo;
    }
}
