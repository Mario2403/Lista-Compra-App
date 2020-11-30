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

    public Grupo getGrupo(String name){

        for (Grupo g : grupos){
            if (g.getTitle().equals(name)){
                return g;
            }
        }
        return null;
    }

    public void addItemToGrupo(String grupoName, String item) {

        for (Grupo g : grupos){
            if (g.getTitle().equals(grupoName)){
                g.getItems().add(new Item(item, 0));
            }
        }
    }
}
