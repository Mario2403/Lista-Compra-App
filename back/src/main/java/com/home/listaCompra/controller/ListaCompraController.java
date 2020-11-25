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
    @PostMapping("/api/list")
    public String getList(@RequestBody (required = true) String body){


        System.out.println(body);

        Gson gson = new Gson();
        ResponseJSON catJSON = gson.fromJson(body, ResponseJSON.class);
        System.out.println(catJSON.toString());

        System.out.println("Controller /list");
        ListaService.createLista(catJSON.getCategorias());

        return "OK";
    }
}
