package com.claseafe.gamecatalog.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.claseafe.gamecatalog.model.Desarrollador;

@Service
public class DesarrolladorServiceImpl implements IDesarrolladorService {
    private List<Desarrollador> lista;
    public DesarrolladorServiceImpl() {
        lista = new ArrayList<>();
        Desarrollador d1 = new Desarrollador(); d1.setId(1); d1.setNombre("Nintendo"); d1.setPais("Japón"); lista.add(d1);
        Desarrollador d2 = new Desarrollador(); d2.setId(2); d2.setNombre("Sony Santa Monica"); d2.setPais("USA"); lista.add(d2);
        Desarrollador d3 = new Desarrollador(); d3.setId(3); d3.setNombre("Mojang"); d3.setPais("Suecia"); lista.add(d3);
    }
    @Override public List<Desarrollador> buscarTodos() { return lista; }
    @Override public Desarrollador buscaPorId(Integer id) { for (Desarrollador d : lista) { if (d.getId().equals(id)) return d; } return null; }
    @Override public void guardar(Desarrollador d) { lista.add(d); }
    @Override public void eliminar(Integer id) { lista.removeIf(d -> d.getId().equals(id)); }
}
