package com.home.listaCompra.builder;

import com.home.listaCompra.model.Categoria;
import com.home.listaCompra.model.excel.Field;
import com.home.listaCompra.model.excel.ThinBlankCell;

import java.util.ArrayList;
import java.util.Comparator;

public class LineBuilder {

    private int indexIzda;
    private int indexDcha;
    private ArrayList<Categoria> categoriasIzda;
    private ArrayList<Categoria> categoriasDcha;


    public LineBuilder(ArrayList<Categoria> categorias) {
        categoriasIzda = new ArrayList<>();
        categoriasDcha = new ArrayList<>();

        categorias.sort(Comparator .comparingInt(o -> -o.getArticulos().size()));

        for (int i = 0; i < categorias.size(); i++) {
            Categoria catActual = categorias.get(i);
            if (i % 2 == 0) {
                categoriasIzda.add(catActual);
            } else {
                categoriasDcha.add(catActual);
            }
        }
    }

    public ArrayList<Field> getLine() {

        ArrayList<Field> resultado = new ArrayList<>();

        Categoria catIzda = categoriasIzda.get(indexIzda);
        ArrayList<Field> izdaElem = catIzda.getNext();
        if (izdaElem == null) {
            //next index izda
            indexIzda++;
            if (indexIzda < categoriasIzda.size()) {
                catIzda = categoriasIzda.get(indexIzda);
                izdaElem = catIzda.getNext();
                if (izdaElem == null) {
                    //TODOS DE BLANCO
                    izdaElem = new ArrayList<>();
                    izdaElem.add(new ThinBlankCell());
                    izdaElem.add(new ThinBlankCell());
                }
            }else{
                //TODOS DE BLANCO
                izdaElem = new ArrayList<>();
                izdaElem.add(new ThinBlankCell());
                izdaElem.add(new ThinBlankCell());
            }
        }
        resultado.addAll(izdaElem);




        ArrayList<Field> blankField = new ArrayList<>();
        blankField.add(new ThinBlankCell());
        resultado.addAll(blankField);



        ArrayList<Field> dchaElem = new ArrayList<>();
        if (indexDcha< categoriasDcha.size()) {
            Categoria catDcha = categoriasDcha.get(indexDcha);
            if (catDcha != null) {
                dchaElem = catDcha.getNext();
                if (dchaElem == null) {
                    //next index dcha
                    indexDcha++;
                    if (indexDcha < categoriasDcha.size()) {
                        catDcha = categoriasDcha.get(indexDcha);
                        dchaElem = catDcha.getNext();
                        if (dchaElem == null) {
                            //TODOS DE BLANCO
                            dchaElem = new ArrayList<>();
                            dchaElem.add(new ThinBlankCell());
                            dchaElem.add(new ThinBlankCell());
                        }
                    } else {
                        //TODOS DE BLANCO
                        dchaElem = new ArrayList<>();
                        dchaElem.add(new ThinBlankCell());
                        dchaElem.add(new ThinBlankCell());
                    }
                }
            } else {
                dchaElem = new ArrayList<>();
                dchaElem.add(new ThinBlankCell());
                dchaElem.add(new ThinBlankCell());
            }
        }else{
            dchaElem = new ArrayList<>();
            dchaElem.add(new ThinBlankCell());
            dchaElem.add(new ThinBlankCell());
        }
        resultado.addAll(dchaElem);

        for (Field elem : resultado) {
            if (elem.getClass() != ThinBlankCell.class) {
                return resultado;
            }
        }
        return null;
    }


}
