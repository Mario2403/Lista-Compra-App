package com.home.listaCompra.controller;

import com.google.gson.Gson;
import com.home.listaCompra.cache.GruposCache;
import com.home.listaCompra.model.frontJson.GrupoBuilder;
import com.home.listaCompra.model.frontJson.Grupos;
import com.home.listaCompra.model.frontJson.Item;
import com.home.listaCompra.model.json.AddGrupoJSON;
import com.home.listaCompra.model.json.ResponseJSON;
import com.home.listaCompra.service.ListaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> getGrupos(){

        GruposCache grupos = GruposCache.getInstance();
        return new ResponseEntity<>(new Gson().toJson(grupos), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/api/addGrupo")
    public String addGrupo(@RequestBody AddGrupoJSON addGrupoJSON){

        GruposCache.getInstance().addToGrupo(addGrupoJSON.getGrupoName(), addGrupoJSON.getItemName());
        return "OK";
    }


}
