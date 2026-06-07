package com.claseafe.gamecatalog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import java.util.List;

@Entity
@Table(name = "desarrollador")
public class Desarrollador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String pais;
    private String descripcion;

    // Un desarrollador tiene MUCHOS videojuegos (@OneToMany)
    @OneToMany(mappedBy = "desarrollador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Videojuego> videojuegos;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Videojuego> getVideojuegos() { return videojuegos; }
    public void setVideojuegos(List<Videojuego> videojuegos) { this.videojuegos = videojuegos; }
}
