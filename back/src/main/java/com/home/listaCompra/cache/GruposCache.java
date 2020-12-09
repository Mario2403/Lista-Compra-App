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
                    new Item("Morcilla"),
                    new Item("Cinta de lomo adobada"),
                    new Item("Cinta de lomo fresca")));

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
                    new Item("Limones"),
                    new Item("Sandía"),
                    new Item("Melón")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("PANADERÍA", "mdi-baguette",
                    new Item("Pan Sebas"),
                    new Item("Pan integral"),
                    new Item("Pan rallado"),
                    new Item("Pan de salchichas"),
                    new Item("Pan de molde")));


            gruposGson.addGrupo(GrupoBuilder.buildGrupo("VERDULERÍA", "mdi-seed",
                    new Item("Pimiento verde"),
                    new Item("Pimiento rojo"),
                    new Item("Judías verdes"),
                    new Item("Cebollas"),
                    new Item("Brócoli"),
                    new Item("Patatas"),
                    new Item("Bolsa de lechuga"),
                    new Item("Calabacín"),
                    new Item("Berenjena"),
                    new Item("Lechuga")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("CONGELADOS", "mdi-snowflake",
                    new Item("Palitos de Cangrejo"),
                    new Item("Pescanova"),
                    new Item("Empanadillas La Cocinera"),
                    new Item("Croquetas bacalao La Cocinera"),
                    new Item("Pimientos rellenos bacalao")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("DROGUERÍA", "mdi-lotion",
                    new Item("Don Limpio Baño"),
                    new Item("Papel de cocina"),
                    new Item("Papel higiénico Loli"),
                    new Item("Papel higiénico"),
                    new Item("Friegasuelos"),
                    new Item("Amoníaco"),
                    new Item("Lejía"),
                    new Item("Pastillas lavavajillas"),
                    new Item("Jabón lavadora"),
                    new Item("Suavizante")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("CONSERVAS", "mdi-cup-outline",
                    new Item("Tomate frito"),
                    new Item("Tomate triturado natural"),
                    new Item("Pimientos rellenos bacalao")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("LÁCTEOS", "mdi-cow",
                    new Item("Bebida de avena"),
                    new Item("Leche Sebas"),
                    new Item("Zumo blanco"),
                    new Item("Yogures Activia"),
                    new Item("Danacol"),
                    new Item("Densia"),
                    new Item("Yogures Mario")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("LEGUMBRES Y PASTAS", "mdi-cow",
                    new Item("Lentejas"),
                    new Item("Arroz"),
                    new Item("Macarrones"),
                    new Item("Espaguettis"),
                    new Item("Harina"),
                    new Item("Garbanzos")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("EMBUTIDOS", "mdi-pig",
                    new Item("Pavo Mario"),
                    new Item("Chorizo Loli"),
                    new Item("Fuet"),
                    new Item("Salchichas")));


            gruposGson.addGrupo(GrupoBuilder.buildGrupo("VARIOS", "mdi-dice-multiple",
                    new Item("Cruesli"),
                    new Item("Huevos"),
                    new Item("Aceite de oliva"),
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
