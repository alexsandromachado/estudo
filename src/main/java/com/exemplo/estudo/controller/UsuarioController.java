package com.exemplo.estudo.controller;

import com.exemplo.estudo.config.EmpresaContextHolder;
import com.exemplo.estudo.dto.DadosListagemUsuarioDTO;
import com.exemplo.estudo.dto.RoleIdDTO;
import com.exemplo.estudo.dto.UsuarioCadastroDTO;
import com.exemplo.estudo.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<DadosListagemUsuarioDTO> cadastrar(@RequestBody @Valid UsuarioCadastroDTO dados, UriComponentsBuilder uriBuilder) {
        System.out.println("EmpresaID: -> " + EmpresaContextHolder.getEmpresaId());
        var usuario = usuarioService.cadastrar(dados);
        var uri = uriBuilder.path("/{nomeUsuario}").buildAndExpand(usuario.getNome()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemUsuarioDTO(usuario));
    }

@PostMapping("/{id}/roles")
public ResponseEntity<?> atribuirPermissoes(
        @PathVariable Long id,
        @RequestBody RoleIdDTO role) {

    usuarioService.atribuirRoles(id, role);
    return ResponseEntity.ok().build();
}
}
