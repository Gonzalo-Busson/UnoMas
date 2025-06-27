package com.company.neovest.qa;

import com.company.neovest.qa.controller.ControllerPartido;
import com.company.neovest.qa.controller.ControllerUsuario;
import com.company.neovest.qa.state.Armado;
import com.company.neovest.qa.state.EnJuego;
import com.company.neovest.qa.strategy.HabilidadDelJugador;
import com.company.neovest.qa.strategy.ProximidadDelJugador;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ControllerPartido cp = new ControllerPartido();
    ControllerUsuario cu = new ControllerUsuario();


    @Test
    void crearPartido() {
        cu.crearUsuario("Juanito","1234","juanito@gmail.com",new GeoLocation(40,50));
        Usuario juanito = cu.getUsuarios().get(0);
        Deporte tennis = new Deporte("tennis","1",2);
        cu.agregarDeporteFavorito(juanito,tennis,Nivel.INTERMEDIO);
        cp.crearPartido(new Date(),10,new GeoLocation(40,40),tennis,juanito);
        assertTrue(
            cp.getPartidos().size() > 0,
            "El partido no fue creado correctamente"
        );
    }

    @Test
    void agregarJugadorAPartido(){
        cu.crearUsuario("Juanito","1234","juanito@gmail.com",new GeoLocation(40,50));
        cu.crearUsuario("Luchito","1234","luchito@gmail.com",new GeoLocation(40,40));
        Usuario juanito = cu.getUsuarios().get(0);
        Usuario luchito = cu.getUsuarios().get(1);
        Deporte tennis = new Deporte("tennis","1",2);
        cu.agregarDeporteFavorito(juanito,tennis,Nivel.INTERMEDIO);
        cp.crearPartido(new Date(),10,new GeoLocation(35,45),tennis,juanito);
        Partido partidoTenis = cp.getPartidos().get(0);
        cp.unirseAPartido(cu.getUsuarios().get(1),partidoTenis);
        System.out.println(partidoTenis.getJugadoresActuales().size()
        );
        assertTrue(
            partidoTenis.getJugadoresActuales().contains(luchito),
            "El jugador no fue agregado al partido correctamente");
        assertTrue(
                partidoTenis.getJugadoresActuales().contains(juanito),
                "El jugador no fue agregado al partido correctamente");
        assertTrue(partidoTenis.getState() instanceof Armado,
            "El estado del partido no esta en estado Armado");
    }


    @Test
    void cambiarEstadoDePartido(){
        cu.crearUsuario("Juanito","1234","juanito@gmail.com",new GeoLocation(40,50));
        cu.crearUsuario("Luchito","1234","luchito@gmail.com",new GeoLocation(40,40));
        Usuario juanito = cu.getUsuarios().get(0);
        Usuario luchito = cu.getUsuarios().get(1);
        Deporte tennis = new Deporte("tennis","1",2);
        cu.agregarDeporteFavorito(juanito,tennis,Nivel.INTERMEDIO);
        cp.crearPartido(new Date(),10,new GeoLocation(35,45),tennis,juanito);
        Partido partidoTenis = cp.getPartidos().get(0);
        cp.unirseAPartido(cu.getUsuarios().get(1),partidoTenis);
        cp.actualizarPartido(partidoTenis, new EnJuego());
        assertTrue(partidoTenis.getState() instanceof EnJuego,
                "El estado del partido no esta en estado EnJuego");
    }

    @Test
    void cambiarEstrategiaDeEmparejamientoPorUbicaion() throws Exception {
        cu.crearUsuario("Juanito","1234","juanito@gmail.com",new GeoLocation(40,50));
        cu.crearUsuario("Luchito","1234","luchito@gmail.com",new GeoLocation(40,40));
        cu.crearUsuario("Benito","1234","Benito@gmail.com",new GeoLocation(10000,100000));
        Usuario juanito = cu.getUsuarios().get(0);
        Usuario luchito = cu.getUsuarios().get(1);
        Usuario benito = cu.getUsuarios().get(2);
        Deporte tennis = new Deporte("tennis","1",2);
        cu.agregarDeporteFavorito(juanito,tennis,Nivel.INTERMEDIO);
        cp.crearPartido(new Date(),10,new GeoLocation(35,45),tennis,juanito);
        Partido partidoTenis = cp.getPartidos().get(0);
        cp.configurarEstrategiaDeEmparejamiento(partidoTenis,new ProximidadDelJugador());
        assertTrue(
            partidoTenis.getEstrategiaDeEmparejamiento() instanceof ProximidadDelJugador,
            "La estrategia de emparejamiento no se ha configurado correctamente"
        );
        System.out.println("Partidos cercanos a Benito: " + cp.buscarPartidos(benito).size());
        System.out.println("Partidos cercanos a Luchito: " + cp.buscarPartidos(luchito).size());
    }

    @Test
    void cambiarEstrategiaDeEmparejamientoPorNivel() throws Exception {
        cu.crearUsuario("Juanito","1234","juanito@gmail.com",new GeoLocation(40,50));
        cu.crearUsuario("Luchito","1234","luchito@gmail.com",new GeoLocation(40,40));
        cu.crearUsuario("Benito","1234","Benito@gmail.com",new GeoLocation(10000,100000));
        Usuario juanito = cu.getUsuarios().get(0);
        Usuario luchito = cu.getUsuarios().get(1);
        Usuario benito = cu.getUsuarios().get(2);
        Deporte tennis = new Deporte("tennis","1",2);
        cu.agregarDeporteFavorito(juanito,tennis,Nivel.INTERMEDIO);
        cu.agregarDeporteFavorito(luchito,tennis,Nivel.INTERMEDIO);
        cu.agregarDeporteFavorito(benito,tennis,Nivel.PRINCIPIANTE);

        cp.crearPartido(new Date(),10,new GeoLocation(35,45),tennis,juanito);
        Partido partidoTenis = cp.getPartidos().get(0);
        cp.configurarEstrategiaDeEmparejamiento(partidoTenis,new HabilidadDelJugador());
        assertTrue(
                partidoTenis.getEstrategiaDeEmparejamiento() instanceof HabilidadDelJugador,
                "La estrategia de emparejamiento no se ha configurado correctamente"
        );
        System.out.println("Partidos cercanos a Benito: " + cp.buscarPartidos(benito).size());
        System.out.println("Partidos cercanos a Luchito: " + cp.buscarPartidos(luchito).size());
    }

}