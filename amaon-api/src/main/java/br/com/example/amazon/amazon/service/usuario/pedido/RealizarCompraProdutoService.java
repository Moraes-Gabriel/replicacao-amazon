package br.com.example.amazon.amazon.service.usuario.pedido;

import br.com.example.amazon.amazon.controller.request.ComprarProdutoRequest;
import br.com.example.amazon.amazon.model.*;
import br.com.example.amazon.amazon.repository.UsuarioRepository;
import br.com.example.amazon.amazon.service.buscar.BuscarCartaoCreditoService;
import br.com.example.amazon.amazon.service.buscar.BuscarEnderecoService;
import br.com.example.amazon.amazon.service.buscar.BuscarProdutoService;
import br.com.example.amazon.amazon.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RealizarCompraProdutoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarEnderecoService buscarEnderecoService;

    @Autowired
    private BuscarCartaoCreditoService buscarCartaoCreditoService;

    @Autowired
    private BuscarProdutoService buscarProdutoService;


    public void comprar(ComprarProdutoRequest request) {

        LocalDate hoje = LocalDate.now();

        Usuario usuario = usuarioAutenticadoService.get();
        CartaoCredito cartao = buscarCartaoCreditoService.porId(request.getCartaoId());
        Endereco endereco = buscarEnderecoService.porId(request.getEnderecoId());

        Produto produto = buscarProdutoService.porId(request.getProdutoId());

        Double valorTotal = (produto.getPreco() * request.getQuantidade());

        Carrinho carrinho = Carrinho.builder().produto(produto).quantidadeProdutos(request.getQuantidade()).usuario(usuario).build();
        List<Carrinho> listCarrinho = new ArrayList<>();
        listCarrinho.add(carrinho);

        Pedido pedido = Pedido.builder()
                .cartao(cartao)
                .endereco(endereco)
                .usuario(usuario)
                .valorTotal(valorTotal)
                .situacaoPedido(SituacaoPedido.PEDIDO)
                .carrinho(listCarrinho)
                .dataPedidoRealizado(hoje)
                .dataElegivelDevolucao(hoje.plusDays(7))
                .build();

        usuario.getPedidos().add(pedido);

    }
}
