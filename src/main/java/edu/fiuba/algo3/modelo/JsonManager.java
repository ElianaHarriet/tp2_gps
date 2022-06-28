package edu.fiuba.algo3.modelo;


import java.io.*;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonManager {

    public static JSONObject obtenerJson(String path) {
        JSONParser parser = new JSONParser();
        Object json = null;

        try {
            json = parser.parse(new FileReader(path));
        } catch (java.io.FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (org.json.simple.parser.ParseException e) {
            System.out.println("Error al parsear el archivo");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        JSONObject objetoJson = (JSONObject)json;
        return objetoJson;
    }

    public static String obtenerRanking() {
        String rankingString = "";
        JSONObject ranking = obtenerJson("./ranking.json");
        Iterator<String> claves = ranking.keySet().iterator();
        while (claves.hasNext()) {
            String claveActual = claves.next();
            String movimientos = (String)(ranking.get(claveActual));
            rankingString += "✩--" + claveActual + "\t--✩--\t" + movimientos + "--✩\n";
        }
        return rankingString;
    }

    public static void guardarMovimientos(JSONObject json, String nick, int movimientos) {
        json.put(nick, movimientos);
    }

}
