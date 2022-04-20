package com.jmunoz.springboot.error.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public String aritmeticaError(ArithmeticException ex, Model model) {
        model.addAttribute("error", "Error de aritmética");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        // Se puede usar esta vista o la genérica que he creado, aprovechando que las dos vistas son iguales
        return "error/aritmetica";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String numeroFormatoError(NumberFormatException ex, Model model) {
        model.addAttribute("error", "Error: Formato número inválido!");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        // Se puede usar esta vista o la genérica que he creado, aprovechando que las dos vistas son iguales
        return "error/numero-formato";
    }
}
