package edu.fiuba.algo3.modelo.Ranking;

import edu.fiuba.algo3.modelo.Ranking.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RankingManagerTest {
    private final String rankingPath = "/home/rueba/code/tp2_gps/src/main/test/edu/fiuba/algo3/modelo/Ranking/rankingTest.json";
    @Test
    public void prueba01SeAgregaUnaPuntuacionAlRankingYSeObtieneElRanking(){
        RankingManager ranking = new RankingManager(this.rankingPath);
        ranking.limpiarRanking();
        String nick = "BuchwaldGod";
        int puntuacion = 38;

        ranking.guardarNuevaPuntuacion(nick, puntuacion);
        String rankingString = ranking.obtenerRanking();
        String rankingEsperado = "✩-- BuchwaldGod\t--✩--\t38 --✩\n";
        assertEquals(rankingString,rankingEsperado);

    }

    @Test
    public void prueba02SeAgregan3PuntuacionesYSeVerificaQueLaMejorSeaCorrecta(){
        RankingManager ranking = new RankingManager(this.rankingPath);
        ranking.limpiarRanking();
        String nick1 = "BuchwaldGod";
        int puntuacion1 = 13;
        String nick2 = "BonShot";
        int puntuacion2 = 23;
        String nick3 = "Pandelfin";
        int puntuacion3 = 11;

        ranking.guardarNuevaPuntuacion(nick1, puntuacion1);
        ranking.guardarNuevaPuntuacion(nick2, puntuacion2);
        ranking.guardarNuevaPuntuacion(nick3, puntuacion3);
        String rankingString = ranking.obtenerRanking();
        String rankingEsperado = "✩-- Pandelfin\t--✩--\t11 --✩\n✩-- BuchwaldGod\t--✩--\t13 --✩\n✩-- BonShot\t--✩--\t23 --✩\n";

        assertEquals(rankingEsperado,rankingString);
    }

}