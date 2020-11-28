package com.home.listaCompra.model.frontJson;

public class Item {

    private String title;
    private int qty;

    public Item(String title, int qty) {
        this.title = title;
        this.qty = qty;
    }
    public Item(String title) {
        this.title = title;
        this.qty = 0;
    }
}
