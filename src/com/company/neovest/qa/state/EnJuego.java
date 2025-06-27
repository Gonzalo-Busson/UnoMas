package com.company.neovest.qa.state;

import com.company.neovest.qa.Interfaces.IState;
import com.company.neovest.qa.Partido;

public class EnJuego implements IState {

    @Override
    public void cambiarEstado(Partido partido) {
        partido.setState(new EnJuego());
    }

    @Override
    public boolean puedeCambiarEstado(Partido partido) {
        return false; // El partido no puede cambiar de estado una vez en juego
    }

    @Override
    public IState getEstado(Partido partido) {
        return partido.getState();
    }
}
