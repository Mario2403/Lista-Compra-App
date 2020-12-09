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
                    new Item("Rodaja bonito"),
                    new Item("Filete bacalao"),
                    new Item("Lomos de caballa"),
                    new Item("Bacaladitos"),
                    new Item("Emperador"),
                    new Item("Boquerones"),
                    new Item("Gallos")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("FRUTERÍA", "mdi-food-apple",
                    new Item("Plátanos"),
                    new Item("Peras"),
                    new Item("Arándanos"),
                    new Item("Frambuesas"),
                    new Item("Uvas rojas"),
                    new Item("Piña"),
                    new Item("Granada"),
                    new Item("Naranjas"),
                    new Item("Kiwis"),
                    new Item("Moras"),
                    new Item("Aguacate"),
                    new Item("Chirimoya"),
                    new Item("Papaya"),
                    new Item("Mango"),
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
                    new Item("Pan de molde"),
                    new Item("Galletas"),
                    new Item("Achicoria"),
                    new Item("Chocolate negro"),
                    new Item("Chocolatinas"),
                    new Item("Cereales Cruesli"),
                    new Item("Tostadas integrales")));


            gruposGson.addGrupo(GrupoBuilder.buildGrupo("VERDULERÍA", "mdi-seed",
                    new Item("Pimiento verde"),
                    new Item("Pimiento rojo"),
                    new Item("Espinacas"),
                    new Item("Coliflor"),
                    new Item("Repollo"),
                    new Item("Acelgas"),
                    new Item("Remolacha"),
                    new Item("Col rizada"),
                    new Item("Tomates"),
                    new Item("Berros"),
                    new Item("Cebolletas"),
                    new Item("Judías verdes"),
                    new Item("Cebollas"),
                    new Item("Ajos"),
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
                    new Item("Bolsa plástico bocadillo"),
                    new Item("Lavavajillas Mistol"),
                    new Item("Balletas"),
                    new Item("Estropajos"),
                    new Item("Mochos fregona"),
                    new Item("Servilletas"),
                    new Item("Líquido suelos"),
                    new Item("Amoníaco"),
                    new Item("Sanitol"),
                    new Item("Papel WC húmedo"),
                    new Item("Jabón tocador"),
                    new Item("Detergente líquido Dixan"),
                    new Item("Lejía"),
                    new Item("Pastillas lavavajillas"),
                    new Item("Suavizante Vernel")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("CONSERVAS", "mdi-cup-outline",
                    new Item("Tomate frito"),
                    new Item("Pimientos rojos bote"),
                    new Item("Latas sardinas"),
                    new Item("Latas atun"),
                    new Item("Latas mejillones"),
                    new Item("Latas berberechos"),
                    new Item("Lata callos"),
                    new Item("Fabada litoral"),
                    new Item("Tomate triturado natural")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("LÁCTEOS", "mdi-cow",
                    new Item("Leche Loli"),
                    new Item("Leche Sebas"),
                    new Item("Zumo blanco"),
                    new Item("Yogures Activia"),
                    new Item("Botecitos Densia"),
                    new Item("Botecitos Danacol"),
                    new Item("Yogures Mario")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("LEGUMBRES Y PASTAS", "mdi-barley",
                    new Item("Lentejas"),
                    new Item("Arroz"),
                    new Item("Macarrones pluma 6"),
                    new Item("Espaguettis"),
                    new Item("Harina integral"),
                    new Item("Garbanzos")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("EMBUTIDOS", "mdi-pig",
                    new Item("Pavo Mario"),
                    new Item("Chorizo Loli"),
                    new Item("Fuet"),
                    new Item("Salchichas"),
                    new Item("Lomo embuchado"),
                    new Item("Queso de cabra"),
                    new Item("Queso havarti"),
                    new Item("Queso fresco"),
                    new Item("Queso cottage"),
                    new Item("Queso cabaña"),
                    new Item("Queso kefir"),
                    new Item("Queso Tofu"),
                    new Item("Queso parmesano"),
                    new Item("Queso feta"),
                    new Item("Queso brie"),
                    new Item("Queso gouda"),
                    new Item("Queso edam")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("FRUTOS SECOS", "mdi-peanut",
                    new Item("Almendras"),
                    new Item("Nueces"),
                    new Item("Pistachos"),
                    new Item("Patatas fritas"),
                    new Item("Avellanas"),
                    new Item("Patatas fritas"),
                    new Item("Pipas")));

            gruposGson.addGrupo(GrupoBuilder.buildGrupo("VARIOS", "mdi-dice-multiple",
                    new Item("Huevos"),
                    new Item("Aceite de oliva")));

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
