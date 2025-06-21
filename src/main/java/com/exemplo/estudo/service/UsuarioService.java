package com.exemplo.estudo.service;

import com.exemplo.estudo.dto.RoleIdDTO;
import com.exemplo.estudo.dto.UsuarioCadastroDTO;
import com.exemplo.estudo.entity.Usuario;
import com.exemplo.estudo.exception.UserEmailAlreadyExistsException;
import com.exemplo.estudo.repository.RoleRepository;
import com.exemplo.estudo.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
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
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmailIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("O usuário não foi encontrado!"));
    }

    @Transactional
    public Usuario cadastrar(UsuarioCadastroDTO dados) {
       if( usuarioRepository.existsByEmailIgnoreCase(dados.email())){
            throw new UserEmailAlreadyExistsException("Já existe um usuário cadastrado com este e-mail!");
        }

        var senhaCriptografada = passwordEncoder.encode(dados.senha());
        var usuario = new Usuario(dados, senhaCriptografada);

        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPeloNome(String nome) {
        return usuarioRepository.findByNomeIgnoreCase(nome).orElseThrow(
                () -> new RuntimeException("Nome de usuário não encontrado!"));
    }

    public void atribuirRoles(Long id, RoleIdDTO role) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado!"));
        role.idRoles().forEach(r -> {
            var roleEntity = roleRepository.findById(r)
                    .orElseThrow(() -> new RuntimeException("Role com id " + r + " não encontrada!"));
            usuario.getRoles().add(roleEntity);
        });

        usuario.getRoles().forEach(r -> System.out.println(r.getNome()));
        usuarioRepository.save(usuario);
    }
}