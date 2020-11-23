package com.home.listaCompra.startup;

import com.home.listaCompra.controller.ListaCompraController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = ListaCompraController.class)
public class ListaCompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaCompraApplication.class, args);
	}

}
