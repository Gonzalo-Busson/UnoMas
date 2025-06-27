package com.company.neovest.qa.state;

import com.company.neovest.qa.Interfaces.IState;
import com.company.neovest.qa.Partido;

public class NecesitandoJugadores implements IState {

    @Override
    public void cambiarEstado(Partido partido) {
        partido.setState(new NecesitandoJugadores());
    }

    @Override
    public boolean puedeCambiarEstado(Partido partido) {
        return true; // El partido puede cambiar de estado si necesita más jugadores
    }

    @Override
    public IState getEstado(Partido partido) {
        return partido.getState();
    }
}
