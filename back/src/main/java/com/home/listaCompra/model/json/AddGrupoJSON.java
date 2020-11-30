package com.home.listaCompra.model.json;

public class AddGrupoJSON {


    private String grupoName;
    private String itemName;

    public AddGrupoJSON(String grupoName, String itemName) {
        this.grupoName = grupoName;
        this.itemName = itemName;
    }

    public String getGrupoName() {
        return grupoName;
    }

    public void setGrupoName(String grupoName) {
        this.grupoName = grupoName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
