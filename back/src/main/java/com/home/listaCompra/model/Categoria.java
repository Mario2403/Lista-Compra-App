package com.home.listaCompra.model;

import com.home.listaCompra.model.excel.Field;
import com.home.listaCompra.model.excel.NormalField;
import com.home.listaCompra.model.excel.RightTitleField;
import com.home.listaCompra.model.excel.TitleField;

import java.util.ArrayList;

public class Categoria {

    TitleField titleField;
    ArrayList<Articulo> articulos;
    int index;

    public Categoria(String nombre, ArrayList<Articulo> articulos) {
        this.titleField = new TitleField(nombre);
        this.articulos = articulos;
        this.index = 0;
    }

    public Categoria() {
        this.index = 0;
    }

    public ArrayList<Field> getNext(){
        ArrayList<Field> res =  new ArrayList<>();
        if (this.index == 0){
            res.add(this.titleField);
            res.add(new RightTitleField());
        }else if (this.index -1 < this.articulos.size()){
            res.add(this.articulos.get(index-1).getCantidad());
            res.add(this.articulos.get(index-1).getNombre());
        }else if (this.index-1 == this.articulos.size()){
            res.add(new NormalField(""));
            res.add(new NormalField(""));
        }else{
            return null;
        }
        this.index++;
        return res;
    }

    public int getTotalSize(){
        return this.articulos.size() + 1;
    }
    public TitleField getTitleField() {
        return titleField;
    }

    public void setTitleField(TitleField titleField) {
        this.titleField = titleField;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "titleField=" + titleField +
                ", articulos=" + articulos +
                ", index=" + index +
                '}';
    }
}
