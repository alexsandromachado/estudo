package com.exemplo.estudo.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosRefreshTokenDTO(@NotBlank String refreshToken) {
}
