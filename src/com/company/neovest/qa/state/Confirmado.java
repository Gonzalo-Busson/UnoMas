package com.company.neovest.qa.state;

import com.company.neovest.qa.Interfaces.IState;
import com.company.neovest.qa.Partido;

public class Confirmado implements IState {
    @Override
    public void cambiarEstado(Partido partido) {
        partido.setState(new Confirmado());
    }

    @Override
    public boolean puedeCambiarEstado(Partido partido) {
        return false;
    }

    @Override
    public IState getEstado(Partido partido) {
        return null;
    }
}
