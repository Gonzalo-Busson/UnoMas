package com.company.neovest.qa.strategy;

import com.company.neovest.qa.Interfaces.IStrategy;
import com.company.neovest.qa.Partido;
import com.company.neovest.qa.Usuario;
import com.sun.tools.javac.util.List;

public class HabilidadDelJugador implements IStrategy {

    @Override
    public void encontrarPartidoAdecuado(Partido partido, Usuario usuario, java.util.List<Partido> partidosAdecuados) throws Exception {
        if (partido.getJugadoresActuales().get(0).getNivelUsuario() == usuario.getNivelUsuario()) {
            partidosAdecuados.add(partido);
        }
    }
}
