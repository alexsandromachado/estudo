package com.exemplo.estudo.service;


import com.exemplo.estudo.dto.CategoriaResponseDTO;
import com.exemplo.estudo.dto.ProdutoRequestDTO;
import com.exemplo.estudo.dto.ProdutoResponseDTO;
import com.exemplo.estudo.entity.Produto;
import com.exemplo.estudo.repository.CategoriaRepository;
import com.exemplo.estudo.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<CategoriaResponseDTO> listarTodos(Long produtoId) {
        return categoriaRepository.findCategoriasByProdutoId(produtoId)
                .stream()
                .map(CategoriaResponseDTO::new)
                .toList();
    }
}
