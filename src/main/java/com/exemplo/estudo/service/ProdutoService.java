package com.exemplo.estudo.service;


import com.exemplo.estudo.dto.ProdutoRequestDTO;
import com.exemplo.estudo.dto.ProdutoResponseDTO;
import com.exemplo.estudo.entity.Produto;
import com.exemplo.estudo.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoResponseDTO> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoResponseDTO::new)
                .toList();
    }

    public Page<ProdutoResponseDTO> listarPaginado(Pageable pageable) {
        return produtoRepository.findAll(pageable)
                .map(ProdutoResponseDTO::new);
    }

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = buscarEntidadePorId(id);
        return new ProdutoResponseDTO(produto);
    }

    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setValor(dto.valor());
        produto.setDescricao(dto.descricao());

        Produto salvo = produtoRepository.save(produto);
        return new ProdutoResponseDTO(salvo);
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produto = buscarEntidadePorId(id);

        produto.setNome(dto.nome());
        produto.setValor(dto.valor());
        produto.setDescricao(dto.descricao());

        Produto atualizado = produtoRepository.save(produto);
        return new ProdutoResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        Produto produto = buscarEntidadePorId(id);
        produtoRepository.delete(produto);
    }

    private Produto buscarEntidadePorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
    }
}
