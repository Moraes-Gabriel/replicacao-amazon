package br.com.example.amazon.amazon.controller;

import br.com.example.amazon.amazon.controller.request.IncluirUsuarioRequest;
import br.com.example.amazon.amazon.controller.response.IncluirUsuarioResponse;
import br.com.example.amazon.amazon.service.IncluirUsuarioService;
import br.com.example.amazon.amazon.service.produto.AdicionarProdutoCarrinho;
import br.com.example.amazon.amazon.service.usuario.RemoverProdutoCarrinho;
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

    @PostMapping()
    public IncluirUsuarioResponse incluir (@Valid @RequestBody IncluirUsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @PutMapping("/adicionar/produto/carrinho/{produtoId}")
    @Secured("ROLE_USER")
    public void adicionarProdutoAoCarrinho(@PathVariable Long produtoId){
        adicionarProdutoCarrinho.adicionar(produtoId);
    }

    @PutMapping("/remover/produto/carrinho/{produtoId}")
    @Secured("ROLE_USER")
    public void removerProdutoCarrinho(@PathVariable Long produtoId){
        removerProdutoCarrinho.remover(produtoId);
    }


    /*@GetMapping()
    @Secured("ROLE_USER")
    public UsuarioResponse buscarUsuarioLogado(){
        return buscarUsuarioLogadoService.buscar();
    }*/
}
