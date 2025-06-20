package com.exemplo.estudo.repository;

import com.exemplo.estudo.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
