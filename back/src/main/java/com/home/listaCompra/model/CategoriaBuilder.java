package com.home.listaCompra.model;

import com.home.listaCompra.model.excel.TitleField;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoriaBuilder {

    public static Categoria buildCategoria(String nombre, Articulo... arts){
        Categoria categoria = new Categoria();
        categoria.setTitleField(new TitleField(nombre));

        ArrayList<Articulo> articulos = new ArrayList<>(Arrays.asList(arts));
        categoria.setArticulos(articulos);
        return categoria;
    }
}
