package com.exemplo.estudo.repository;

import com.exemplo.estudo.entity.Categoria;
import com.exemplo.estudo.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT c FROM Categoria c Join c.produtos p WHERE p.id = :produtoId")
    List<Categoria> findCategoriasByProdutoId(@Param("produtoId") Long produtoId);
}
