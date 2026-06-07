package com.claseafe.gamecatalog.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.claseafe.gamecatalog.model.Plataforma;

@Service
public class PlataformaServiceImpl implements IPlataformaService {
    private List<Plataforma> lista;
    public PlataformaServiceImpl() {
        lista = new ArrayList<>();
        Plataforma p1 = new Plataforma(); p1.setId(1); p1.setNombre("PC"); p1.setFabricante("Varios"); lista.add(p1);
        Plataforma p2 = new Plataforma(); p2.setId(2); p2.setNombre("PlayStation 5"); p2.setFabricante("Sony"); lista.add(p2);
        Plataforma p3 = new Plataforma(); p3.setId(3); p3.setNombre("Nintendo Switch"); p3.setFabricante("Nintendo"); lista.add(p3);
        Plataforma p4 = new Plataforma(); p4.setId(4); p4.setNombre("Xbox Series X"); p4.setFabricante("Microsoft"); lista.add(p4);
    }
    @Override public List<Plataforma> buscarTodas() { return lista; }
    @Override public Plataforma buscaPorId(Integer id) { for (Plataforma p : lista) { if (p.getId().equals(id)) return p; } return null; }
    @Override public void guardar(Plataforma p) { lista.add(p); }
    @Override public void eliminar(Integer id) { lista.removeIf(p -> p.getId().equals(id)); }
}
