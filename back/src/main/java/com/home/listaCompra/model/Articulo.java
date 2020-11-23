package com.home.listaCompra.model;

import com.home.listaCompra.defs.CategoryPositionEnum;
import com.home.listaCompra.model.excel.NormalField;
import com.home.listaCompra.model.excel.NumberField;

public class Articulo {

    NumberField cantidad;
    NormalField nombre;

    public Articulo() {
    }

    public Articulo(String nombre, String cantidad, CategoryPositionEnum position) {
        this.cantidad = new NumberField(cantidad, position);
        this.nombre = new NormalField(nombre, position);
    }

    public NumberField getCantidad() {
        return cantidad;
    }

    public void setCantidad(NumberField cantidad) {
        this.cantidad = cantidad;
    }

    public NormalField getNombre() {
        return nombre;
    }

    public void setNombre(NormalField nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "cantidad=" + cantidad +
                ", nombre=" + nombre +
                '}';
    }
}
