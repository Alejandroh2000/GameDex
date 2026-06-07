package com.claseafe.gamecatalog.service;

import java.util.List;
import com.claseafe.gamecatalog.model.Desarrollador;

public interface IDesarrolladorService {
    List<Desarrollador> buscarTodos();
    Desarrollador buscaPorId(Integer id);
    void guardar(Desarrollador desarrollador);
    void eliminar(Integer id);
}
