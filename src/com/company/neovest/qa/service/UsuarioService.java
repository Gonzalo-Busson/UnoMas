package com.company.neovest.qa.service;

import com.company.neovest.qa.Deporte;
import com.company.neovest.qa.GeoLocation;
import com.company.neovest.qa.Nivel;
import com.company.neovest.qa.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    public List<Usuario> repositorioUsuarios = new ArrayList<>();;

    private static UsuarioService instance;

    // Private constructor prevents instantiation from other classes
    public UsuarioService() {}

    // Public method to provide access to the instance
    public static synchronized UsuarioService getInstance() {
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    public void crearUsuario(String nombre, String password, String email, GeoLocation location) {
        Usuario nuevoUsuario = new Usuario(nombre, password, email, location );
        this.repositorioUsuarios.add(nuevoUsuario);
    }

    public void ActualizarDeporteFavorito(Usuario usuario, Deporte deporte, Nivel nivel) {
        usuario.actualizarDeporte(deporte, nivel);
    }

    public Usuario buscarUsuario(String nombre, String password) throws Exception {
        for (Usuario usuario : this.repositorioUsuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        throw new Exception("Usuario no encontrado");
    }
    public List<Usuario> getUsuarios() {
        return repositorioUsuarios;
    }

}
