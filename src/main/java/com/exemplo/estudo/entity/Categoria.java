package com.exemplo.estudo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Categoria {
    @Id
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;
}
