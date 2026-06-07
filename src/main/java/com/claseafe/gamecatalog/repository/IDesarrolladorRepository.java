package com.claseafe.gamecatalog.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.claseafe.gamecatalog.model.Desarrollador;
public interface IDesarrolladorRepository extends JpaRepository<Desarrollador, Integer> {
    
    
}
