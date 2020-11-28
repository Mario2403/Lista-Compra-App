package com.home.listaCompra.controller;

import com.google.gson.Gson;
import com.home.listaCompra.model.frontJson.GrupoBuilder;
import com.home.listaCompra.model.frontJson.Grupos;
import com.home.listaCompra.model.frontJson.Item;
import com.home.listaCompra.model.json.ResponseJSON;
import com.home.listaCompra.service.ListaService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListaCompraController {

    @CrossOrigin
    @PostMapping("/api/list")
    public String createList(@RequestBody (required = true) String body){


        System.out.println(body);

        Gson gson = new Gson();
        ResponseJSON catJSON = gson.fromJson(body, ResponseJSON.class);
        System.out.println(catJSON.toString());

        System.out.println("Controller /list");
        ListaService.createLista(catJSON.getCategorias());

        return "OK";
    }

    @CrossOrigin
    @GetMapping("/api/grupos")
    public String getGrupos(){

        Grupos grupos = new Grupos();

        grupos.addGrupo(GrupoBuilder.buildGrupo("CARNICERIA", "mdi-food-drumstick",
                new Item("Carne Picada"),
                new Item("Filetes de pollo"),
                new Item("Filetes cinta de lomo")));

        grupos.addGrupo(GrupoBuilder.buildGrupo("PESCADERIA", "mdi-fish",
                new Item("Salmón"),
                new Item("Pescanova"),
                new Item("Gallos")));

        String gson = new Gson().toJson(grupos);
        return gson;
    }


}
