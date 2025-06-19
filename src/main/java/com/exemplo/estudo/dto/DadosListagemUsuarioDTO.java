package com.exemplo.estudo.dto;

import com.exemplo.estudo.entity.Usuario;

public record DadosListagemUsuarioDTO(Long id,
                                      String email,
                                      String nome
) {
    public DadosListagemUsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getEmail(),
                usuario.getNome());
    }
}
