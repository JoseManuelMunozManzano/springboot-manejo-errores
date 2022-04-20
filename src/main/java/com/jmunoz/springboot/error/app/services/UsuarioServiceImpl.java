package com.jmunoz.springboot.error.app.services;

import com.jmunoz.springboot.error.app.models.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            // Nota importante.
            // Se usa el método equals en vez del signo == porque es del tipo OBJETO Integer.
            // Solo sirve el signo == cuando la lista no supera los 128 elementos, ya que los primeros 128
            // elementos, la máquina virtual de Java los guarda en caché como valores y como objetos.
            // Entonces con el signo ==, como evalúa por referencia, a partir del elemento 129 ya es distinta.
            // Sin embargo, con el método equals, como se evalúa por valor ya no habría problema.
            //
            // Si fuera del tipo primitivo int entonces sí se podría usar sin problemas el signo ==
            if (u.getId().equals(id)) {
                resultado = u;
                break;
            }
        }

        return resultado;
    }
}
