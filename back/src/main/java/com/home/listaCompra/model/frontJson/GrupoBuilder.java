package com.home.listaCompra.model.frontJson;

import java.util.ArrayList;
import java.util.Arrays;

public class GrupoBuilder {


    public static Grupo buildGrupo(String title, String icon, Item... items){

        Grupo g = new Grupo();
        g.setTitle(title);
        g.setIcon(icon);
        g.setItems(new ArrayList<>(Arrays.asList(items)));
        return g;
    }
}
