package com.alev.mundodisney.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String imagen;
    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "personaje_genero",
            joinColumns = @JoinColumn(name = "genero_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private List<Pelicula> peliculas;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "personaje_serie",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "serie_id"))
    private List<Serie> series;



}
