package com.exemplo.estudo.dto;

import com.exemplo.estudo.entity.Categoria;
import com.exemplo.estudo.entity.Produto;

import java.math.BigDecimal;

public record CategoriaResponseDTO(
        Long id,
        String nome

) {

    public CategoriaResponseDTO(Categoria categoria) {
     this(
             categoria.getId(),
             categoria.getNome()
     );
    }

}

