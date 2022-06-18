package br.com.example.amazon.amazon.service.usuario.cartao;

import br.com.example.amazon.amazon.model.CartaoCredito;
import br.com.example.amazon.amazon.model.Usuario;
import br.com.example.amazon.amazon.repository.UsuarioRepository;
import br.com.example.amazon.amazon.service.buscar.BuscarCartaoCreditoService;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverCartaoCreditoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarCartaoCreditoService buscarCartaoCreditoService;

    public void remover(Long cartaoId) {

        Usuario usuario = usuarioAutenticadoService.get();

        CartaoCredito cartao = buscarCartaoCreditoService.porId(cartaoId);

        usuario.getCartoes().remove(cartao);

        usuarioRepository.save(usuario);
    }
}
