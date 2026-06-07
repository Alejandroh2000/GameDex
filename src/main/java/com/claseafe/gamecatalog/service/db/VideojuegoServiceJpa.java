package com.claseafe.gamecatalog.service.db;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.claseafe.gamecatalog.model.Videojuego;
import com.claseafe.gamecatalog.repository.IVideojuegoRepository;
import com.claseafe.gamecatalog.service.IVideojuegoService;

@Primary
@Service
public class VideojuegoServiceJpa implements IVideojuegoService {

    @Autowired
    private IVideojuegoRepository videojuegoRepository;

    @Override
    public List<Videojuego> buscarTodos() {
        return videojuegoRepository.findAll();
    }

    @Override
    public Videojuego buscaPorId(Integer id) {
        Optional<Videojuego> optional = videojuegoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public void guardar(Videojuego videojuego) {
        videojuegoRepository.save(videojuego);
    }

    @Override
    public void eliminar(Integer id) {
        videojuegoRepository.deleteById(id);
    }
}
