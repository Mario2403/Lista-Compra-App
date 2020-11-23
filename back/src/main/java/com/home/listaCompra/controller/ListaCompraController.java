package com.home.listaCompra.controller;

import com.google.gson.Gson;
import com.home.listaCompra.model.json.ResponseJSON;
import com.home.listaCompra.service.ListaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListaCompraController {

    @CrossOrigin
    @PostMapping("/list")
    public String getList(@RequestBody (required = true) String body){


        System.out.println(body);

        Gson gson = new Gson();
        ResponseJSON catJSON = gson.fromJson(body, ResponseJSON.class);
        System.out.println(catJSON.toString());

        System.out.println("Controller /list");

//
//        Categoria c1 = CategoriaBuilder.buildCategoria("CARNICERIA",
//                new Articulo("CARNE LOCA", "1", CategoryPositionEnum.FIRST),
//                new Articulo("CARNE BUENA", "2", CategoryPositionEnum.MIDDLE),
//                new Articulo("CARNADA", "4", CategoryPositionEnum.MIDDLE),
//                new Articulo("CARNAZA", "43", CategoryPositionEnum.MIDDLE),
//                new Articulo("CARNECITA", "441", CategoryPositionEnum.MIDDLE),
//                new Articulo("CARNUNA", "1", CategoryPositionEnum.LAST));
//
//        Categoria c2 = CategoriaBuilder.buildCategoria("PESCADERIA",
//                new Articulo("PESCADITO", "6", CategoryPositionEnum.FIRST),
//                new Articulo("PERCADOTE", "7", CategoryPositionEnum.MIDDLE),
//                new Articulo("PESCADOR", "89", CategoryPositionEnum.MIDDLE),
//                new Articulo("PESCADO LOCO 2", "99999", CategoryPositionEnum.LAST));
//
//
//        Categoria c3 = CategoriaBuilder.buildCategoria("VARIOS",
//                new Articulo("COSAS GUAY", "1", CategoryPositionEnum.FIRST),
//                new Articulo("WAKAAA", "13", CategoryPositionEnum.MIDDLE),
//                new Articulo("OTRAS COSAS", "3", CategoryPositionEnum.LAST));
//
//
//        ArrayList<Categoria> categorias = new ArrayList<>();
//        categorias.add(c1);
//        categorias.add(c2);
//        categorias.add(c3);

        ListaService.createLista(catJSON.getCategorias());

        return "OK";
    }
}
