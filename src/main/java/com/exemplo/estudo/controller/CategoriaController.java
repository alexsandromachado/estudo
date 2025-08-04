package com.exemplo.estudo.controller;

import com.exemplo.estudo.dto.CategoriaResponseDTO;
import com.exemplo.estudo.dto.ProdutoRequestDTO;
import com.exemplo.estudo.dto.ProdutoResponseDTO;
import com.exemplo.estudo.service.CategoriaService;
import com.exemplo.estudo.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/{produtoId}")
    public List<CategoriaResponseDTO> listarTodos(@PathVariable Long produtoId) {
        return categoriaService.listarTodos(produtoId);
    }


}

