package com.company.neovest.qa;

import com.company.neovest.qa.Interfaces.IObserver;
import com.company.neovest.qa.Interfaces.IState;
import com.company.neovest.qa.Interfaces.IStrategy;
import com.company.neovest.qa.notifications.NotificationFacade;
import com.company.neovest.qa.service.UsuarioService;
import com.company.neovest.qa.state.*;
import com.company.neovest.qa.strategy.ProximidadDelJugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partido {
    public Partido(Date fechaPartido, int duracion, GeoLocation location, Deporte deporte,Usuario organizador) {
        this.id = String.valueOf(Math.random());
        this.fechaPartido = fechaPartido;
        this.location = location;
        this.deporte = deporte;
        this.duracion = duracion;
        this.state= new NecesitandoJugadores();
        this.estrategiaDeEmparejamiento = new ProximidadDelJugador();
        this.jugadoresActuales = new ArrayList<>();
        this.jugadoresActuales.add(organizador);
    }

    private String id;
    private List<Usuario> usuarios;
    private IState state;
    private Date fechaPartido;
    private GeoLocation location;
    private Deporte deporte;
    private int duracion;
    private List<Usuario> jugadoresActuales;
    private List<IObserver> observers;
    private IStrategy estrategiaDeEmparejamiento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        NotificationFacade notificacion = new NotificationFacade();
        if (state instanceof NecesitandoJugadores) {
        } else if (state instanceof Armado) {
            notificacion.sendNotificationPartidoEnArmado(this.getJugadoresActuales());
        } else if (state instanceof EnJuego) {
            notificacion.sendNotificationPartidoEnJuego(this.getJugadoresActuales());
        } else if (state instanceof Finalizado) {
            notificacion.sendNotificationPartidoFinalizado(this.getJugadoresActuales());
        } else if (state instanceof Cancelado) {
            notificacion.sendNotificationPartidoCancelado(this.getJugadoresActuales());
        }
        this.state = state;
    }

    public int getNumeroJugadores() {
        return deporte.getNumeroJugadores();
    }


    public Date getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation geoLocation) {
        this.location = geoLocation;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public IStrategy getEstrategiaDeEmparejamiento() {
        return estrategiaDeEmparejamiento;
    }

    public void setEstrategiaDeEmparejamiento(IStrategy estrategiaDeEmparejamiento) {
        this.estrategiaDeEmparejamiento = estrategiaDeEmparejamiento;
    }

    public List<Usuario> getJugadoresActuales() {
        return jugadoresActuales;
    }

    public void setJugadoresActuales(List<Usuario> jugadoresActuales) {
        this.jugadoresActuales = jugadoresActuales;
    }

    public void agregarJugador(Usuario jugador) {
        if (!jugadoresActuales.contains(jugador) && jugadoresActuales.size() < deporte.getNumeroJugadores()){
            jugadoresActuales.add(jugador);
            if (jugadoresActuales.size() == deporte.getNumeroJugadores()) {
                IState nuevoEstado = new Armado();
                setState(new Armado());
                System.out.println("Partido armado con éxito. Jugadores actuales: " + jugadoresActuales.size() + "/" + deporte.getNumeroJugadores());
            }
        }else if (jugadoresActuales.size() >= deporte.getNumeroJugadores()) {
            System.out.println("El partido ya está completo. No se pueden agregar más jugadores.");
        }


    }

    public  void eliminarJugador(Usuario jugador){
        if (jugadoresActuales == null || !jugadoresActuales.contains(jugador)) {
            System.out.println("El jugador no está en la lista de jugadores actuales.");
        }
        if (jugadoresActuales.contains(jugador)){
            jugadoresActuales.remove(jugador);
            NotificationFacade notificacion = new NotificationFacade();
            notificacion.sendNotificationPartidoNecesitandoJugadores(this.getJugadoresActuales());
            System.out.println("Partido NecesitandoJugadores. Jugadores actuales: " + jugadoresActuales.size() + "/" + deporte.getNumeroJugadores());

        }

    }


    public List<IObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<IObserver> observers) {
        this.observers = observers;
    }


}