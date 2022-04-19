package com.jmunoz.springboot.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/index")
    public String index() {
        // No vamos a crear la vista por lo que va a lanzar un error con status 500.
        // Los tipos de error 500 se lanzan cuando hay excepciones runtime como por ejemplo:
        // TemplateInputException  (No existe la vista)
        // NumberFormatException  (queremos pasar string no numérico a Integer)
        // Dividir por 0
        // Desconexiones en BBDD  (Data Access Exception)
        // ...
        // Es muy importante, para el manejo de errores, detectar la excepción que se está lanzando
        // En este caso es:
        // TemplateInputException
        // Esa página de error la podemos personalizar y hacer más amistosa al usuario.
        //
        // También se puede manejar el error 404, cuando no existe el recurso o la página.
        // Por ejemplo, si queremos acceder a http://localhost:8080/clientes, como no está mapeada
        // en ningún @GetMapping, da error 404.
        //
        //
        // Como en SpringBoot to-do tiene una preconfiguración predefinida que es automática, pero también
        // maneja convención por sobreconfiguración, es decir, podemos cumplir cierta estructura en nuestra
        // aplicación, ya sea nombre de directorios... para poder implementar alguna funcionalidad, como
        // el manejo de error.
        // En resources/templates podemos crear el directorio error
        // SE TIENE QUE LLAMAR error
        // Dentro del directorio error podemos crear vistas HTML para customizar nuestra página de error por
        // cada código de error (404, 500...)
        // Los nombres de las vistas deberán ser 404.html, 500.html, etc.
        // Aunque también se puede personalizar cada lanzamiento de excepción implementando una clase
        // controladora especializada en el manejo de error.
        return "index";
    }

    @GetMapping("/division0")
    public String divisionPorCero() {
        Integer valor = 100/0;

        return "index";
    }

    // Nota: para probar página no encontrada (error 404) ir a la ruta:
    // http://localhost:8080/clientes
}
