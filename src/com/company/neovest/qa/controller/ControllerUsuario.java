package com.company.neovest.qa.controller;

import com.company.neovest.qa.Deporte;
import com.company.neovest.qa.GeoLocation;
import com.company.neovest.qa.Nivel;
import com.company.neovest.qa.Usuario;
import com.company.neovest.qa.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {

    UsuarioService us = UsuarioService.getInstance();


    public List<Usuario> getUsuarios() {
        return us.getUsuarios();
    }


    public void crearUsuario(String nombre, String password, String email, GeoLocation location){
        Usuario usuario = new Usuario(nombre,password,email,location);
        us.repositorioUsuarios.add(usuario);
    }
    public void loginUsuario(String nombre, String password) {
        boolean encontrado = false;

        for (Usuario usuario : us.repositorioUsuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getPassword().equals(password)) {
                System.out.println("-------Bienvenido " + usuario.getNombre() + "--------");
                encontrado = true;
                break; // salimos del bucle
            }
        }
        if (!encontrado) {
            System.out.println("-------Error de login--------");
        }
    }

    public void agregarDeporteFavorito(Usuario usuario, Deporte deporte, Nivel nuevoNivel){
        usuario.actualizarDeporte(deporte,nuevoNivel);
        us.ActualizarDeporteFavorito(usuario,deporte,nuevoNivel);
    }


}
