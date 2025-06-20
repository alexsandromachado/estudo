package com.exemplo.estudo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCadastroDTO(
        @NotBlank String nome,
        @Email @NotBlank String email,
        @NotBlank String senha
) {}