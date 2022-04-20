package com.jmunoz.springboot.error.app.controllers;

import com.jmunoz.springboot.error.app.models.domain.Usuario;
import com.jmunoz.springboot.error.app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/division0")
    public String divisionPorCero() {
        Integer valor = 100/0;
        return "index";
    }

    @GetMapping("/nonumber")
    public String numberFormatException() {
        Integer valor = Integer.parseInt("Esto no es un número");
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioService.obtenerPorId(id);

        model.addAttribute("usuario", usuario);
        // Si el usuario es null, al invocar el método getNombre() va a lanzarse la excepción NullPointerException.
        //
        // Un ejemplo de usuario null sería
        // http://localhost:8080/ver/8
        model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));

        return "ver";
    }

    // Nota: para probar página no encontrada (error 404) ir a la ruta:
    // http://localhost:8080/clientes
}
