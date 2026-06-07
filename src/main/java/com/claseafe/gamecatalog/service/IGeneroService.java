package com.claseafe.gamecatalog.service;

import java.util.List;
import com.claseafe.gamecatalog.model.Genero;

public interface IGeneroService {
    List<Genero> buscarTodos();
    Genero buscaPorId(Integer id);
    void guardar(Genero genero);
    void eliminar(Integer id);
}
