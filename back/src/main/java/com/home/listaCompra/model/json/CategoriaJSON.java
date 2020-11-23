package com.home.listaCompra.model.json;

import com.home.listaCompra.defs.CategoryPositionEnum;
import com.home.listaCompra.model.Articulo;
import com.home.listaCompra.model.Categoria;
import com.home.listaCompra.model.excel.TitleField;

import java.util.ArrayList;

public class CategoriaJSON {



    String name;
    ArrayList<ArticuloJSON> articulos;

    public Categoria toCategoria() {
        Categoria cat = new Categoria();
        ArrayList<Articulo> articulosResult = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            ArticuloJSON artJSON = articulos.get(i);
            if (articulos.size()==1){
                articulosResult.add(artJSON.getArticulo(CategoryPositionEnum.ONLY_ONE));
            }
            else if (i == 0) {
                articulosResult.add(artJSON.getArticulo(CategoryPositionEnum.FIRST));
            }else if (i == articulos.size()-1){
                articulosResult.add(artJSON.getArticulo(CategoryPositionEnum.LAST));
            }else{
                articulosResult.add(artJSON.getArticulo(CategoryPositionEnum.MIDDLE));
            }
        }
        cat.setTitleField(new TitleField(this.name));
        cat.setArticulos(articulosResult);
        return cat;
    }

    @Override
    public String toString() {
        return "CategoriaJSON{" +
                "name='" + name + '\'' +
                ", articulos=" + articulos +
                '}';
    }
}
