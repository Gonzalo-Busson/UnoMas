package com.company.neovest.qa.state;

import com.company.neovest.qa.Interfaces.IState;
import com.company.neovest.qa.Partido;

public class Cancelado implements IState {

    @Override
    public void cambiarEstado(Partido partido) {
        partido.setState(new Cancelado());
    }

    @Override
    public boolean puedeCambiarEstado(Partido partido) {
        return false; // El partido no puede cambiar de estado una vez cancelado
    }

    @Override
    public IState getEstado(Partido partido) {
        return partido.getState();
    }
}
