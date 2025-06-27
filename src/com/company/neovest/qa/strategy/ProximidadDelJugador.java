package com.company.neovest.qa.strategy;

import com.company.neovest.qa.Interfaces.IStrategy;
import com.company.neovest.qa.Partido;
import com.company.neovest.qa.Usuario;

import java.util.List;

public class ProximidadDelJugador implements IStrategy {

    @Override
    public void encontrarPartidoAdecuado(Partido partido, Usuario usuario, List<Partido> partidosAdecuados) throws Exception {
        if (partido.getLocation().distancia(usuario.getLocation())<= 100) {
            partidosAdecuados.add(partido);
        }
    }
}
