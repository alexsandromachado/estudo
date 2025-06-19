package com.exemplo.estudo.dto;

import com.exemplo.estudo.entity.Produto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        BigDecimal valor,
        String descricao
) {

    public ProdutoResponseDTO (Produto produto) {
     this(
             produto.getId(),
             produto.getNome(),
             produto.getValor(),
             produto.getDescricao()
     );
    }

}

