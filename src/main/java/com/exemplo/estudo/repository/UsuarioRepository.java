package com.exemplo.estudo.repository;

import com.exemplo.estudo.entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailIgnoreCase(String email);
    Optional<Usuario> findByNomeIgnoreCase(String nomeUsuario);
    boolean existsByEmailIgnoreCase(String email);
}
