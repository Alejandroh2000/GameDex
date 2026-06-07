package com.claseafe.gamecatalog.service;

import java.util.List;
import com.claseafe.gamecatalog.model.Videojuego;

public interface IVideojuegoService {
    List<Videojuego> buscarTodos();
    Videojuego buscaPorId(Integer id);
    void guardar(Videojuego videojuego);
    void eliminar(Integer id);
}
