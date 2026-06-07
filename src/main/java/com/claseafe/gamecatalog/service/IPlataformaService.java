package com.claseafe.gamecatalog.service;

import java.util.List;
import com.claseafe.gamecatalog.model.Plataforma;

public interface IPlataformaService {
    List<Plataforma> buscarTodas();
    Plataforma buscaPorId(Integer id);
    void guardar(Plataforma plataforma);
    void eliminar(Integer id);
}
