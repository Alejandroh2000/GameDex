package com.claseafe.gamecatalog.service.db;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.claseafe.gamecatalog.model.Genero;
import com.claseafe.gamecatalog.repository.IGeneroRepository;
import com.claseafe.gamecatalog.service.IGeneroService;

@Primary
@Service
public class GeneroServiceJpa implements IGeneroService {

    @Autowired
    private IGeneroRepository generoRepository;

    @Override
    public List<Genero> buscarTodos() {
        return generoRepository.findAll();
    }

    @Override
    public Genero buscaPorId(Integer id) {
        Optional<Genero> optional = generoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public void guardar(Genero genero) {
        generoRepository.save(genero);
    }

    @Override
    public void eliminar(Integer id) {
        generoRepository.deleteById(id);
    }
}
