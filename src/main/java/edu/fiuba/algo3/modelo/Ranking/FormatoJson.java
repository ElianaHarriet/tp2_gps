package edu.fiuba.algo3.modelo.Ranking;import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FormatoJson {
    private String pathArchivo;

    public FormatoJson(String path){
        this.pathArchivo = path;
    }

    private JSONObject obtenerJson() {
        JSONParser parser = new JSONParser();
        Object json = null;

        try(FileReader reader = new FileReader(this.pathArchivo)) {
            json = parser.parse(reader);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (org.json.simple.parser.ParseException e) {
            System.out.println("Error al parsear el archivo en la línea " + e.getPosition());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        return (JSONObject)json;
    }

    public ArrayList<Jugada> convertirJsonALista() {
        JSONObject json = obtenerJson();
        Iterator<String> claves = json.keySet().iterator();
        ArrayList<Jugada> lista = new ArrayList<Jugada>();
        while (claves.hasNext()) {
            String claveActual = claves.next();
            String valor = (json.get(claveActual)).toString();
            Jugada jugada = new Jugada(claveActual, Integer.parseInt(valor));
            lista.add(jugada);
        }
        return lista;
    }

    public void guardarElemento(String clave, int valor){
        JSONObject json = obtenerJson();
        json.put(clave, valor);
        try (FileWriter file = new FileWriter(this.pathArchivo)) {
            file.write(json.toJSONString());
            file.flush();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    public void vaciarArchivo() {
        try (FileWriter file = new FileWriter(this.pathArchivo)) {
            file.write((new JSONObject()).toJSONString());
            file.flush();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}
