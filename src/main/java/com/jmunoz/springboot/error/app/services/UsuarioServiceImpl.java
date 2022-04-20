package com.jmunoz.springboot.error.app.services;

import com.jmunoz.springboot.error.app.models.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    // En un ejemplo real esto sería un acceso a BBDD
    private List<Usuario> lista;

    public UsuarioServiceImpl() {
        this.lista = new ArrayList<>();
        this.lista.add(new Usuario(1, "José", "Muñoz"));
        this.lista.add(new Usuario(2, "Adri", "Mena"));
        this.lista.add(new Usuario(3, "Pepito", "Sánchez"));
        this.lista.add(new Usuario(4, "Tania", "López"));
        this.lista.add(new Usuario(5, "Marina", "Gutierrez"));
        this.lista.add(new Usuario(6, "Rosa", "Manzano"));
        this.lista.add(new Usuario(7, "Ferney", "Acosta"));
    }

    @Override
    public List<Usuario> listar() {
        return lista;
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        Usuario resultado = null;

        for (Usuario u : this.lista) {
            if (u.getId().equals(id)) {
                resultado = u;
                break;
            }
        }

        return resultado;
    }

    // Una mejora al método obtenerPorId(), usando la característica Optional de Java8
    @Override
    public Optional<Usuario> obtenerPorIdOptional(Integer id) {
        Usuario usuario = obtenerPorId(id);
        // Con ofNullable convertimos usuario (sea o no null) en tipo Optional
        // La ventaja de ofNullable sobre of es que el primero acepta null y devolvería empty() en ese caso.
        return Optional.ofNullable(usuario);
    }
}
