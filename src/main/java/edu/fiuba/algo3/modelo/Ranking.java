package edu.fiuba.algo3.modelo;

import org.json.simple.JSONObject;

import java.util.*;


public class Ranking {
    private TreeMap<String, Integer> ranking;
    private JSONObject json;

    public Ranking() {
        this.ranking = new TreeMap<String, Integer>();
    }

    public void guardarMovimientos(String nick, int movimientos) {
        ranking.put(nick, movimientos);
    }

    public static <K, V extends Comparable<V> > Map<K, V> ordenarPorValores(final Map<K, V> map) {

        Comparator<K> comparar = new Comparator<K>() {
            public int compare(K clave1, K clave2) {
                int comp = map.get(clave1).compareTo(map.get(clave2));
                if (comp == 0)
                    return 1;
                else return comp;
            }
        };

        Map<K, V> ordenado = new TreeMap<K, V>(comparar);
        ordenado.putAll(map);
        return ordenado;
    }

    public void guardarJson() {
        Map sortedMap = ordenarPorValores(ranking);
        Set set = sortedMap.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry mp = (Map.Entry)i.next();
            JsonManager.guardarMovimientos(json, (String)mp.getKey(), (int)mp.getValue());
        }
    }
}
