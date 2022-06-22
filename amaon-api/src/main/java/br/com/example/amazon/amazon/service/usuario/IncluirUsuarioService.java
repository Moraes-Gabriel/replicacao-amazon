package br.com.example.amazon.amazon.service.usuario;

import br.com.example.amazon.amazon.controller.request.IncluirUsuarioRequest;
import br.com.example.amazon.amazon.controller.response.IncluirUsuarioResponse;
import br.com.example.amazon.amazon.mapper.IncluirUsuarioMapper;
import br.com.example.amazon.amazon.model.Permissao;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static br.com.example.amazon.amazon.mapper.IncluirUsuarioMapper.toEntity;

@Service
public class IncluirUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public IncluirUsuarioResponse incluir(IncluirUsuarioRequest request) {

        request.setSenha(passwordEncoder.encode(request.getSenha()));

        Permissao permissao = Permissao.builder().nome("USER").build();

        Usuario usuario = toEntity(request);
        usuario.setPermissoes(new ArrayList<>());
        usuario.getPermissoes().add(permissao);

        usuarioRepository.save(usuario);

        return IncluirUsuarioMapper.toResponse(usuario);
    }
}
