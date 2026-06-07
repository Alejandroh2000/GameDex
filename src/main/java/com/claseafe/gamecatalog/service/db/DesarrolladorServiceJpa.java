package com.claseafe.gamecatalog.service.db;
import java.util.List; import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary; import org.springframework.stereotype.Service;
import com.claseafe.gamecatalog.model.Desarrollador;
import com.claseafe.gamecatalog.repository.IDesarrolladorRepository;
import com.claseafe.gamecatalog.service.IDesarrolladorService;
@Primary @Service
public class DesarrolladorServiceJpa implements IDesarrolladorService {
    @Autowired private IDesarrolladorRepository repo;
    @Override public List<Desarrollador> buscarTodos() { return repo.findAll(); }
    @Override public Desarrollador buscaPorId(Integer id) { Optional<Desarrollador> o = repo.findById(id); return o.isPresent() ? o.get() : null; }
    @Override public void guardar(Desarrollador d) { repo.save(d); }
    @Override public void eliminar(Integer id) { repo.deleteById(id); }
}
