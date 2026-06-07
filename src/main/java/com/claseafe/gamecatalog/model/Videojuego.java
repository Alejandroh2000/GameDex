package com.claseafe.gamecatalog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "videojuego")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descripcion;
    private double precio;

    @Column(name = "anioLanzamiento")
    private Integer anioLanzamiento;

    private String clasificacion;
    private String estatus;
    private String imagen = "no-image.png";
    private String detalles;

    // Muchos videojuegos pertenecen a UN género (@ManyToOne -> genera @OneToMany en Genero)
    @ManyToOne
    @JoinColumn(name = "idGenero")
    private Genero genero;

    // Muchos videojuegos pertenecen a UN desarrollador (@ManyToOne -> genera @OneToMany en Desarrollador)
    @ManyToOne
    @JoinColumn(name = "idDesarrollador")
    private Desarrollador desarrollador;

    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "videojuego_plataforma",
        joinColumns = @JoinColumn(name = "idVideojuego"),
        inverseJoinColumns = @JoinColumn(name = "idPlataforma")
    )
    private List<Plataforma> plataformas;

    // ==================== Getters y Setters ====================

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public Integer getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(Integer anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }

    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    public String getEstatus() { return estatus; }
    public void setEstatus(String estatus) { this.estatus = estatus; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getDetalles() { return detalles; }
    public void setDetalles(String detalles) { this.detalles = detalles; }

    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }

    public Desarrollador getDesarrollador() { return desarrollador; }
    public void setDesarrollador(Desarrollador desarrollador) { this.desarrollador = desarrollador; }

    public List<Plataforma> getPlataformas() { return plataformas; }
    public void setPlataformas(List<Plataforma> plataformas) { this.plataformas = plataformas; }
}
