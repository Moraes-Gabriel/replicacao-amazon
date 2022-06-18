package br.com.example.amazon.amazon.service.enderecos;

import br.com.example.amazon.amazon.controller.request.AdicionarEnderecoRequeSt;
import br.com.example.amazon.amazon.mapper.AdicionarEnderecoMapper;
import br.com.example.amazon.amazon.model.Endereco;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.UsuarioRepository;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdicionarEnderecoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public void adicionar(AdicionarEnderecoRequeSt request) {

        Usuario usuario = usuarioAutenticadoService.get();

        Endereco endereco = AdicionarEnderecoMapper.toEntity(request);

        usuario.getEnderecos().add(endereco);

        usuarioRepository.save(usuario);
    }
}
