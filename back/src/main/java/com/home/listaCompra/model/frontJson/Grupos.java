package com.home.listaCompra.model.frontJson;

import java.util.ArrayList;

public class Grupos {

    private ArrayList<Grupo> grupos;

    public Grupos() {
        this.grupos = new ArrayList<>();
    }

    public void addGrupo(Grupo grupo){
        this.grupos.add(grupo);
    }
}
