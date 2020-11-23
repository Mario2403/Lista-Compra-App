package com.home.listaCompra.model.json;

import com.home.listaCompra.model.Categoria;

import java.util.ArrayList;

public class ResponseJSON {

    ArrayList<CategoriaJSON> categorias;



    public ArrayList<Categoria> getCategorias(){

        ArrayList<Categoria> result = new ArrayList<>();
        for (CategoriaJSON catJson : categorias){
            result.add(catJson.toCategoria());
        }
        return result;
    }

    @Override
    public String toString() {
        return "ResponseJSON{" +
                "categorias=" + categorias +
                '}';
    }
}
