package com.company.neovest.qa;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre;
    private String password;
    private String email;
    private Nivel nivelUsuario;
    private Deporte deporte;
    private List<Partido> historialDePartidos;



    private GeoLocation Location;

    // Constructor
    public Usuario(String nombre, String password, String email, GeoLocation location) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.Location= location;

    }


    public void actualizarDeporte(Deporte nuevoDeporte, Nivel nuevoNivel) {
        this.setDeporte(nuevoDeporte);
        this.setNivelUsuario(nuevoNivel);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Nivel getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(Nivel nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public GeoLocation getLocation() {
        return Location;
    }

    public void setLocation(GeoLocation location) {
        Location = location;
    }

    public List<Partido> getHistorialDePartidos() {
        return historialDePartidos;
    }

    public void agregarPartido(Partido partido) {
        if (this.historialDePartidos == null) {
            this.historialDePartidos = new ArrayList<>();
        }
        this.historialDePartidos.add(partido);
    }

}
