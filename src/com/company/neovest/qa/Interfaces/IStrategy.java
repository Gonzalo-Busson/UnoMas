package com.company.neovest.qa.Interfaces;

import com.company.neovest.qa.Partido;
import com.company.neovest.qa.Usuario;

import java.util.List;

public interface IStrategy {
    public void encontrarPartidoAdecuado(Partido partido, Usuario usuario, List<Partido> partidosAdecuados) throws Exception;
}
