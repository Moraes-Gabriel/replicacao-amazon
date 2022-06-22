package br.com.example.amazon.amazon.controller;

import br.com.example.amazon.amazon.controller.request.*;
import br.com.example.amazon.amazon.controller.response.IncluirUsuarioResponse;
import br.com.example.amazon.amazon.service.usuario.IncluirUsuarioService;
import br.com.example.amazon.amazon.service.usuario.cartao.RemoverCartaoCreditoService;
import br.com.example.amazon.amazon.service.enderecos.AdicionarEnderecoService;
import br.com.example.amazon.amazon.service.enderecos.RemoverEnderecoService;
import br.com.example.amazon.amazon.service.usuario.carrinho.AdicionarProdutoCarrinho;
import br.com.example.amazon.amazon.service.usuario.carrinho.RemoverProdutoCarrinho;
import br.com.example.amazon.amazon.service.usuario.cartao.AdicionarCartaoService;
import br.com.example.amazon.amazon.service.usuario.pedido.FecharPedidoDoCarrinhoService;
import br.com.example.amazon.amazon.service.usuario.pedido.RealizarCompraProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @Autowired
    private AdicionarProdutoCarrinho adicionarProdutoCarrinho;

    @Autowired
    private RemoverProdutoCarrinho removerProdutoCarrinho;

    @Autowired
    private AdicionarEnderecoService adicionarEnderecoService;

    @Autowired
    private RemoverEnderecoService removerEnderecoService;

    @Autowired
    private AdicionarCartaoService adicionarCartaoService;

    @Autowired
    private RemoverCartaoCreditoService removerCartaoCreditoService;

    @Autowired
    private FecharPedidoDoCarrinhoService fecharPedidoDoCarrinhoService;

    @Autowired
    private RealizarCompraProdutoService realizarCompraProdutoService;

    @PostMapping()
    public IncluirUsuarioResponse incluir (@Valid @RequestBody IncluirUsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @PutMapping("/adicionar/produto/carrinho/{produtoId}/{quantidade}")
    @Secured("ROLE_USER")
    public void adicionarProdutoAoCarrinho(@PathVariable Long produtoId, Long quantidade){
        adicionarProdutoCarrinho.adicionar(produtoId, quantidade);
    }

    @PutMapping("/remover/produto/carrinho/{produtoId}")
    @Secured("ROLE_USER")
    public void removerProdutoCarrinho(@PathVariable Long produtoId){
        removerProdutoCarrinho.remover(produtoId);
    }

    @PostMapping("/adicionar/endereço")
    @Secured("ROLE_USER")
    public void adicionarEnderecoAoUsuario(@Valid @RequestBody AdicionarEnderecoRequeSt request){
        adicionarEnderecoService.adicionar(request);
    }

    @PutMapping("/remover/endereço")
    @Secured("ROLE_USER")
    public void removerEnderecoDoUsuario(@PathVariable Long enderecoId){
        removerEnderecoService.remover(enderecoId);
    }

    @PostMapping("/adicionar/cartao")
    @Secured("ROLE_USER")
    public void adicionarCartaoAoUsuario(@Valid @RequestBody AdicionarCartaoRequest request){
        adicionarCartaoService.adicionar(request);
    }

    @PutMapping("/remover/cartao")
    @Secured("ROLE_USER")
    public void removerCartaoDoUsuario(@PathVariable Long cartaoId){
        removerCartaoCreditoService.remover(cartaoId);
    }

    @PutMapping("/fechar/pedido/carrinho")
    @Secured("ROLE_USER")
    public void fecharPedidoDoCarrinhoService(@PathVariable Long cartaoId, Long enderecoId){
        fecharPedidoDoCarrinhoService.fechar(cartaoId, enderecoId);
    }

    @PutMapping("/comprar/produto")
    @Secured("ROLE_USER")
    public void comprarProduto(@Valid @RequestBody ComprarProdutoRequest request){
        realizarCompraProdutoService.comprar(request);
    }




    /*@GetMapping()
    @Secured("ROLE_USER")
    public UsuarioResponse buscarUsuarioLogado(){
        return buscarUsuarioLogadoService.buscar();
    }*/
}
