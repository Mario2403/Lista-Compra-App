package com.home.listaCompra.model.json;

import com.home.listaCompra.defs.CategoryPositionEnum;
import com.home.listaCompra.model.Articulo;

public class ArticuloJSON {

    String title;
    int qty;

    public Articulo getArticulo(CategoryPositionEnum position) {

        return new Articulo(title, String.valueOf(qty), position);
    }

    @Override
    public String toString() {
        return "ArticuloJSON{" +
                "title='" + title + '\'' +
                ", qty=" + qty +
                '}';
    }
}
