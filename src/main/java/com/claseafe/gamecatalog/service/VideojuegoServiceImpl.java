package com.claseafe.gamecatalog.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.claseafe.gamecatalog.model.Videojuego;

@Service
public class VideojuegoServiceImpl implements IVideojuegoService {

    private List<Videojuego> lista;

    public VideojuegoServiceImpl() {
        lista = new ArrayList<Videojuego>();

        Videojuego v1 = new Videojuego();
        v1.setId(1);
        v1.setTitulo("The Legend of Zelda: Breath of the Wild");
        v1.setDescripcion("Aventura épica en mundo abierto");
        v1.setPrecio(59.99);
        v1.setAnioLanzamiento(2017);
        v1.setClasificacion("E10+");
        v1.setEstatus("Disponible");
        lista.add(v1);

        Videojuego v2 = new Videojuego();
        v2.setId(2);
        v2.setTitulo("God of War");
        v2.setDescripcion("Kratos y su hijo en la mitología nórdica");
        v2.setPrecio(49.99);
        v2.setAnioLanzamiento(2018);
        v2.setClasificacion("M");
        v2.setEstatus("Disponible");
        lista.add(v2);

        Videojuego v3 = new Videojuego();
        v3.setId(3);
        v3.setTitulo("Minecraft");
        v3.setDescripcion("Construye y explora mundos infinitos");
        v3.setPrecio(29.99);
        v3.setAnioLanzamiento(2011);
        v3.setClasificacion("E10+");
        v3.setEstatus("Disponible");
        lista.add(v3);
    }

    @Override
    public List<Videojuego> buscarTodos() {
        return lista;
    }

    @Override
    public Videojuego buscaPorId(Integer id) {
        for (Videojuego v : lista) {
            if (v.getId().equals(id)) return v;
        }
        return null;
    }

    @Override
    public void guardar(Videojuego videojuego) {
        lista.add(videojuego);
    }

    @Override
    public void eliminar(Integer id) {
        lista.removeIf(v -> v.getId().equals(id));
    }
}
