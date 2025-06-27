package com.company.neovest.qa.state;

import com.company.neovest.qa.Interfaces.IState;
import com.company.neovest.qa.Partido;

public class Finalizado implements IState {

    @Override
    public void cambiarEstado(Partido partido) {
        partido.setState(new Finalizado());
    }

    @Override
    public boolean puedeCambiarEstado(Partido partido) {
        return false; // El partido no puede cambiar de estado una vez finalizado
    }

    @Override
    public IState getEstado(Partido partido) {
        return partido.getState();
    }
}
