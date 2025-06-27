package com.company.neovest.qa.controller;

import com.company.neovest.qa.Deporte;
import com.company.neovest.qa.GeoLocation;
import com.company.neovest.qa.Interfaces.IState;
import com.company.neovest.qa.Interfaces.IStrategy;
import com.company.neovest.qa.Partido;
import com.company.neovest.qa.Usuario;
import com.company.neovest.qa.notifications.NotificationFacade;
import com.company.neovest.qa.service.PartidoService;
import com.company.neovest.qa.service.UsuarioService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ControllerPartido {

    public PartidoService ps = new PartidoService();
    NotificationFacade nf = new NotificationFacade();
    UsuarioService us = UsuarioService.getInstance();

    public List<Partido> getPartidos() {
        return ps.repositorioPartidos;
    }

    public void crearPartido(Date fecha, int duracion,GeoLocation ubicacion, Deporte deporte,Usuario organizador){
        Partido partido = new Partido(fecha, duracion, ubicacion, deporte,organizador);
        ps.repositorioPartidos.add(partido);
        List<Usuario> usuariosANotificar= new ArrayList<>();
        for (Usuario usuario:us.getUsuarios()
             ) {
            if (deporte.getNombre()==usuario.getDeporte().getNombre()){
                usuariosANotificar.add(usuario);
            }
        }
        NotificationFacade notificacion = new NotificationFacade();
        notificacion.sendNotificationPartidoNecesitandoJugadores(usuariosANotificar);
    }

    public void configurarEstrategiaDeEmparejamiento(Partido partido,IStrategy estrategiaDeEmparejamiento){
        ps.setEstrategiaDePartido(estrategiaDeEmparejamiento,partido);
    }

    public List<Partido> buscarPartidos(Usuario usuario) throws Exception {
        System.out.println("-----------Buscando partidos para el usuario: " + usuario.getNombre());
        return ps.buscarPartidos(usuario);
    }

    public void unirseAPartido(Usuario usuario, Partido partido){
        partido.agregarJugador(usuario);
    }

    public void actualizarPartido(Partido partido , IState state){
        partido.setState(state);
    }

}
