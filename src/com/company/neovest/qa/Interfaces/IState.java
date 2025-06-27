package com.company.neovest.qa.Interfaces;

import com.company.neovest.qa.Partido;

public interface IState {

   public void cambiarEstado(Partido partido);
   public boolean puedeCambiarEstado(Partido partido);
   public IState getEstado(Partido partido);

}