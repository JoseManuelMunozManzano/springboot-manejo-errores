package com.jmunoz.springboot.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/division0")
    public String divisionPorCero() {
        // Manejar este error en una vista propia y personalizada para esta excepción.
        // Ver controlador ErrorHandlerController
        Integer valor = 100/0;
        return "index";
    }

    // Nota: para probar página no encontrada (error 404) ir a la ruta:
    // http://localhost:8080/clientes
}
