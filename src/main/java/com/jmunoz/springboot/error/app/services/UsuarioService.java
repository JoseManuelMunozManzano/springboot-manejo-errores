package com.jmunoz.springboot.error.app.services;

import com.jmunoz.springboot.error.app.models.domain.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario obtenerPorId(Integer id);
}
