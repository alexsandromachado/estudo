package com.exemplo.estudo.repository;

import com.exemplo.estudo.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("Select p from Produto p where p.descricao like '%com%' ORDER BY p.nome")
    List<Produto> findOrdenado();

}
