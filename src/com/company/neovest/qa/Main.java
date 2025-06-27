package com.company.neovest.qa;

import com.company.neovest.qa.controller.ControllerPartido;
import com.company.neovest.qa.controller.ControllerUsuario;
import com.company.neovest.qa.notifications.NotificationFacade;
import com.company.neovest.qa.state.Cancelado;
import com.company.neovest.qa.state.EnJuego;
import com.company.neovest.qa.state.Finalizado;
import com.company.neovest.qa.strategy.HabilidadDelJugador;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
    // Example usage of the Notification system
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        NotificationFacade notification = new NotificationFacade();
        ControllerPartido cPartido = new ControllerPartido();
        ControllerUsuario cUsuario = new ControllerUsuario();
        cUsuario.crearUsuario("a","a","a@gemail.com",new GeoLocation(40, -74));
        cUsuario.crearUsuario("b","b","b@gmail.com",new GeoLocation(40, -74));
        Deporte tennis = new Deporte("Tennis","1",2);
        cUsuario.agregarDeporteFavorito(cUsuario.getUsuarios().get(0), tennis,Nivel.INTERMEDIO);
        cUsuario.agregarDeporteFavorito(cUsuario.getUsuarios().get(1), tennis,Nivel.AVANZADO);

        //Probar Login
        cUsuario.loginUsuario("a","a");

        Usuario a= cUsuario.getUsuarios().get(0);
        Usuario b = cUsuario.getUsuarios().get(1);
        // probar crear partido
        cPartido.crearPartido(new Date(),10,new GeoLocation(40, -74),tennis,a);
        // configurar estrategia de emparejamiento
        cPartido.configurarEstrategiaDeEmparejamiento(cPartido.getPartidos().get(0),new HabilidadDelJugador());
        // probar buscar partidos
        System.out.println("partidos encontrados : " + cPartido.buscarPartidos(a).size());
        // probar unirse a partido
        System.out.println("-----agregando Jugador a partido");
        cPartido.getPartidos().get(0).agregarJugador(b);

        System.out.println("partido: "+cPartido.getPartidos().get(0).getId() + "tiene Jugadores Actuales: "+cPartido.getPartidos().get(0).getJugadoresActuales().size());

        // Probar notificaciones cancelar
        cPartido.actualizarPartido(cPartido.getPartidos().get(0), new EnJuego());
        cPartido.actualizarPartido(cPartido.getPartidos().get(0), new Finalizado());
        cPartido.actualizarPartido(cPartido.getPartidos().get(0), new Cancelado());
        // Probar agregar jugador a partido completo

    }


}
