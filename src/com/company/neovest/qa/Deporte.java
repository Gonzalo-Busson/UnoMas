package com.company.neovest.qa;

public class Deporte {
    private String nombre;
    private String id;
    private Integer numeroJugadores;

    public Deporte(String nombre, String id, Integer numeroJugadores) {
        this.nombre = nombre;
        this.id = id;
        this.numeroJugadores = numeroJugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(Integer numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }
}
