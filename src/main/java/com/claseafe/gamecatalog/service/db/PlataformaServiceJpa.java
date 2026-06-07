package com.claseafe.gamecatalog.service.db;
import java.util.List; import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary; import org.springframework.stereotype.Service;
import com.claseafe.gamecatalog.model.Plataforma;
import com.claseafe.gamecatalog.repository.IPlataformaRepository;
import com.claseafe.gamecatalog.service.IPlataformaService;
@Primary @Service
public class PlataformaServiceJpa implements IPlataformaService {
    @Autowired private IPlataformaRepository repo;
    @Override public List<Plataforma> buscarTodas() { return repo.findAll(); }
    @Override public Plataforma buscaPorId(Integer id) { Optional<Plataforma> o = repo.findById(id); return o.isPresent() ? o.get() : null; }
    @Override public void guardar(Plataforma p) { repo.save(p); }
    @Override public void eliminar(Integer id) { repo.deleteById(id); }
}
