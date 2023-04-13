package com.alev.mundodisney.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "personaje_pelicula",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private List<Pelicula> peliculas;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "personaje_serie",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "serie_id"))
    private List<Serie> series;
}
