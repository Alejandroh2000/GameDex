package com.claseafe.gamecatalog.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.claseafe.gamecatalog.model.Videojuego;
public interface IVideojuegoRepository extends JpaRepository<Videojuego, Integer> {

    
}
