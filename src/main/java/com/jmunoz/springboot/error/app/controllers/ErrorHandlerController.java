package com.jmunoz.springboot.error.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

// @ControllerAdvice maneja excepciones. Captura los lanzamientos de excepción y los maneja en un método.
// Parecido a un @Controller normal y corriente que está mapeado a rutas URL, pero aquí mapeamos a una excepción.
@ControllerAdvice
public class ErrorHandlerController {

    // En vez de @GetMapping, aquí se usa @ExceptionHandler y se coloca el nombre de la excepción
    // Puede ir más de una excepción entre llaves y separadas por comas.
    // Se pasa la excepción, como el tipo genérico Exception o el tipo más concreto, y el Model
    @ExceptionHandler(ArithmeticException.class)
    public String aritmeticaError(ArithmeticException ex, Model model) {
        // Podemos enviar lo que queramos. En este caso estamos mandando lo que se suele manejar en una excepción
        model.addAttribute("error", "Error de aritmética");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/aritmetica";
    }
}
