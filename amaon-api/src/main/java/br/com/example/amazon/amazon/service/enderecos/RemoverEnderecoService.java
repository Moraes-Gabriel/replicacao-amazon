package br.com.example.amazon.amazon.service.enderecos;

import br.com.example.amazon.amazon.model.Endereco;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.UsuarioRepository;
import br.com.example.amazon.amazon.service.buscar.BuscarEnderecoService;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;

public class RemoverEnderecoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarEnderecoService buscarEnderecoService;

    public void remover(Long enderecoId) {

        Usuario usuario = usuarioAutenticadoService.get();
        Endereco endereco = buscarEnderecoService.porId(enderecoId);

        usuario.getEnderecos().remove(endereco);

        usuarioRepository.save(usuario);

    }
}
