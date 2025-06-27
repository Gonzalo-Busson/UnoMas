package com.company.neovest.qa.service;

import com.company.neovest.qa.Deporte;
import com.company.neovest.qa.GeoLocation;
import com.company.neovest.qa.Interfaces.IStrategy;
import com.company.neovest.qa.Partido;
import com.company.neovest.qa.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartidoService {
    public List <Partido> repositorioPartidos = new ArrayList<>();
    public IStrategy estrategiaDePartido;

    public void crearPartido(Date fecha, GeoLocation ubicacion, Deporte deporte, int duracion, Usuario organizador) {
        Partido nuevoPartido = new Partido(fecha, duracion,ubicacion,deporte,organizador);
        this.repositorioPartidos.add(nuevoPartido);
    }

    public List<Partido> buscarPartidos(Usuario usuario) throws Exception {
        List<Partido> partidosAdecuados = new ArrayList<>();
        for (Partido partido : this.repositorioPartidos) {
            partido.getEstrategiaDeEmparejamiento().encontrarPartidoAdecuado(partido,usuario,partidosAdecuados);
        }
        return partidosAdecuados;
    }

    public Partido unirsePartido(Usuario usuario, String idPartido) throws Exception {
        for (Partido partido : this.repositorioPartidos) {
            if (partido.getId().equals(idPartido)){
                return partido;
            }else {
                throw new Exception("Partido no encontrado");
            }
        }
        return null;
    }

    public void setEstrategiaDePartido(IStrategy estrategiaDePartido,Partido partido){
        partido.setEstrategiaDeEmparejamiento(estrategiaDePartido);
    }

}
