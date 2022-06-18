package br.com.example.amazon.amazon.service.usuario.cartao;

import br.com.example.amazon.amazon.controller.request.AdicionarCartaoRequest;
import br.com.example.amazon.amazon.mapper.AdicionarCartaoMapper;
import br.com.example.amazon.amazon.model.CartaoCredito;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.UsuarioRepository;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarCartaoService {


    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void adicionar(AdicionarCartaoRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();
        CartaoCredito cartao = AdicionarCartaoMapper.toEntity(request);

        usuario.getCartoes().add(cartao);

        usuarioRepository.save(usuario);
    }
}
