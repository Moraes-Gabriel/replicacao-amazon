package br.com.example.amazon.amazon.controller;

import br.com.example.amazon.amazon.controller.request.IncluirProdutoRequest;
import br.com.example.amazon.amazon.service.IncluirProdutoService;
import br.com.example.amazon.amazon.service.produto.AdicionarQuantidadeDeProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private IncluirProdutoService incluirProdutoService;

    @Autowired
    private AdicionarQuantidadeDeProduto adicionarQuantidadeDeProduto;

    @Secured("ADMIN")
    @PostMapping()
    public void incluir(@Valid @RequestBody IncluirProdutoRequest request) {
        incluirProdutoService.incluir(request);
    }

    @Secured("ADMIN")
    @PutMapping("/adicionar/quantidade/{produtoId}/{quantidadeProduto}")
    public void adicionarQuantidadeProduto(@PathVariable Long quantidadeProduto, Long produtoId) {
        adicionarQuantidadeDeProduto.adicionar(quantidadeProduto, produtoId);
    }
}
