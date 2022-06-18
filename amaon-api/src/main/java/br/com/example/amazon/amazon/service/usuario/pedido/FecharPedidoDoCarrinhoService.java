package br.com.example.amazon.amazon.service.usuario.pedido;

import br.com.example.amazon.amazon.model.*;
import br.com.example.amazon.amazon.repository.UsuarioRepository;
import br.com.example.amazon.amazon.service.buscar.BuscarCartaoCreditoService;
import br.com.example.amazon.amazon.service.buscar.BuscarEnderecoService;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Service
public class FecharPedidoDoCarrinhoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarEnderecoService buscarEnderecoService;

    @Autowired
    private BuscarCartaoCreditoService buscarCartaoCreditoService;

    @Transactional
    public void fechar(Long cartaoId, Long enderecoId) {

        LocalDate hoje = LocalDate.now();

        Endereco endereco = buscarEnderecoService.porId(enderecoId);
        CartaoCredito cartao = buscarCartaoCreditoService.porId(cartaoId);
        Usuario usuario = usuarioAutenticadoService.get();

        usuario.getCarrinho().getCarrinho().forEach(carrinho -> {

            Long quantidadeProdutoPedido = carrinho.getQuantidadeProdutos();
            Long quantidadeProdutoDisponivel = carrinho.getProduto().getQuantidadeProduto();

            if((quantidadeProdutoDisponivel - quantidadeProdutoPedido) < 0 ){
                throw new ResponseStatusException(UNAUTHORIZED, "quantidade de produto indisponivel!");
            }
            carrinho.getProduto().setQuantidadeProduto(quantidadeProdutoDisponivel - quantidadeProdutoPedido);
        });

        Pedido pedido = Pedido.builder()
                .cartao(cartao)
                .endereco(endereco)
                .usuario(usuario)
                .valorTotal(usuario.getCarrinho().getValorTotal())
                .situacaoPedido(SituacaoPedido.PEDIDO)
                .carrinho(usuario.getCarrinho().getCarrinho())
                .dataPedidoRealizado(hoje)
                .dataElegivelDevolucao(hoje.plusDays(7))
                .build();

        usuario.getPedidos().add(pedido);
        usuario.getCarrinho().getCarrinho().removeAll(usuario.getCarrinho().getCarrinho());

        usuarioRepository.save(usuario);
    }
}
