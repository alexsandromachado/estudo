package com.exemplo.estudo.service;

import com.exemplo.estudo.dto.UsuarioCadastroDTO;
import com.exemplo.estudo.entity.Usuario;
import com.exemplo.estudo.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmailIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("O usuário não foi encontrado!"));
    }

    @Transactional
    public Usuario cadastrar(UsuarioCadastroDTO dados) {
        var senhaCriptografada = passwordEncoder.encode(dados.senha());
        var usuario = new Usuario(dados, senhaCriptografada);

        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPeloNome(String nome) {
        return usuarioRepository.findByNomeIgnoreCase(nome).orElseThrow(
                () -> new RuntimeException("Nome de usuário não encontrado!"));
    }

}