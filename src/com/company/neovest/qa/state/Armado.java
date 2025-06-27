package com.company.neovest.qa.state;

import com.company.neovest.qa.Interfaces.IState;
import com.company.neovest.qa.Partido;

public class Armado implements IState {


    @Override
    public void cambiarEstado(Partido partido) {
        partido.setState(new Armado());
    }

    @Override
    public boolean puedeCambiarEstado(Partido partido) {
        if (partido.getJugadoresActuales().size()== partido.getNumeroJugadores()) {
            return true; // El partido puede cambiar de estado a EnJuego}
        } else {return false;}
    }

    @Override
    public IState getEstado(Partido partido) {
        return  partido.getState();
    }
}
