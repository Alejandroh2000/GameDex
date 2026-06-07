package com.claseafe.gamecatalog.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.claseafe.gamecatalog.model.Genero;

@Service
public class GeneroServiceImpl implements IGeneroService {

    private List<Genero> lista;

    public GeneroServiceImpl() {
        lista = new ArrayList<Genero>();

        Genero g1 = new Genero();
        g1.setId(1);
        g1.setNombre("Acción");
        g1.setDescripcion("Juegos de combate y movimiento rápido");
        lista.add(g1);

        Genero g2 = new Genero();
        g2.setId(2);
        g2.setNombre("RPG");
        g2.setDescripcion("Juegos de rol con historia profunda");
        lista.add(g2);

        Genero g3 = new Genero();
        g3.setId(3);
        g3.setNombre("Aventura");
        g3.setDescripcion("Exploración y resolución de puzzles");
        lista.add(g3);
    }

    @Override
    public List<Genero> buscarTodos() {
        return lista;
    }

    @Override
    public Genero buscaPorId(Integer id) {
        for (Genero g : lista) {
            if (g.getId().equals(id)) return g;
        }
        return null;
    }

    @Override
    public void guardar(Genero genero) {
        lista.add(genero);
    }

    @Override
    public void eliminar(Integer id) {
        lista.removeIf(g -> g.getId().equals(id));
    }
}
