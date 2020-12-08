package com.home.listaCompra.cache;

import com.google.gson.Gson;
import com.home.listaCompra.model.frontJson.Grupo;
import com.home.listaCompra.model.frontJson.GrupoBuilder;
import com.home.listaCompra.model.frontJson.Grupos;
import com.home.listaCompra.model.frontJson.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class GruposCache {


    private static GruposCache instance;
    private Grupos grupos;


    public synchronized static GruposCache getInstance() {

            if (instance == null) {
                instance = initGrupos();
            }

        return instance;
    }

    private static GruposCache initGrupos() {


        String line = null;
        GruposCache gruposCache = new GruposCache();
        try {
            RandomAccessFile raf = new RandomAccessFile(new File("grupos.txt"), "rw");
            line = raf.readLine();
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line == null || line.equals("")) {
            Grupos gruposGson = new Grupos();

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("CARNICERIA", "mdi-food-drumstick",
                    new Item("Carne Picada"),
                    new Item("Filetes de pollo"),
                    new Item("Filetes cinta de lomo")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("PESCADERIA", "mdi-fish",
                    new Item("Salmón"),
                    new Item("Pescanova"),
                    new Item("Gallos")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("FRUTERÍA", "mdi-food-apple",
                    new Item("Plátanos"),
                    new Item("Peras"),
                    new Item("Manzanas"),
                    new Item("Ciruelas"),
                    new Item("Melocotones"),
                    new Item("Mandarinas"),
                    new Item("Naranjas"),
                    new Item("Sandía"),
                    new Item("Melón")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("PANADERÍA", "mdi-baguette",
                    new Item("Pan Sebas"),
                    new Item("Pan integral"),
                    new Item("Pan rallado"),
                    new Item("Pan de molde")));


            gruposGson.addGrupo(GrupoBuilder.buildGrupo("VERDULERÍA", "mdi-seed",
                    new Item("Pimientos"),
                    new Item("Judías verdes"),
                    new Item("Cebollas"),
                    new Item("Brócoli"),
                    new Item("Lechuga")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("CONGELADOS", "mdi-snowflake",
                    new Item("Palitos de Cangrejo"),
                    new Item("Pescanova"),
                    new Item("Pimientos rellenos bacalao")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("DROGUERÍA", "mdi-lotion",
                    new Item("Don Limpio Baño"),
                    new Item("Friegasuelos"),
                    new Item("Amoníaco"),
                    new Item("Lejía"),
                    new Item("Cápsulas lavavajillas"),
                    new Item("Jabón lavadora"),
                    new Item("Suavizante")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("CONSERVAS", "mdi-cup-outline",
                    new Item("Palitos de Cangrejo"),
                    new Item("Pescanova"),
                    new Item("Pimientos rellenos bacalao")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("VARIOS", "mdi-dice-multiple",
                    new Item("Cruesli"),
                    new Item("Patatas Fritas")));
            gruposCache.setGrupos(gruposGson);
        } else {
            gruposCache.setGrupos(new Gson().fromJson(line, Grupos.class));
        }

        return gruposCache;
    }

    public void addToGrupo(String grupoName, String item) {
        String line = null;
        Grupos gruposResponse = null;
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("grupos.txt"), "rw");
            line = raf.readLine();


        if (line != null && !line.equals("")) {

            gruposResponse = new Gson().fromJson(line, Grupos.class);
            gruposResponse.addItemToGrupo(grupoName, item);

        }

        raf.setLength(0);
        raf.writeBytes(new Gson().toJson(gruposResponse));
        raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Grupos getGrupos() {
        return grupos;
    }

    private void setGrupos(Grupos grupos) {
        this.grupos = grupos;
    }
}
